package bluedye.converter;

import bluedye.BDRawColor;

public class RGB2XYZ extends BDRawColor implements BDConverter {
    public RGB2XYZ() {
        super();
    }

    public RGB2XYZ(double red, double green, double blue) {
        super(red, green, blue);
    }

    public RGB2XYZ(BDRawColor color) {
        super(color);
    }

    public BDRawColor setX(double cyan) {
        double[] converter = this.converter(this.toArray());
        converter[0] = cyan;
        return new BDRawColor(this.toRGB(converter));
    }

    public BDRawColor setY(double magenta) {
        double[] converter = this.converter(this.toArray());
        converter[1] = magenta;
        return new BDRawColor(this.toRGB(converter));
    }

    public BDRawColor setZ(double yellow) {
        double[] converter = this.converter(this.toArray());
        converter[2] = yellow;
        return new BDRawColor(this.toRGB(converter));
    }

    public double getX() {
        double[] converter = this.converter(this.toArray());
        return converter[0];
    }

    public double getY() {
        double[] converter = this.converter(this.toArray());
        return converter[1];
    }

    public double getZ() {
        double[] converter = this.converter(this.toArray());
        return converter[2];
    }

    @Override
    public double[] converter(double[] rgbBase) {
        double red = rgbBase[0], green = rgbBase[1], blue = rgbBase[2];
        return new double[]{
                .4124 * red + .3576 * green + .1805 * blue,
                .2126 * red + .7152 * green + .0722 * blue,
                .0193 * red + .1192 * green + .9505 * blue
        };
    }

    @Override
    public double[] toRGB(double[] xBase) {
        double x = xBase[0], y = xBase[1], z = xBase[2];
        return
                new double[]{
                        3.2406 * x - 1.5372 * y - 0.4986 * z,
                        -0.9689 * x + 1.8758 * y + 0.0415 * z,
                        0.0557 * x - 0.2040 * y + 1.0570 * z
                };
    }
}
