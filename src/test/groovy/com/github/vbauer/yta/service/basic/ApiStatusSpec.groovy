package com.github.vbauer.yta.service.basic

import com.github.vbauer.yta.common.TestUtils
import com.github.vbauer.yta.service.basic.exception.ApiException
import spock.lang.Specification

/**
 * Tests for {@link ApiStatusSpec}.
 *
 * @author Vladislav Bauer
 */

class ApiStatusSpec extends Specification {

    def "API response statuses"() {
        expect:
            value == code

        where:
            value | code
            200   | ApiStatus.ERR_OK
            401   | ApiStatus.ERR_KEY_INVALID
            402   | ApiStatus.ERR_KEY_BLOCKED
            403   | ApiStatus.ERR_DAILY_REQ_LIMIT_EXCEEDED
            404   | ApiStatus.ERR_DAILY_CHAR_LIMIT_EXCEEDED
            413   | ApiStatus.ERR_TEXT_TOO_LONG
            422   | ApiStatus.ERR_UNPROCESSABLE_TEXT
            501   | ApiStatus.ERR_LANG_NOT_SUPPORTED
    }

    def "Check-method with correct status code"() {
        when:
            ApiStatus.check(ApiStatus.ERR_OK)
        then:
            notThrown ApiException
    }

    def "Check-method throws an ApiException"() {
        expect:
            try {
                ApiStatus.check(status)
            } catch (final Exception ex) {
                assert ex instanceof ApiException
            }
        where:
            status << [
                ApiStatus.ERR_KEY_INVALID,
                ApiStatus.ERR_KEY_BLOCKED,
                ApiStatus.ERR_DAILY_REQ_LIMIT_EXCEEDED,
                ApiStatus.ERR_DAILY_CHAR_LIMIT_EXCEEDED,
                ApiStatus.ERR_TEXT_TOO_LONG,
                ApiStatus.ERR_UNPROCESSABLE_TEXT,
                ApiStatus.ERR_LANG_NOT_SUPPORTED
            ]
    }

    def "Check count of available statuses"() {
        expect:
            TestUtils.countStaticFields(ApiStatus) == 8
    }

}
