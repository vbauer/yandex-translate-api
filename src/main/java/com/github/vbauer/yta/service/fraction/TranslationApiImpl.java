package com.github.vbauer.yta.service.fraction;

import com.github.vbauer.yta.model.Direction;
import com.github.vbauer.yta.model.Language;
import com.github.vbauer.yta.model.Translation;
import com.github.vbauer.yta.model.artificial.TranslationInfo;
import com.github.vbauer.yta.model.artificial.TranslationInfo.TranslationInfoUtils;
import com.github.vbauer.yta.model.basic.TextFormat;
import com.github.vbauer.yta.service.basic.AbstractApi;
import com.github.vbauer.yta.service.basic.ApiContext;
import com.github.vbauer.yta.service.basic.ApiStatus;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;

/**
 * @author Vladislav Bauer
 */

public class TranslationApiImpl extends AbstractApi implements TranslationApi {

    private static final String METHOD_DETECT = "/translate";
    private static final String ATTR_LANG = "lang";
    private static final String ATTR_TEXT = "text";
    private static final String ATTR_FORMAT = "format";


    public TranslationApiImpl(final ApiContext context) {
        super(context);
    }


    @Override
    public Translation translate(final String text, final Language language) {
        return translate(text, Direction.of(language));
    }

    @Override
    public Translation translate(final String text, final Direction direction) {
        return translate(text, direction, TextFormat.PLAIN_TEXT);
    }

    @Override
    public Translation translate(final String text, Direction direction, final TextFormat format) {
        final ImmutableMap<String, Object> params = ImmutableMap.<String, Object>builder()
            .put(ATTR_TEXT, Strings.nullToEmpty(text))
            .put(ATTR_LANG, direction.toString())
            .put(ATTR_FORMAT, TextFormat.getOrDefault(format).code())
            .build();

        final TranslationInfo data = callMethod(TranslationInfo.class, METHOD_DETECT, params);
        ApiStatus.check(data.code());

        return TranslationInfoUtils.convert(data);
    }

}
