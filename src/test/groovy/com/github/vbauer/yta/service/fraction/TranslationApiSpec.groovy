package com.github.vbauer.yta.service.fraction

import com.github.vbauer.yta.common.AbstractApiSpec
import com.github.vbauer.yta.model.Direction
import com.github.vbauer.yta.model.Language
import com.github.vbauer.yta.model.basic.TextFormat

import static com.github.vbauer.yta.service.fraction.impl.TranslationApiImpl.*

/**
 * Tests for {@link TranslationApi}.
 *
 * @author Vladislav Bauer
 */

class TranslationApiSpec extends AbstractApiSpec {

    def "Check Translate API"() {
        setup:
            def translateApi = api.translationApi()
        expect:
            translateApi != null

        when: "Translate Russian to English"
            def translationRuEn = translateApi.translate("Как дела?", Language.EN)
        then:
            ["How are you doing?", "How's it going?"].any { it.equals(translationRuEn.text()) }
            translationRuEn.direction().equals(Direction.of(Language.RU, Language.EN))

        when: "Translate English to Russian"
            def enRu = Direction.of(Language.EN, Language.RU)
            def translationEnRu = translateApi.translate("How are you doing?", enRu)
            def text = translationEnRu.text()
            def direction = translationEnRu.direction()
        then:
            ["Как у тебя дела?", "Как поживаешь?", "Как ты делаешь?"].any { it.equals(text) }
            direction.equals(enRu)

        when: "Translate Russian to English with HTML"
            def ruEn = Direction.of(Language.RU, Language.EN)
            def translationRuEnHtml = translateApi.translate(
                "<span>Привет</span>", ruEn, TextFormat.HTML
            )
        then:
            translationRuEnHtml.toString().equals("<span>Hi</span>")
            translationRuEnHtml.direction().equals(ruEn)
    }

    def "Check constants"() {
        expect:
            constant == value
        where:
            constant      | value
            METHOD_DETECT | "/translate"
            ATTR_LANG     | "lang"
            ATTR_TEXT     | "text"
            ATTR_FORMAT   | "format"
    }

}
