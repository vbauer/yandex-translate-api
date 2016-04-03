package com.github.vbauer.yta.model

import spock.lang.Specification

/**
 * Tests for {@link Translation}.
 *
 * @author Vladislav Bauer
 */
class TranslationSpec extends Specification {

    def "Check factory method"() {
        def direction = Direction.of(Language.EN, Language.RU)
        def text = "text"

        setup:
            def translation = Translation.of(direction, text)
        expect:
            translation.text().equals(text)
            translation.direction().equals(direction)

        when:
            Translation.of(direction, null)
        then:
            thrown NullPointerException

        when:
            Translation.of(null, text)
        then:
            thrown NullPointerException
    }

    def "Check toString method"() {
        setup:
            def direction = Direction.of(Language.EN, Language.RU)
            def text = "text"
            def translation = Translation.of(direction, text)
            def str = translation.toString();
        expect:
            !str.isEmpty()
            str.equals(translation.text())
    }

}
