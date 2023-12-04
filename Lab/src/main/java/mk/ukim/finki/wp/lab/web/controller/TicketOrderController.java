package mk.ukim.finki.wp.lab.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import mk.ukim.finki.wp.lab.model.User;
import mk.ukim.finki.wp.lab.service.UserService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/ticketOrder")
public class TicketOrderController {
    private UserService userService;

    public TicketOrderController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public String submitOrder(@RequestParam String selectedMovie,
                              @RequestParam int numTickets,
                              @RequestParam User name,
                              @RequestParam("dateCreation") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime dateCreation,
                              HttpServletRequest request,
                                Model model){

        model.addAttribute("selectedMovie",selectedMovie);
        model.addAttribute("numTickets",numTickets);
        model.addAttribute("name",name);
        model.addAttribute("address",request.getRemoteAddr());
        model.addAttribute("dateCreation", dateCreation);
        return "orderConfirmation";
    }

    @PostMapping("/editOrder")
    public String editOrder(
            //@RequestParam("name") Long userId,
            @RequestParam("address") String address,
            @RequestParam("selectedMovie") String selectedMovie,
            @RequestParam("numTickets") int numTickets,
            @RequestParam("dateCreation") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime dateCreation,
            Model model) {
        List<User> users = this.userService.listAll();
        model.addAttribute("users", users);

        //User selectedUser = userService.findById(userId);

       // model.addAttribute("name", selectedUser);
        model.addAttribute("address", address);
        model.addAttribute("selectedMovie", selectedMovie);
        model.addAttribute("numTickets", numTickets);
        model.addAttribute("dateCreation", dateCreation);

        return "editOrder"; // Name of the Thymeleaf HTML file for editing
    }


}
