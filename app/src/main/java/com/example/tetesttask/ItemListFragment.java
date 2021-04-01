package com.example.tetesttask;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.xmlpull.v1.XmlPullParserException;

import java.util.List;

public class ItemListFragment extends Fragment /*implements RecyclerViewAdapter.ItemClickListener*/ {

    private static final String TAG = "#_LIST_FRAGMENT";
    public static final int VERTICAL = 1;

    public MainViewModel mainViewModel;
    private List<SimpleColorItem> simpleColorList;

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

// Call parse method
        XmlResourceParser xml = getResources().getXml(R.xml.colors);
        try {
            simpleColorList = mainViewModel.getSimpleColorList(xml);
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        RecyclerView recyclerView = null;
        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;

            recyclerView.setLayoutManager(new LinearLayoutManager(context));

            RecyclerViewAdapter adapter = new RecyclerViewAdapter(simpleColorList);
            recyclerView.setAdapter(adapter);
        }
        DividerItemDecoration decoration = new DividerItemDecoration(getContext(), VERTICAL);
        recyclerView.addItemDecoration(decoration);

        return view;
    }

}