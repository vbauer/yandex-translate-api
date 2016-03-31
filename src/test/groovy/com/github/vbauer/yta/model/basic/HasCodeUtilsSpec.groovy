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
