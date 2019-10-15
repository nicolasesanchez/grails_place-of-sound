package com.placeofsound

class Instrument {

    long id
    String title
    String description
    BigDecimal price
    byte[] picture

    static constraints = {
        picture(maxSize: 1024 * 1024 * 2)
    }
}
