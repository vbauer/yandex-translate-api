package com.github.vbauer.yta.service.transport.impl;

import com.github.vbauer.yta.service.basic.ApiStatus;
import com.github.vbauer.yta.service.basic.exception.YTranslateException;
import com.github.vbauer.yta.service.transport.RestClient;

import javax.annotation.concurrent.ThreadSafe;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * See {@link RestClient}.
 *
 * @author Vladislav Bauer
 */

@ThreadSafe
public class RestClientImpl implements RestClient {

    public static final String SERVICE_URL = "https://translate.yandex.net/api/v1.5/tr.json";
    public static final String ATTR_KEY = "key";
    public static final int DEFAULT_TIMEOUT = 30000;

    private static final String METHOD_POST = "POST";
    private static final String PARAMETER_DELIMITER = "&";
    private static final String PARAMETER_ASSIGNMENT = "=";
    private static final String HEADER_CONTENT_TYPE = "Content-Type";
    private static final String HEADER_CONTENT_TYPE_VALUE = "application/x-www-form-urlencoded; charset=UTF-8";


    private final String key;


    public RestClientImpl(final String key) {
        this.key = key;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public String callMethod(final String method, final Map<String, Object> parameters) {
        try {
            final String uri = formatMethodUrl(method);
            final Map<String, Object> params = composeRequestParameters(parameters);
            final byte[] body = generatePostBody(params);

            final HttpURLConnection connection = createHttpURLConnection(uri);
            connection.setFixedLengthStreamingMode(body.length);
            connection.connect();

            try {
                try (OutputStream os = connection.getOutputStream()) {
                    os.write(body);
                }

                ApiStatus.check(connection.getResponseCode());

                try (
                    InputStream inputStream = connection.getInputStream();
                    InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
                    BufferedReader bufferedReader = new BufferedReader(streamReader)
                ) {
                    return bufferedReader.lines().collect(Collectors.joining(""));
                }
            } finally {
                connection.disconnect();
            }
        } catch (final IOException | RuntimeException ex) {
            throw new YTranslateException(
                String.format("Could not call method \"%s\" using %s", method, parameters), ex
            );
        }
    }


    private HttpURLConnection createHttpURLConnection(final String uri) throws IOException {
        final URL url = new URL(uri);
        final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setConnectTimeout(DEFAULT_TIMEOUT);
        connection.setReadTimeout(DEFAULT_TIMEOUT);
        connection.setRequestMethod(METHOD_POST);
        connection.setDoOutput(true);
        connection.setRequestProperty(HEADER_CONTENT_TYPE, HEADER_CONTENT_TYPE_VALUE);
        return connection;
    }

    private byte[] generatePostBody(final Map<String, Object> params) throws UnsupportedEncodingException {
        final StringJoiner body = new StringJoiner(PARAMETER_DELIMITER);

        for (final Map.Entry<String, Object> entry : params.entrySet()) {
            final String key = encode(entry.getKey());
            final String value = encode(Objects.toString(entry.getValue(), ""));

            body.add(key + PARAMETER_ASSIGNMENT + value);
        }

        return body.toString().getBytes(StandardCharsets.UTF_8);
    }

    private String encode(final String k) throws UnsupportedEncodingException {
        return URLEncoder.encode(k, StandardCharsets.UTF_8.name());
    }

    private String formatMethodUrl(final String method) {
        return SERVICE_URL + method;
    }

    private Map<String, Object> composeRequestParameters(final Map<String, Object> parameters) {
        final Map<String, Object> params = new HashMap<>();
        if (parameters != null) {
            params.putAll(parameters);
        }
        params.put(ATTR_KEY, key);
        return params;
    }

}
