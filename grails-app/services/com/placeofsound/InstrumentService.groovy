package com.placeofsound

import grails.transaction.Transactional
import org.springframework.web.multipart.MultipartFile

@Transactional
class InstrumentService {

    void saveInstrument(String title, String category, String description, BigDecimal price, MultipartFile picture) {
        Instrument instrumentInstance =  new Instrument()

        instrumentInstance.title = title
        instrumentInstance.description = description
        instrumentInstance.price = price
        instrumentInstance.picture = picture.bytes

        instrumentInstance.save(flush: true, failOnError: true)
    }

    byte[] getPictureByInstrumentId(long instrumentId) {
        return Instrument.findById(instrumentId).picture
    }

}
