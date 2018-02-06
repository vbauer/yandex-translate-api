package com.github.vbauer.yta.model.basic;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
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
    @Nonnull
    T code();


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
    static <T, E extends HasCode<T>> Optional<E> findByCode(
        @Nullable final Collection<E> collection, @Nullable final T code
    ) {
        return Optional.ofNullable(collection)
            .orElseGet(Collections::emptyList)
            .stream()
                .filter(item -> Objects.equals(code, item.code()))
                .findFirst();
    }

}
