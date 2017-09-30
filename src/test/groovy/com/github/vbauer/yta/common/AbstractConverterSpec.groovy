package com.github.vbauer.yta.common

import spock.lang.Specification

/**
 * Basic class to test converters.
 *
 * @author Vladislav Bauer
 */

abstract class AbstractConverterSpec extends Specification {

    def "Check null-value conversion"() {
        expect:
            converter().convert(null) == null
    }

    def "Check that doBackward is not available"() {
        when:
            converter().doBackward(null)
        then:
            thrown UnsupportedOperationException
    }

    protected abstract converter();

}
