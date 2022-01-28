package bluedye.converter;

import bluedye.*;
import bluedye.util.BDNumericalFilter;

public class RGB2LAB extends BDRawColor implements BDConverter {
    public RGB2LAB() {
        super();
    }

    public RGB2LAB(double red, double green, double blue) {
        super(red, green, blue);
    }

    public RGB2LAB(BDRawColor color) {
        super(color);
    }

    public BDRawColor setLuminance(double luminance) {
        double[] converter = this.converter(this.toArray());
        converter[0] = luminance;
        return new BDRawColor(this.toRGB(converter));
    }

    public BDRawColor setTint(double a) {
        double[] converter = this.converter(this.toArray());
        converter[1] = a;
        return new BDRawColor(this.toRGB(converter));
    }

    public BDRawColor setTempture(double b) {
        double[] converter = this.converter(this.toArray());
        converter[2] = b;
        return new BDRawColor(this.toRGB(converter));
    }

    public double getLuminance() {
        double[] converter = this.converter(this.toArray());
        return converter[0];
    }

    public double getTint() {
        double[] converter = this.converter(this.toArray());
        return converter[1];
    }

    public double getTempeture() {
        double[] converter = this.converter(this.toArray());
        return converter[2];
    }

    @Override
    public double[] converter(double[] rgbBase) {
        double[] xyz = (new RGB2XYZ()).converter(rgbBase);
        double x = xyz[0];
        double y = xyz[1];
        double z = xyz[2];
        BDNumericalFilter f = u -> {
            double n = 6 / 29;
            if (u > Math.pow(n, 3))
                return Math.pow(u, 1 / 3);
            return 1 / (3 * n * n) * u + 4 / 29;
        };

        return new double[]{
                116 * f.filter(y / 100),
                500 * (f.filter(x / 95.047) - f.filter(y / 100)),
                200 * (f.filter(y / 100) - f.filter(z / 108.883))
        };
    }

    @Override
    public double[] toRGB(double[] xBase) {
        return new double[0];
    }
}
