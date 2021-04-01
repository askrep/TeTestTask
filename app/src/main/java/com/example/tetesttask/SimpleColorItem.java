package com.example.tetesttask;

public class SimpleColorItem {

    public static final int SIMPLE_ITEM = 0;
    public static final int EXPANDED_ITEM = 1;

    private static final String TAG = "#_SIMPLE_COLOR";
    private String colorName;
    private String colorCode;
    private String colorCodeDefault = "#3A3A3A";
    private boolean isExpanded;
    private int type;

    public SimpleColorItem(String colorName, String colorCode) {
        this.colorName = colorName;
        this.colorCode = colorCode;
        this.isExpanded = false;
        type = 0;
    }

    public static String getTAG() {
        return TAG;
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
        type = isExpanded ? 1 : 0;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getColorCodeDefault() {
        return colorCodeDefault;
    }

    public void setColorCodeDefault(String colorCodeDefault) {
        this.colorCodeDefault = colorCodeDefault;
    }
}
