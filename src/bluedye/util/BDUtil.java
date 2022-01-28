package bluedye.util;

import bluedye.BDColors;

public class BDUtil {
    public static double linMax(double x, double alpha) {
        return x + (((100 - x) / 100) * alpha);
    }

    public static double linMin(double x, double alpha) {
        return x / 100 * alpha;
    }

    public static double logarithmic(double x, double gamma) {
        return Math.pow(x / 256, gamma) * 256;
    }

    public static double sigmoid(double x) {
        return 255 / (1 + Math.exp(-x / 32 - 4));
    }

    public static double prompt(double x){
        return ( BDUtil.sigmoid(x)-BDUtil.sigmoid(0))/(BDUtil.sigmoid(255)-BDUtil.sigmoid(0))*255;
    }

    public static long translate(BDColors name) {
        return switch (name) {
            case ALICEBLUE -> 15792383L;
            case ANTIQUEWHITE -> 16444375L;
            case AQUA -> 65535L;
            case AQUAMARINE -> 8388564L;
            case AZURE -> 15794175L;
            case BEIGE -> 16119260L;
            case BISQUE -> 16770244L;
            case BLACK -> 0L;
            case BLUE -> 255L;
            case BLUEVIOLET -> 9055202L;
            case BLANCHEDALMOND -> 16772045L;
            case BROWN -> 10824234L;
            case BURLYWOOD -> 14596231L;
            case CADETBLUE -> 6266528L;
            case CHARTREUSE -> 8388352L;
            case CHOCOLATE -> 13789470L;
            case CORAL -> 16744272L;
            case CORNFLOWERBLUE -> 6591981L;
            case CORNSILK -> 16775388L;
            case CRIMSON -> 14423100L;
            case CYAN -> 65535L;
            case DARKBLUE -> 139L;
            case DARKCYAN -> 35723L;
            case DARKGOLDENROD -> 12092939L;
            case DARKGRAY -> 11119017L;
            case DARKGREEN -> 25600L;
            case DARKGREY -> 11119017L;
            case DARKKHAKI -> 12433259L;
            case DARKMAGENTA -> 9109643L;
            case DARKOLIVEGREEN -> 5597999L;
            case DARKORANGE -> 16747520L;
            case DARKORCHID -> 10040012L;
            case DARKRED -> 9109504L;
            case DARKSALMON -> 15308410L;
            case DARKSEAGREEN -> 9419919L;
            case DARKSLATEBLUE -> 4734347L;
            case DARKSLATEGRAY -> 3100495L;
            case DARKSLATEGREY -> 3100495L;
            case DARKTURQUOISE -> 52945L;
            case DARKVIOLET -> 9699539L;
            case DEEPPINK -> 16716947L;
            case DEEPSKYBLUE -> 49151L;
            case DIMGRAY -> 6908265L;
            case DIMGREY -> 6908265L;
            case DODGERBLUE -> 2003199L;
            case FIREBRICK -> 11674146L;
            case FLORALWHITE -> 16775920L;
            case FORESTGREEN -> 2263842L;
            case FUCHSIA -> 16711935L;
            case GAINSBORO -> 14474460L;
            case GHOSTWHITE -> 16316671L;
            case GOLD -> 16766720L;
            case GOLDENROD -> 14329120L;
            case GRAY -> 8421504L;
            case GREEN -> 32768L;
            case GREENYELLOW -> 11403055L;
            case GREY -> 8421504L;
            case HONEYDEW -> 15794160L;
            case HOTPINK -> 16738740L;
            case INDIANRED -> 13458524L;
            case INDIGO -> 4915330L;
            case IVORY -> 16777200L;
            case KHAKI -> 15787660L;
            case LAVENDER -> 15132410L;
            case LAVENDERBLUSH -> 16773365L;
            case LAWNGREEN -> 8190976L;
            case LEMONCHIFFON -> 16775885L;
            case LIGHTBLUE -> 11393254L;
            case LIGHTCORAL -> 15761536L;
            case LIGHTCYAN -> 14745599L;
            case LIGHTGOLDENRODYELLOW -> 16448210L;
            case LIGHTGRAY -> 13882323L;
            case LIGHTGREEN -> 9498256L;
            case LIGHTGREY -> 13882323L;
            case LIGHTPINK -> 16758465L;
            case LIGHTSALMON -> 16752762L;
            case LIGHTSEAGREEN -> 2142890L;
            case LIGHTSKYBLUE -> 8900346L;
            case LIGHTSLATEGRAY -> 7833753L;
            case LIGHTSLATEGREY -> 7833753L;
            case LIGHTSTEELBLUE -> 11584734L;
            case LIGHTYELLOW -> 16777184L;
            case LIME -> 65280L;
            case LIMEGREEN -> 3329330L;
            case LINEN -> 16445670L;
            case MAGENTA -> 16711935L;
            case MAROON -> 8388608L;
            case MEDIUMAQUAMARINE -> 6737322L;
            case MEDIUMBLUE -> 205L;
            case MEDIUMORCHID -> 12211667L;
            case MEDIUMPURPLE -> 9662680L;
            case MEDIUMSEAGREEN -> 3978097L;
            case MEDIUMSLATEBLUE -> 8087790L;
            case MEDIUMSPRINGGREEN -> 64154L;
            case MEDIUMTURQUOISE -> 4772300L;
            case MEDIUMVIOLETRED -> 13047173L;
            case MIDNIGHTBLUE -> 1644912L;
            case MINTCREAM -> 16121850L;
            case MISTYROSE -> 16770273L;
            case MOCCASIN -> 16770229L;
            case NAVAJOWHITE -> 16768685L;
            case NAVY -> 128L;
            case OLDLACE -> 16643558L;
            case OLIVE -> 8421376L;
            case OLIVEDRAB -> 7048739L;
            case ORANGE -> 16753920L;
            case ORANGERED -> 16729344L;
            case ORCHID -> 14315734L;
            case PALEGOLDENROD -> 15657130L;
            case PALEGREEN -> 10025880L;
            case PALETURQUOISE -> 11529966L;
            case PALEVIOLETRED -> 14184595L;
            case PAPAYAWHIP -> 16773077L;
            case PEACHPUFF -> 16767673L;
            case PERU -> 13468991L;
            case PINK -> 16761035L;
            case PLUM -> 14524637L;
            case POWDERBLUE -> 11591910L;
            case PURPLE -> 8388736L;
            case REBECCAPURPLE -> 6697881L;
            case RED -> 16711680L;
            case ROSYBROWN -> 12357519L;
            case ROYALBLUE -> 4286945L;
            case SADDLEBROWN -> 9127187L;
            case SALMON -> 16416882L;
            case SANDYBROWN -> 16032864L;
            case SEAGREEN -> 3050327L;
            case SEASHELL -> 16774638L;
            case SIENNA -> 10506797L;
            case SILVER -> 12632256L;
            case SKYBLUE -> 8900331L;
            case SLATEBLUE -> 6970061L;
            case SLATEGRAY -> 7372944L;
            case SLATEGREY -> 7372944L;
            case SNOW -> 16775930L;
            case SPRINGGREEN -> 65407L;
            case STEELBLUE -> 4620980L;
            case TAN -> 13808780L;
            case TEAL -> 32896L;
            case THISTLE -> 14204888L;
            case TOMATO -> 16737095L;
            case TURQUOISE -> 4251856L;
            case VIOLET -> 4251856L;
            case WHEAT -> 16113331L;
            case WHITE -> 16777215L;
            case WHITESMOKE -> 16119285L;
            case YELLOW -> 16776960L;
            case YELLOWGREEN -> 10145074L;
        };
    }
}
