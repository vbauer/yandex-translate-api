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

/**
 * Tests for {@link Direction}.
 *
 * @author Vladislav Bauer
 */

class DirectionSpec extends Specification {

    def "Check separator"() {
        expect:
            Direction.SEPARATOR == "-"
    }

    def "Check factory method with source and target arguments"() {
        when:
            def direction = Direction.of(Language.RU, Language.EN)
        then:
            direction.source().get() == Language.RU
            direction.target() == Language.EN

        when:
            Direction.of(Language.RU, null)
        then:
            thrown NullPointerException
    }

    def "Check factory method with target argument"() {
        when:
            def direction = Direction.of(Language.RU)
        then:
            !direction.source().isPresent()
            direction.target() == Language.RU

        when:
            Direction.of(null)
        then:
            thrown NullPointerException
    }

    def "Check toString method"() {
        setup:
            def direction = Direction.of(Language.RU, Language.EN)
            def str = direction.toString();
        expect:
            !str.isEmpty()
            str.contains(Direction.SEPARATOR)
    }

}
