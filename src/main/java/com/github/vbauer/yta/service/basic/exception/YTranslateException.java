package com.github.vbauer.yta.service.basic.exception;

import javax.annotation.Nonnull;

/**
 * Basic class for all exceptions corresponding to yandex-translate-api library.
 *
 * @author Vladislav Bauer
 */

@SuppressWarnings("serial")
public class YTranslateException extends RuntimeException {

    public YTranslateException(@Nonnull final String message) {
        super(message);
    }

    public YTranslateException(@Nonnull final String message, @Nonnull final Throwable cause) {
        super(message, cause);
    }

}
