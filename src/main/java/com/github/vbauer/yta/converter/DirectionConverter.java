package com.github.vbauer.yta.converter;

import com.github.vbauer.yta.model.Direction;
import com.github.vbauer.yta.model.Language;
import com.github.vbauer.yta.model.basic.HasCode;
import com.google.common.collect.Lists;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.ThreadSafe;
import java.util.Collection;

/**
 * Converter which allows to transform type {@link String} to {@link Direction}.
 *
 * @author Vladislav Bauer
 */

@ThreadSafe
public class DirectionConverter extends BasicConverter<String, Direction> {

    public static final DirectionConverter INSTANCE = new DirectionConverter();


    @Nonnull
    @Override
    protected Direction doForward(@Nonnull final String direction) {
        return convertDirection(Lists.newArrayList(), direction);
    }


    public Direction convertDirection(final Collection<Language> languages, final String dir) {
        final String[] parts = dir.split(Direction.SEPARATOR);
        final String from = parts[0];
        final String to = parts[1];
        return composeDirection(languages, from, to);
    }

    private Direction composeDirection(
        final Collection<Language> languages, final String from, final String to
    ) {
        final Language source = findOrCreateLanguage(languages, from);
        final Language target = findOrCreateLanguage(languages, to);
        return Direction.of(source, target);
    }

    private Language findOrCreateLanguage(final Collection<Language> languages, final String code) {
        return HasCode.HasCodeUtils.findByCode(languages, code).orElseGet(() -> {
            final Language language = Language.of(code);
            languages.add(language);
            return language;
        });
    }

}
