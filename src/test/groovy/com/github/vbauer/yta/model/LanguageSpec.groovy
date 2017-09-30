package com.github.vbauer.yta.model

import com.github.vbauer.yta.common.TestUtils
import spock.lang.Specification

import static com.github.vbauer.yta.model.Language.*

/**
 * Tests for {@link Language}.
 *
 * @author Vladislav Bauer
 */

class LanguageSpec extends Specification {

    static final LANGUAGES = [
        EN, RU, TR, UK,

        SW, AZ, HY, ID, KO, BE, JA, KA, CY, KK,
        IT, RO, HU, MS, MK, FA, DA, ES, FR, LY,
        GA, SR, TT, SQ, MT, PL, HR, TH, NO, KY,
        GL, FI, TG, EU, AR, CA, NL, BG, AF, MN,
        HT, PT, DE, TL, BS, VI, CS, EL, MG, SK,
        BA, LT, ET, ZH, HE, UZ, LA, SL, SV, IS
    ]


    def "Check case-insensitive of code param"() {
        expect:
            of("en") == of("EN")
            of("en", null) == of("EN", null)
    }

    def "Check factory method with code only"() {
        setup:
            def code = "en"
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
            lang << LANGUAGES
    }

    def "Check count of available languages"() {
        expect:
            TestUtils.countStaticFields(Language) == LANGUAGES.size()
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
