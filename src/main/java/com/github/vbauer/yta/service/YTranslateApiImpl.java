package com.github.vbauer.yta.service;

import com.github.vbauer.yta.service.basic.AbstractApi;
import com.github.vbauer.yta.service.basic.ApiContext;
import com.github.vbauer.yta.service.fraction.DetectionApi;
import com.github.vbauer.yta.service.fraction.LanguageApi;
import com.github.vbauer.yta.service.fraction.TranslationApi;
import com.github.vbauer.yta.service.fraction.impl.DetectionApiImpl;
import com.github.vbauer.yta.service.fraction.impl.LanguageApiImpl;
import com.github.vbauer.yta.service.fraction.impl.TranslationApiImpl;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.ThreadSafe;

/**
 * See {@link YTranslateApi}.
 *
 * @author Vladislav Bauer
 */

@ThreadSafe
public class YTranslateApiImpl extends AbstractApi implements YTranslateApi {

    private final LanguageApi languageService;
    private final DetectionApi detectionService;
    private final TranslationApi translationService;


    public YTranslateApiImpl(@Nonnull final String key) {
        this(ApiContext.of(key));
    }

    public YTranslateApiImpl(@Nonnull final ApiContext context) {
        super(context);

        this.languageService = new LanguageApiImpl(context);
        this.detectionService = new DetectionApiImpl(context);
        this.translationService = new TranslationApiImpl(context);
    }


    /**
     * {@inheritDoc}
     */
    @Nonnull
    @Override
    public LanguageApi languageApi() {
        return languageService;
    }

    /**
     * {@inheritDoc}
     */
    @Nonnull
    @Override
    public DetectionApi detectionApi() {
        return detectionService;
    }

    /**
     * {@inheritDoc}
     */
    @Nonnull
    @Override
    public TranslationApi translationApi() {
        return translationService;
    }

}
