package com.github.vbauer.yta.model.basic;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.ThreadSafe;
import java.util.Optional;

/**
 * Text format could be used in the following services:
 * <ul>
 *     <li>{@link com.github.vbauer.yta.service.fraction.DetectionApi}</li>
 *     <li>{@link com.github.vbauer.yta.service.fraction.TranslationApi}</li>
 * </ul>
 * It allows to specify kind of source text.
 *
 * @author Vladislav Bauer
 */

@ThreadSafe
public enum TextFormat implements HasCode<String> {

    /**
     * Text without markup.
     */
    PLAIN_TEXT("plain"),

    /**
     * Text in HTML format.
     */
    HTML("html");


    private final String code;


    TextFormat(final String code) {
        this.code = code;
    }


    /**
     * Check if it possible to use {@code format} parameter or use default value.
     *
     * @param format text format
     * @return {@code format} if it is not null or {@link TextFormat#PLAIN_TEXT} otherwise
     */
    @Nonnull
    public static TextFormat getOrDefault(final TextFormat format) {
        return Optional.ofNullable(format).orElse(TextFormat.PLAIN_TEXT);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public String code() {
        return code;
    }

}
