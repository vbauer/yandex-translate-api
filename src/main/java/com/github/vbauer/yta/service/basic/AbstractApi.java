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
