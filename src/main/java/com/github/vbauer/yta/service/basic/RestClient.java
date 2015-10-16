package com.github.vbauer.yta.service.basic;

import java.util.Map;

/**
 * @author Vladislav Bauer
 */

public interface RestClient {

    String callMethod(RestMethodType type, String method, Map<String, Object> parameters);


    enum RestMethodType {
        GET,
        POST
    }

}
