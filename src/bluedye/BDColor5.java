package bluedye;

import bluedye.util.BDFilter;
import bluedye.util.BDNumericalFilter;
import bluedye.util.BDUtil;

import java.util.ArrayList;

public class BDColor5 extends BDColor4 {
    private ArrayList<BDRawColor> cart = new ArrayList<>();

    public BDColor5(BDRawColor color) {
        super(color);
    }

    public BDColor5(BDColors color){
        this(BDUtil.translate(color));
    }

    public BDColor5() {
        super();
    }

    public BDColor5(double red, double green, double blue) {
        super(red, green, blue);
    }

    public BDColor5(double red, double green, double blue, double alpha) {
        super(red, green, blue, alpha);
    }

    public BDColor5(double grayscale) {
        super(grayscale);
    }

    public BDColor5(long colorId) {
        super(colorId);
    }

    public BDColor5(boolean white) {
        super(white);
    }

    public BDColor5(double[] rgb) {
        super(rgb);
    }

    public int toCart() {
        cart.add(this.rawColor());
        return cart.size();
    }

    public ArrayList<BDRawColor> exportCart() {
        ArrayList<BDRawColor> cart = this.cart;
        this.cart = new ArrayList<>();
        return cart;
    }

    public void colorFilter(BDFilter filter) {
        this.parseColor(filter.filter(this));
        this.autoSave();
    }

    public void numericalFilter(BDNumericalFilter filter) {
        this.red = filter.filter(this.red);
        this.green = filter.filter(this.green);
        this.blue = filter.filter(this.blue);
    }


}
