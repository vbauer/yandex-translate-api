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
package com.github.vbauer.yta.converter

import com.github.vbauer.yta.model.Direction
import com.github.vbauer.yta.model.Languages
import com.github.vbauer.yta.model.artificial.ImmutableLanguagesInfo
import spock.lang.Specification

import static com.github.vbauer.yta.model.Language.EN
import static com.github.vbauer.yta.model.Language.RU

/**
 * Tests for {@link LanguagesConverter}.
 *
 * @author Vladislav Bauer
 */

class LanguagesConverterSpec extends Specification {

    def "Check null-value conversion"() {
        expect:
            LanguagesConverter.INSTANCE.convert(null) == null
    }

    def "Check correct conversion"() {
        when:
            def input = ImmutableLanguagesInfo.builder()
                .dirs(["ru-en"])
                .langs([
                    "ru": "Russian",
                    "en": "English"
                ])
                .build()
            def output = Languages.of([RU, EN], [Direction.of(RU, EN)])
        then:
            LanguagesConverter.INSTANCE.convert(input) == output
    }

    def "Check that doBackward is not available"() {
        when:
            LanguagesConverter.INSTANCE.doBackward(null)
        then:
            thrown UnsupportedOperationException
    }

}
