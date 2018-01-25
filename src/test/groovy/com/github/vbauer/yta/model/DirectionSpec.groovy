package com.github.vbauer.yta.model

import spock.lang.Specification

/**
 * Tests for {@link Direction}.
 *
 * @author Vladislav Bauer
 */

class DirectionSpec extends Specification {

    def "Check separator"() {
        expect:
            Direction.SEPARATOR == "-"
    }

    def "Check factory method with source and target arguments"() {
        when:
            def dirRuToEn = Direction.of(Language.RU, Language.EN)
        then:
            dirRuToEn.source().get() == Language.RU
            dirRuToEn.target() == Language.EN

        when:
            def dirSomethingToEn = Direction.of(null, Language.EN)
        then:
            !dirSomethingToEn.source().isPresent()
            dirSomethingToEn.target() == Language.EN

        when:
            Direction.of(Language.RU, null)
        then:
            thrown NullPointerException
    }

    def "Check factory method with target argument"() {
        when:
            def direction = Direction.of(Language.RU)
        then:
            !direction.source().isPresent()
            direction.target() == Language.RU

        when:
            Direction.of(null)
        then:
            thrown NullPointerException
    }

    def "Check toString method"() {
        when:
            def dirRu2En = Direction.of(Language.RU, Language.EN)
            def strRu2En = dirRu2En.toString()
        then:
            strRu2En == Language.RU.code() + Direction.SEPARATOR + Language.EN.code()

        when:
            def dirSomethingToEn = Direction.of(null, Language.EN)
            def strSomethingToEn = dirSomethingToEn.toString()
        then:
            strSomethingToEn == Language.EN.code()
    }

}
