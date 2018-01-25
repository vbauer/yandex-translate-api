package com.github.vbauer.yta.service.fraction;

import com.github.vbauer.yta.model.Language;
import com.github.vbauer.yta.model.basic.TextFormat;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Optional;

/**
 * <p>
 * Service allows to detects language of specified text.
 * </p>
 *
 * <a href="https://tech.yandex.com/translate/doc/dg/reference/detect-docpage/">
 * Official REST API documentation
 * </a>
 *
 * @author Vladislav Bauer
 */

public interface DetectionApi {

    /**
     * Detects the language of the specified text. Text format is {@link TextFormat#PLAIN_TEXT}.
     *
     * @param text the text to detect the language for
     * @return detected language
     */
    @Nonnull
    Optional<Language> detect(@Nullable String text);

    /**
     * Detects the language of the specified text.
     *
     * @param text the text to detect the language for
     * @param format text format: html or plain text
     * @return detected language
     */
    @Nonnull
    Optional<Language> detect(@Nullable String text, @Nullable TextFormat format);

}
