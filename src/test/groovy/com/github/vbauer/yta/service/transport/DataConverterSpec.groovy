package com.github.vbauer.yta.service.transport

import com.github.vbauer.yta.model.artificial.LanguageInfo
import com.github.vbauer.yta.model.artificial.LanguagesInfo
import com.github.vbauer.yta.model.artificial.TranslationInfo
import com.github.vbauer.yta.service.basic.ApiStatus
import com.github.vbauer.yta.service.transport.impl.DataConverterImpl
import spock.lang.Specification

import static com.github.vbauer.yta.model.Language.EN

/**
 * Tests for {@link DataConverter}.
 *
 * @author Vladislav Bauer
 */

class DataConverterSpec extends Specification {

    static final CONVERTER = new DataConverterImpl()


    def "Check bad params"() {
        expect:
            CONVERTER.convert(null, LanguagesInfo) == null

        when:
            CONVERTER.convert("", null)
        then:
            thrown NullPointerException
    }

    def "Check LanguageInfo"() {
        setup:
            def model = convert(LanguageInfo)
        expect:
            model.code() == ApiStatus.ERR_OK
            model.lang().get() == EN.code()
    }

    def "Check LanguagesInfo"() {
        setup:
            def model = convert(LanguagesInfo)
        expect:
            model.dirs() == ["ru-en", "en-ru"]
            model.langs() == ["ru": "Russian", "en": "English"]
    }

    def "Check TranslationInfo"() {
        setup:
            def model = convert(TranslationInfo)
        expect:
            model.code() == ApiStatus.ERR_OK
            model.lang() == "en"
            model.text() == ["Hello, World!"]
    }


    def <T> T convert(Class<T> clazz) {
        def resourceName = clazz.getSimpleName() + ".json"
        def resource = DataConverter.class.getResource(resourceName)
        def json = resource.text

        return CONVERTER.convert(json, clazz)
    }

}
