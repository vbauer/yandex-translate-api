package com.github.vbauer.yta.converter;

import com.google.common.base.Converter;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.ThreadSafe;

/**
 * Basic converter which is based on the {@link Converter} and allows to transform type A to B.
 * Backward transformation is not supported.
 *
 * @param <A> input type
 * @param <B> output type
 * @author Vladislav Bauer
 */

@ThreadSafe
public abstract class BasicConverter<A, B> extends Converter<A, B> {

    @Nonnull
    @Override
    protected A doBackward(@Nonnull final B input) {
        throw new UnsupportedOperationException("Backward transformation is not supported");
    }

}
