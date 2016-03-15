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

/**
 * @author Vladislav Bauer
 */

@SuppressWarnings("serial")
public class ApiException extends RuntimeException {

    /**
     * Possible values are described in {@link com.github.vbauer.yta.service.basic.ApiStatus} class.
     */
    private final int status;


    public ApiException(final int status) {
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

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMessage() {
        final int status = getStatus();
        return String.format("Can not retrieve information from server: %d", status);
    }

}
