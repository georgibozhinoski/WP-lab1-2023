package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService
{
 List<Movie> listAll();
    List<Movie> searchMovies(String text,double rating);
    Optional<Movie> save(String title, String summary, double rating, Long production);
    void update(Long id, String title, String summary, double rating, Long productionId);
    Optional<Movie> findById(Long id);
    void deleteById(Long id);
}
