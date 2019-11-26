package place.of.sound

import com.placeofsound.CategoryService
import com.placeofsound.Instrument
import com.placeofsound.InstrumentService
import com.placeofsound.UserService
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest

import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletResponse

class PlaceOfSoundController {
    CategoryService categoryService
    InstrumentService instrumentService
    UserService userService

    def index() {
        String cookieValue = params.remove("cookie")

        if (cookieValue) {
            Cookie cookie = new Cookie(userService.USER_COOKIE, cookieValue)
            cookie.setMaxAge(3600) // one hour

            response.addCookie(cookie)
        }

        List<List<Instrument>> instruments = []

        List<Instrument> instrumentsDb = instrumentService.getAllInstruments()


        int index = 0

        instruments << []

        for (int i = 0; i < instrumentsDb.size(); i++) {
            instruments[index] << instrumentsDb[i]

            if ((i + 1) % 4 == 0) {
                index++
                instruments << []
            }
        }

        boolean loggedIn = ((getUserCookieIfAny() && !getUserCookieIfAny().value.isEmpty()) || cookieValue)

        if (params.remove("fromSignOut")) {
            Cookie cookie = new Cookie(userService.USER_COOKIE, "")
            cookie.setMaxAge(0) // deleted

            response.addCookie(cookie)
            loggedIn = false
        }

        render(view: "home", model: [categories: categoryService.getCategoriesList(), instrumentsList: instruments, logedIn: loggedIn, isAdmin: isAdminUser(cookieValue)])
    }

    private boolean isAdminUser(String cookieValue = null) {
        if (cookieValue) {
            return userService.isAdminUser(cookieValue as long)
        }

        Cookie cookie = getUserCookieIfAny()
        return cookie?.value ? userService.isAdminUser(cookie.value as long) : false
    }

    def getInstrumentForm() {
        Cookie userCookie = getUserCookieIfAny()
        if (!userCookie || !userService.isAdminUser(userCookie.value as long)) return [response: [message: "User not logged in or does not have the right permissions"], status: HttpServletResponse.SC_BAD_REQUEST]

        render(view: "instrumentForm", model: [categories: categoryService.getAllCategories(), logedIn: true, isAdmin: true])
    }

    def submitInstrument() {
        Map cleanParams = getInstrumentFormData()

        try {
            instrumentService.saveInstrument(cleanParams.title, cleanParams.category, cleanParams.description, cleanParams.price, cleanParams.picture)
        } catch (Exception e) {
            log.error("There was an error while trying to save a new instrument in the db", e)
            return [response: [message: "Error while saving new register"], status: HttpServletResponse.SC_INTERNAL_SERVER_ERROR]
        }

        // TODO should send path of category

        redirect(uri: "/submit_instrument")
    }

    private Map getInstrumentFormData() {
        Map cleanedParams = [:]

        cleanedParams.title = params.title
        cleanedParams.category = "" // iterate categories
        cleanedParams.description = params.description
        cleanedParams.price = params.price as BigDecimal
        cleanedParams.picture = (request as DefaultMultipartHttpServletRequest).getFile("picture")

        return cleanedParams
    }

    def getSignInForm() {
        render(view: "login")
    }

    def signIn() {
        long cookieValue = userService.logUserIn(params.userName, params.password)

        if (cookieValue) {
            redirect(uri: "/home", params: [cookie: cookieValue])
        } else {
            return [response: [message: "User or password invalid"], status: HttpServletResponse.SC_NOT_FOUND]
        }
    }

    def signOut() {
        Cookie userCookie = getUserCookieIfAny()
        userService.logUserOut(userCookie.value as long)

        redirect(uri: "/home", params: [fromSignOut: true])
    }

    def getSignUpForm() {
        render(view: "registerForm")
    }

    def signUp() {
        long cookieValue = userService.createNewUser(params.name, params.lastName, params.email, params.password, (params.role ?: userService.BUYER_ROLE), params.userName)
        redirect(uri: "/home", params: [cookie: cookieValue])
    }

    def getInstrumentPicture() {
        response.outputStream << instrumentService.getPictureByInstrumentId(params.id as long)
        response.outputStream.flush()
    }

    /*private String wrapCookie(long value) {
        return (((value as String) as List).collect { digit -> (digit as long) * 7l }).join()
    }

    private String unwrapCookie(long value) {
        long result = 0

        (value as List<Long>).each { digit -> result += ((digit / 5) / 2) }

        return result
    }*/

    private Cookie getUserCookieIfAny() {
        return request.getCookies().find { userService.USER_COOKIE == it.name }
    }

    def random() {
        render(view:"checkout")
    }

}
