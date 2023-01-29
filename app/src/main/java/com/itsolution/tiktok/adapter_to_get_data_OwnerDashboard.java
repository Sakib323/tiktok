package com.itsolution.tiktok;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adapter_to_get_data_OwnerDashboard extends RecyclerView.Adapter<adapter_to_get_data_OwnerDashboard.ViewHolder> {

    Context context;
    List<com.itsolution.tiktok.model_for_owner_dash> modellist;

    public adapter_to_get_data_OwnerDashboard(Context context, List<com.itsolution.tiktok.model_for_owner_dash> modellist) {
        this.context = context;
        this.modellist = modellist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_video,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        com.itsolution.tiktok.model_for_owner_dash model_for_owner_dash_variable=modellist.get(position);
        holder.description.setText(model_for_owner_dash_variable.getDescription());
        holder.tittle.setText(model_for_owner_dash_variable.getTittle());
        //holder.videoView.setVideoURI(Uri.parse(model_for_owner_dash_variable.getVurl()));
        holder.videoView.setVideoPath(model_for_owner_dash_variable.getVurl());

        holder.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                holder.Pbar.setVisibility(View.INVISIBLE);
                holder.videoView.start();
            }
        });
        holder.videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {

                holder.videoView.start();
            }
        });


    }

    @Override
    public int getItemCount() {
        return modellist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView description,tittle;
        VideoView videoView;
        ProgressBar Pbar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            description=itemView.findViewById(R.id.des);
            tittle=itemView.findViewById(R.id.tittle);
            videoView=itemView.findViewById(R.id.videoView);
            Pbar=itemView.findViewById(R.id.progress);
        }
    }
}
