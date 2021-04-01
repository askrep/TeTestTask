package com.example.tetesttask;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.xmlpull.v1.XmlPullParserException;

import java.util.List;

public class ItemListFragment extends Fragment /*implements RecyclerViewAdapter.ItemClickListener*/ {

    private static final String TAG = "#_LIST_FRAGMENT";
    public MainViewModel mainViewModel;
    private List<SimpleColor> simpleColorList;
    private String isClickedColorName = "";
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;

    public ItemListFragment() {
    }

    @SuppressWarnings("unused")
    public static ItemListFragment newInstance() {
        ItemListFragment fragment = new ItemListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        XmlResourceParser xml = getResources().getXml(R.xml.colors);
        try {
            simpleColorList = mainViewModel.getSimpleColorList(xml);
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;

            recyclerView.setLayoutManager(new LinearLayoutManager(context));

            adapter = new RecyclerViewAdapter(simpleColorList);
            recyclerView.setAdapter(adapter);
        }
        return view;
    }



    private void onFirstClickConfig(View view, int color) {
        view.setBackgroundColor(color);
        //view.getLayoutParams().height = getResources().getDimensionPixelSize(R.dimen.item_height_expanded);

    }

    private void onSecondClickConfig(View view, int color) {
        view.setBackgroundColor(getResources().getColor(R.color.purple_500));
        //view.getLayoutParams().height = getResources().getDimensionPixelSize(R.dimen.item_height_default);

    }
}