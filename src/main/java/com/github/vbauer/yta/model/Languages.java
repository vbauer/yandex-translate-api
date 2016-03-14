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

import javax.annotation.Nonnull;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

/**
 * Model represents information about available languages and translation directions.
 *
 * @author Vladislav Bauer
 */

@SuppressWarnings("serial")
@Immutable
public abstract class Languages implements Serializable {

    /**
     * Get collection of available languages.
     *
     * @return languages
     */
    public abstract Set<Language> languages();

    /**
     * Get collection of possible directions.
     * Each direction's language should be presented in {@link #languages()}.
     *
     * @return directions
     */
    public abstract Set<Direction> directions();


    /**
     * A factory method to create object using given languages and directions.
     *
     * @param languages collection of languages
     * @param directions collection of directions
     * @return "languages" object
     */
    @Nonnull
    public static Languages of(final Collection<Language> languages, final Collection<Direction> directions) {
        return ImmutableLanguages.builder()
            .languages(languages)
            .directions(directions)
            .build();
    }

}
