package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Movie;
import mk.ukim.finki.wp.lab.model.Production;
import mk.ukim.finki.wp.lab.model.User;
import mk.ukim.finki.wp.lab.service.MovieService;
import mk.ukim.finki.wp.lab.service.ProductionService;
import mk.ukim.finki.wp.lab.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {
    private final ProductionService productionService;
    private final MovieService movieService;
    private final UserService userService;

    public MovieController(ProductionService productionService, MovieService movieService, UserService userService){
        this.productionService=productionService;
        this.movieService=movieService;
        this.userService = userService;
    }
    @GetMapping
    public String getMoviePage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<User> users = this.userService.listAll();
        model.addAttribute("users", users);
        List<Movie> movies = this.movieService.listAll();
        model.addAttribute("movies", movies);
        return "listMovies";
    }

    @GetMapping("/delete/{id}")
    public String deleteMovie(@PathVariable Long id) {
        this.movieService.deleteById(id);
        return "redirect:/movies";
    }

    @GetMapping("/edit-form/{id}")
    public String editMoviePage(@PathVariable Long id, Model model) {
        if (this.movieService.findById(id).isPresent()) {
            Movie movie = this.movieService.findById(id).get();
            List<Production> productions = this.productionService.listAll();
            model.addAttribute("productions", productions);
            model.addAttribute("movie", movie);
            return "add-movie";
        }
        return "redirect:/movies?error=MovieNotFound";
    }

    @GetMapping("/add-form")
    public String addMoviePage(Model model) {
        List<Production> productions = this.productionService.listAll();
        model.addAttribute("productions", productions);
        return "add-movie";
    }

    @PostMapping("/add")
    public String saveMovie(
            @RequestParam String title,
            @RequestParam String summary,
            @RequestParam double rating,
            @RequestParam Long productions,
            @RequestParam(required = false) Long id) {


        if (id != null) {
            // Editing an existing movie
            this.movieService.update(id, title, summary, rating, productions);
        } else {
            // Adding a new movie
            this.movieService.save(title, summary, rating, productions);
        }
        return "redirect:/movies";
    }
}
