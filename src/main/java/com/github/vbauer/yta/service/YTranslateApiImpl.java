package com.github.vbauer.yta.service;

import com.github.vbauer.yta.service.basic.AbstractApi;
import com.github.vbauer.yta.service.basic.ApiContext;
import com.github.vbauer.yta.service.fraction.DetectionApi;
import com.github.vbauer.yta.service.fraction.DetectionApiImpl;
import com.github.vbauer.yta.service.fraction.LanguageApi;
import com.github.vbauer.yta.service.fraction.LanguageApiImpl;
import com.github.vbauer.yta.service.fraction.TranslationApi;
import com.github.vbauer.yta.service.fraction.TranslationApiImpl;

/**
 * @author Vladislav Bauer
 */

public class YTranslateApiImpl extends AbstractApi implements YTranslateApi {

    private final LanguageApi languageApi;
    private final DetectionApi detectionApi;
    private final TranslationApi translationApi;


    public YTranslateApiImpl(final String key) {
        this(ApiContext.of(key));
    }

    public YTranslateApiImpl(final ApiContext context) {
        super(context);

        this.languageApi = new LanguageApiImpl(context);
        this.detectionApi = new DetectionApiImpl(context);
        this.translationApi = new TranslationApiImpl(context);
    }


    @Override
    public LanguageApi languageApi() {
        return languageApi;
    }

    @Override
    public DetectionApi detectionApi() {
        return detectionApi;
    }

    @Override
    public TranslationApi translationApi() {
        return translationApi;
    }

}
