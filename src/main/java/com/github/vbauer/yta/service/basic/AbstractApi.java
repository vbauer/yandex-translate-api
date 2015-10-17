package com.github.vbauer.yta.service.basic;

import java.util.Map;

/**
 * @author Vladislav Bauer
 */

public abstract class AbstractApi {

    private final ApiContext context;


    public AbstractApi(final ApiContext context) {
        this.context = context;
    }


    protected final RestClient client() {
        return context.client();
    }

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
