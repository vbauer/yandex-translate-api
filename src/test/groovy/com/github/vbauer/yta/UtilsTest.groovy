package com.github.vbauer.yta

import com.github.vbauer.yta.model.artificial.LanguagesInfo
import com.github.vbauer.yta.model.artificial.TranslationInfo
import com.github.vbauer.yta.model.basic.HasCode
import com.github.vbauer.yta.service.basic.ApiStatus
import com.pushtorefresh.private_constructor_checker.PrivateConstructorChecker
import spock.lang.Specification

/**
 * @author Vladislav Bauer
 */

class UtilsTest extends Specification {

    def "Check constructors in util-classes"() {
        when:
            PrivateConstructorChecker
                .forClasses(
                    LanguagesInfo.LanguagesInfoUtils,
                    TranslationInfo.TranslationInfoUtils,
                    HasCode.HasCodeUtils,
                    ApiStatus
                )
                .expectedTypeOfException(UnsupportedOperationException.class)
                .check();
        then:
            true
    }

}
