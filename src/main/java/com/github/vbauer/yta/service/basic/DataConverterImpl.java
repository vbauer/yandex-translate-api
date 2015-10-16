package com.github.vbauer.yta.service.basic;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapterFactory;

import java.util.ServiceLoader;

/**
 * @author Vladislav Bauer
 */

public class DataConverterImpl implements DataConverter {

    private static final Gson CONVERTER = createConverter();


    @Override
    public <T> T convert(final String data, final Class<T> targetClass) {
        return CONVERTER.fromJson(data, targetClass);
    }


    private static Gson createConverter() {
        final GsonBuilder builder = new GsonBuilder();
        for (final TypeAdapterFactory factory : ServiceLoader.load(TypeAdapterFactory.class)) {
            builder.registerTypeAdapterFactory(factory);
        }
        return builder.create();
    }

}
