package com.github.vbauer.yta.service.transport

import com.github.vbauer.yta.service.transport.impl.RestClientImpl
import groovy.json.JsonSlurper
import spock.lang.Specification

import static com.github.vbauer.yta.common.AbstractApiSpec.KEY
import static com.github.vbauer.yta.service.fraction.impl.LanguageApiImpl.METHOD_GET_LANGS
import static com.github.vbauer.yta.service.transport.impl.RestClientImpl.*

/**
 * Tests for {@link RestClient}.
 *
 * @author Vladislav Bauer
 */

class RestClientSpec extends Specification {

    def "Smoke test"() {
        when:
            def client = new RestClientImpl(KEY)
            def json = client.callMethod(METHOD_GET_LANGS, [] as Map)
            def slurper = new JsonSlurper()
            def object = slurper.parseText(json)
        then:
            object != null
    }

    def "Check constants"() {
        expect:
            constant == value
        where:
            constant        | value
            SERVICE_URL     | "https://translate.yandex.net/api/v1.5/tr.json"
            ATTR_KEY        | "key"
            DEFAULT_TIMEOUT | 30000
    }

}
