package com.github.vbauer.yta.model

import spock.lang.Specification

import static com.github.vbauer.yta.model.Language.EN
import static com.github.vbauer.yta.model.Language.RU

/**
 * Tests for {@link Languages}.
 *
 * @author Vladislav Bauer
 */

class LanguagesSpec extends Specification {

    def "Check factory method"() {
        def langs = [RU, EN] as Set
        def dirs = [Direction.of(RU, EN)] as Set

        when:
            def languages = Languages.of(langs, dirs)
        then:
            languages.languages() == langs
            languages.directions() == dirs

        when:
            Languages.of(null, dirs)
        then:
            thrown NullPointerException

        when:
            Languages.of(langs, null)
        then:
            thrown NullPointerException
    }

}
