package bluedye;

import bluedye.converter.*;
import bluedye.util.BDUtil;

public class BDColor4 extends BDColor {

    public BDColor4(BDRawColor color) {
        super(color);
    }

    public BDColor4() {
        super();
    }

    public BDColor4(double red, double green, double blue) {
        super(red, green, blue);
    }

    public BDColor4(double red, double green, double blue, double alpha) {
        super(red, green, blue, alpha);
    }

    public BDColor4(double grayscale) {
        super(grayscale);
    }

    public BDColor4(long colorId) {
        super(colorId);
    }

    public BDColor4(boolean white) {
        super(white);
    }

    public BDColor4(double[] rgb) {
        super(rgb);
    }

    public void gray() {
        double g = this.red + this.green + this.blue;
        this.parseColor(new BDRawColor(g / 3));
        this.autoSave();
    }

    public void grey() {
        this.gray();
    }

    public void negative() {
        this.parseColor(new BDRawColor(255 - this.red, 255 - this.green, 255 - this.blue));
        this.autoSave();
    }

    public void saturate(double level) {
        RGB2HSV cnv = new RGB2HSV(this.rawColor());
        double saturation = BDUtil.linMax(cnv.getSaturation(), level);
        this.parseColor(cnv.setSaturation(saturation));
        this.autoSave();
    }

    public void desaturate(double level) {
        RGB2HSV cnv = new RGB2HSV(this.rawColor());
        double saturation = BDUtil.linMin(cnv.getSaturation(), level);
        this.parseColor(cnv.setSaturation(saturation));
        this.autoSave();
    }

    public void dark(double level) {
        RGB2HSL cnv = new RGB2HSL(this.rawColor());
        double light = BDUtil.linMin(cnv.getLightness(), level);
        this.parseColor(cnv.setLightness(light));
        this.autoSave();
    }

    public void light(double level) {
        RGB2HSL cnv = new RGB2HSL(this.rawColor());
        double light = BDUtil.linMax(cnv.getLightness(), level);
        this.parseColor(cnv.setLightness(light));
        this.autoSave();
    }

    public void rotate(double angle) {
        RGB2HCG cnv = new RGB2HCG(this.rawColor());
        double hue = (cnv.getHue() + angle + 360) % 360;
        this.parseColor(cnv.setHue(hue));
        this.autoSave();
    }


    public void log(double gamma) {

    }

    public double contrast(BDRawColor color) {
        double c = (this.getLuminance() + .01) / ((new BDColor4(color)).getLuminance() + .01);
        return c;
    }

    public double getHue() {
        RGB2HCG cnv = new RGB2HCG(this.rawColor());
        return cnv.getHue();
    }

    public double getSaturation() {
        RGB2HSV cnv = new RGB2HSV(this.rawColor());
        return cnv.getSaturation();
    }

    public double getValue() {
        RGB2HSV cnv = new RGB2HSV(this.rawColor());
        return cnv.getValue();
    }

    public double getCyan() {
        RGB2CMYK cnv = new RGB2CMYK(this.rawColor());
        return cnv.getCyan();
    }

    public double getMagenta() {
        RGB2CMYK cnv = new RGB2CMYK(this.rawColor());
        return cnv.getMagenta();
    }

    public double getYellow() {
        RGB2CMYK cnv = new RGB2CMYK(this.rawColor());
        return cnv.getYellow();
    }

    public double getBlack() {
        RGB2CMYK cnv = new RGB2CMYK(this.rawColor());
        return cnv.getBlack();
    }

    public double getLightness() {
        RGB2HSL cnv = new RGB2HSL(this.rawColor());
        return cnv.getLightness();
    }

    public double getLuminance() {
        RGB2LAB cnv = new RGB2LAB(this.rawColor());
        return cnv.getLuminance();
    }

    public double getChroma() {
        RGB2HCG cnv = new RGB2HCG(this.rawColor());
        return cnv.getChroma();
    }

    public double getGrayness() {
        RGB2HCG cnv = new RGB2HCG(this.rawColor());
        return cnv.getGrayness();
    }

    public double getTempeture() {
        RGB2LAB cnv = new RGB2LAB(this.rawColor());
        return cnv.getTempeture();
    }

    public double getTint() {
        RGB2LAB cnv = new RGB2LAB(this.rawColor());
        return cnv.getTint();
    }
}
