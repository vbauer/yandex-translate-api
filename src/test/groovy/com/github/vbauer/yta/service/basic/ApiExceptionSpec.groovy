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
package com.github.vbauer.yta.service.basic

import javaslang.control.Try
import spock.lang.Specification

/**
 * Tests for {@link ApiException}.
 *
 * @author Vladislav Bauer
 */

class ApiExceptionSpec extends Specification {

    def "Check inheritance"() {
        expect:
            RuntimeException.isAssignableFrom(ApiException)
    }

    def "Check construction"() {
        def assertCheck = { ex ->
            assert ex.toString().contains(String.valueOf(status))
            assert ex.getStatus() == status
        }

        expect:
            Try.of({ throw new ApiException(status) })
                .onFailure(assertCheck)
        where:
            status << [
                ApiStatus.ERR_KEY_INVALID,
                ApiStatus.ERR_KEY_BLOCKED,
                ApiStatus.ERR_DAILY_REQ_LIMIT_EXCEEDED,
                ApiStatus.ERR_DAILY_CHAR_LIMIT_EXCEEDED,
                ApiStatus.ERR_TEXT_TOO_LONG,
                ApiStatus.ERR_UNPROCESSABLE_TEXT,
                ApiStatus.ERR_LANG_NOT_SUPPORTED
            ]
    }

}
