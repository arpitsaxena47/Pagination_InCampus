package com.arpit.paginationincampus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PaginationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private boolean isLoadingAdded = false;
    private static final int ITEM = 0;
    private static final int LOADING = 1;
    private Context context;
    private List<Songs> songsList;

    public PaginationAdapter(Context context) {
        this.context = context;
        songsList = new ArrayList<>();
    }
    public List<Songs> getMovies() {
        return songsList;
    }
    public void setMovies(List<Songs> songsList) {
        this.songsList = songsList;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case ITEM:
                viewHolder = getViewHolder(parent, inflater);
                break;
            case LOADING:
                View v2 = inflater.inflate(R.layout.item_songs, parent, false);
                viewHolder = new LoadingVH(v2);
                break;
        }
        return viewHolder;
    }
    @NonNull
    private RecyclerView.ViewHolder getViewHolder(ViewGroup parent, LayoutInflater inflater) {
        RecyclerView.ViewHolder viewHolder;
        View v1 = inflater.inflate(R.layout.item_songs, parent, false);
        viewHolder = new SongsVH(v1);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Songs song = songsList.get(position);

        switch (getItemViewType(position)) {
            case ITEM:
                SongsVH songsVH = (SongsVH) holder;

                songsVH.songsName.setText(song.getSongName());
                songsVH.singerName.setText(song.getSinger());
                break;
            case LOADING:
//                Do nothing
                break;
        }
    }

    @Override
    public int getItemCount() {
        return songsList.size();
    }
    @Override
    public int getItemViewType(int position) {
        return (position == songsList.size() - 1 && isLoadingAdded) ? LOADING : ITEM;
    }
    public void add(Songs s) {
        songsList.add(s);
        notifyItemInserted(songsList.size() - 1);
    }
    public void addAll(List<Songs> songList) {
        for (Songs s: songList) {
            songsList.add(s);
        }
    }
    public void addLoadingFooter() {
        isLoadingAdded = true;
        add(new Songs());
    }

    public void removeLoadingFooter() {
        isLoadingAdded = false;

        int position =songsList.size() - 1;
       Songs item = getItem(position);
        if (item != null) {
           songsList.remove(position);
            notifyItemRemoved(position);
        }
    }
    public Songs getItem(int position) {
        return songsList.get(position);
    }

    protected class SongsVH extends RecyclerView.ViewHolder {
        private TextView songsName;
        private TextView singerName;

        public SongsVH(View itemView) {
            super(itemView);

            songsName = (TextView) itemView.findViewById(R.id.txtSongName);
            singerName = (TextView) itemView.findViewById(R.id.txtSinger);
        }
    }


    protected class LoadingVH extends RecyclerView.ViewHolder {

        public LoadingVH(View itemView) {
            super(itemView);
        }
    }

}
