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
