package place.of.sound

import com.placeofsound.test.TestTable

class PlaceOfSoundController {

    def index() {
        List<TestTable> registers = TestTable.findAll()

        StringBuilder sb = new StringBuilder()
        registers.each {
            sb.append(it.toString())
        }

        // TODO it works, now build the db schema

        render sb.toString()
    }
}
