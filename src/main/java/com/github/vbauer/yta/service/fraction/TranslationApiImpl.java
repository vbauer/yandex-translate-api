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
import com.github.vbauer.yta.model.Translation;
import com.github.vbauer.yta.model.artificial.TranslationInfo;
import com.github.vbauer.yta.model.artificial.TranslationInfo.TranslationInfoUtils;
import com.github.vbauer.yta.model.basic.TextFormat;
import com.github.vbauer.yta.service.basic.AbstractApi;
import com.github.vbauer.yta.service.basic.ApiContext;
import com.github.vbauer.yta.service.basic.ApiStatus;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;

import java.util.Map;

/**
 * @author Vladislav Bauer
 */

public class TranslationApiImpl extends AbstractApi implements TranslationApi {

    private static final String METHOD_DETECT = "/translate";
    private static final String ATTR_LANG = "lang";
    private static final String ATTR_TEXT = "text";
    private static final String ATTR_FORMAT = "format";


    public TranslationApiImpl(final ApiContext context) {
        super(context);
    }


    @Override
    public Translation translate(final String text, final Language language) {
        return translate(text, Direction.of(language));
    }

    @Override
    public Translation translate(final String text, final Direction direction) {
        return translate(text, direction, TextFormat.PLAIN_TEXT);
    }

    @Override
    public Translation translate(final String text, Direction direction, final TextFormat format) {
        final Map<String, Object> params = ImmutableMap.<String, Object>builder()
            .put(ATTR_TEXT, Strings.nullToEmpty(text))
            .put(ATTR_LANG, direction.toString())
            .put(ATTR_FORMAT, TextFormat.getOrDefault(format).code())
            .build();

        final TranslationInfo data = callMethod(TranslationInfo.class, METHOD_DETECT, params);
        ApiStatus.check(data.code());

        return TranslationInfoUtils.convert(data);
    }

}
