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
package com.github.vbauer.yta.model.artificial;

import com.github.vbauer.yta.model.ImmutableTranslation;
import com.github.vbauer.yta.model.Translation;
import com.github.vbauer.yta.model.artificial.LanguagesInfo.LanguagesInfoUtils;
import com.github.vbauer.yta.model.basic.HasCode;
import com.google.common.collect.Iterables;
import org.immutables.gson.Gson.TypeAdapters;
import org.immutables.value.Value.Immutable;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.ThreadSafe;
import java.util.List;
import java.util.Optional;

/**
 * @author Vladislav Bauer
 */

@Immutable
@TypeAdapters
public interface TranslationInfo extends HasCode<Integer> {

    String lang();

    List<String> text();


    @ThreadSafe
    final class TranslationInfoUtils {

        private TranslationInfoUtils() {
            throw new UnsupportedOperationException();
        }


        @Nonnull
        public static Translation convert(final TranslationInfo translationInfo) {
            final String text = Iterables.getFirst(translationInfo.text(), null);

            return ImmutableTranslation.builder()
                .text(Optional.ofNullable(text).orElse(""))
                .direction(LanguagesInfoUtils.convert(translationInfo.lang()))
                .build();
        }

    }

}
