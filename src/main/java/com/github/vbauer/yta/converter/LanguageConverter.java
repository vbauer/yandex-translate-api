package com.github.vbauer.yta.converter;

import com.github.vbauer.yta.model.Language;
import com.github.vbauer.yta.model.artificial.LanguageInfo;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.ThreadSafe;
import java.util.Optional;

/**
 * Converter which allows to transform type {@link LanguageInfo} to {@link Language}.
 *
 * @author Vladislav Bauer
 */

@ThreadSafe
public class LanguageConverter implements BasicConverter<LanguageInfo, Optional<Language>> {

    public static final LanguageConverter INSTANCE = new LanguageConverter();


    /**
     * {@inheritDoc}
     */
    @Nonnull
    @Override
    public Optional<Language> convert(@Nonnull final LanguageInfo languageInfo) {
        return languageInfo.lang().map(Language::of);
    }

}
