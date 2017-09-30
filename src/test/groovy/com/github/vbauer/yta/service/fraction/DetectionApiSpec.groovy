package com.github.vbauer.yta.service.fraction

import com.github.vbauer.yta.common.AbstractApiSpec
import com.github.vbauer.yta.model.Language

import static com.github.vbauer.yta.service.fraction.impl.DetectionApiImpl.*

/**
 * Tests for {@link DetectionApi}.
 *
 * @author Vladislav Bauer
 */

class DetectionApiSpec extends AbstractApiSpec {

    def "Check Detection API"() {
        setup:
            def detectApi = api.detectionApi()
        expect:
            detectApi != null

        when: "Language should be detected as English"
            detectApi.detect("Hello, World!")
        then:
            Language.EN

        when: "HTML with Russian text should be detected"
            detectApi.detect("<b><h1>Привет, Мир!</h1></b>")
        then:
            Language.RU
    }

    def "Check constants"() {
        expect:
            constant == value
        where:
            constant      | value
            METHOD_DETECT | "/detect"
            ATTR_TEXT     | "text"
            ATTR_FORMAT   | "format"
    }
}
