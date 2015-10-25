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

import com.github.vbauer.yta.model.Direction;
import com.github.vbauer.yta.model.ImmutableDirection;
import com.github.vbauer.yta.model.Language;
import com.github.vbauer.yta.model.Languages;
import com.github.vbauer.yta.model.basic.HasCode.HasCodeUtils;
import com.google.common.collect.Lists;
import org.immutables.gson.Gson.TypeAdapters;
import org.immutables.value.Value.Immutable;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Vladislav Bauer
 */

@Immutable
@TypeAdapters
public interface LanguagesInfo {

    List<String> dirs();

    Map<String, String> langs();


    final class LanguagesInfoUtils {

        private LanguagesInfoUtils() {
            throw new UnsupportedOperationException();
        }


        public static Direction convert(final String direction) {
            return convertDirection(Lists.newArrayList(), direction);
        }

        public static Languages convert(final LanguagesInfo languagesInfo) {
            final Map<String, String> langs = languagesInfo.langs();
            final List<String> dirs = languagesInfo.dirs();

            final List<Language> languages = langs.entrySet().stream()
                .map(entry -> Language.of(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());

            final List<Direction> directions = dirs.stream()
                .map(dir -> convertDirection(languages, dir))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

            return Languages.of(languages, directions);
        }

        private static Direction convertDirection(final Collection<Language> languages, final String dir) {
            final String[] parts = dir.split(Direction.SEPARATOR);
            final String from = parts[0];
            final String to = parts[1];
            return composeDirection(languages, from, to);
        }

        private static Direction composeDirection(
            final Collection<Language> languages, final String from, final String to
        ) {
            final Language source = findOrCreateLanguage(languages, from);
            final Language target = findOrCreateLanguage(languages, to);

            return ImmutableDirection.builder()
                .source(source)
                .target(target)
                .build();
        }

        private static Language findOrCreateLanguage(final Collection<Language> languages, final String code) {
            return HasCodeUtils.findByCode(languages, code).orElseGet(() -> {
                final Language language = Language.of(code);
                languages.add(language);
                return language;
            });
        }

    }

}
