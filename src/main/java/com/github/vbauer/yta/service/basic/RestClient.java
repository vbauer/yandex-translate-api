package com.github.vbauer.yta.service.basic;

import java.util.Map;

/**
 * @author Vladislav Bauer
 */

public interface RestClient {

    String callMethod(String method, Map<String, Object> parameters);

}
