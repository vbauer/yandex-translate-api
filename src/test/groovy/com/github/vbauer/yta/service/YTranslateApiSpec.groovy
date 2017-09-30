package com.github.vbauer.yta.service

import com.github.vbauer.yta.service.basic.ApiStatus
import com.github.vbauer.yta.service.basic.exception.ApiException
import spock.lang.Specification

/**
 * Tests for {@link YTranslateApi}.
 *
 * @author Vladislav Bauer
 */

class YTranslateApiSpec extends Specification {

    def "Check wrong API key"() {
        setup:
            def badApi = new YTranslateApiImpl("wrong key")
        when:
            badApi.languageApi().all()
        then:
            def e = thrown ApiException
            e.status != ApiStatus.ERR_OK
            !e.message.empty
    }

}
