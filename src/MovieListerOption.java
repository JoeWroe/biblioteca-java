/**
 * Created by joe on 16/01/2017.
 */
public class MovieListerOption implements Option {
    private String name;
    private MovieLister movieLister;

    public MovieListerOption(String name, MovieLister movieLister) {
        this.name = name;
        this.movieLister = movieLister;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void run() {
        movieLister.listAllMovies();
    }
}
