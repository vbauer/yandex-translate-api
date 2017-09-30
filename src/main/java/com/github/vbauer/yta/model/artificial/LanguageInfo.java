package com.github.vbauer.yta.model.artificial;

import com.github.vbauer.yta.model.basic.HasCode;
import org.immutables.gson.Gson.TypeAdapters;
import org.immutables.value.Value.Immutable;

import java.util.Optional;

/**
 * Model-interface with information about language.
 *
 * @author Vladislav Bauer
 */

@Immutable
@TypeAdapters
public interface LanguageInfo extends HasCode<Integer> {

    /**
     * Language code/identifier.
     *
     * @return language
     */
    Optional<String> lang();

}
