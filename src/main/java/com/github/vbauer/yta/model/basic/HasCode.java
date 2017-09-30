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
