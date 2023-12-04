package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.ShoppingCart;
import mk.ukim.finki.wp.lab.model.TicketOrder;
import mk.ukim.finki.wp.lab.model.User;
import mk.ukim.finki.wp.lab.service.TicketOrderService;
import org.springframework.stereotype.Service;

@Service
public class TicketOrderServiceImpl implements TicketOrderService {

    @Override
    public TicketOrder placeOrder(String movieTitle, ShoppingCart shoppingCart, long numberOfTickets) {
        TicketOrder ticketOrder= new TicketOrder(movieTitle,numberOfTickets,shoppingCart);
        shoppingCart.getTicketOrders().add(ticketOrder);
        return ticketOrder;
    }
}
