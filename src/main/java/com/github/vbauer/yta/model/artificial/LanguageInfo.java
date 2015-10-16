package com.github.vbauer.yta.model.artificial;

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

}
