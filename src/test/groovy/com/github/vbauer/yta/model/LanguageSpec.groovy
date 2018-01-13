package com.github.vbauer.yta.model

import com.github.vbauer.yta.common.TestUtils
import spock.lang.Specification

import static com.github.vbauer.yta.model.Language.ALL
import static com.github.vbauer.yta.model.Language.of

/**
 * Tests for {@link Language}.
 *
 * @author Vladislav Bauer
 */

class LanguageSpec extends Specification {

    def "Check case-insensitive of code param"() {
        expect:
            of("en") == of("EN")
            of("en", null) == of("EN", null)
    }

    def "Check factory method with code only"() {
        setup:
            def code = "unknown"
            def lang = of(code)
        expect:
            code == lang.code()
            !lang.name().isPresent()

        when:
            of(null)
        then:
            thrown NullPointerException
    }

    def "Check factory method with code and name"() {
        def name = "English"

        setup:
            def code = "en"
            def lang = of(code, name)
        expect:
            code == lang.code()
            name == lang.name().get()

        when:
            of(null, name)
        then:
            thrown NullPointerException
    }

    def "Check available languages API key"() {
        expect:
            lang != null
            lang.code() != null
            lang.name() != null
        where:
            lang << ALL.values()
    }

    def "Check count of available languages"() {
        expect:
            // We skip only the "ALL" field
            TestUtils.countStaticFields(Language) - 1 == ALL.size()
    }

    def "Check toString method"() {
        setup:
            def code = "code"
            def lang = of(code)
            def str = lang.toString()
        expect:
            !str.isEmpty()
            str == code
    }

}
