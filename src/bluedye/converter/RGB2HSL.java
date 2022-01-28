package bluedye.converter;

import bluedye.*;

public class RGB2HSL extends BDRawColor implements BDConverter {
    private double hue, saturation, lightness;

    public RGB2HSL(double red, double green, double blue) {
        super(red, green, blue);
    }

    public RGB2HSL(BDRawColor color) {
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

    public BDRawColor setLightness(double lightness) {
        double[] converter = this.converter(this.toArray());
        converter[2] = lightness;
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

    public double getLightness() {
        double[] converter = this.converter(this.toArray());
        return converter[2];
    }

    @Override
    public double[] converter(double[] rgbBase) {
        return new double[0];
    }

    @Override
    public double[] toRGB(double[] xBase) {
        return new double[0];
    }
}
