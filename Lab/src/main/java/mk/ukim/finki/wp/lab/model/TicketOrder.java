package mk.ukim.finki.wp.lab.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class TicketOrder {
    @Id
    @GeneratedValue
    private int id;
    private String movieTitle;
    @ManyToOne
    private  ShoppingCart shoppingCart;
   private Long numberOfTickets;



    public TicketOrder(String movieTitle, Long numberOfTickets, ShoppingCart shoppingCart) {
        this.movieTitle = movieTitle;
        this.numberOfTickets = numberOfTickets;
        this.shoppingCart=shoppingCart;
    }

    public TicketOrder() {

    }
}
