package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.ShoppingCart;
import mk.ukim.finki.wp.lab.model.TicketOrder;
import mk.ukim.finki.wp.lab.model.User;

public interface TicketOrderService {
    TicketOrder placeOrder(String movieTitle, ShoppingCart shoppingCart, long numberOfTickets);
}
