package com.example.tetesttask.data;

public class SimpleColorItem {

    public static final int SIMPLE_ITEM = 0;
    public static final int EXPANDED_ITEM = 1;

    private static final String TAG = "#_SIMPLE_COLOR";
    private String colorName;
    private String colorCode;
    private boolean isExpanded;
    private int type; // type for getItemViewType() of RecyclerViewAdapter

    public SimpleColorItem(String colorName, String colorCode) {
        this.colorName = colorName.substring(0, 1).toUpperCase() + colorName.substring(1);
        this.colorCode = colorCode;
        this.isExpanded = false;
        type = 0;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    /**
     * Call when item clicked, change type
     */
    public void setExpanded(boolean expanded) {
        this.isExpanded = expanded;
        type = isExpanded ? 1 : 0;
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


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

}
