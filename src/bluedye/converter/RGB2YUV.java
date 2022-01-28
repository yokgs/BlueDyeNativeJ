package bluedye.converter;

import bluedye.*;

public class RGB2YUV extends BDRawColor implements BDConverter {
    public RGB2YUV() {
        super();
    }

    public RGB2YUV(double red, double green, double blue) {
        super(red, green, blue);
    }

    public RGB2YUV(BDRawColor color) {
        super(color);
    }

    public BDRawColor setY(double cyan) {
        double[] converter = this.converter(this.toArray());
        converter[0] = cyan;
        return new BDRawColor(this.toRGB(converter));
    }

    public BDRawColor setU(double magenta) {
        double[] converter = this.converter(this.toArray());
        converter[1] = magenta;
        return new BDRawColor(this.toRGB(converter));
    }

    public BDRawColor setV(double yellow) {
        double[] converter = this.converter(this.toArray());
        converter[2] = yellow;
        return new BDRawColor(this.toRGB(converter));
    }


    @Override
    public double[] converter(double[] rgbBase) {
        double red = rgbBase[0], green = rgbBase[1], blue = rgbBase[2];
        return new double[]{
                .2991 * red + .5879 * green + .114 * blue,
                -.1474 * red - .2896 * green + .437 * blue,
                .6148 * red - .5157 * green - .0991 * blue
        };
    }

    @Override
    public double[] toRGB(double[] xBase) {
        double y = xBase[0], u = xBase[1], v = xBase[2];
        return new double[]{
                y + 1.14 * v,
                y - .39 * u - .58 * v,
                y + 2.03 * u
        };
    }
}
