package bluedye.converter;

import bluedye.*;

public class RGB2HSV extends BDRawColor implements BDConverter {
    public RGB2HSV(double red, double green, double blue) {
        super(red, green, blue);
    }

    public RGB2HSV(BDRawColor color) {
        super(color);
    }

    public BDRawColor setHue(double hue) {
        double[] converter = this.converter(this.toArray());
        converter[0] = hue;
        return new BDRawColor(this.toRGB(converter));
    }

    public BDRawColor setSaturation(double saturation) {
        double[] converter = this.converter(this.toArray());
        converter[1] = saturation;
        return new BDRawColor(this.toRGB(converter));
    }

    public BDRawColor setValue(double value) {
        double[] converter = this.converter(this.toArray());
        converter[2] = value;
        return new BDRawColor(this.toRGB(converter));
    }

    public double getHue() {
        double[] converter = this.converter(this.toArray());
        return converter[0];
    }

    public double getSaturation() {
        double[] converter = this.converter(this.toArray());
        return converter[1];
    }

    public double getValue() {
        double[] converter = this.converter(this.toArray());
        return converter[2];
    }

    public double[] converter(double[] rgbBase) {
        double red = rgbBase[0],
                green = rgbBase[1],
                blue = rgbBase[2];
        double max = Math.max(blue, Math.max(green, red)),
                min = Math.min(red, Math.min(green, blue)),
                d = max - min, hue, saturation,
                value = max / 2.55;
        if (d == 0) return new double[]{0, 0, value};
        if (max == red)
            hue = 60 * (green - blue) / d;
        else if (max == green)
            hue = 60 * (blue - red) / d + 120;
        else
            hue = 60 * (red - green) / d + 240;
        saturation = (1 - min / max) * 100;
        hue = (hue < 0 ? hue + 360 : hue) % 360;
        return new double[]{hue, saturation, value};
    }

    public double[] toRGB(double[] hsvBase) {
        double hue = hsvBase[0],
                saturation = hsvBase[1] / 100,
                value = hsvBase[2] * 2.55;
        int hue6 = ((int) Math.floor(hue / 60)) % 6;
        double d = hue / 60 - hue6,
                a = (1 - saturation) * value,
                b = (1 - saturation * d) * value,
                c = (1 - saturation * (1 - d)) * value;
        return switch (hue6) {
            case 0 -> new double[]{value, c, a};
            case 1 -> new double[]{b, value, a};
            case 2 -> new double[]{a, value, c};
            case 3 -> new double[]{a, b, value};
            case 4 -> new double[]{c, a, value};
            default -> new double[]{value, a, b};
        };
    }
}
