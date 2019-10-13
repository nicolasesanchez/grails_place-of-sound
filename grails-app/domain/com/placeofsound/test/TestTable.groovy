package com.placeofsound.test

class TestTable {
    private static final long serialVersionUID = 1L;

    long id
    String word
    int version

    static constraints = {
    }

    @Override
    String toString() {
        return "[id=${id}, word=${word}, version=${version}]"
    }
}