package com.github.vbauer.yta.model;

import com.google.common.base.Objects;
import org.immutables.value.Value.Immutable;
import org.immutables.value.Value.Parameter;

import java.util.Optional;

/**
 * @author Vladislav Bauer
 */

@Immutable
public abstract class Language implements com.github.vbauer.yta.model.basic.HasCode<String> {

    public static final Language EN = of("en", "English");
    public static final Language RU = of("ru", "Russian");
    public static final Language TR = of("en", "Turkish");
    public static final Language UK = of("en", "Ukrainian");

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


    @Parameter(order = 0)
    public abstract String code();

    @Parameter(order = 1)
    public abstract Optional<String> name();


    public static Language of(final String code) {
        return ImmutableLanguage.of(code, Optional.empty());
    }

    public static Language of(final String code, final String name) {
        return ImmutableLanguage.of(code, Optional.of(name));
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(code());
    }

    @Override
    public boolean equals(final Object another) {
        return this == another
            || (another instanceof Language && Objects.equal(((Language) another).code(), code()));
    }

    @Override
    public String toString() {
        return code();
    }

}
