package com.example.tetesttask;

import android.app.Application;
import android.content.res.XmlResourceParser;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.tetesttask.data.SimpleColorItem;
import com.example.tetesttask.util.ColorXmlParser;

import org.xmlpull.v1.XmlPullParserException;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    
    private static final String TAG = "#_VIEW_MODEL";
    private final MutableLiveData<List<SimpleColorItem>> colorItemListLiveData = new MutableLiveData<>();
    
    public MainViewModel(@NonNull Application application) throws XmlPullParserException {
        super(application);
        
        /** Get xml resource*/
        XmlResourceParser xml = application.getResources().getXml(R.xml.colors);
        
        /** Call parse method*/
        List<SimpleColorItem> simpleColorItems = parseToSimpleColorList(xml);
        colorItemListLiveData.setValue(simpleColorItems);
    }
    
    /**
     * Get SimpleColor list from xml resource
     *
     * @param xmlResourceParser XmlResourceParser
     * @return List<SimpleColor>
     */
    private List<SimpleColorItem> parseToSimpleColorList(XmlResourceParser xmlResourceParser) throws XmlPullParserException {
        List<SimpleColorItem> colorList = ColorXmlParser.parseToSimpleColorItemList(xmlResourceParser);
        Log.d(TAG, "parseToSimpleColorList: list size: " + colorList.size());
        return colorList;
    }
    
    public LiveData<List<SimpleColorItem>> getColorItemListLiveData() {
        return colorItemListLiveData;
    }
}