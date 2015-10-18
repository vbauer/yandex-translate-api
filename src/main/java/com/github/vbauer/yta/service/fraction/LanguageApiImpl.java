package com.github.vbauer.yta.service.fraction;

import com.github.vbauer.yta.model.Language;
import com.github.vbauer.yta.model.Languages;
import com.github.vbauer.yta.model.artificial.LanguagesInfo;
import com.github.vbauer.yta.model.artificial.LanguagesInfo.LanguagesInfoUtils;
import com.github.vbauer.yta.service.basic.AbstractApi;
import com.github.vbauer.yta.service.basic.ApiContext;
import com.google.common.collect.ImmutableMap;

import java.util.Map;

/**
 * @author Vladislav Bauer
 */

public class LanguageApiImpl extends AbstractApi implements LanguageApi {

    private static final String METHOD_GET_LANGS = "/getLangs";
    private static final String ATTR_UI = "ui";


    public LanguageApiImpl(final ApiContext context) {
        super(context);
    }


    @Override
    public Languages all() {
        return all((String) null);
    }

    @Override
    public Languages all(final Language ui) {
        return all(ui == null ? null : ui.code());
    }

    @Override
    public Languages all(final String ui) {
        final Map<String, Object> data = ui == null ? null : ImmutableMap.of(ATTR_UI, ui);
        final LanguagesInfo languagesInfo = callMethod(LanguagesInfo.class, METHOD_GET_LANGS, data);

        return LanguagesInfoUtils.convert(languagesInfo);
    }

}
