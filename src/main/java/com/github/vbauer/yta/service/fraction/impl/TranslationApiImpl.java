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
package com.github.vbauer.yta.service.fraction.impl;

import com.github.vbauer.yta.converter.TranslationConverter;
import com.github.vbauer.yta.model.Direction;
import com.github.vbauer.yta.model.Language;
import com.github.vbauer.yta.model.Translation;
import com.github.vbauer.yta.model.artificial.TranslationInfo;
import com.github.vbauer.yta.model.basic.TextFormat;
import com.github.vbauer.yta.service.basic.AbstractApi;
import com.github.vbauer.yta.service.basic.ApiContext;
import com.github.vbauer.yta.service.basic.ApiStatus;
import com.github.vbauer.yta.service.fraction.TranslationApi;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import java.util.Map;

/**
 * See {@link TranslationApi}.
 *
 * @author Vladislav Bauer
 */

@ThreadSafe
public class TranslationApiImpl extends AbstractApi implements TranslationApi {

    public static final String METHOD_DETECT = "/translate";
    public static final String ATTR_LANG = "lang";
    public static final String ATTR_TEXT = "text";
    public static final String ATTR_FORMAT = "format";


    public TranslationApiImpl(final ApiContext context) {
        super(context);
    }


    /**
     * {@inheritDoc}
     */
    @Nonnull
    @Override
    public Translation translate(
        @Nullable final String text,
        @Nonnull final Language language
    ) {
        return translate(text, Direction.of(language));
    }

    /**
     * {@inheritDoc}
     */
    @Nonnull
    @Override
    public Translation translate(
        @Nullable final String text,
        @Nonnull final Direction direction
    ) {
        return translate(text, direction, TextFormat.PLAIN_TEXT);
    }

    /**
     * {@inheritDoc}
     */
    @Nonnull
    @Override
    public Translation translate(
        @Nullable final String text,
        @Nonnull final Direction direction,
        @Nullable final TextFormat format
    ) {
        final Map<String, Object> params = ImmutableMap.<String, Object>builder()
            .put(ATTR_TEXT, Strings.nullToEmpty(text))
            .put(ATTR_LANG, direction.toString())
            .put(ATTR_FORMAT, TextFormat.getOrDefault(format).code())
            .build();

        final TranslationInfo data = callMethod(TranslationInfo.class, METHOD_DETECT, params);
        ApiStatus.check(data.code());

        return Preconditions.checkNotNull(TranslationConverter.INSTANCE.convert(data));
    }

}
