package com.github.vbauer.yta.service.fraction;

import com.github.vbauer.yta.model.Language;
import com.github.vbauer.yta.model.artificial.LanguageInfo;
import com.github.vbauer.yta.model.basic.TextFormat;
import com.github.vbauer.yta.service.basic.AbstractApi;
import com.github.vbauer.yta.service.basic.ApiContext;
import com.github.vbauer.yta.service.basic.ApiStatus;
import com.github.vbauer.yta.service.basic.RestClient.RestMethodType;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;

import java.util.Optional;

/**
 * @author Vladislav Bauer
 */

public class DetectionApiImpl extends AbstractApi implements DetectionApi {

    private static final String METHOD_DETECT = "/detect";
    private static final String ATTR_TEXT = "text";
    private static final String ATTR_FORMAT = "format";


    public DetectionApiImpl(final ApiContext context) {
        super(context);
    }


    @Override
    public Optional<Language> detect(final String text) {
        return detect(text, TextFormat.PLAIN_TEXT);
    }

    @Override
    public Optional<Language> detect(final String text, final TextFormat format) {
        final ImmutableMap<String, Object> params = ImmutableMap.<String, Object>builder()
            .put(ATTR_TEXT, Strings.nullToEmpty(text))
            .put(ATTR_FORMAT, TextFormat.getOrDefault(format).code())
            .build();

        final LanguageInfo data = callMethod(LanguageInfo.class, RestMethodType.POST, METHOD_DETECT, params);
        ApiStatus.check(data.code());

        return data.lang().map(Language::of);
    }

}
