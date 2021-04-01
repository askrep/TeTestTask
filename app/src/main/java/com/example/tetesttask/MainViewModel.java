package com.example.tetesttask;

import android.content.res.XmlResourceParser;

import androidx.lifecycle.ViewModel;

import com.example.tetesttask.data.SimpleColorItem;
import com.example.tetesttask.util.ColorXmlParser;

import org.xmlpull.v1.XmlPullParserException;

import java.util.List;

public class MainViewModel extends ViewModel {
    
    /**
     * Get SimpleColor list from xml resource
     *
     * @param xmlResourceParser XmlResourceParser
     * @return List<SimpleColor>
     */
    public List<SimpleColorItem> parseToSimpleColorList(XmlResourceParser xmlResourceParser) throws XmlPullParserException {
        return ColorXmlParser.parseToSimpleColorList(xmlResourceParser);
    }
    
}