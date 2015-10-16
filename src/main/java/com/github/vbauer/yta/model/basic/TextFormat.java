package com.github.vbauer.yta.model.basic;

import java.util.Optional;

/**
 * @author Vladislav Bauer
 */

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


    public static TextFormat getOrDefault(final TextFormat format) {
        return Optional.of(format).orElse(TextFormat.PLAIN_TEXT);
    }


    @Override
    public String code() {
        return code;
    }

}
