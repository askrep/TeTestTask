package com.example.tetesttask;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static com.example.tetesttask.SimpleColorItem.EXPANDED_ITEM;
import static com.example.tetesttask.SimpleColorItem.SIMPLE_ITEM;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "#_LIST_ADAPTER";
    private final List<SimpleColorItem> colorList;
    private View view;

    public RecyclerViewAdapter(List<SimpleColorItem> simpleColorList) {
        this.colorList = simpleColorList;
    }

    /**
     * Depending on the viewType (simple or expanding), we fill it with a different layout
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
    public int getItemViewType(int position) {
        return colorList.get(position).getType();
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.item = colorList.get(position);
        String colorName = colorList.get(position).getColorName();
        String colorCode = colorList.get(position).getColorCode();
        String colorCodeDefault = colorList.get(position).getColorCodeDefault();

        holder.colorName.setText(colorName);
        if (holder.item.isExpanded()) {
            /** Change drawable background color*/
            view.getBackground().setColorFilter(Color.parseColor(colorCode), PorterDuff.Mode.SRC_ATOP);
        }
    }

    @Override
    public int getItemCount() {
        return colorList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private static final String TAG = "#_VIEW_HOLDER";
        private TextView color_name;
        public View itemView;
        public final TextView colorName;

        public SimpleColorItem item;

        public ViewHolder(View view) {
            super(view);
            this.itemView = view;

            colorName = (TextView) view.findViewById(R.id.color_name);


            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int adapterPosition = getAdapterPosition();
            SimpleColorItem simpleColor = colorList.get(adapterPosition);
            //TODO Change text color
/** Change state when clicked*/
            simpleColor.setExpanded(!simpleColor.isExpanded());

            notifyItemChanged(getAdapterPosition());

        }

        @Override
        public String toString() {
            return super.toString();
        }
    }

}