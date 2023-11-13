package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Movie;
import mk.ukim.finki.wp.lab.model.Production;
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
    public List<Movie> searchMovies(String text,double rating) {
      return movieRepository.searchMovies(text,rating);
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
    public Optional<Movie> save(String title, String summary, double rating, Long production) {
        Production p= this.productionRepository.findByID(production).orElseThrow(()->new RuntimeException("Production not found"));
        return this.movieRepository.save(title,summary,rating,p);
    }

    @Override
    public void update(Long id, String title, String summary, double rating, Long productionId) {
        Production production = productionRepository.findByID(productionId)
                .orElseThrow(() -> new RuntimeException("Production not found"));

        movieRepository.update(id, title, summary, rating, production);
    }
}

