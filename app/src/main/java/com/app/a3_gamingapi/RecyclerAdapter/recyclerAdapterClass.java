package com.app.a3_gamingapi.RecyclerAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.app.a3_gamingapi.R;
import java.util.ArrayList;
import java.util.List;

public class recyclerAdapterClass extends RecyclerView.Adapter<recyclerAdapterClass.DataViewHolder> implements Filterable {

    List<dataClass> mDataList;
    List<dataClass> mDataList2;

    public recyclerAdapterClass(List<dataClass> mDataList) {
        this.mDataList = mDataList;
        mDataList2 = new ArrayList<>(mDataList);
    }

    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout,parent,false);
        return new DataViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        //Set the position here!!!
        dataClass currentItem = mDataList.get(position);

        holder.imageView.setImageResource(R.drawable.ic_launcher_foreground);
        holder.nameTV.setText(currentItem.getNameData());
        holder.desTV.setText(currentItem.getDesData());
        holder.attackTV.setText(currentItem.getAttackData());
        holder.defenseTV.setText(currentItem.getDefenseData());
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public class DataViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView nameTV,desTV,attackTV,defenseTV;

        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView =itemView.findViewById(R.id.imageView);
            nameTV=itemView.findViewById(R.id.nameTV);
            desTV=itemView.findViewById(R.id.desTV);
            attackTV=itemView.findViewById(R.id.attackTV);
            defenseTV=itemView.findViewById(R.id.defenseTV);
        }
    }

    //Filteration Applied!!!
    @Override
    public Filter getFilter() {
        return filterList;
    }

    public Filter filterList = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<dataClass> filteredList2 = new ArrayList<>();

            if (charSequence == null || charSequence.length() == 0) {
                filteredList2.addAll(mDataList2);
            }
            else{
                String filterPattern = charSequence.toString().toLowerCase().trim();
                for(dataClass item : mDataList2)
                {
                    if(item.getNameData().toLowerCase().contains(filterPattern))
                    {
                        filteredList2.add(item);
                    }
                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList2;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            mDataList.clear();
            mDataList.addAll((List) filterResults.values);
            notifyDataSetChanged();
        }
    };
}
