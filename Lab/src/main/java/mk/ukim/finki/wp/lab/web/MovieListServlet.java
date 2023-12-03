package mk.ukim.finki.wp.lab.web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.model.Movie;
import mk.ukim.finki.wp.lab.model.TicketOrder;
import mk.ukim.finki.wp.lab.service.MovieService;
import mk.ukim.finki.wp.lab.service.TicketOrderService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="movieList_servlet",urlPatterns = "")
public class MovieListServlet extends HttpServlet {
    private final MovieService movieService;
    private final SpringTemplateEngine springTemplateEngine;
    public MovieListServlet(MovieService movieService,SpringTemplateEngine springTemplateEngine) {
        this.movieService = movieService;
        this.springTemplateEngine=springTemplateEngine;
    }
    private List<TicketOrder> orders;

    @Override
    public void init() throws ServletException {
        orders = new ArrayList<>();
        getServletContext().setAttribute("orders", orders);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {


        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context =  new WebContext(webExchange);

        String searchTerm = req.getParameter("searchText");


        List<Movie> movies;
        if (searchTerm != null && !searchTerm.isEmpty()) {
            double rating=Double.parseDouble(req.getParameter("searchRating"));
            movies = movieService.searchMovies(searchTerm,rating);
        } else {
            movies = movieService.listAll();
        }


        context.setVariable("movies", movies);

        springTemplateEngine.process(
                "listMovies.html",
                context,
                resp.getWriter()
        );

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String type=req.getParameter("formType");
        if(type.equals("form1")){

            resp.sendRedirect("");

        }

        else if(type.equals("form2"))
        {
            String title=req.getParameter("movie");
            String tickets=req.getParameter("numTickets");
//            String name =req.getParameter("name");
//            String addr= req.getRemoteAddr();
            TicketOrder ticketOrder=new TicketOrder(title,Long.parseLong(tickets));
            req.getSession(true).setAttribute("ticketOrder",ticketOrder);
            orders.add(ticketOrder);

            ServletContext servletContext = getServletContext();
            servletContext.setAttribute("orders", orders);

            resp.sendRedirect("/ticketOrder");

        }


    }
}
//req.setAttribute("orders",orders);
//        RequestDispatcher rd = req.getRequestDispatcher("/users");
//        rd.forward(req,resp);