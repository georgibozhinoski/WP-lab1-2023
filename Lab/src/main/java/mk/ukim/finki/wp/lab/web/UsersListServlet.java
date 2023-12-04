//package mk.ukim.finki.wp.lab.web;
//
//import jakarta.servlet.ServletContext;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.ukim.finki.wp.lab.model.Movie;
//import mk.ukim.finki.wp.lab.model.TicketOrder;
//import mk.ukim.finki.wp.lab.service.MovieService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//@WebServlet(name="users-servlet",urlPatterns = "/users")
//public class UsersListServlet extends HttpServlet {
//
//    private final SpringTemplateEngine springTemplateEngine;
//    public UsersListServlet(SpringTemplateEngine springTemplateEngine) {
//
//        this.springTemplateEngine=springTemplateEngine;
//    }
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(req, resp);
//
//        WebContext context =  new WebContext(webExchange);
//        ServletContext servletContext = getServletContext();
//        List<TicketOrder> ticketOrderList=(List<TicketOrder>)servletContext.getAttribute("orders");
//        context.setVariable("orders",ticketOrderList);
//
//
//
//
//
//        springTemplateEngine.process(
//                "usersList.html",
//                context,
//                resp.getWriter()
//        );
//    }
//
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String usernameToSearch = req.getParameter("username");
//
//        List<Movie> moviesByUser= new ArrayList<>();
//
//
//
//    }
//}
