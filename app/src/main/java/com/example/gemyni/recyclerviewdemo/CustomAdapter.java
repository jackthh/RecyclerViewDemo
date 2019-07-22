package com.example.gemyni.recyclerviewdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {
    private List<Image> images;
    private Context context;
    private LayoutInflater layoutInflater;

    CustomAdapter(Context context, List<Image> images) {
        this.context = context;
        this.images = images;
        layoutInflater = LayoutInflater.from(this.context);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.TextView);
            imageView = itemView.findViewById(R.id.ImageView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Item duoc click la: " + textView.getText(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View tmp = layoutInflater.inflate(R.layout.item_custom_layout, viewGroup, false);
        return new CustomViewHolder(tmp);
    }

    @Override
    public void onBindViewHolder(CustomAdapter.CustomViewHolder viewHolder, int i) {
        viewHolder.textView.setText(images.get(i).getName());
        viewHolder.imageView.setImageResource(images.get(i).getId());
    }

    @Override
    public int getItemCount() {
        return this.images.size();
    }
}
