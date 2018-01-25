package com.github.vbauer.yta.service.fraction;

import com.github.vbauer.yta.model.Direction;
import com.github.vbauer.yta.model.Language;
import com.github.vbauer.yta.model.basic.TextFormat;
import com.github.vbauer.yta.model.Translation;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * <p>
 * Service allows to translate text to the specified language.
 * </p>
 *
 * <a href="https://tech.yandex.com/translate/doc/dg/reference/translate-docpage/">
 * Official REST API documentation
 * </a>
 *
 * @author Vladislav Bauer
 */

public interface TranslationApi {

    /**
     * Translates text to the specified language. Source language is detected by text.
     * Text format is {@link TextFormat#PLAIN_TEXT}.
     *
     * @param text the text to translate
     * @param language the target language for translation
     * @return translated text
     */
    @Nonnull
    Translation translate(@Nullable String text, @Nonnull Language language);

    /**
     * Translates text to the specified language. Text format is {@link TextFormat#PLAIN_TEXT}.
     *
     * @param text the text to translate
     * @param direction the direction of translation
     * @return translated text
     */
    @Nonnull
    Translation translate(@Nullable String text, @Nonnull Direction direction);

    /**
     * Translates text to the specified language.
     *
     * @param text the text to translate
     * @param direction the direction of translation
     * @param format the text format
     * @return translated text
     */
    @Nonnull
    Translation translate(
        @Nullable String text, @Nonnull Direction direction, @Nullable TextFormat format
    );

}
