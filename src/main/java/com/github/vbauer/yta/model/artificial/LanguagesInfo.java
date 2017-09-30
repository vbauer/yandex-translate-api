package com.github.vbauer.yta.model.artificial;

import org.immutables.gson.Gson.TypeAdapters;
import org.immutables.value.Value.Immutable;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Model-interface with information about languages.
 *
 * @author Vladislav Bauer
 */

@Immutable
@TypeAdapters
public interface LanguagesInfo extends Serializable {

    /**
     * Collection of translation directions.
     *
     * @return translation directions
     */
    List<String> dirs();

    /**
     * Dictionary with languages (code / name).
     *
     * @return languages
     */
    Map<String, String> langs();

}
