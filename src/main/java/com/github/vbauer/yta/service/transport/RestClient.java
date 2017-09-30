package com.github.vbauer.yta.service.transport;

import java.util.Map;

/**
 * REST client which allows to fetch information from Yandex.Translate service.
 *
 * @author Vladislav Bauer
 */

public interface RestClient {

    /**
     * Make REST API call.
     *
     * @param method url method
     * @param parameters method parameters
     * @return raw response in plain text
     */
    String callMethod(String method, Map<String, Object> parameters);

}
