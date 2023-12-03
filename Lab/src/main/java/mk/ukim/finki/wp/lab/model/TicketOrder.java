package mk.ukim.finki.wp.lab.model;

import lombok.Data;

@Data
public class TicketOrder {
    String movieTitle;

    Long numberOfTickets;

    public TicketOrder(String movieTitle, Long numberOfTickets) {
        this.movieTitle = movieTitle;

        this.numberOfTickets = numberOfTickets;
    }
}
