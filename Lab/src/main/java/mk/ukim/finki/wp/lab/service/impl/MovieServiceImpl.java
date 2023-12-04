package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Movie;
import mk.ukim.finki.wp.lab.model.Production;
import mk.ukim.finki.wp.lab.model.User;
import mk.ukim.finki.wp.lab.repository.MovieRepository;
import mk.ukim.finki.wp.lab.repository.ProductionRepository;
import mk.ukim.finki.wp.lab.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

final private MovieRepository movieRepository;
final private ProductionRepository productionRepository;

    public MovieServiceImpl(MovieRepository movieRepository, ProductionRepository productionRepository) {
        this.movieRepository = movieRepository;
        this.productionRepository=productionRepository;
    }

    @Override
   public List<Movie> listAll(){
        return this.movieRepository.findAll();
    }

    @Override
    public List<Movie> searchMovies(String text) {
      return movieRepository.searchAllMoviesByTitle(text);
    }

    @Override
    public Optional<Movie> findById(Long id) {
        return movieRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        movieRepository.deleteById(id);
    }




    @Override
    public void save(String title, String summary, double rating, Long production) {
        Production p= this.productionRepository.findById(production).orElseThrow(()->new RuntimeException("Production not found"));
        Movie m= new Movie(title,summary,rating,p);
        this.movieRepository.save(m);
    }

    @Override
    public void update(Long id, String title, String summary, double rating, Long productionId) {
        Production production = productionRepository.findById(productionId)
                .orElseThrow(() -> new RuntimeException("Production not found"));
        Movie existingMovie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        existingMovie.setTitle(title);
        existingMovie.setSummary(summary);
        existingMovie.setRating(rating);
        existingMovie.setProduction(production);

        movieRepository.save(existingMovie);

    }
}

