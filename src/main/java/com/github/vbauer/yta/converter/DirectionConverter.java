package com.github.vbauer.yta.converter;

import com.github.vbauer.yta.model.Direction;
import com.github.vbauer.yta.model.Language;
import com.github.vbauer.yta.model.basic.HasCode;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.ThreadSafe;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Converter which allows to transform type {@link String} to {@link Direction}.
 *
 * @author Vladislav Bauer
 */

@ThreadSafe
public class DirectionConverter implements BasicConverter<String, Direction> {

    public static final DirectionConverter INSTANCE = new DirectionConverter();


    /**
     * {@inheritDoc}
     */
    @Nonnull
    @Override
    public Direction convert(@Nonnull final String direction) {
        return convertDirection(new ArrayList<>(), direction);
    }


    /**
     * Detect translation direction using collection with languages and
     * text representation of the given direction.
     *
     * @param languages collection with languages
     * @param dir text representation of the direction (ex: "ru-en")
     * @return direction model object
     */
    @Nonnull
    public Direction convertDirection(final Collection<Language> languages, final String dir) {
        final String[] parts = getLanguages(dir);
        final String from = parts[0];
        final String to = parts[1];
        return composeDirection(languages, from, to);
    }

    /**
     * Get 2 languages by given direction.
     *
     * @param dir text representation of the direction (ex: "ru-en")
     * @return 2 languages
     */
    @Nonnull
    public String[] getLanguages(final String dir) {
        return dir.split(Direction.SEPARATOR);
    }


    private Direction composeDirection(
        final Collection<Language> languages, final String from, final String to
    ) {
        final Language source = findOrCreateLanguage(languages, from);
        final Language target = findOrCreateLanguage(languages, to);
        return Direction.of(source, target);
    }

    private Language findOrCreateLanguage(final Collection<Language> languages, final String code) {
        return HasCode.findByCode(languages, code).orElseGet(() -> {
            final Language language = Language.of(code);
            languages.add(language);
            return language;
        });
    }

}
