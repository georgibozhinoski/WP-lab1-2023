package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Movie;
import mk.ukim.finki.wp.lab.repository.MovieRepository;
import mk.ukim.finki.wp.lab.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

final private MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
   public List<Movie> listAll(){
        return this.movieRepository.findAll();
    }

    @Override
    public List<Movie> searchMovies(String text,double rating) {
      return movieRepository.searchMovies(text,rating);
    }
}
