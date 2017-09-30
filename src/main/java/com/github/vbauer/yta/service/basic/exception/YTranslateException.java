package com.github.vbauer.yta.service.basic.exception;

/**
 * Basic class for all exceptions.
 *
 * @author Vladislav Bauer
 */

@SuppressWarnings("serial")
public class YTranslateException extends RuntimeException {

    public YTranslateException(final String message) {
        super(message);
    }

    public YTranslateException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public YTranslateException(final Throwable cause) {
        super(cause);
    }

}
