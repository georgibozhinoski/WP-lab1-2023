//package mk.ukim.finki.wp.lab.web;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//import mk.ukim.finki.wp.lab.model.TicketOrder;
//import mk.ukim.finki.wp.lab.service.TicketOrderService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//import java.util.AbstractMap;
//import java.util.Arrays;
//import java.util.Objects;
//
//import static java.util.Arrays.asList;
//
//@WebServlet(name="ticket-order-servlet", urlPatterns ="/ticketOrder")
//public class TicketOrderServlet extends HttpServlet {
//
//    private final SpringTemplateEngine springTemplateEngine;
//
//    public TicketOrderServlet(TicketOrderService ticketOrderService, SpringTemplateEngine springTemplateEngine) {
//        this.springTemplateEngine = springTemplateEngine;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        HttpSession session= req.getSession();
//        TicketOrder order=(TicketOrder) session.getAttribute("ticketOrder");
//
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(req, resp);
//
//        WebContext context =  new WebContext(webExchange);
//        context.setVariable("ipAddress",order.getClientAddress() );
//        context.setVariable("movieTitle",order.getMovieTitle());
//        context.setVariable("tickets", order.getNumberOfTickets());
//        context.setVariable("name",order.getClientName());
//
//
//        springTemplateEngine.process(
//                "orderConfirmation.html",
//                context,
//                resp.getWriter()
//        );
//    }
//}
