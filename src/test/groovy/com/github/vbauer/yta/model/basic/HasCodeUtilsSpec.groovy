package com.github.vbauer.yta.model.basic

import com.github.vbauer.yta.model.Language
import spock.lang.Specification

import static com.github.vbauer.yta.model.basic.HasCode.HasCodeUtils

/**
 * Tests for {@link HasCodeUtils}.
 *
 * @author Vladislav Bauer
 */

class HasCodeUtilsSpec extends Specification {

    def "Check method findByCode"() {
        setup:
            def languages = [Language.RU, Language.EN]

        when:
            def existedLang = HasCodeUtils.findByCode(languages, "ru")
        then:
            existedLang.get() == Language.RU

        when:
            def missedLang = HasCodeUtils.findByCode(languages, "fr")
        then:
            !missedLang.isPresent()

        when:
            def nullLang = HasCodeUtils.findByCode(languages, null)
        then:
            !nullLang.isPresent()

        when:
            def nullCollection = HasCodeUtils.findByCode(null, "ru")
        then:
            !nullCollection.isPresent()
    }

}
