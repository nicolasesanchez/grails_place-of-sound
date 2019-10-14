package place.of.sound

import com.placeofsound.CategoryService
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
        render(view: "instrumentForm", model: [categories: categoryService.getLOneCategories()])
    }

    def submitInstrument() {
        Map cleanParams = getInstrumentFormData()

        try {
//            instrumentService.saveInstrument(cleanParams.title, cleanParams.category, cleanParams.description, cleanParams.price)
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
        //cleanParams.picture = params.picture?

        return cleanedParams
    }

}
