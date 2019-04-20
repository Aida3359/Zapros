package com.example.zapros;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MoAdapter extends RecyclerView.Adapter<MoAdapter.MoViewHolder> {

    private Context context;
    private ArrayList<Mo> mos;

    public MoAdapter(Context context,ArrayList<Mo>mos){

        this.context  = context;
        this.mos = mos;
    }

    @NonNull
    @Override
    public MoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item,
                viewGroup,false);

        return new MoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoViewHolder moViewHolder, int i) {

        Mo currentMo = mos.get(i);

        String title = currentMo.getTitle();
        String id = currentMo.getId();
        String image = currentMo.getImage();

        moViewHolder.title.setText(title);
        moViewHolder.id.setText(id);
        Picasso.get().load(image).fit().centerInside().into(moViewHolder.image);
    }

    @Override
    public int getItemCount() {
        return mos.size();
    }


    public class MoViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView id;
        TextView title;
        public MoViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            id = itemView.findViewById(R.id.id);
            title = itemView.findViewById(R.id.title);

        }
    }
}
