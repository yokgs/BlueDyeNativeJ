package bluedye.converter;

import bluedye.BDRawColor;

public class RGB2YIQ extends BDRawColor implements BDConverter {
    public RGB2YIQ() {
        super();
    }

    public RGB2YIQ(double red, double green, double blue) {
        super(red, green, blue);
    }

    public RGB2YIQ(BDRawColor color) {
        super(color);
    }

    public BDRawColor setLuma(double luma) {
        double[] converter = this.converter(this.toArray());
        converter[0] = luma;
        return new BDRawColor(this.toRGB(converter));
    }

    public BDRawColor setInPhase(double inPhase) {
        double[] converter = this.converter(this.toArray());
        converter[1] = inPhase;
        return new BDRawColor(this.toRGB(converter));
    }

    public BDRawColor setQuadrature(double quadrature) {
        double[] converter = this.converter(this.toArray());
        converter[2] = quadrature;
        return new BDRawColor(this.toRGB(converter));
    }

    public double getLuma() {
        double[] converter = this.converter(this.toArray());
        return converter[0];
    }

    public double getInPhase() {
        double[] converter = this.converter(this.toArray());
        return converter[1];
    }

    public double getQuadrature() {
        double[] converter = this.converter(this.toArray());
        return converter[2];
    }

    @Override
    public double[] converter(double[] rgbBase) {
        double red = rgbBase[0], green = rgbBase[1], blue = rgbBase[2];
        return new double[]{
                red * .299 + green * .587 + blue * .114,
                red * .596 - green * .275 - blue * .321,
                red * .212 - green * .523 + blue * .311
        };
    }

    @Override
    public double[] toRGB(double[] xBase) {
        double y = xBase[0], i = xBase[1], q = xBase[2];
        return new double[]{1.2750 * y + 1.9032 * i - 2.4318 * q,
                1.8160 * y - 1.0654 * i + 0.4340 * q,
                -3.9231 * y + 0.4944 * i + 4.1432 * q};
    }
}
