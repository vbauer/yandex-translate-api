package com.github.vbauer.yta.converter;

import com.github.vbauer.yta.model.ImmutableTranslation;
import com.github.vbauer.yta.model.Translation;
import com.github.vbauer.yta.model.artificial.TranslationInfo;
import com.google.common.collect.Iterables;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.ThreadSafe;
import java.util.Optional;

/**
 * Converter which allows to transform type {@link TranslationInfo} to {@link Translation}.
 *
 * @author Vladislav Bauer
 */

@ThreadSafe
public class TranslationConverter extends BasicConverter<TranslationInfo, Translation> {

    public static final TranslationConverter INSTANCE = new TranslationConverter();


    @Nonnull
    @Override
    protected Translation doForward(@Nonnull final TranslationInfo translationInfo) {
        final String text = Iterables.getFirst(translationInfo.text(), null);

        return ImmutableTranslation.builder()
            .text(Optional.ofNullable(text).orElseGet(String::new))
            .direction(DirectionConverter.INSTANCE.convert(translationInfo.lang()))
            .build();
    }

}
