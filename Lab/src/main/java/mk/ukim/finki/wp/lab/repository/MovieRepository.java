package mk.ukim.finki.wp.lab.repository;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import mk.ukim.finki.wp.lab.model.Movie;
import mk.ukim.finki.wp.lab.model.Production;
import org.hibernate.sql.Insert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Component
public interface MovieRepository extends JpaRepository<Movie,Long> {
 List<Movie> searchAllMoviesByTitle(String name);
 Movie save(Movie movie);




//    public List<Movie> movies;
//    public MovieRepository(ProductionRepository productionRepository) {
//        movies = new ArrayList<>();
//        movies.add(new Movie("The Shawshank Redemption", "Drama",  9.3,productionRepository.findAll().get(0)));
//        movies.add(new Movie("The Godfather: Part II", "Crime",  9.0,productionRepository.findAll().get(1)));
//        movies.add(new Movie("Avengers: End Game", "Sci-fi",  9.9,productionRepository.findAll().get(2)));
//        movies.add(new Movie("SuperMan", "Hero",  8.9, productionRepository.findAll().get(3)));
//        movies.add(new Movie("Spider-Man", "Hero",  10.0, productionRepository.findAll().get(4)));
//
//    }
//
//    public List<Movie> findAll()
//    {
//        return movies;
//    }
//
//    public List<Movie> searchMovies(String text,double rating)
//    {
//            List<Movie> movieList;
//           movieList= movies.stream().filter(movie -> (movie.getTitle().contains(text) || movie.getSummary().contains(text)) && movie.getRating()>=rating).toList();
//
//            return movieList;
//    }
//    public Optional<Movie> findById(Long id) {
//        return movies.stream()
//                .filter(movie -> movie.getId().equals(id)).findFirst();
//    }
//    public void deleteById(Long id) {
//        movies.removeIf(movie -> movie.getId().equals(id));
//    }
//
//    public Optional<Movie> save(String title, String summary, double rating, Production production) {
//        if( production==null)
//            throw new RuntimeException("Production not found");
//        Movie movie = new Movie(title,summary,rating,production);
//        movies.add(movie);
//        return Optional.of(movie);
//    }
//    public void update(Long id, String title, String summary, double rating, Production production) {
//        Optional<Movie> optionalMovie = findById(id);
//        if (optionalMovie.isPresent()) {
//            Movie movie = optionalMovie.get();
//            movie.setTitle(title);
//            movie.setSummary(summary);
//            movie.setRating(rating);
//            movie.setProduction(production);
//        } else {
//            throw new RuntimeException("Movie not found with id: " + id);
//        }
//    }
}
