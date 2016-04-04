/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Vladislav Bauer
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.github.vbauer.yta.service.transport.impl;

import com.github.vbauer.yta.service.basic.ApiStatus;
import com.github.vbauer.yta.service.transport.RestClient;
import com.google.common.base.Throwables;
import com.google.common.collect.Maps;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import javaslang.control.Try;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;

import javax.annotation.concurrent.ThreadSafe;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

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

    private final AtomicBoolean initialized = new AtomicBoolean(false);
    private final String key;


    public RestClientImpl(final String key) {
        this.key = key;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public String callMethod(final String method, final Map<String, Object> parameters) {
        return Try.of(() -> {
            initHttpClientIfNecessary();

            final String url = formatMethodUrl(method);
            final Map<String, Object> params = composeRequestParameters(parameters);
            final HttpResponse<String> response =
                Unirest.post(url)
                    .fields(params)
                    .asString();

            ApiStatus.check(response.getStatus());

            return response.getBody();
        }).getOrElseThrow(Throwables::propagate);
    }


    private String formatMethodUrl(final String method) {
        return SERVICE_URL + method;
    }

    private Map<String, Object> composeRequestParameters(final Map<String, Object> parameters) {
        final Map<String, Object> params = Maps.newHashMap();
        if (parameters != null) {
            params.putAll(parameters);
        }
        params.put(ATTR_KEY, key);
        return params;
    }

    private void initHttpClientIfNecessary() throws Exception {
        if (initialized.compareAndSet(false, true)) {
            final HttpClient httpClient = createClient();
            Unirest.setHttpClient(httpClient);
        }
    }

    private HttpClient createClient() throws Exception {
        final SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(
            SSLContexts.custom()
                .loadTrustMaterial(null, new TrustSelfSignedStrategy())
                .build()
        );

        final RequestConfig requestConfig = RequestConfig.custom()
            .setSocketTimeout(DEFAULT_TIMEOUT)
            .setConnectTimeout(DEFAULT_TIMEOUT)
            .setConnectionRequestTimeout(DEFAULT_TIMEOUT)
            .setRedirectsEnabled(true)
            .build();

        return HttpClients.custom()
            .setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE)
            .setSSLSocketFactory(socketFactory)
            .setDefaultRequestConfig(requestConfig)
            .build();
    }

}
