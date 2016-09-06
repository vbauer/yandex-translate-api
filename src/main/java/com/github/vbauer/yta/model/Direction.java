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
package com.github.vbauer.yta.model;

import org.immutables.value.Value.Immutable;
import org.immutables.value.Value.Parameter;

import javax.annotation.Nonnull;
import java.io.Serializable;
import java.util.Optional;

/**
 * Model which represents direction of translation.
 *
 * @author Vladislav Bauer
 */

@SuppressWarnings("serial")
@Immutable
public abstract class Direction implements Serializable {

    public static final String SEPARATOR = "-";


    /**
     * Get source/origin language.
     *
     * @return source language
     */
    @Parameter(order = 0)
    public abstract Optional<Language> source();

    /**
     * Get target/destination language.
     *
     * @return target language
     */
    @Parameter(order = 1)
    public abstract Language target();


    /**
     * A factory method to create direction object using source and target languages.
     *
     * @param source source language
     * @param target target language
     * @return direction (from source to target)
     */
    @Nonnull
    public static Direction of(final Language source, final Language target) {
        return ImmutableDirection.of(Optional.ofNullable(source), target);
    }

    /**
     * A factory method to create direction object using only target language.
     * Source language will be null/empty (and will be detected automatically during translation).
     *
     * @param target target language
     * @return direction (from something to target)
     */
    @Nonnull
    public static Direction of(final Language target) {
        return of(null, target);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        final String prefix = source()
            .map(language -> language.toString() + SEPARATOR)
            .orElseGet(String::new);

        return prefix + target().toString();
    }

}
