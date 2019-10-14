package com.placeofsound

import grails.transaction.Transactional

@Transactional
class InstrumentService {

    void saveInstrument(String title, String category, String description, BigDecimal price) {
        Instrument instrumentInstance =  new Instrument()

        instrumentInstance.title = title
        instrumentInstance.description = description
        instrumentInstance.price = price

        instrumentInstance.save(flush: true, failOnError: true)
    }

}
