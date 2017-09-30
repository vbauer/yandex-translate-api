package com.github.vbauer.yta.service.fraction.impl;

import com.github.vbauer.yta.converter.LanguagesConverter;
import com.github.vbauer.yta.model.Language;
import com.github.vbauer.yta.model.Languages;
import com.github.vbauer.yta.model.artificial.LanguagesInfo;
import com.github.vbauer.yta.service.basic.AbstractApi;
import com.github.vbauer.yta.service.basic.ApiContext;
import com.github.vbauer.yta.service.fraction.LanguageApi;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import java.util.Collections;
import java.util.Map;

/**
 * See {@link LanguageApi}.
 *
 * @author Vladislav Bauer
 */

@ThreadSafe
public class LanguageApiImpl extends AbstractApi implements LanguageApi {

    public static final String METHOD_GET_LANGS = "/getLangs";
    public static final String ATTR_UI = "ui";


    public LanguageApiImpl(final ApiContext context) {
        super(context);
    }


    /**
     * {@inheritDoc}
     */
    @Nonnull
    @Override
    public Languages all() {
        return all((String) null);
    }

    /**
     * {@inheritDoc}
     */
    @Nonnull
    @Override
    public Languages all(@Nullable final Language ui) {
        return all(ui == null ? null : ui.code());
    }

    /**
     * {@inheritDoc}
     */
    @Nonnull
    @Override
    public Languages all(@Nullable final String ui) {
        final Map<String, Object> data = ui == null ? null : Collections.singletonMap(ATTR_UI, ui);
        final LanguagesInfo languagesInfo = callMethod(LanguagesInfo.class, METHOD_GET_LANGS, data);

        return LanguagesConverter.INSTANCE.convert(languagesInfo);
    }

}
