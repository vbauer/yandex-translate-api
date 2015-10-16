package com.github.vbauer.yta.service.basic;

/**
 * @author Vladislav Bauer
 */

public interface DataConverter {

    <T> T convert(String data, Class<T> targetClass);

}
