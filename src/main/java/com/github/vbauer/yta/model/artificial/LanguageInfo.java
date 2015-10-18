package com.github.vbauer.yta.model.artificial;

import com.github.vbauer.yta.model.Language;
import com.github.vbauer.yta.model.basic.HasCode;
import org.immutables.gson.Gson.TypeAdapters;
import org.immutables.value.Value.Immutable;

import java.util.Optional;

/**
 * @author Vladislav Bauer
 */

@Immutable
@TypeAdapters
public interface LanguageInfo extends HasCode<Integer> {

    Optional<String> lang();


    final class LanguageInfoUtils {

        private LanguageInfoUtils() {
            throw new UnsupportedOperationException();
        }


        public static Optional<Language> convert(final LanguageInfo languageInfo) {
            return languageInfo.lang().map(Language::of);
        }

    }

}
