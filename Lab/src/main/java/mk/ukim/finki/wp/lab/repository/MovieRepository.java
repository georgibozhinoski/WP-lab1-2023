package mk.ukim.finki.wp.lab.repository;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Movie;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
@Component
public class MovieRepository {
    public static List<Movie> movies;
@PostConstruct
    public void init() {
    movies=new ArrayList<>();
        movies.add(new Movie("Movie1", "summary1", 1));
        movies.add(new Movie("Movie2", "summary2", 2));
        movies.add(new Movie("Movie3", "summary3", 3));
        movies.add(new Movie("Movie4", "summary4", 4));
        movies.add(new Movie("Movie5", "summary5", 5));
        movies.add(new Movie("Movie6", "summary6", 6));
        movies.add(new Movie("Movie7", "summary7", 7));
        movies.add(new Movie("Movie8", "summary8", 8));
        movies.add(new Movie("Movie9", "summary9", 9));
        movies.add(new Movie("Movie10", "summary10", 10));
    }

    public List<Movie> findAll()
    {
        return movies;
    }

    public List<Movie> searchMovies(String text,double rating)
    {
            List<Movie> movieList;
           movieList= movies.stream().filter(movie -> (movie.getTitle().contains(text) || movie.getSummary().contains(text)) && movie.getRating()>=rating).toList();

            return movieList;
    }
}
