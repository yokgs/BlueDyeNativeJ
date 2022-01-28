package bluedye.converter;

import bluedye.*;

public class RGB2CMYK extends BDRawColor implements BDConverter {
    public RGB2CMYK(){super();}

    public RGB2CMYK(double red, double green, double blue) {
        super(red, green, blue);
    }

    public RGB2CMYK(BDRawColor color) {
        super(color);
    }

    public BDRawColor setCyan(double cyan) {
        double[] converter = this.converter(this.toArray());
        converter[0] = cyan;
        return new BDRawColor(this.toRGB(converter));
    }

    public BDRawColor setMagenta(double magenta) {
        double[] converter = this.converter(this.toArray());
        converter[1] = magenta;
        return new BDRawColor(this.toRGB(converter));
    }

    public BDRawColor setYellow(double yellow) {
        double[] converter = this.converter(this.toArray());
        converter[2] = yellow;
        return new BDRawColor(this.toRGB(converter));
    }

    public BDRawColor setBlack(double black) {
        double[] converter = this.converter(this.toArray());
        converter[3] = black;
        return new BDRawColor(this.toRGB(converter));
    }

    public double getCyan() {
        double[] converter = this.converter(this.toArray());
        return converter[0];
    }

    public double getMagenta() {
        double[] converter = this.converter(this.toArray());
        return converter[1];
    }

    public double getYellow() {
        double[] converter = this.converter(this.toArray());
        return converter[2];
    }

    public double getBlack() {
        double[] converter = this.converter(this.toArray());
        return converter[3];
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
