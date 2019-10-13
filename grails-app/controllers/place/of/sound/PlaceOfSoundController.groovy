package place.of.sound

import com.placeofsound.User

class PlaceOfSoundController {

    def index() {
        User user = User.findById(1)

        render user.name
    }
}
