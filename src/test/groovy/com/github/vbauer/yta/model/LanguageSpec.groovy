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
        AZ, SQ, AM, EN, AR, HY, AF, EU, BA, BE,
        BN, MY, BG, BS, CY, HU, VI, HT, GL, NL,
        MRJ, EL, KA, GU, DA, HE, YI, ID, GA, IT,
        IS, ES, KK, KN, CA, KY, ZH, KO, XH, KM,
        LO, LA, LV, LT, LB, MG, MS, ML, MT, MK,
        MI, MR, MHR, MN, DE, NE, NO, PA, PAP, FA,
        PL, PT, RO, RU, CEB, SR, SI, SK, SL, SW,
        SU, TG, TH, TL, TA, TT, TE, TR, UDM, UZ,
        UK, UR, FI, FR, HI, HR, CS, SV, GD, ET,
        EO, JV, JA, EMJ
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
