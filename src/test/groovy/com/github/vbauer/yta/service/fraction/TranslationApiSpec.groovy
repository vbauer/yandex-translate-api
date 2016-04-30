/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Vladislav Bauer
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
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
