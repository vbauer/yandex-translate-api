package com.github.vbauer.yta.converter

import com.github.vbauer.yta.model.Direction
import com.github.vbauer.yta.model.Translation
import com.github.vbauer.yta.model.artificial.ImmutableTranslationInfo
import spock.lang.Specification

import static com.github.vbauer.yta.model.Language.EN
import static com.github.vbauer.yta.model.Language.RU

/**
 * @author Vladislav Bauer
 */

class TranslationConverterSpec extends Specification {

    def "Check correct conversion"() {
        when:
            def input = ImmutableTranslationInfo.builder()
                .code(0)
                .lang("ru-en")
                .text(["Hello"])
                .build()
            def output = Translation.of(Direction.of(RU, EN), "Hello")
        then:
            TranslationConverter.INSTANCE.convert(input) == output
    }

    def "Check that doBackward is not available"() {
        when:
            TranslationConverter.INSTANCE.doBackward(null)
        then:
            thrown UnsupportedOperationException
    }

}
