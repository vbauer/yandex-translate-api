package com.github.vbauer.yta.service.fraction;

import com.github.vbauer.yta.model.Language;
import com.github.vbauer.yta.model.Languages;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * <p>
 * Service allows to get a list of translation directions.
 * <br>
 *
 * The service translates between any of the languages in the list of supported languages.
 * To get this information, set the ui parameter when calling methods.
 * </p>
 *
 * <a href="https://tech.yandex.com/translate/doc/dg/reference/getLangs-docpage/">
 * Official REST API documentation
 * </a>
 *
 * @author Vladislav Bauer
 */

public interface LanguageApi {

    /**
     * Gets a list of translation directions and available languages supported by the service.
     * In this case, language names ({@link Language#name()}) are not fetched from the Yandex.Translate service.
     *
     * @return information about available languages and directions of translation
     */
    @Nonnull
    Languages all();

    /**
     * Gets a list of translation directions and available languages supported by the service.
     *
     * @param ui if set, the response contains explanations of language codes
     * @return information about available languages and directions of translation
     */
    @Nonnull
    Languages all(@Nullable Language ui);

    /**
     * Gets a list of translation directions and available languages supported by the service.
     *
     * @param ui if set, the response contains explanations of language codes
     * @return information about available languages and directions of translation
     */
    @Nonnull
    Languages all(@Nullable String ui);

}
