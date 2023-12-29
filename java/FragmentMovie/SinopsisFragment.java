package androidx.constraintlayout.widget.FragmentMovie;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.satset.R;
import androidx.fragment.app.Fragment;

public class SinopsisFragment extends Fragment {

    private static final String ARG_MOVIE_ITEM = "movieItem";

    private MovieItem movieItem;

    private VideoView videoView;

    public SinopsisFragment() {
        // Diperlukan konstruktor kosong
    }

    public static SinopsisFragment newInstance(MovieItem movieItem) {
        SinopsisFragment fragment = new SinopsisFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_MOVIE_ITEM, movieItem);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            movieItem = (MovieItem) getArguments().getSerializable(ARG_MOVIE_ITEM);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sinopsis, container, false);

        ImageView sinopsisImageView = rootView.findViewById(R.id.sinopsisImageView);
        TextView sinopsisTitleTextView = rootView.findViewById(R.id.sinopsisTitleTextView);
        TextView sinopsisContentTextView = rootView.findViewById(R.id.sinopsisContentTextView);
        TextView sinopsisRatingTextView = rootView.findViewById(R.id.sinopsisRatingTextView);
        TextView sinopsisRilisTextView = rootView.findViewById(R.id.sinopsisRilisTextView);
        TextView sinopsisGenreTextView = rootView.findViewById(R.id.sinopsisGenreTextView);

        videoView = rootView.findViewById(R.id.videoView);
        if (movieItem != null) {
            sinopsisImageView.setImageResource(movieItem.getMoviePoster());
            sinopsisTitleTextView.setText(movieItem.getMovieTitle());
            sinopsisContentTextView.setText(movieItem.getSinopsis());
            sinopsisRatingTextView.setText(movieItem.getRating());
            sinopsisRilisTextView.setText(movieItem.getRilis());
            sinopsisGenreTextView.setText(movieItem.getGenre());
            initializeVideoView(movieItem.getVideoPath());
        }

        return rootView;
    }

    private void initializeVideoView(int rawResourceId) {
        // Dapatkan path dari res/raw
        String videoPath = "android.resource://" + requireContext().getPackageName() + "/" + rawResourceId;

        // Atur path video ke VideoView
        videoView.setVideoPath(videoPath);
        MediaController mediaController = new MediaController(requireContext());
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        // Mulai pemutaran
        videoView.start();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Hentikan pemutaran video dan lepaskan sumber daya VideoView
        videoView.stopPlayback();
    }
}
