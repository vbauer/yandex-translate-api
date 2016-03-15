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
import com.github.vbauer.yta.service.transport.impl.DataConverterImpl;
import com.github.vbauer.yta.service.transport.impl.RestClientImpl;
import org.immutables.value.Value.Immutable;

import javax.annotation.Nonnull;

/**
 * API context is a model with core functionality to work with Yandex.Translate API.
 *
 * @author Vladislav Bauer
 */

@Immutable
public abstract class ApiContext {

    /**
     * Get Yandex.Translate API key.
     *
     * @return API key
     */
    @Nonnull
    public abstract String key();

    /**
     * Get REST client.
     * It allows to fetch data from Yandex.Translate service.
     *
     * @return REST client
     */
    @Nonnull
    public abstract RestClient client();

    /**
     * Get data converter.
     * It is necessary to convert data from REST client to internal models.
     *
     * @return data converter
     */
    @Nonnull
    public abstract DataConverter converter();


    /**
     * Create API context object with default configuration.
     *
     * @param key Yandex.Translate API key
     * @return API context
     */
    @Nonnull
    public static ApiContext of(final String key) {
        return ImmutableApiContext.builder()
            .key(key)
            .client(new RestClientImpl(key))
            .converter(new DataConverterImpl())
            .build();
    }

}
