package com.example.tetesttask;

import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tetesttask.dummy.DummyContent.DummyItem;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "#_LIST_ADAPTER";
    private final List<SimpleColor> colorList;
    //private ItemClickListener itemClickListener;

    public RecyclerViewAdapter(List<SimpleColor> simpleColorList/*, ItemClickListener itemClickListener*/) {
        this.colorList = simpleColorList;
        //this.itemClickListener = itemClickListener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.item = colorList.get(position);
        holder.colorName.setText(colorList.get(position).getColorName());
        boolean isExpanded = colorList.get(position).isExpanded();
        Log.d(TAG, "onBindViewHolder: STATE " + isExpanded);
        holder.expandedLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return colorList.size();
    }

    /**
     * OnClick interface
     */

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private static final String TAG = "#_LIST_ADAPTER";
        public LinearLayout expandedLayout;
        public final TextView colorName;

        public SimpleColor item;

        public ViewHolder(View view) {
            super(view);

            expandedLayout = view.findViewById(R.id.item_container_expandable);
            colorName = view.findViewById(R.id.color_name);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int adapterPosition = getAdapterPosition();
            SimpleColor simpleColor = colorList.get(adapterPosition);
            simpleColor.setExpanded(!simpleColor.isExpanded());
            notifyItemChanged(getAdapterPosition());

            // to fragment
            //itemClickListener.onItemClick(adapterPosition, view, simpleColor);
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }

/*    public interface ItemClickListener {

        void onItemClick(int position, View view, SimpleColor simpleColor);
    }*/
}