package com.github.vbauer.yta.service.basic;

import org.immutables.value.Value.Immutable;

/**
 * @author Vladislav Bauer
 */

@Immutable
public abstract class ApiContext {

    public abstract String key();

    public abstract RestClient client();

    public abstract DataConverter converter();


    public static ApiContext of(final String key) {
        return ImmutableApiContext.builder()
            .key(key)
            .client(new RestClientImpl(key))
            .converter(new DataConverterImpl())
            .build();
    }

}
