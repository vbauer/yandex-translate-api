package com.github.vbauer.yta.converter

import com.github.vbauer.yta.common.AbstractConverterSpec
import com.github.vbauer.yta.model.Direction
import com.github.vbauer.yta.model.Languages
import com.github.vbauer.yta.model.artificial.ImmutableLanguagesInfo

import static com.github.vbauer.yta.model.Language.EN
import static com.github.vbauer.yta.model.Language.RU

/**
 * Tests for {@link LanguagesConverter}.
 *
 * @author Vladislav Bauer
 */

class LanguagesConverterSpec extends AbstractConverterSpec {

    def "Check correct conversion"() {
        when:
            def input = ImmutableLanguagesInfo.builder()
                .dirs(["ru-en"])
                .langs([
                    "ru": "Russian",
                    "en": "English"
                ])
                .build()
            def output = Languages.of([RU, EN], [Direction.of(RU, EN)])
        then:
            converter().convert(input) == output
    }

    @Override
    protected converter() { LanguagesConverter.INSTANCE }

}
