package com.github.vbauer.yta.converter

import spock.lang.Specification

/**
 * @author Vladislav Bauer
 */

class DirectionConverterSpec extends Specification {

    def "Check that doBackward is not available"() {
        when:
            DirectionConverter.INSTANCE.doBackward(null)
        then:
            thrown UnsupportedOperationException
    }

}
