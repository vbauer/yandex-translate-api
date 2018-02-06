package com.github.vbauer.yta.service.fraction.impl;

import com.github.vbauer.yta.converter.LanguageConverter;
import com.github.vbauer.yta.model.Language;
import com.github.vbauer.yta.model.artificial.ImmutableLanguageInfo;
import com.github.vbauer.yta.model.artificial.LanguageInfo;
import com.github.vbauer.yta.model.basic.TextFormat;
import com.github.vbauer.yta.service.basic.AbstractApi;
import com.github.vbauer.yta.service.basic.ApiContext;
import com.github.vbauer.yta.service.basic.ApiStatus;
import com.github.vbauer.yta.service.fraction.DetectionApi;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * See {@link DetectionApi}.
 *
 * @author Vladislav Bauer
 */

@ThreadSafe
public class DetectionApiImpl extends AbstractApi implements DetectionApi {

    public static final String METHOD_DETECT = "/detect";
    public static final String ATTR_TEXT = "text";
    public static final String ATTR_FORMAT = "format";


    public DetectionApiImpl(final ApiContext context) {
        super(context);
    }


    /**
     * {@inheritDoc}
     */
    @Nonnull
    @Override
    public Optional<Language> detect(@Nullable final String text) {
        return detect(text, TextFormat.PLAIN_TEXT);
    }

    /**
     * {@inheritDoc}
     */
    @Nonnull
    @Override
    public Optional<Language> detect(
        @Nullable final String text, @Nullable final TextFormat format
    ) {
        final Map<String, Object> params = new HashMap<>();
        params.put(ATTR_TEXT, Objects.toString(text, ""));
        params.put(ATTR_FORMAT, TextFormat.getOrDefault(format).code());

        final LanguageInfo data = callMethod(ImmutableLanguageInfo.class, METHOD_DETECT, params);
        ApiStatus.check(data.code());

        return LanguageConverter.INSTANCE.convert(data);
    }

}
