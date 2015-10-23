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
package com.github.vbauer.yta.service;

import com.github.vbauer.yta.service.basic.AbstractApi;
import com.github.vbauer.yta.service.basic.ApiContext;
import com.github.vbauer.yta.service.fraction.DetectionApi;
import com.github.vbauer.yta.service.fraction.DetectionApiImpl;
import com.github.vbauer.yta.service.fraction.LanguageApi;
import com.github.vbauer.yta.service.fraction.LanguageApiImpl;
import com.github.vbauer.yta.service.fraction.TranslationApi;
import com.github.vbauer.yta.service.fraction.TranslationApiImpl;

/**
 * {@inheritDoc}
 *
 * @author Vladislav Bauer
 */

public class YTranslateApiImpl extends AbstractApi implements YTranslateApi {

    private final LanguageApi languageApi;
    private final DetectionApi detectionApi;
    private final TranslationApi translationApi;


    public YTranslateApiImpl(final String key) {
        this(ApiContext.of(key));
    }

    public YTranslateApiImpl(final ApiContext context) {
        super(context);

        this.languageApi = new LanguageApiImpl(context);
        this.detectionApi = new DetectionApiImpl(context);
        this.translationApi = new TranslationApiImpl(context);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public LanguageApi languageApi() {
        return languageApi;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DetectionApi detectionApi() {
        return detectionApi;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TranslationApi translationApi() {
        return translationApi;
    }

}
