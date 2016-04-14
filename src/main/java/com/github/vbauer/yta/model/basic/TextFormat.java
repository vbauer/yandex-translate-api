/**
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
package com.github.vbauer.yta.model.basic;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.ThreadSafe;
import java.util.Optional;

/**
 * Text format could be used in the following services:
 * <ul>
 *     <li>{@link com.github.vbauer.yta.service.fraction.DetectionApi}</li>
 *     <li>{@link com.github.vbauer.yta.service.fraction.TranslationApi}</li>
 * </ul>
 * It allows to specify kind of source text.
 *
 * @author Vladislav Bauer
 */

@ThreadSafe
public enum TextFormat implements HasCode<String> {

    /**
     * Text without markup.
     */
    PLAIN_TEXT("plain"),

    /**
     * Text in HTML format.
     */
    HTML("html");


    private final String code;


    TextFormat(final String code) {
        this.code = code;
    }


    /**
     * Check if it possible to use {@code format} parameter or use default value.
     *
     * @param format text format
     * @return {@code format} if it is not null or {@link TextFormat#PLAIN_TEXT} otherwise
     */
    @Nonnull
    public static TextFormat getOrDefault(final TextFormat format) {
        return Optional.ofNullable(format).orElse(TextFormat.PLAIN_TEXT);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public String code() {
        return code;
    }

}
