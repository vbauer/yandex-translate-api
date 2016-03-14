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
package com.github.vbauer.yta.model.basic;

import com.google.common.collect.ImmutableList;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.ThreadSafe;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

/**
 * Interface which indicates that class should have code.
 *
 * @param <T> type of code
 * @author Vladislav Bauer
 */

public interface HasCode<T> extends Serializable {

    /**
     * Get code value.
     *
     * @return code
     */
    T code();


    /**
     * Utility class to work with {@link HasCode} interface/instances.
     *
     * @author Vladislav Bauer
     */
    @ThreadSafe
    final class HasCodeUtils {

        private HasCodeUtils() {
            throw new UnsupportedOperationException();
        }


        /**
         * Find find corresponding {@link HasCode} element from collection by code.
         *
         * @param collection collection with {@link HasCode} instances.
         * @param code code value
         * @param <T> type of code value
         * @param <E> kind of {@link HasCode} elements
         * @return element from collection with the corresponding code or null otherwise
         */
        @Nonnull
        public static <T, E extends HasCode<T>> Optional<E> findByCode(final Collection<E> collection, final T code) {
            return Optional.ofNullable(collection)
                .orElseGet(ImmutableList::of)
                .stream()
                    .filter(item -> Objects.equals(code, item.code()))
                    .findFirst();
        }

    }

}
