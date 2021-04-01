package com.example.tetesttask;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

//TODO FIX mixing colors regardless of position, incorrect background color change when clicked
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        SimpleColorItem simpleColorItem = colorList.get(position);

        holder.colorNameTextView.setText(simpleColorItem.getColorName());

        if (simpleColorItem.isExpanded()) {
            /** Change drawable background color*/

            Log.d(TAG, "onBindViewHolder: Extended position: " + position + "; color: " + simpleColorItem.getColorName());
            view.getBackground().setColorFilter(Color.parseColor(simpleColorItem.getColorCode()), PorterDuff.Mode.SRC_ATOP);

        } else {
            /** Change color of colorName*/
            Log.d(TAG, "onBindViewHolder: Simple position " + position + "; color: " + simpleColorItem.getColorName());
            holder.colorNameTextView.setTextColor(Color.parseColor(simpleColorItem.getColorCode()));
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

        //private final SimpleColorItem simpleColorItem;
        private final TextView colorNameTextView;
        private final int itemPosition;


        public ViewHolder(View view) {
            super(view);
            itemPosition = getAdapterPosition();
            colorNameTextView = view.findViewById(R.id.color_name);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int adapterPosition = getAdapterPosition();
            SimpleColorItem simpleColor = colorList.get(adapterPosition);

            Log.d(TAG, "ViewHolder: adapter Position " + getAdapterPosition() + "; itemPosition: " + itemPosition);

            /** Change item state when clicked*/
            simpleColor.setExpanded(!simpleColor.isExpanded());
            notifyItemChanged(getAdapterPosition());
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}