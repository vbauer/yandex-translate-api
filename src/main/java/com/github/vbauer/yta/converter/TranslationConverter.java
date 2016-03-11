package com.github.vbauer.yta.converter;

import com.github.vbauer.yta.model.Direction;
import com.github.vbauer.yta.model.Translation;
import com.github.vbauer.yta.model.artificial.TranslationInfo;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.ThreadSafe;

/**
 * Converter which allows to transform type {@link TranslationInfo} to {@link Translation}.
 *
 * @author Vladislav Bauer
 */

@ThreadSafe
public class TranslationConverter extends BasicConverter<TranslationInfo, Translation> {

    public static final TranslationConverter INSTANCE = new TranslationConverter();

    /**
     * {@inheritDoc}
     */
    @Nonnull
    @Override
    protected Translation doForward(@Nonnull final TranslationInfo translationInfo) {
        final String text = Strings.nullToEmpty(Iterables.getFirst(translationInfo.text(), null));
        final Direction direction = DirectionConverter.INSTANCE.convert(translationInfo.lang());
        return Translation.of(direction, text);
    }

}
