package com.github.vbauer.yta

import com.github.vbauer.yta.model.Direction
import com.github.vbauer.yta.model.Language
import com.github.vbauer.yta.model.basic.TextFormat
import com.github.vbauer.yta.service.YTranslateApiImpl
import com.github.vbauer.yta.service.basic.ApiException
import com.github.vbauer.yta.service.basic.ApiStatus
import spock.lang.Shared
import spock.lang.Specification

/**
 * @author Vladislav Bauer
 */

class YTranslateApiTest extends Specification {

    static final KEY = "trnsl.1.1.20151012T201854Z.52731c6f05cd2ac8.f9ccae1aec912fb16879d4d89a2a40bbf1c802a3"

    @Shared api = new YTranslateApiImpl(KEY)


    def "Check wrong API key"() {
        setup:
            def badApi = new YTranslateApiImpl("wrong key")
        when:
            badApi.languageApi().all()
        then:
            def e = thrown(ApiException)
            e.status != ApiStatus.ERR_OK
            !e.message.empty
    }

    def "Check Language API"() {
        setup:
            def langApi = api.languageApi()

        when: "UI parameter is not passed"
            def allLanguages = langApi.all()
        then:
            !allLanguages.toString().empty
            !allLanguages.directions().empty
            allLanguages.languages().empty

        when: "UI parameter is an object"
            def allLanguagesEn = langApi.all(Language.EN)
        then:
            !allLanguagesEn.directions().empty
            !allLanguagesEn.languages().empty

        when: "UI parameter is a string"
            def allLanguagesRu = langApi.all("ru")
        then:
            !allLanguagesRu.directions().empty
            !allLanguagesRu.languages().empty
    }

    def "Check Detection API"() {
        setup:
            def detectApi = api.detectionApi()

        when: "Language should be detected as English"
            detectApi.detect("Hello, World!")
        then:
            Language.EN

        when: "HTML with Russian text should be detected"
            detectApi.detect("<b><h1>Привет, Мир!</h1></b>")
        then:
            Language.RU
    }

    def "Check Translate API"() {
        setup:
            def translateApi = api.translationApi()

        when: "Translate Russian to English"
            def translationRuEn = translateApi.translate("Как дела?", Language.EN)
        then:
            translationRuEn.text().equals("How are you doing?")
            translationRuEn.direction().equals(Direction.of(Language.RU, Language.EN))

        when: "Translate English to Russian"
            def enRu = Direction.of(Language.EN, Language.RU)
            def translationEnRu = translateApi.translate("How are you doing?", enRu)
        then:
            translationEnRu.text().equals("Как у тебя дела?")
            translationEnRu.direction().equals(enRu)

        when: "Translate Russian to English with HTML"
            def ruEn = Direction.of(Language.RU, Language.EN)
            def translationRuEnHtml = translateApi.translate(
                "<span>Привет</span>", ruEn, TextFormat.HTML
            )
        then:
            translationRuEnHtml.toString().equals("<span>Hi</span>")
            translationRuEnHtml.direction().equals(ruEn)
    }

}
