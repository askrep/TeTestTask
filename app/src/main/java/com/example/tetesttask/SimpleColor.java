package com.example.tetesttask;

public class SimpleColor {

    private static final String TAG = "#_SIMPLE_COLOR";

    private String colorName;
    private String colorCode;
    private boolean isExpanded;

    public SimpleColor(String colorName, String colorCode) {
        this.colorName = colorName;
        this.colorCode = colorCode;
        this.isExpanded = false;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        this.isExpanded = expanded;
    }
}
