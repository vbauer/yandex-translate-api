package com.github.vbauer.yta.service.fraction;

import com.github.vbauer.yta.model.Language;
import com.github.vbauer.yta.model.Languages;

/**
 * @author Vladislav Bauer
 */

public interface LanguageApi {

    Languages all();

    Languages all(Language ui);

    Languages all(String ui);

}
