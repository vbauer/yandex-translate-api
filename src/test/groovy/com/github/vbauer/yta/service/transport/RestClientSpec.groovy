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
package com.github.vbauer.yta.service.transport

import com.github.vbauer.yta.service.transport.impl.RestClientImpl
import groovy.json.JsonSlurper
import spock.lang.Specification

import static com.github.vbauer.yta.common.AbstractApiSpec.KEY
import static com.github.vbauer.yta.service.fraction.impl.LanguageApiImpl.METHOD_GET_LANGS
import static com.github.vbauer.yta.service.transport.impl.RestClientImpl.*

/**
 * Tests for {@link RestClient}.
 *
 * @author Vladislav Bauer
 */

class RestClientSpec extends Specification {

    def "Smoke test"() {
        when:
            def client = new RestClientImpl(KEY);
            def json = client.callMethod(METHOD_GET_LANGS, [] as Map)
            def slurper = new JsonSlurper()
            def object = slurper.parseText(json)
        then:
            object != null
    }

    def "Check constants"() {
        expect:
            constant == value
        where:
            constant        | value
            SERVICE_URL     | "https://translate.yandex.net/api/v1.5/tr.json"
            ATTR_KEY        | "key"
            DEFAULT_TIMEOUT | 30000
    }

}
