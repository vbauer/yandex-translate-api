package com.github.vbauer.yta.service.transport;

/**
 * Converter of raw responses from Yandex.Translate service.
 *
 * @author Vladislav Bauer
 */

public interface DataConverter {

    /**
     * Convert raw response from Yandex.Translate to POJO.
     *
     * @param data response in plain text
     * @param targetClass target class
     * @param <T> type of target class
     * @return converted response as POJO
     */
    <T> T convert(String data, Class<T> targetClass);

}
