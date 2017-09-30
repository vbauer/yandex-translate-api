package com.github.vbauer.yta.converter

import com.github.vbauer.yta.common.AbstractConverterSpec
import com.github.vbauer.yta.model.Direction
import com.github.vbauer.yta.model.Translation
import com.github.vbauer.yta.model.artificial.ImmutableTranslationInfo

import static com.github.vbauer.yta.model.Language.EN
import static com.github.vbauer.yta.model.Language.RU

/**
 * Tests for {@link TranslationConverter}.
 *
 * @author Vladislav Bauer
 */

class TranslationConverterSpec extends AbstractConverterSpec {

    def "Check correct conversion"() {
        when:
            def input = ImmutableTranslationInfo.builder()
                .code(0)
                .lang("ru-en")
                .text(["Hello"])
                .build()
            def output = Translation.of(Direction.of(RU, EN), "Hello")
        then:
            converter().convert(input) == output
    }

    @Override
    protected converter() { TranslationConverter.INSTANCE }

}
