package com.github.vbauer.yta.converter

import spock.lang.Specification

/**
 * @author Vladislav Bauer
 */

class TranslationConverterSpec extends Specification {

    def "Check that doBackward is not available"() {
        when:
            TranslationConverter.INSTANCE.doBackward(null)
        then:
            thrown UnsupportedOperationException
    }

}
