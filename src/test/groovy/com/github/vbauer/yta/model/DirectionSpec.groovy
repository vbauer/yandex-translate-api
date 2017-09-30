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
            def direction = Direction.of(Language.RU, Language.EN)
        then:
            direction.source().get() == Language.RU
            direction.target() == Language.EN

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
        setup:
            def direction = Direction.of(Language.RU, Language.EN)
            def str = direction.toString()
        expect:
            !str.isEmpty()
            str.contains(Direction.SEPARATOR)
    }

}
