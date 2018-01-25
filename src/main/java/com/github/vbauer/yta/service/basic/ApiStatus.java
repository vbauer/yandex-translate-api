package com.github.vbauer.yta.service.basic;

import com.github.vbauer.yta.service.basic.exception.YTranslateApiException;

import javax.annotation.concurrent.ThreadSafe;

/**
 * @author Vladislav Bauer
 */

@ThreadSafe
public final class ApiStatus {

    /**
     * Operation completed successfully.
     */
    public static final int ERR_OK = 200;

    /**
     * Invalid API key.
     */
    public static final int ERR_KEY_INVALID = 401;

    /**
     * This API key has been blocked.
     */
    public static final int ERR_KEY_BLOCKED = 402;

    /**
     * You have reached the daily limit for requests
     * (including calls of the translate method).
     */
    public static final int ERR_DAILY_REQ_LIMIT_EXCEEDED = 403;

    /**
     * You have reached the daily limit for the volume of translated text
     * (including calls of the translate method).
     */
    public static final int ERR_DAILY_CHAR_LIMIT_EXCEEDED = 404;

    /**
     * The text size exceeds the maximum.
     */
    public static final int ERR_TEXT_TOO_LONG = 413;

    /**
     * The text could not be translated.
     */
    public static final int ERR_UNPROCESSABLE_TEXT = 422;

    /**
     * The specified translation direction is not supported.
     */
    public static final int ERR_LANG_NOT_SUPPORTED = 501;


    private ApiStatus() {
        throw new UnsupportedOperationException();
    }


    /**
     * Check that status is {@link #ERR_OK} and throw {@link YTranslateApiException} otherwise.
     *
     * @param status status code
     */
    public static void check(final int status) {
        if (status != ApiStatus.ERR_OK) {
            throw new YTranslateApiException(status);
        }
    }

}
