package com.example.midpaper;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapterInspired extends RecyclerView.Adapter<CustomAdapterInspired.ViewHolder> {
    Context context;
    ArrayList<Modal> arr1;
    private SelectedListener listener;

    public CustomAdapterInspired(Context context, ArrayList<Modal> arr1, SelectedListener listener) {
        this.context = context;
        this.arr1= arr1;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.city, null);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.img.setImageResource(arr1.get(position).getImage());
        holder.txt.setText(arr1.get(position).getName());
        holder.txt1.setText(arr1.get(position).getName1());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClicked(arr1.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return arr1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txt;
        TextView txt1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            txt = itemView.findViewById(R.id.txt);
            txt1 = itemView.findViewById(R.id.txt1);
        }
    }
}