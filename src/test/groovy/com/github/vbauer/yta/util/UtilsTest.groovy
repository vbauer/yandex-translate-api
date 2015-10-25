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
package com.github.vbauer.yta.util

import com.github.vbauer.yta.model.artificial.LanguageInfo
import com.github.vbauer.yta.model.artificial.LanguagesInfo
import com.github.vbauer.yta.model.artificial.TranslationInfo
import com.github.vbauer.yta.model.basic.HasCode
import com.github.vbauer.yta.service.basic.ApiStatus
import com.pushtorefresh.private_constructor_checker.PrivateConstructorChecker
import spock.lang.Specification

/**
 * @author Vladislav Bauer
 */

class UtilsTest extends Specification {

    def "Check constructors in util-classes"() {
        when:
            PrivateConstructorChecker
                .forClasses(
                    LanguageInfo.LanguageInfoUtils,
                    LanguagesInfo.LanguagesInfoUtils,
                    TranslationInfo.TranslationInfoUtils,
                    HasCode.HasCodeUtils,
                    ApiStatus
                )
                .expectedTypeOfException(UnsupportedOperationException.class)
                .check();
        then:
            true
    }

}