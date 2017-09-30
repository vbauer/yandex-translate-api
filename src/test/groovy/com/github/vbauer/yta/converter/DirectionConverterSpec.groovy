package com.github.vbauer.yta.converter

import com.github.vbauer.yta.common.AbstractConverterSpec
import com.github.vbauer.yta.model.Direction

import static com.github.vbauer.yta.model.Language.EN
import static com.github.vbauer.yta.model.Language.RU

/**
 * Tests for {@link DirectionConverter}.
 *
 * @author Vladislav Bauer
 */

class DirectionConverterSpec extends AbstractConverterSpec {

    def "Check correct conversion"() {
        expect:
            converter().convert(input) == output
        where:
            input   || output
            "ru-en" || Direction.of(RU, EN)
            "en-ru" || Direction.of(EN, RU)
    }

    @Override
    protected converter() { DirectionConverter.INSTANCE }

}
