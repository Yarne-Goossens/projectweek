package ui.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.service.AppService;

@WebServlet("/Controller")
public class Controller extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final AppService service = new AppService();
    private final HandlerFactory handlerFactory = new HandlerFactory();

    public Controller() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String destination;
        String command = request.getParameter("command");

        if (command == null) {
            command = "Home";
        }

        RequestHandler handler = handlerFactory.getHandler(command, service);
        try {
            destination = handler.handleRequest(request, response);
        } catch (NotAuthorizedException e){
            request.setAttribute("notAuthorized","Je hebt niet voldoende rechten om deze pagina te bezoeken");
            destination = "Controller?command=Home";
        }




        if(!response.isCommitted()){
            RequestDispatcher view = request.getRequestDispatcher(destination);
            view.forward(request, response);
        }
    }

}
