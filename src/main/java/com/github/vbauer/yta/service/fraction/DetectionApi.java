package com.github.vbauer.yta.service.fraction;

import com.github.vbauer.yta.model.Language;
import com.github.vbauer.yta.model.basic.TextFormat;

import java.util.Optional;

/**
 * @author Vladislav Bauer
 */

public interface DetectionApi {

    Optional<Language> detect(String text);

    Optional<Language> detect(String text, TextFormat format);

}
