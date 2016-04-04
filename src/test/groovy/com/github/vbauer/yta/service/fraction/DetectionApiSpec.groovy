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

import static com.github.vbauer.yta.service.fraction.impl.DetectionApiImpl.*

/**
 * Tests for {@link DetectionApi}.
 *
 * @author Vladislav Bauer
 */

class DetectionApiSpec extends AbstractApiSpec {

    def "Check Detection API"() {
        setup:
            def detectApi = api.detectionApi()
        expect:
            detectApi != null

        when: "Language should be detected as English"
            detectApi.detect("Hello, World!")
        then:
            Language.EN

        when: "HTML with Russian text should be detected"
            detectApi.detect("<b><h1>Привет, Мир!</h1></b>")
        then:
            Language.RU
    }

    def "Check constants"() {
        expect:
            constant == value
        where:
            constant      | value
            METHOD_DETECT | "/detect"
            ATTR_TEXT     | "text"
            ATTR_FORMAT   | "format"
    }
}
