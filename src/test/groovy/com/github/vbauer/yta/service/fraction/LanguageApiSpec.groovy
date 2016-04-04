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
import com.github.vbauer.yta.model.Language

import static com.github.vbauer.yta.service.fraction.impl.LanguageApiImpl.ATTR_UI
import static com.github.vbauer.yta.service.fraction.impl.LanguageApiImpl.METHOD_GET_LANGS

/**
 * Tests for {@link LanguageApi}.
 *
 * @author Vladislav Bauer
 */

class LanguageApiSpec extends AbstractApiSpec {

    def "Check Language API"() {
        setup:
            def langApi = api.languageApi()
        expect:
            langApi != null

        when: "UI parameter is not passed"
            def allLanguages = langApi.all()
        then:
            !allLanguages.toString().empty
            !allLanguages.directions().empty
            !allLanguages.languages().empty

        when: "UI parameter is an object"
            def allLanguagesEn = langApi.all(Language.EN)
        then:
            !allLanguagesEn.directions().empty
            !allLanguagesEn.languages().empty

        when: "UI parameter is a string"
            def allLanguagesRu = langApi.all("ru")
        then:
            !allLanguagesRu.directions().empty
            !allLanguagesRu.languages().empty
    }

    def "Check constants"() {
        expect:
            constant == value
        where:
            constant         | value
            METHOD_GET_LANGS | "/getLangs"
            ATTR_UI          | "ui"
    }

}
