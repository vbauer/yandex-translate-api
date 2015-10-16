package com.github.vbauer.yta.model.basic;

import com.google.common.collect.ImmutableList;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

/**
 * @author Vladislav Bauer
 */

public interface HasCode<T> extends Serializable {

    T code();


    final class HasCodeUtils {

        private HasCodeUtils() {
            throw new UnsupportedOperationException();
        }


        public static <T, E extends HasCode<T>> Optional<E> findByCode(final T code, final Collection<E> collection) {
            return Optional.ofNullable(collection)
                .orElseGet(ImmutableList::of)
                .stream()
                    .filter(item -> Objects.equals(code, item.code()))
                    .findFirst();
        }

    }

}
