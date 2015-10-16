package com.github.vbauer.yta.service.basic;

import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.collect.Maps;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.BaseRequest;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.HttpClients;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/**
 * @author Vladislav Bauer
 */

public class RestClientImpl implements RestClient {

    private static final String SERVICE_URL = "https://translate.yandex.net/api/v1.5/tr.json";
    private static final String ATTR_KEY = "key";
    private static final int DEFAULT_TIMEOUT = 30000;

    static {
        final HttpClient httpClient = createClient();
        Unirest.setHttpClient(httpClient);
    }


    private final String key;


    public RestClientImpl(final String key) {
        this.key = key;
    }


    @Override
    public String callMethod(final RestMethodType type, final String method, final Map<String, Object> parameters) {
        final Map<String, Object> params = Maps.newHashMap();
        if (parameters != null) {
            params.putAll(parameters);
        }
        params.put(ATTR_KEY, key);

        try {
            final BaseRequest request = createHttpRequest(type, method, params);
            final HttpResponse<String> response = request.asString();

            System.out.println(response.getBody());
            ApiStatus.check(response.getStatus());

            return response.getBody();
        } catch (final Throwable ex) {
            throw Throwables.propagate(ex);
        }
    }


    private static HttpClient createClient() {
        final SSLContext sslContext = createSslContext();
        final SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(sslContext);
        final RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(DEFAULT_TIMEOUT)
                .setConnectTimeout(DEFAULT_TIMEOUT)
                .build();

        return HttpClients.custom()
                .setSSLSocketFactory(socketFactory)
                .setDefaultRequestConfig(requestConfig)
                .build();
    }

    private static SSLContext createSslContext() {
        try {
            return new SSLContextBuilder()
                .loadTrustMaterial(null, new TrustSelfSignedStrategy())
                .build();
        } catch (final NoSuchAlgorithmException | KeyManagementException | KeyStoreException ex) {
            throw Throwables.propagate(ex);
        }
    }


    private BaseRequest createHttpRequest(
        final RestMethodType type, final String method, final Map<String, Object> parameters
    ) {
        final String url = SERVICE_URL + method;
        switch (Preconditions.checkNotNull(type)) {
            case GET:
                return Unirest.get(url).queryString(parameters);
            case POST:
                return Unirest.post(url).fields(parameters);
            default:
                throw new UnsupportedOperationException();
        }
    }

}
