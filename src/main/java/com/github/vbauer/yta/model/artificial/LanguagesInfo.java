package com.github.vbauer.yta.model.artificial;

import com.github.vbauer.yta.model.Direction;
import com.github.vbauer.yta.model.ImmutableDirection;
import com.github.vbauer.yta.model.Language;
import com.github.vbauer.yta.model.Languages;
import com.github.vbauer.yta.model.basic.HasCode.HasCodeUtils;
import com.google.common.collect.Lists;
import org.immutables.gson.Gson.TypeAdapters;
import org.immutables.value.Value.Immutable;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Vladislav Bauer
 */

@Immutable
@TypeAdapters
public interface LanguagesInfo {

    List<String> dirs();

    Map<String, String> langs();


    final class LanguagesInfoUtils {

        private LanguagesInfoUtils() {
            throw new UnsupportedOperationException();
        }


        public static Direction convert(final String direction) {
            return convertDirection(Lists.newArrayList(), direction);
        }

        public static Languages convert(final LanguagesInfo languagesInfo) {
            final Map<String, String> langs = languagesInfo.langs();
            final List<String> dirs = languagesInfo.dirs();

            final List<Language> languages = langs.entrySet().stream()
                .map(entry -> Language.of(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());

            final List<Direction> directions = dirs.stream()
                .map(dir -> convertDirection(languages, dir))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

            return Languages.of(languages, directions);
        }

        private static Direction convertDirection(final Collection<Language> languages, final String dir) {
            final String[] parts = dir.split(Direction.SEPARATOR);
            final String from = parts[0];
            final String to = parts[1];
            return composeDirection(languages, from, to);
        }

        private static Direction composeDirection(
            final Collection<Language> languages, final String from, final String to
        ) {
            final Language source = findOrCreateLanguage(languages, from);
            final Language target = findOrCreateLanguage(languages, to);

            return ImmutableDirection.builder()
                .source(source)
                .target(target)
                .build();
        }

        private static Language findOrCreateLanguage(final Collection<Language> languages, final String code) {
            return HasCodeUtils.findByCode(code, languages).orElseGet(() -> {
                final Language language = Language.of(code);
                languages.add(language);
                return language;
            });
        }

    }

}
