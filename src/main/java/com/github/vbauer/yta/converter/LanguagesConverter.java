package com.github.vbauer.yta.converter;

import com.github.vbauer.yta.model.Direction;
import com.github.vbauer.yta.model.Language;
import com.github.vbauer.yta.model.Languages;
import com.github.vbauer.yta.model.artificial.LanguagesInfo;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.ThreadSafe;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Converter which allows to transform type {@link LanguagesInfo} to {@link Languages}.
 *
 * @author Vladislav Bauer
 */

@ThreadSafe
public class LanguagesConverter extends BasicConverter<LanguagesInfo, Languages> {

    public static final LanguagesConverter INSTANCE = new LanguagesConverter();


    /**
     * {@inheritDoc}
     */
    @Nonnull
    @Override
    protected Languages doForward(@Nonnull final LanguagesInfo languagesInfo) {
        final Map<String, String> langs = languagesInfo.langs();
        final List<String> dirs = languagesInfo.dirs();

        final List<Language> languages = langs.entrySet().stream()
            .map(entry -> Language.of(entry.getKey(), entry.getValue()))
            .collect(Collectors.toList());

        final List<Direction> directions = dirs.stream()
            .map(dir -> DirectionConverter.INSTANCE.convertDirection(languages, dir))
            .filter(Objects::nonNull)
            .collect(Collectors.toList());

        return Languages.of(languages, directions);
    }

}
