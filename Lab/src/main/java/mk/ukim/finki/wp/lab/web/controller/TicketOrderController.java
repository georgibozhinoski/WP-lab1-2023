package mk.ukim.finki.wp.lab.web.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import mk.ukim.finki.wp.lab.model.TicketOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ticketOrder")
public class TicketOrderController {
    @PostMapping
    public String submitOrder(@RequestParam String selectedMovie,
                              @RequestParam int numTickets,
                              @RequestParam String name,
                              HttpServletRequest request,
                                Model model){

        model.addAttribute("selectedMovie",selectedMovie);
        model.addAttribute("numTickets",numTickets);
        model.addAttribute("name",name);
        model.addAttribute("address",request.getRemoteAddr());
        return "orderConfirmation";
    }

    @PostMapping("/editOrder")
    public String editOrder(
            @RequestParam("name") String name,
            @RequestParam("address") String address,
            @RequestParam("selectedMovie") String selectedMovie,
            @RequestParam("numTickets") int numTickets,
            Model model) {

        // You can perform additional processing or validation here if needed

        // Add the data to the model to be used in the next Thymeleaf template
        model.addAttribute("name", name);
        model.addAttribute("address", address);
        model.addAttribute("selectedMovie", selectedMovie);
        model.addAttribute("numTickets", numTickets);

        return "editOrder"; // Name of the Thymeleaf HTML file for editing
    }


}
