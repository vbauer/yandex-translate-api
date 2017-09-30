package com.github.vbauer.yta.common

import com.github.vbauer.yta.service.YTranslateApiImpl
import groovy.transform.CompileStatic
import spock.lang.Shared
import spock.lang.Specification

/**
 * Basic class to test API services.
 *
 * @author Vladislav Bauer
 */

@CompileStatic
abstract class AbstractApiSpec extends Specification {

    /**
     * <b>Important:</b> Do not use this API key in your projects.
     * It is necessary to test this library and could be changed.
     */
    public static final String KEY =
        "trnsl.1.1.20151012T201854Z.52731c6f05cd2ac8.f9ccae1aec912fb16879d4d89a2a40bbf1c802a3"

    /**
     * Shared "YTA" API service for testing purpose.
     */
    @Shared api = new YTranslateApiImpl(KEY)

}
