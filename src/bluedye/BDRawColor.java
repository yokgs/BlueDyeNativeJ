package bluedye;

public class BDRawColor {
    protected double red, green, blue, alpha;

    public BDRawColor() {
        this.red = 0;
        this.green = 0;
        this.blue = 0;
        this.alpha = 0;
    }

    public BDRawColor(double red, double green, double blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = 1;
    }

    public BDRawColor(double red, double green, double blue, double alpha) {
        this(red, green, blue);
        this.alpha = alpha;
    }

    public BDRawColor(double grayscale) {
        this.red = grayscale;
        this.green = grayscale;
        this.blue = grayscale;
        this.alpha = 1;
    }

    public BDRawColor(BDRawColor color) {
        this.red = color.getRed();
        this.green = color.getGreen();
        this.blue = color.getBlue();
        this.alpha = color.getAlpha();
    }

    public BDRawColor(long colorId) {
        this(Math.floor((colorId / 256 / 256) % 256), Math.floor((colorId >> 8) % 256), Math.floor(colorId % 256));
    }

    public BDRawColor(boolean white) {
        this(white ? 255.0 : 0.0);
    }

    public BDRawColor(double[] rgb) {
        this(rgb[0], rgb[1], rgb[2]);
    }

    protected static double correct(double number) {
        return Math.min(Math.max(number, 0), 100);
    }

    public static void main(String[] args) {
        BDColor c = new BDColor();
        System.out.println(c);
        c = new BDColor(78);
        System.out.println(c);
        c = new BDColor(78, 99, 78);
        System.out.println(c);
        c = new BDColor(89, 99, 89, .8);
        System.out.println(c);
        //var cnv = new RGB2HSV(new BDRawColor());
        //System.out.println(new BDRawColor(cnv.toRGB(cnv.converter(new double[]{80, 0, 0}))));
        c = new BDColor5(true);
        ((BDColor5) c).numericalFilter(x -> (x / 2 + 5));
        System.out.println(c);
        System.out.println(c.toNumber());

    }

    public double getRed() {
        return red;
    }

    public double getGreen() {
        return green;
    }

    public double getBlue() {
        return blue;
    }

    public double getAlpha() {
        return alpha;
    }

    @Override
    public String toString() {
        return "rgba(" + red +
                ", " + green +
                ", " + blue +
                ", " + alpha +
                ')';
    }

    public double[] toArray() {
        return new double[]{this.red, this.green, this.blue, this.alpha};
    }

    public long toNumber() {
        return (((int) this.red * 256 + (int) this.green) * 256 + (int) this.blue);
    }
}
