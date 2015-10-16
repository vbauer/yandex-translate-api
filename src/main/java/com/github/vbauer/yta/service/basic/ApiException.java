package com.github.vbauer.yta.service.basic;

/**
 * @author Vladislav Bauer
 */

public class ApiException extends RuntimeException {

    private final int status;


    public ApiException(final int status) {
        this.status = status;
    }


    public int getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        final int status = getStatus();
        return String.format("Can not retrieve information from server: %d", status);
    }

}
