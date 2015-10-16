package com.github.vbauer.yta.service;

import com.github.vbauer.yta.service.fraction.DetectionApi;
import com.github.vbauer.yta.service.fraction.LanguageApi;
import com.github.vbauer.yta.service.fraction.TranslationApi;

/**
 * @author Vladislav Bauer
 */

public interface YTranslateApi {

    LanguageApi languageApi();

    DetectionApi detectionApi();

    TranslationApi translationApi();

}
