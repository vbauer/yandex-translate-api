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
import com.github.vbauer.yta.model.artificial.LanguagesInfo;
import com.github.vbauer.yta.model.artificial.LanguagesInfo.LanguagesInfoUtils;
import com.github.vbauer.yta.service.basic.AbstractApi;
import com.github.vbauer.yta.service.basic.ApiContext;
import com.google.common.collect.ImmutableMap;

import java.util.Map;

/**
 * @author Vladislav Bauer
 */

public class LanguageApiImpl extends AbstractApi implements LanguageApi {

    private static final String METHOD_GET_LANGS = "/getLangs";
    private static final String ATTR_UI = "ui";


    public LanguageApiImpl(final ApiContext context) {
        super(context);
    }


    @Override
    public Languages all() {
        return all((String) null);
    }

    @Override
    public Languages all(final Language ui) {
        return all(ui == null ? null : ui.code());
    }

    @Override
    public Languages all(final String ui) {
        final Map<String, Object> data = ui == null ? null : ImmutableMap.of(ATTR_UI, ui);
        final LanguagesInfo languagesInfo = callMethod(LanguagesInfo.class, METHOD_GET_LANGS, data);

        return LanguagesInfoUtils.convert(languagesInfo);
    }

}
