package place.of.sound

import com.placeofsound.CategoryService
import com.placeofsound.Instrument
import com.placeofsound.InstrumentService
import com.placeofsound.User

import javax.servlet.http.HttpServletResponse

class PlaceOfSoundController {
    CategoryService categoryService
    InstrumentService instrumentService

    def index() {
        User user = User.findById(1)

        render user.name
    }

    def getInstrumentForm() {
        byte[] picture = Instrument.findById(4).picture
        println("DEBUG ±±± picture -- ${picture}")
        // TODO guardar imagenes en dir de compu (o app) y traer a traves de path
        render(view: "instrumentForm", model: [categories: categoryService.getLOneCategories(), image: "file:///Users/nicsanchez/Desktop/" + new String(picture)])
    }

    def submitInstrument() {
        Map cleanParams = getInstrumentFormData()

        try {
            instrumentService.saveInstrument(cleanParams.title, cleanParams.category, cleanParams.description, cleanParams.price, cleanParams.picture)
        } catch(Exception e) {
            log.error("There was an error while trying to save a new instrument in the db", e)
            return [response: [message: "Error while saving new register"], status: HttpServletResponse.SC_INTERNAL_SERVER_ERROR]
        }

        // TODO should send path of category

        redirect(uri: "/submit_instrument")
    }

    private Map getInstrumentFormData() {
        Map cleanedParams = [:]

        println("DEBUG ±±± category? == ${params.category}")

        cleanedParams.title = params.title
        cleanedParams.category = "" // iterate categories
        cleanedParams.description = params.description
        cleanedParams.price = params.price as BigDecimal
        println("DEBUG ±±± picture -- ${params.picture}")
        cleanedParams.picture = params.picture as byte[]

        return cleanedParams
    }

    def signIn() {
        String userName = params.userName
        String password = params.password

        User user = User.findByUserName(userName)

        if (!user || password != user.password) {
            return [response: [message: "User or password invalid"], status: HttpServletResponse.SC_NOT_FOUND]
        }

        if (password == user.password ) {
            redirect(uri: "/home")
        } else {
            return [response: [message: "User or password invalid"], status: HttpServletResponse.SC_NOT_FOUND]
        }
    }

    def signUp() {
        String name = params.name
        String lastName = params.lastName
        String email = params.email
        String password = params.password
        String role = params.role
        String userName = params.userName

        User userInstance = new User()

        userInstance.name = name
        userInstance.lastName = lastName
        userInstance.email = email
        userInstance.password = password
        userInstance.role = role
        userInstance.userName = userName

        userInstance.save(flush: true, failOnError: true)

        redirect(uri: "/home")
    }

}
