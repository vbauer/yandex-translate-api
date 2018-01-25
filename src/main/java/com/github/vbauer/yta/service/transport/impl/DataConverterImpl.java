package com.github.vbauer.yta.service.transport.impl;

import com.github.vbauer.yta.service.transport.DataConverter;
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
        return CONVERTER.fromJson(data, targetClass);
    }


    private static Gson createConverter() {
        final GsonBuilder builder = new GsonBuilder();
        final ServiceLoader<TypeAdapterFactory> serviceLoader =
            ServiceLoader.load(TypeAdapterFactory.class);

        serviceLoader.forEach(builder::registerTypeAdapterFactory);

        return builder.create();
    }

}
