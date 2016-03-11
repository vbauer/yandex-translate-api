package com.github.vbauer.yta.converter

import spock.lang.Specification

/**
 * @author Vladislav Bauer
 */

class LanguageConverterSpec extends Specification {

    def "Check that doBackward is not available"() {
        when:
            LanguageConverter.INSTANCE.doBackward(null)
        then:
            thrown UnsupportedOperationException
    }

}
