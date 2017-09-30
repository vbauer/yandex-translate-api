package com.github.vbauer.yta.model.artificial;

import com.github.vbauer.yta.model.basic.HasCode;
import org.immutables.gson.Gson.TypeAdapters;
import org.immutables.value.Value.Immutable;

import java.util.List;

/**
 * Model-interface with information about translated text.
 *
 * @author Vladislav Bauer
 */

@Immutable
@TypeAdapters
public interface TranslationInfo extends HasCode<Integer> {

    /**
     * Target language.
     *
     * @return target language
     */
    String lang();

    /**
     * Translated text.
     *
     * @return text
     */
    List<String> text();

}
