package mk.ukim.finki.wp.lab.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class TicketOrder {
    @Id
    @GeneratedValue
    private int id;
    private String movieTitle;

   private Long numberOfTickets;

    public TicketOrder(String movieTitle, Long numberOfTickets) {
        this.movieTitle = movieTitle;

        this.numberOfTickets = numberOfTickets;
    }

    public TicketOrder() {

    }
}
