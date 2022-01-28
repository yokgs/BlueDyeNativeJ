package bluedye.converter;

import bluedye.*;

public class RGB2HCG extends BDRawColor implements BDConverter {
    private double hue, chroma, grayness;

    public RGB2HCG(double red, double green, double blue) {
        super(red, green, blue);
    }

    public RGB2HCG(BDRawColor color) {
        super(color);
    }

    public BDRawColor setHue(double hue) {
        double[] converter = this.converter(this.toArray());
        converter[0] = hue;
        return new BDRawColor(this.toRGB(converter));
    }

    public BDRawColor setChroma(double chroma) {
        double[] converter = this.converter(this.toArray());
        converter[1] = chroma;
        return new BDRawColor(this.toRGB(converter));
    }

    public BDRawColor setGrayness(double grayness) {
        double[] converter = this.converter(this.toArray());
        converter[2] = grayness;
        return new BDRawColor(this.toRGB(converter));
    }

    public double getHue() {
        double[] converter = this.converter(this.toArray());
        return converter[0];
    }

    public double getChroma() {
        double[] converter = this.converter(this.toArray());
        return converter[1];
    }

    public double getGrayness() {
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
