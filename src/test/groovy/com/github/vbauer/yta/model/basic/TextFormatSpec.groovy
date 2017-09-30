package com.github.vbauer.yta.model.basic

import com.github.vbauer.yta.common.TestUtils
import spock.lang.Specification

import static com.github.vbauer.yta.model.basic.TextFormat.HTML
import static com.github.vbauer.yta.model.basic.TextFormat.PLAIN_TEXT

/**
 * Tests for {@link TextFormat}.
 *
 * @author Vladislav Bauer
 */

class TextFormatSpec extends Specification {

    def "Check codes"() {
        expect:
            value.code() == code
        where:
            value      | code
            PLAIN_TEXT | "plain"
            HTML       | "html"
    }

    def "Check method getOrDefault"() {
        expect:
            TextFormat.getOrDefault(input) == output
        where:
            input      | output
            null       | PLAIN_TEXT
            PLAIN_TEXT | PLAIN_TEXT
            HTML       | HTML
    }

    def "Check count of available formats"() {
        expect:
            TestUtils.countStaticFields(TextFormat) == 2
    }

}
