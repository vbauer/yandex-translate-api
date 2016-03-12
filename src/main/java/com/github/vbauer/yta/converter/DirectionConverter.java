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
import com.github.vbauer.yta.model.Language;
import com.github.vbauer.yta.model.basic.HasCode;
import com.google.common.collect.Lists;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.ThreadSafe;
import java.util.Collection;

/**
 * Converter which allows to transform type {@link String} to {@link Direction}.
 *
 * @author Vladislav Bauer
 */

@ThreadSafe
public class DirectionConverter extends BasicConverter<String, Direction> {

    public static final DirectionConverter INSTANCE = new DirectionConverter();


    /**
     * {@inheritDoc}
     */
    @Nonnull
    @Override
    protected Direction doForward(@Nonnull final String direction) {
        return convertDirection(Lists.newArrayList(), direction);
    }


    /**
     * Detect translation direction using collection with languages and
     * text representation of the given direction.
     *
     * @param languages collection with languages
     * @param dir text representation of the direction
     * @return direction model object
     */
    public Direction convertDirection(final Collection<Language> languages, final String dir) {
        final String[] parts = dir.split(Direction.SEPARATOR);
        final String from = parts[0];
        final String to = parts[1];
        return composeDirection(languages, from, to);
    }


    private Direction composeDirection(
        final Collection<Language> languages, final String from, final String to
    ) {
        final Language source = findOrCreateLanguage(languages, from);
        final Language target = findOrCreateLanguage(languages, to);
        return Direction.of(source, target);
    }

    private Language findOrCreateLanguage(final Collection<Language> languages, final String code) {
        return HasCode.HasCodeUtils.findByCode(languages, code).orElseGet(() -> {
            final Language language = Language.of(code);
            languages.add(language);
            return language;
        });
    }

}
