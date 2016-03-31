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
package com.github.vbauer.yta.model

import spock.lang.Specification

import static com.github.vbauer.yta.model.Language.*

/**
 * Tests for {@link Language}.
 *
 * @author Vladislav Bauer
 */

class LanguageSpec extends Specification {

    def "Check available languages API key"() {
        expect:
            lang != null
            lang.code() != null
            lang.name() != null
        where:
            lang << [
                EN, RU, TR, UK,

                SW, AZ, HY, ID, KO, BE, JA, KA, CY, KK,
                IT, RO, HU, MS, MK, FA, DA, ES, FR, LV,
                GA, SR, TT, SQ, MT, PL, HR, TH, NO, KY,
                GL, FI, TG, EU, AR, CA, NL, BG, AF, MN,
                HT, PT, DE, TL, BS, VI, CS, EL, MG, SK,
                BA, LT, ET, ZH, HE, UZ, LA, SL, SV, IS
            ]
    }

}
