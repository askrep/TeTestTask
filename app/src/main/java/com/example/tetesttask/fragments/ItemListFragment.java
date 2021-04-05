package com.example.tetesttask.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tetesttask.MainViewModel;
import com.example.tetesttask.R;
import com.example.tetesttask.RecyclerViewAdapter;
import com.example.tetesttask.data.SimpleColorItem;

import java.util.List;

public class ItemListFragment extends Fragment {
    
    private static final String TAG = "#_LIST_FRAGMENT";
    public static final int VERTICAL = 1;
    
    public MainViewModel mainViewModel;
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
        mainViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication())
                .create(MainViewModel.class);
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);
        RecyclerView recyclerView = null;
        
        /** Init RecyclerView*/
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            adapter = new RecyclerViewAdapter();
    
            List<SimpleColorItem> colorItemList = mainViewModel.getColorItemListLiveData().getValue();
    
            /** put data list to adapter*/
            adapter.setItemList(colorItemList);
            recyclerView.setAdapter(adapter);
        }
        
        DividerItemDecoration decoration = new DividerItemDecoration(getContext(), VERTICAL);
        recyclerView.addItemDecoration(decoration);
        
        return view;
    }
    
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        
        /** Add LiveData observer for color list*/
        mainViewModel.getColorItemListLiveData().observe(getViewLifecycleOwner(), colorItemList -> {
            adapter.setItemList(colorItemList);
        });
    }
}