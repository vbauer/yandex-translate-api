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
package com.github.vbauer.yta.service.fraction;

import com.github.vbauer.yta.model.Direction;
import com.github.vbauer.yta.model.Language;
import com.github.vbauer.yta.model.basic.TextFormat;
import com.github.vbauer.yta.model.Translation;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Service allows to translate text to the specified language.
 *
 * Official REST API documentation: https://tech.yandex.com/translate/doc/dg/reference/translate-docpage/
 *
 * @author Vladislav Bauer
 */

public interface TranslationApi {

    /**
     * Translates text to the specified language. Source language is detected by text.
     * Text format is {@link TextFormat#PLAIN_TEXT}.
     *
     * @param text the text to translate
     * @param language the target language for translation
     * @return translated text
     */
    @Nonnull
    Translation translate(@Nullable String text, @Nonnull Language language);

    /**
     * Translates text to the specified language. Text format is {@link TextFormat#PLAIN_TEXT}.
     *
     * @param text the text to translate
     * @param direction the direction of translation
     * @return translated text
     */
    @Nonnull
    Translation translate(@Nullable String text, @Nonnull Direction direction);

    /**
     * Translates text to the specified language.
     *
     * @param text the text to translate
     * @param direction the direction of translation
     * @param format the text format
     * @return translated text
     */
    @Nonnull
    Translation translate(
        @Nullable String text, @Nonnull Direction direction, @Nullable TextFormat format
    );

}
