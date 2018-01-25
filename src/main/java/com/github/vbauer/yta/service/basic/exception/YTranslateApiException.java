package com.github.vbauer.yta.service.basic.exception;

/**
 * Exception class for problems corresponding to Yandex Translate API service.
 *
 * @author Vladislav Bauer
 */

@SuppressWarnings("serial")
public class YTranslateApiException extends YTranslateException {

    /**
     * Possible values are described in {@link com.github.vbauer.yta.service.basic.ApiStatus} class.
     */
    private final int status;


    public YTranslateApiException(final int status) {
        super("Can not retrieve information from Yandex Translate service. Status: " + status);

        this.status = status;
    }


    /**
     * Get status of error.
     * See {@link com.github.vbauer.yta.service.basic.ApiStatus}.
     *
     * @return error status
     */
    public int getStatus() {
        return status;
    }

}
