package com.github.vbauer.yta.converter

import com.github.vbauer.yta.model.Direction
import spock.lang.Specification

import static com.github.vbauer.yta.model.Language.EN
import static com.github.vbauer.yta.model.Language.RU

/**
 * @author Vladislav Bauer
 */

class DirectionConverterSpec extends Specification {

    def "Check correct conversion"() {
        expect:
            DirectionConverter.INSTANCE.convert(input) == output
        where:
            input   || output
            "ru-en" || Direction.of(RU, EN)
            "en-ru" || Direction.of(EN, RU)
    }

    def "Check that doBackward is not available"() {
        when:
            DirectionConverter.INSTANCE.doBackward(null)
        then:
            thrown UnsupportedOperationException
    }

}
