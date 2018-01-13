package com.github.vbauer.yta.converter;

import com.github.vbauer.yta.model.Direction;
import com.github.vbauer.yta.model.Language;
import com.github.vbauer.yta.model.Languages;
import com.github.vbauer.yta.model.artificial.LanguagesInfo;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.ThreadSafe;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Converter which allows to transform type {@link LanguagesInfo} to {@link Languages}.
 *
 * @author Vladislav Bauer
 */

@ThreadSafe
public class LanguagesConverter implements BasicConverter<LanguagesInfo, Languages> {

    public static final LanguagesConverter INSTANCE = new LanguagesConverter();


    /**
     * {@inheritDoc}
     */
    @Nonnull
    @Override
    public Languages convert(@Nonnull final LanguagesInfo languagesInfo) {
        final List<Language> languages = getLanguages(languagesInfo);
        final List<Direction> directions = getDirections(languagesInfo, languages);

        return Languages.of(languages, directions);
    }

    private List<Language> getLanguages(final LanguagesInfo languagesInfo) {
        final Map<String, String> langs = languagesInfo.langs();
        if (langs != null) {
            return langs.entrySet().stream()
                .map(entry -> Language.of(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
        }

        final List<String> dirs = languagesInfo.dirs();
        return dirs.stream()
            .map(DirectionConverter.INSTANCE::getLanguages)
            .flatMap(Arrays::stream)
            .distinct()
            .map(Language::of)
            .collect(Collectors.toList());
    }

    private List<Direction> getDirections(final LanguagesInfo languagesInfo, final List<Language> languages) {
        final List<String> dirs = languagesInfo.dirs();
        return dirs.stream()
            .map(dir -> DirectionConverter.INSTANCE.convertDirection(languages, dir))
            .collect(Collectors.toList());
    }

}
