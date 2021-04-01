package com.example.tetesttask;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.tetesttask.data.SimpleColorItem;

import java.util.List;

import static com.example.tetesttask.data.SimpleColorItem.EXPANDED_ITEM;
import static com.example.tetesttask.data.SimpleColorItem.SIMPLE_ITEM;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    
    private static final String TAG = "#_VIEW_ADAPTER";
    private List<SimpleColorItem> colorList;
    private View view;
    
    public RecyclerViewAdapter() {
    }
    
    public void setItemList(List<SimpleColorItem> simpleColorList) {
        this.colorList = simpleColorList;
        notifyDataSetChanged();
    }
    
    /**
     * Depending on the viewType (simple or expanded), we fill it with a different layout
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = null;
    
        if (viewType == SIMPLE_ITEM) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.fragment_item_simple, parent, false);
            return new ViewHolder(view);
        
        } else if (viewType == EXPANDED_ITEM) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.fragment_item_expanded, parent, false);
            return new ViewHolder(view);
        }
        return null;
    }
    
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        SimpleColorItem simpleColorItem = colorList.get(position);
        
        holder.textView.setText(simpleColorItem.getColorName());
        
        if (simpleColorItem.isExpanded()) {
            /** Change drawable background color*/
            holder.layout.getBackground()
                    .setColorFilter(Color.parseColor(simpleColorItem.getColorCode()), PorterDuff.Mode.SRC_IN);
        } else {
            /** Change color of textView*/
            holder.textView.setTextColor(Color.parseColor(simpleColorItem.getColorCode()));
        }
    }
    
    /**
     * Get view type: simple/expanded
     */
    @Override
    public int getItemViewType(int position) {
        return colorList.get(position).getType();
    }
    
    @Override
    public int getItemCount() {
        if (colorList == null) return 0;
        return colorList.size();
    }
    
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        
        private static final String TAG = "#_VIEW_HOLDER";
        
        private final TextView textView;
        private final LinearLayout layout;
        
        public ViewHolder(View view) {
            super(view);
            
            textView = view.findViewById(R.id.color_name);
            layout = view.findViewById(R.id.item_container);
            view.setOnClickListener(this);
        }
        
        @Override
        public void onClick(View view) {
            int adapterPosition = getAdapterPosition();
            SimpleColorItem simpleColor = colorList.get(adapterPosition);
            
            /** Invert item state when clicked*/
            simpleColor.setExpanded(!simpleColor.isExpanded());
            notifyItemChanged(getAdapterPosition());
        }
    }
}