package com.github.vbauer.yta.service;

import com.github.vbauer.yta.service.fraction.DetectionApi;
import com.github.vbauer.yta.service.fraction.LanguageApi;
import com.github.vbauer.yta.service.fraction.TranslationApi;

import javax.annotation.Nonnull;

/**
 * Facade service which allows to use Yandex.Translate features.
 *
 * @author Vladislav Bauer
 */

public interface YTranslateApi {

    /**
     * {@link LanguageApi} allows to get information about available languages.
     *
     * @return language API service
     */
    @Nonnull
    LanguageApi languageApi();

    /**
     * {@link DetectionApi} detects the language of the specified text.
     *
     * @return detection API service
     */
    @Nonnull
    DetectionApi detectionApi();

    /**
     * {@link TranslationApi} allows to translate text from one language to another.
     *
     * @return translation API service
     */
    @Nonnull
    TranslationApi translationApi();

}
