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

import com.github.vbauer.yta.common.TestUtils
import spock.lang.Specification

import static com.github.vbauer.yta.model.basic.TextFormat.HTML
import static com.github.vbauer.yta.model.basic.TextFormat.PLAIN_TEXT

/**
 * Tests for {@link TextFormat}.
 *
 * @author Vladislav Bauer
 */

class TextFormatSpec extends Specification {

    def "Check codes"() {
        expect:
            value.code().equals(code)
        where:
            value      | code
            PLAIN_TEXT | "plain"
            HTML       | "html"
    }

    def "Check method getOrDefault"() {
        expect:
            TextFormat.getOrDefault(input) == output
        where:
            input      | output
            null       | PLAIN_TEXT
            PLAIN_TEXT | PLAIN_TEXT
            HTML       | HTML
    }

    def "Check count of available formats"() {
        expect:
            TestUtils.countStaticFields(TextFormat) == 2
    }

}
