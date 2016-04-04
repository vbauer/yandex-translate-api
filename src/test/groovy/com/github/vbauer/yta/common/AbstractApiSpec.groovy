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
package com.github.vbauer.yta.common

import com.github.vbauer.yta.service.YTranslateApiImpl
import spock.lang.Shared
import spock.lang.Specification

/**
 * Basic class to test API services.
 *
 * @author Vladislav Bauer
 */

abstract class AbstractApiSpec extends Specification {

    /**
     * <b>Important:</b> Do not use this API key in your projects.
     * It is necessary to test this library and could be changed.
     */
    public static final KEY = "trnsl.1.1.20151012T201854Z.52731c6f05cd2ac8.f9ccae1aec912fb16879d4d89a2a40bbf1c802a3"

    /**
     * Shared "YTA" API service for testing purpose.
     */
    @Shared api = new YTranslateApiImpl(KEY)

}
