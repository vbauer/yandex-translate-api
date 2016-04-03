/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Vladislav Bauer
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.github.vbauer.yta.model;

import com.github.vbauer.yta.model.basic.HasCode;
import com.google.common.base.Objects;
import org.immutables.value.Value.Immutable;
import org.immutables.value.Value.Parameter;

import javax.annotation.Nonnull;
import java.util.Optional;

/**
 * Model which represents language.
 *
 * @author Vladislav Bauer
 */

@SuppressWarnings("serial")
@Immutable
public abstract class Language implements HasCode<String> {

    public static final Language EN = of("en", "English");
    public static final Language RU = of("ru", "Russian");
    public static final Language TR = of("tr", "Turkish");
    public static final Language UK = of("uk", "Ukrainian");

    public static final Language SW = of("sw", "Swahili");
    public static final Language AZ = of("az", "Azerbaijani");
    public static final Language HY = of("hy", "Armenian");
    public static final Language ID = of("id", "Indonesian");
    public static final Language KO = of("ko", "Korean");
    public static final Language BE = of("be", "Belarusian");
    public static final Language JA = of("ja", "Japanese");
    public static final Language KA = of("ka", "Georgian");
    public static final Language CY = of("cy", "Welsh");
    public static final Language KK = of("kk", "Kazakh");
    public static final Language IT = of("it", "Italian");
    public static final Language RO = of("ro", "Romanian");
    public static final Language HU = of("hu", "Hungarian");
    public static final Language MS = of("ms", "Malay");
    public static final Language MK = of("mk", "Macedonian");
    public static final Language FA = of("fa", "Persian");
    public static final Language DA = of("da", "Danish");
    public static final Language ES = of("es", "Spanish");
    public static final Language FR = of("fr", "French");
    public static final Language LV = of("lv", "Latvian");
    public static final Language GA = of("ga", "Irish");
    public static final Language SR = of("sr", "Serbian");
    public static final Language TT = of("tt", "Tatar");
    public static final Language SQ = of("sq", "Albanian");
    public static final Language MT = of("mt", "Maltese");
    public static final Language PL = of("pl", "Polish");
    public static final Language HR = of("hr", "Croatian");
    public static final Language TH = of("th", "Thai");
    public static final Language NO = of("no", "Norwegian");
    public static final Language KY = of("ky", "Kirghiz");
    public static final Language GL = of("gl", "Galician");
    public static final Language FI = of("fi", "Finnish");
    public static final Language TG = of("tg", "Tajik");
    public static final Language EU = of("eu", "Basque");
    public static final Language AR = of("ar", "Arabic");
    public static final Language CA = of("ca", "Catalan");
    public static final Language NL = of("nl", "Dutch");
    public static final Language BG = of("bg", "Bulgarian");
    public static final Language AF = of("af", "Afrikaans");
    public static final Language MN = of("mn", "Mongolian");
    public static final Language HT = of("ht", "Haitian");
    public static final Language PT = of("pt", "Portuguese");
    public static final Language DE = of("de", "German");
    public static final Language TL = of("tl", "Tagalog");
    public static final Language BS = of("bs", "Bosnian");
    public static final Language VI = of("vi", "Vietnamese");
    public static final Language CS = of("cs", "Czech");
    public static final Language EL = of("el", "Greek");
    public static final Language MG = of("mg", "Malagasy");
    public static final Language SK = of("sk", "Slovak");
    public static final Language BA = of("ba", "Bashkir");
    public static final Language LT = of("lt", "Lithuanian");
    public static final Language ET = of("et", "Estonian");
    public static final Language ZH = of("zh", "Chinese");
    public static final Language HE = of("he", "Hebrew");
    public static final Language UZ = of("uz", "Uzbek");
    public static final Language LA = of("la", "Latin");
    public static final Language SL = of("sl", "Slovenian");
    public static final Language SV = of("sv", "Swedish");
    public static final Language IS = of("is", "Icelandic");


    /**
     * {@inheritDoc}
     */
    @Override
    @Parameter(order = 0)
    public abstract String code();

    /**
     * Get language name.
     *
     * @return language name
     */
    @Parameter(order = 1)
    public abstract Optional<String> name();


    /**
     * A factory method to create language object using code and name.
     *
     * @param code code value
     * @param name language name
     * @return language
     */
    @Nonnull
    public static Language of(final String code, final String name) {
        final String normalizedCode = code == null ? null : code.toLowerCase();
        return ImmutableLanguage.of(normalizedCode, Optional.ofNullable(name));
    }

    /**
     * Create language object using only code value.
     *
     * @param code code value
     * @return language
     */
    @Nonnull
    public static Language of(final String code) {
        return of(code, null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(code());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object another) {
        return this == another
            || another instanceof Language && Objects.equal(((Language) another).code(), code());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return code();
    }

}
