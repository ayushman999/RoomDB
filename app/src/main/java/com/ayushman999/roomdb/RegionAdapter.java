package com.ayushman999.roomdb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class RegionAdapter extends RecyclerView.Adapter<RegionHolder> {
    ArrayList<Region> regions=new ArrayList<>();
    Context context;
    public RegionAdapter(Context context)
    {
        this.context=context;
    }

    @NonNull
    @NotNull
    @Override
    public RegionHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View myView=LayoutInflater.from(parent.getContext()).inflate(R.layout.recylerview_item,parent,false);
        RegionHolder holder=new RegionHolder(myView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RegionHolder holder, int position) {
        holder.region.setText(regions.get(position).getName());
        String array="Array:"+"\n";
        for(int i=0;i<regions.get(position).array.size();i++)
        {
            array=array+regions.get(position).array.get(i)+"\n";
        }
        holder.arrayView.setText(array);
    }

    @Override
    public int getItemCount() {
        return regions.size();
    }
    public void update(List<Region> data)
    {
        regions.clear();
        regions.addAll(data);
        notifyDataSetChanged();
    }
}
class RegionHolder extends RecyclerView.ViewHolder {
    TextView region;
    TextView arrayView;
    public RegionHolder(@NonNull @NotNull View itemView) {
        super(itemView);
        region=(TextView) itemView.findViewById(R.id.textView);
        arrayView=(TextView) itemView.findViewById(R.id.arrayView);
    }
}
