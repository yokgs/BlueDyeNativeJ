package bluedye;

import bluedye.converter.*;

import java.util.LinkedList;

public class BDColor extends BDRawColor {
    protected LinkedList<BDRawColor> history = new LinkedList<>();
    protected BDRawColor root;

    public BDColor() {
        super();
        this.pin();
        this.autoSave();
    }

    public BDColor(double red, double green, double blue) {
        super(red, green, blue);
        this.pin();
        this.autoSave();
    }

    public BDColor(double red, double green, double blue, double alpha) {
        super(red, green, blue, alpha);
        this.pin();
        this.autoSave();
    }

    public BDColor(double grayscale) {
        super(grayscale);
        this.pin();
        this.autoSave();
    }

    public BDColor(BDRawColor color) {
        super(color);
        this.pin();
        this.autoSave();
    }

    public BDColor(long colorId) {
        super(colorId);
        this.pin();
        this.autoSave();
    }

    public BDColor(boolean white) {
        super(white);
        this.pin();
        this.autoSave();
    }

    public BDColor(double[] rgb) {
        super(rgb);
        this.pin();
        this.autoSave();
    }

    public void setRed(double red) {
        this.red = BDRawColor.correct(red);
        this.autoSave();
    }

    public void setGreen(double green) {
        this.green = BDRawColor.correct(green);
        this.autoSave();
    }

    public void setBlue(double blue) {
        this.blue = BDRawColor.correct(blue);
        this.autoSave();
    }

    public void setAlpha(double alpha) {
        this.alpha = alpha;
        this.autoSave();
    }

    public void setHue(double hue) {
        RGB2HCG cnv = new RGB2HCG(this.rawColor());
        this.parseColor(cnv.setHue(hue));
        this.autoSave();
    }

    public void setSaturation(double saturation) {
        RGB2HSV cnv = new RGB2HSV(this.rawColor());
        this.parseColor(cnv.setSaturation(saturation));
        this.autoSave();
    }

    public void setValue(double value) {
        RGB2HSV cnv = new RGB2HSV(this.rawColor());
        this.parseColor(cnv.setValue(value));
        this.autoSave();
    }

    public void setCyan(double cyan) {
        RGB2CMYK cnv = new RGB2CMYK(this.rawColor());
        this.parseColor(cnv.setCyan(cyan));
        this.autoSave();
    }

    public void setMagenta(double magenta) {
        RGB2CMYK cnv = new RGB2CMYK(this.rawColor());
        this.parseColor(cnv.setMagenta(magenta));
        this.autoSave();
    }

    public void setYellow(double yellow) {
        RGB2CMYK cnv = new RGB2CMYK(this.rawColor());
        this.parseColor(cnv.setYellow(yellow));
        this.autoSave();
    }

    public void setBlack(double black) {
        RGB2CMYK cnv = new RGB2CMYK(this.rawColor());
        this.parseColor(cnv.setBlack(black));
        this.autoSave();
    }

    public void setLightness(double lightness) {
        RGB2HSL cnv = new RGB2HSL(this.rawColor());
        this.parseColor(cnv.setLightness(lightness));
        this.autoSave();
    }

    public void setLuminance(double luminance) {
        RGB2LAB cnv = new RGB2LAB(this.rawColor());
        this.parseColor(cnv.setLuminance(luminance));
        this.autoSave();
    }

    public void setChroma(double chroma) {
        RGB2HCG cnv = new RGB2HCG(this.rawColor());
        this.parseColor(cnv.setChroma(chroma));
        this.autoSave();
    }

    public void setGrayness(double grayness) {
        RGB2HCG cnv = new RGB2HCG(this.rawColor());
        this.parseColor(cnv.setGrayness(grayness));
        this.autoSave();
    }


    protected void autoSave() {
        this.history.add(this.rawColor());
    }

    public int undo(int times) {
        int size = this.history.size();
        if (times >= size - 1) {
            this.reset();
            return 1;
        }
        for (int i = 0; i < times; i++) {
            this.parseColor(this.history.get(size - 2));
            this.history.remove(--size);
        }
        return size;
    }

    public int undo() {
        return this.undo(1);
    }

    public void pin() {
        this.root = this.rawColor();
    }

    public void reset() {
        this.parseColor(this.root);
    }

    protected void parseColor(BDRawColor rawColor) {
        this.red = rawColor.getRed();
        this.green = rawColor.getGreen();
        this.blue = rawColor.getBlue();
        this.alpha = rawColor.getAlpha();
    }

    public BDRawColor rawColor() {
        return new BDRawColor(this);
    }

}
