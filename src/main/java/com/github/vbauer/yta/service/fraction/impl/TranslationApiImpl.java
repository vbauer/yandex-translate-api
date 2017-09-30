package com.github.vbauer.yta.service.fraction.impl;

import com.github.vbauer.yta.converter.TranslationConverter;
import com.github.vbauer.yta.model.Direction;
import com.github.vbauer.yta.model.Language;
import com.github.vbauer.yta.model.Translation;
import com.github.vbauer.yta.model.artificial.TranslationInfo;
import com.github.vbauer.yta.model.basic.TextFormat;
import com.github.vbauer.yta.service.basic.AbstractApi;
import com.github.vbauer.yta.service.basic.ApiContext;
import com.github.vbauer.yta.service.basic.ApiStatus;
import com.github.vbauer.yta.service.fraction.TranslationApi;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * See {@link TranslationApi}.
 *
 * @author Vladislav Bauer
 */

@ThreadSafe
public class TranslationApiImpl extends AbstractApi implements TranslationApi {

    public static final String METHOD_DETECT = "/translate";
    public static final String ATTR_LANG = "lang";
    public static final String ATTR_TEXT = "text";
    public static final String ATTR_FORMAT = "format";


    public TranslationApiImpl(final ApiContext context) {
        super(context);
    }


    /**
     * {@inheritDoc}
     */
    @Nonnull
    @Override
    public Translation translate(
        @Nullable final String text,
        @Nonnull final Language language
    ) {
        return translate(text, Direction.of(language));
    }

    /**
     * {@inheritDoc}
     */
    @Nonnull
    @Override
    public Translation translate(
        @Nullable final String text,
        @Nonnull final Direction direction
    ) {
        return translate(text, direction, TextFormat.PLAIN_TEXT);
    }

    /**
     * {@inheritDoc}
     */
    @Nonnull
    @Override
    public Translation translate(
        @Nullable final String text,
        @Nonnull final Direction direction,
        @Nullable final TextFormat format
    ) {
        final Map<String, Object> params = new HashMap<>();
        params.put(ATTR_TEXT, Objects.toString(text, ""));
        params.put(ATTR_LANG, direction.toString());
        params.put(ATTR_FORMAT, TextFormat.getOrDefault(format).code());

        final TranslationInfo data = callMethod(TranslationInfo.class, METHOD_DETECT, params);
        ApiStatus.check(data.code());

        return TranslationConverter.INSTANCE.convert(data);
    }

}
