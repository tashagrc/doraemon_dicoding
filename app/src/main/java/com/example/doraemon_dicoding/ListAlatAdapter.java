package com.example.doraemon_dicoding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListAlatAdapter extends RecyclerView.Adapter<ListAlatAdapter.ListViewHolder> {
    private ArrayList<Alat> listAlat;

    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public ListAlatAdapter(ArrayList<Alat> list) {
        this.listAlat = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_alat, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Alat alat = listAlat.get(position);
        Glide.with(holder.itemView.getContext()).load(alat.getImage()).apply(new RequestOptions().override(70, 70)).into(holder.imgPhoto);
        holder.tvTitle.setText(alat.getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listAlat.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listAlat.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvTitle;
        ListViewHolder(View view) {
            super(view);
            imgPhoto = view.findViewById(R.id.imageView);
            tvTitle = view.findViewById(R.id.textView);
        }
    }
}
