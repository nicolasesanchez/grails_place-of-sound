package com.placeofsound

class Instrument {

    long id
    String title
    String description
    BigDecimal price
    byte[] picture

    static constraints = {
        picture(nullable: false, maxSize: 5000000)
    }
}
