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

import com.github.vbauer.yta.common.AbstractConverterSpec
import com.github.vbauer.yta.model.Direction

import static com.github.vbauer.yta.model.Language.EN
import static com.github.vbauer.yta.model.Language.RU

/**
 * Tests for {@link DirectionConverter}.
 *
 * @author Vladislav Bauer
 */

class DirectionConverterSpec extends AbstractConverterSpec {

    def "Check correct conversion"() {
        expect:
            converter().convert(input) == output
        where:
            input   || output
            "ru-en" || Direction.of(RU, EN)
            "en-ru" || Direction.of(EN, RU)
    }

    @Override
    protected converter() { DirectionConverter.INSTANCE }

}
