package com.github.vbauer.yta.service.basic.exception;

/**
 * @author Vladislav Bauer
 */

@SuppressWarnings("serial")
public class ApiException extends YTranslateException {

    /**
     * Possible values are described in {@link com.github.vbauer.yta.service.basic.ApiStatus} class.
     */
    private final int status;


    public ApiException(final int status) {
        super("Can not retrieve information from server: " + status);

        this.status = status;
    }


    /**
     * Get status of error.
     *
     * @return error status
     */
    public int getStatus() {
        return status;
    }

}
