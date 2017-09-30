package com.github.vbauer.yta.util

import com.github.vbauer.yta.service.basic.ApiStatus
import com.pushtorefresh.private_constructor_checker.PrivateConstructorChecker
import spock.lang.Specification

/**
 * Tests for checking util classes.
 *
 * @author Vladislav Bauer
 */

class UtilsSpec extends Specification {

    def "Check constructors in util-classes"() {
        when:
            PrivateConstructorChecker
                .forClasses(ApiStatus)
                .expectedTypeOfException(UnsupportedOperationException.class)
                .check()
        then:
            true
    }

}
