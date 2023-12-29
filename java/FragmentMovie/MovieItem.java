package androidx.constraintlayout.widget.FragmentMovie;

import java.io.Serializable;

public class MovieItem implements Serializable {
    private int movieThumbnail;
    private int moviePoster;
    private String movieTitle;
    private String sinopsis;
    private String rating;
    private String rilis;
    private String genre;
    private Integer videoPath;

    public MovieItem(int movieThumbnail, int moviePoster, String movieTitle, String sinopsis, String rating, String rilis, String genre, Integer videoPath) {
        this.movieThumbnail = movieThumbnail;
        this.moviePoster = moviePoster;
        this.movieTitle = movieTitle;
        this.sinopsis = sinopsis;
        this.rating = rating;
        this.rilis = rilis;
        this.genre = genre;
        this.videoPath = videoPath;
    }

    public int getMovieThumbnail() {

        return movieThumbnail;
    }

    public int getMoviePoster(){
        return moviePoster;
    }

    public String getMovieTitle() {

        return movieTitle;
    }

    public String getSinopsis() {

        return sinopsis;
    }

    public String getRating() {

        return rating;
    }
    public String getRilis() {

        return rilis;
    }
    public String getGenre() {

        return genre;
    }
    public int getVideoPath()
    {
        return videoPath;
    }

}

