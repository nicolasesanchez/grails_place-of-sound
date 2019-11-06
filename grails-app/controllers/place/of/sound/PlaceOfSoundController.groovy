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

    private final String DEFAULT_USER_ROLE = "buyer"

    def index() {
        String cookieValue = params.cookie

        if (cookieValue) {
            Cookie cookie = new Cookie("user_cookie", cookieValue)
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

        render(view: "home", model: [categories: categoryService.getCategoriesList(), instrumentsList: instruments])
    }

    def getInstrumentForm() {
        render(view: "instrumentForm", model: [categories: categoryService.getAllCategories()])
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

    def getSignUpForm() {
        render(view: "registerForm")
    }

    def signUp() {
        long cookieValue = userService.createNewUser(params.name, params.lastName, params.email, params.password, (params.role ?: DEFAULT_USER_ROLE), params.userName)
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

}
