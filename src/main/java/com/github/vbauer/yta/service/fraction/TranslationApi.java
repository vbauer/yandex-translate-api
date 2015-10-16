package com.github.vbauer.yta.service.fraction;

import com.github.vbauer.yta.model.Direction;
import com.github.vbauer.yta.model.Language;
import com.github.vbauer.yta.model.basic.TextFormat;
import com.github.vbauer.yta.model.Translation;

/**
 * @author Vladislav Bauer
 */

public interface TranslationApi {

    Translation translate(String text, Language language);

    Translation translate(String text, Direction direction);

    Translation translate(String text, Direction direction, TextFormat format);

}
