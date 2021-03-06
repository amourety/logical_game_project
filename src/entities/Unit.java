package entities;

public class Unit {
    private String colorName; // GREEN/ YELLOW etc
    private String rgb; // #RGB
    private int pure; // if pure is 1 - pure unit, if pure is 0 - wrong

    public Unit(String colorName, String rgb, int i) {
        this.colorName = colorName;
        this.rgb = rgb;
        this.pure = i;
    }
    public int getPure() {
        return pure;
    }
    public String getColorName() {
        return colorName;
    }
    public String getRgb() {
        return rgb;
    }
}
