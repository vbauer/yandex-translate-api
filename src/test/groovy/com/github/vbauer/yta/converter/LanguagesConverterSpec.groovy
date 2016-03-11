package com.github.vbauer.yta.converter

import com.github.vbauer.yta.model.Direction
import com.github.vbauer.yta.model.Languages
import com.github.vbauer.yta.model.artificial.ImmutableLanguagesInfo
import spock.lang.Specification

import static com.github.vbauer.yta.model.Language.EN
import static com.github.vbauer.yta.model.Language.RU

/**
 * @author Vladislav Bauer
 */

class LanguagesConverterSpec extends Specification {

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
            LanguagesConverter.INSTANCE.convert(input) == output
    }

    def "Check that doBackward is not available"() {
        when:
            LanguagesConverter.INSTANCE.doBackward(null)
        then:
            thrown UnsupportedOperationException
    }

}
