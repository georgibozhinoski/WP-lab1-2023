package mk.ukim.finki.wp.lab.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Movie {
    @Id
    @GeneratedValue
    private Long id;
    String title;
    String summary;
    double rating;
    @ManyToOne
    private Production production;


    public Movie(String title, String summary, double rating, Production production) {
        this.id=(long) (Math.random()*1000);
        this.title = title;
        this.summary = summary;
        this.rating = rating;
        this.production=production;
    }

    public Movie() {

    }
}
