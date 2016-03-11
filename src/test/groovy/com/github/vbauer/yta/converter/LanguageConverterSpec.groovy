package com.github.vbauer.yta.converter

import com.github.vbauer.yta.model.Language
import com.github.vbauer.yta.model.artificial.ImmutableLanguageInfo
import spock.lang.Specification

/**
 * @author Vladislav Bauer
 */

class LanguageConverterSpec extends Specification {

    def "Check correct conversion"() {
        when:
            def input = ImmutableLanguageInfo.builder()
                .lang("ru")
                .code(0)
                .build()
            def output = Optional.of(Language.RU)
        then:
            LanguageConverter.INSTANCE.convert(input) == output
    }

    def "Check that doBackward is not available"() {
        when:
            LanguageConverter.INSTANCE.doBackward(null)
        then:
            thrown UnsupportedOperationException
    }

}
