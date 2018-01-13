package com.github.vbauer.yta.model;

import com.github.vbauer.yta.model.basic.HasCode;
import org.immutables.value.Value.Immutable;
import org.immutables.value.Value.Parameter;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Objects;
import java.util.Optional;

/**
 * Model which represents language.
 *
 * @author Vladislav Bauer
 */

@SuppressWarnings("serial")
@Immutable
public abstract class Language implements HasCode<String> {

    public static final Language AZ = of("az", "Azerbaijan");
    public static final Language SQ = of("sq", "Albanian");
    public static final Language AM = of("am", "Amharic");
    public static final Language EN = of("en", "English");
    public static final Language AR = of("ar", "Arabic");
    public static final Language HY = of("hy", "Armenian");
    public static final Language AF = of("af", "Afrikaans");
    public static final Language EU = of("eu", "Basque");
    public static final Language BA = of("ba", "Bashkir");
    public static final Language BE = of("be", "Belarusian");
    public static final Language BN = of("bn", "Bengali");
    public static final Language MY = of("my", "Burmese");
    public static final Language BG = of("bg", "Bulgarian");
    public static final Language BS = of("bs", "Bosnian");
    public static final Language CY = of("cy", "Welsh");
    public static final Language HU = of("hu", "Hungarian");
    public static final Language VI = of("vi", "Vietnamese");
    public static final Language HT = of("ht", "Haitian (Creole)");
    public static final Language GL = of("gl", "Galician");
    public static final Language NL = of("nl", "Dutch");
    public static final Language MRJ = of("mrj", "Hill Mari");
    public static final Language EL = of("el", "Greek");
    public static final Language KA = of("ka", "Georgian");
    public static final Language GU = of("gu", "Gujarati");
    public static final Language DA = of("da", "Danish");
    public static final Language HE = of("he", "Hebrew");
    public static final Language YI = of("yi", "Yiddish");
    public static final Language ID = of("id", "Indonesian");
    public static final Language GA = of("ga", "Irish");
    public static final Language IT = of("it", "Italian");
    public static final Language IS = of("is", "Icelandic");
    public static final Language ES = of("es", "Spanish");
    public static final Language KK = of("kk", "Kazakh");
    public static final Language KN = of("kn", "Kannada");
    public static final Language CA = of("ca", "Catalan");
    public static final Language KY = of("ky", "Kyrgyz");
    public static final Language ZH = of("zh", "Chinese");
    public static final Language KO = of("ko", "Korean");
    public static final Language XH = of("xh", "Xhosa");
    public static final Language KM = of("km", "Khmer");
    public static final Language LO = of("lo", "Laotian");
    public static final Language LA = of("la", "Latin");
    public static final Language LV = of("lv", "Latvian");
    public static final Language LT = of("lt", "Lithuanian");
    public static final Language LB = of("lb", "Luxembourgish");
    public static final Language MG = of("mg", "Malagasy");
    public static final Language MS = of("ms", "Malay");
    public static final Language ML = of("ml", "Malayalam");
    public static final Language MT = of("mt", "Maltese");
    public static final Language MK = of("mk", "Macedonian");
    public static final Language MI = of("mi", "Maori");
    public static final Language MR = of("mr", "Marathi");
    public static final Language MHR = of("mhr", "Mari");
    public static final Language MN = of("mn", "Mongolian");
    public static final Language DE = of("de", "German");
    public static final Language NE = of("ne", "Nepali");
    public static final Language NO = of("no", "Norwegian");
    public static final Language PA = of("pa", "Punjabi");
    public static final Language PAP = of("pap", "Papiamento");
    public static final Language FA = of("fa", "Persian");
    public static final Language PL = of("pl", "Polish");
    public static final Language PT = of("pt", "Portuguese");
    public static final Language RO = of("ro", "Romanian");
    public static final Language RU = of("ru", "Russian");
    public static final Language CEB = of("ceb", "Cebuano");
    public static final Language SR = of("sr", "Serbian");
    public static final Language SI = of("si", "Sinhala");
    public static final Language SK = of("sk", "Slovakian");
    public static final Language SL = of("sl", "Slovenian");
    public static final Language SW = of("sw", "Swahili");
    public static final Language SU = of("su", "Sundanese");
    public static final Language TG = of("tg", "Tajik");
    public static final Language TH = of("th", "Thai");
    public static final Language TL = of("tl", "Tagalog");
    public static final Language TA = of("ta", "Tamil");
    public static final Language TT = of("tt", "Tatar");
    public static final Language TE = of("te", "Telugu");
    public static final Language TR = of("tr", "Turkish");
    public static final Language UDM = of("udm", "Udmurt");
    public static final Language UZ = of("uz", "Uzbek");
    public static final Language UK = of("uk", "Ukrainian");
    public static final Language UR = of("ur", "Urdu");
    public static final Language FI = of("fi", "Finnish");
    public static final Language FR = of("fr", "French");
    public static final Language HI = of("hi", "Hindi");
    public static final Language HR = of("hr", "Croatian");
    public static final Language CS = of("cs", "Czech");
    public static final Language SV = of("sv", "Swedish");
    public static final Language GD = of("gd", "Scottish");
    public static final Language ET = of("et", "Estonian");
    public static final Language EO = of("eo", "Esperanto");
    public static final Language JV = of("jv", "Javanese");
    public static final Language JA = of("ja", "Japanese");
    public static final Language EMJ = of("emj", "Emoji");


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
    public static Language of(@Nonnull final String code, @Nullable final String name) {
        return ImmutableLanguage.of(code.toLowerCase(), Optional.ofNullable(name));
    }

    /**
     * Create language object using only code value.
     *
     * @param code code value
     * @return language
     */
    @Nonnull
    public static Language of(@Nonnull final String code) {
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
            || another instanceof Language && Objects.equals(((Language) another).code(), code());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return code();
    }

}
