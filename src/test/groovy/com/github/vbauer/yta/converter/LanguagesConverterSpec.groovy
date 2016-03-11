package com.github.vbauer.yta.converter

import spock.lang.Specification

/**
 * @author Vladislav Bauer
 */

class LanguagesConverterSpec extends Specification {

    def "Check that doBackward is not available"() {
        when:
            LanguagesConverter.INSTANCE.doBackward(null)
        then:
            thrown UnsupportedOperationException
    }

}
