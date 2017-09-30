package com.github.vbauer.yta.converter

import com.github.vbauer.yta.common.AbstractConverterSpec
import com.github.vbauer.yta.model.Language
import com.github.vbauer.yta.model.artificial.ImmutableLanguageInfo

/**
 * Tests for {@link LanguageConverter}.
 *
 * @author Vladislav Bauer
 */

class LanguageConverterSpec extends AbstractConverterSpec {

    def "Check correct conversion"() {
        when:
            def input = ImmutableLanguageInfo.builder()
                .lang("ru")
                .code(0)
                .build()
            def output = Optional.of(Language.RU)
        then:
            converter().convert(input) == output
    }

    @Override
    protected converter() { LanguageConverter.INSTANCE }

}
