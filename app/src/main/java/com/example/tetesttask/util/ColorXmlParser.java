package com.example.tetesttask.util;

import android.util.Log;

import com.example.tetesttask.data.SimpleColorItem;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ColorXmlParser {

    private static final String TAG = "#_COLOR_XML_PARSER";
    public static final String TAG_NAME = "color";
    public static final String TAG_ATTR_FIRST = "name";
    public static final String TAG_ATTR_SECOND = "color";

    /**
     * Parse XMl to SimpleColorItem list
     *
     * @param xmlPullParser
     * @return SimpleColorItem
     */
    public static List<SimpleColorItem> parseToSimpleColorList(XmlPullParser xmlPullParser) throws XmlPullParserException {
        List<SimpleColorItem> colorList = new ArrayList<>();

        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        factory.setNamespaceAware(true);

        int eventType = xmlPullParser.getEventType();

        while (eventType != XmlPullParser.END_DOCUMENT) {
            String tagName = xmlPullParser.getName();

            switch (eventType) {
                case XmlPullParser.START_DOCUMENT:
                    Log.d(TAG, "START DOCUMENT");
                    break;

                case XmlPullParser.START_TAG:
                    if (TAG_NAME.equals(tagName)) {
                        String firstAttribute = "";
                        String secondAttribute = "";

                        /** Iterate of all attributes*/
                        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
                            String attributeName = xmlPullParser.getAttributeName(i);
                            String attributeValue = xmlPullParser.getAttributeValue(i);

                            /** get color name*/
                            if (TAG_ATTR_FIRST.equalsIgnoreCase(attributeName)) {
                                firstAttribute = attributeValue;

                                /** get color code*/
                            } else if (TAG_ATTR_SECOND.equalsIgnoreCase(attributeName)) {
                                secondAttribute = attributeValue;
                            }
                        }

                        /** Fill the SimpleColorItem list */
                        colorList.add(new SimpleColorItem(firstAttribute, secondAttribute));

                    }

                    break;
                case XmlPullParser.END_TAG:
                case XmlPullParser.TEXT:
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + eventType);
            }
            try {
                eventType = xmlPullParser.next();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return colorList;
    }
}
