package com.github.vbauer.yta.converter;

import com.github.vbauer.yta.model.Direction;
import com.github.vbauer.yta.model.Translation;
import com.github.vbauer.yta.model.artificial.TranslationInfo;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.ThreadSafe;
import java.util.Objects;

/**
 * Converter which allows to transform type {@link TranslationInfo} to {@link Translation}.
 *
 * @author Vladislav Bauer
 */

@ThreadSafe
public class TranslationConverter implements BasicConverter<TranslationInfo, Translation> {

    public static final TranslationConverter INSTANCE = new TranslationConverter();


    /**
     * {@inheritDoc}
     */
    @Nonnull
    @Override
    public Translation convert(@Nonnull final TranslationInfo translationInfo) {
        final String text = Objects.toString(translationInfo.text().stream().findFirst().orElse(null), "");
        final Direction direction = DirectionConverter.INSTANCE.convert(translationInfo.lang());
        return Translation.of(direction, text);
    }

}
