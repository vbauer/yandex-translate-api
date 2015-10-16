package com.github.vbauer.yta.model.artificial;

import com.github.vbauer.yta.model.ImmutableTranslation;
import com.github.vbauer.yta.model.Translation;
import com.github.vbauer.yta.model.artificial.LanguagesInfo.LanguagesInfoUtils;
import com.github.vbauer.yta.model.basic.HasCode;
import com.google.common.collect.Iterables;
import org.immutables.gson.Gson.TypeAdapters;
import org.immutables.value.Value.Immutable;

import java.util.List;
import java.util.Optional;

/**
 * @author Vladislav Bauer
 */

@Immutable
@TypeAdapters
public interface TranslationInfo extends HasCode<Integer> {

    String lang();

    List<String> text();


    final class TranslationInfoUtils {

        private TranslationInfoUtils() {
            throw new UnsupportedOperationException();
        }


        public static Translation convert(final TranslationInfo translationInfo) {
            final String text = Iterables.getFirst(translationInfo.text(), null);

            return ImmutableTranslation.builder()
                .text(Optional.ofNullable(text).orElse(""))
                .direction(LanguagesInfoUtils.convert(translationInfo.lang()))
                .build();
        }

    }

}
