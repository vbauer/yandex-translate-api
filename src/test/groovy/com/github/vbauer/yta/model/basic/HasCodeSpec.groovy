package com.github.vbauer.yta.model.basic

import com.github.vbauer.yta.model.Language
import spock.lang.Specification

/**
 * Tests for {@link HasCode}.
 *
 * @author Vladislav Bauer
 */

class HasCodeSpec extends Specification {

    def "Check method findByCode"() {
        setup:
            def languages = [Language.RU, Language.EN]

        when:
            def existedLang = HasCode.findByCode(languages, "ru")
        then:
            existedLang.get() == Language.RU

        when:
            def missedLang = HasCode.findByCode(languages, "fr")
        then:
            !missedLang.isPresent()

        when:
            def nullLang = HasCode.findByCode(languages, null)
        then:
            !nullLang.isPresent()

        when:
            def nullCollection = HasCode.findByCode(null, "ru")
        then:
            !nullCollection.isPresent()
    }

}
