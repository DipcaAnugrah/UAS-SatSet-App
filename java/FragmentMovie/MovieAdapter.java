package androidx.constraintlayout.widget.FragmentMovie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.satset.R;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class    MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private List<MovieItem> movieList;
    private Context context;

    public MovieAdapter(List<MovieItem> movieList) {
        this.movieList = movieList;
    }

    public interface OnItemClickListener {
        void onItemClick(int position, Integer videoPath);
    }

    private OnItemClickListener mListener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_film, parent, false);
        return new MovieViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        MovieItem movieItem = movieList.get(position);
        holder.movieThumbnail.setImageResource(movieItem.getMovieThumbnail());
        holder.movieTitle.setText(movieItem.getMovieTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                if (position != RecyclerView.NO_POSITION && mListener != null) {
                    mListener.onItemClick(position, movieList.get(position).getVideoPath());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView movieThumbnail;
        TextView movieTitle;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            movieThumbnail = itemView.findViewById(R.id.movieThumbnail);
            movieTitle = itemView.findViewById(R.id.movieTitle);
        }
    }
}
