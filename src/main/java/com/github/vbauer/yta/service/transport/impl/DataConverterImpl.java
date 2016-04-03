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
package com.github.vbauer.yta.service.transport.impl;

import com.github.vbauer.yta.service.transport.DataConverter;
import com.google.common.base.Preconditions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapterFactory;

import javax.annotation.concurrent.ThreadSafe;
import java.util.ServiceLoader;

/**
` * See {@link DataConverter}.
 *
 * @author Vladislav Bauer
 */

@ThreadSafe
public class DataConverterImpl implements DataConverter {

    private static final Gson CONVERTER = createConverter();


    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T convert(final String data, final Class<T> targetClass) {
        Preconditions.checkNotNull(targetClass, "Target class must be defined");

        return CONVERTER.fromJson(data, targetClass);
    }


    private static Gson createConverter() {
        final GsonBuilder builder = new GsonBuilder();
        ServiceLoader.load(TypeAdapterFactory.class).forEach(builder::registerTypeAdapterFactory);
        return builder.create();
    }

}
