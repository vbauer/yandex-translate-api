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

import com.github.vbauer.yta.service.transport.DataConverter;
import com.github.vbauer.yta.service.transport.RestClient;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.ThreadSafe;
import java.util.Map;

/**
 * Basic class for API services.
 *
 * @author Vladislav Bauer
 */

@ThreadSafe
public abstract class AbstractApi {

    @Nonnull
    private final ApiContext context;


    public AbstractApi(@Nonnull final ApiContext context) {
        this.context = context;
    }

    /**
     * Get REST client from API context.
     *
     * @return REST client
     */
    @Nonnull
    protected final RestClient client() {
        return context.client();
    }

    /**
     * Get data converter from API context.
     *
     * @return data converter
     */
    @Nonnull
    protected final DataConverter converter() {
        return context.converter();
    }

    protected final <T> T callMethod(
        final Class<T> targetClass, final String method, final Map<String, Object> parameters
    ) {
        final String data = client().callMethod(method, parameters);
        return converter().convert(data, targetClass);
    }

}
