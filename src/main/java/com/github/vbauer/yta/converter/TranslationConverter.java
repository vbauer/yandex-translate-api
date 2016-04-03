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
package com.github.vbauer.yta.converter;

import com.github.vbauer.yta.model.Direction;
import com.github.vbauer.yta.model.Translation;
import com.github.vbauer.yta.model.artificial.TranslationInfo;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.ThreadSafe;

/**
 * Converter which allows to transform type {@link TranslationInfo} to {@link Translation}.
 *
 * @author Vladislav Bauer
 */

@ThreadSafe
public class TranslationConverter extends BasicConverter<TranslationInfo, Translation> {

    public static final TranslationConverter INSTANCE = new TranslationConverter();


    /**
     * {@inheritDoc}
     */
    @Nonnull
    @Override
    protected Translation doForward(@Nonnull final TranslationInfo translationInfo) {
        final String text = Strings.nullToEmpty(Iterables.getFirst(translationInfo.text(), null));
        final Direction direction = DirectionConverter.INSTANCE.convert(translationInfo.lang());
        return Translation.of(direction, text);
    }

}
