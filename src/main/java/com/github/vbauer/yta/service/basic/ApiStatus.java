/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Vladislav Bauer
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.github.vbauer.yta.service.basic;

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
     * Check that status is {@link #ERR_OK} and throw {@link ApiException} otherwise.
     *
     * @param status status code
     */
    public static void check(final int status) {
        if (status != ApiStatus.ERR_OK) {
            throw new ApiException(status);
        }
    }

}
