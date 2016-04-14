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

import com.github.vbauer.yta.model.Language;
import com.github.vbauer.yta.model.Languages;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Service allows to get a list of translation directions.
 *
 * The service translates between any of the languages in the list of supported languages.
 * To get this information, set the ui parameter when calling methods.
 *
 * Official REST API documentation: https://tech.yandex.com/translate/doc/dg/reference/getLangs-docpage/
 *
 * @author Vladislav Bauer
 */

public interface LanguageApi {

    /**
     * Gets a list of translation directions and available languages supported by the service.
     * In this case, language names ({@link Language#name()}) are not fetched from the Yandex.Translate service.
     *
     * @return information about available languages and directions of translation
     */
    @Nonnull
    Languages all();

    /**
     * Gets a list of translation directions and available languages supported by the service.
     *
     * @param ui if set, the response contains explanations of language codes
     * @return information about available languages and directions of translation
     */
    @Nonnull
    Languages all(@Nullable Language ui);

    /**
     * Gets a list of translation directions and available languages supported by the service.
     *
     * @param ui if set, the response contains explanations of language codes
     * @return information about available languages and directions of translation
     */
    @Nonnull
    Languages all(@Nullable String ui);

}
