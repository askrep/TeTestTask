package com.example.tetesttask;

import android.content.res.XmlResourceParser;

import androidx.lifecycle.ViewModel;

import org.xmlpull.v1.XmlPullParserException;

import java.util.List;

public class MainViewModel extends ViewModel {
    
    /**
     * Get SimpleColor list from xml resource
     *
     * @param xmlResourceParser XmlResourceParser
     * @return List<SimpleColor>
     */
    public List<SimpleColorItem> getSimpleColorList(XmlResourceParser xmlResourceParser) throws XmlPullParserException {
        return ColorXmlParser.parseToSimpleColorList(xmlResourceParser);
    }
    
}