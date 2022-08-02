package cl.awakelab.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.awakelab.model.entity.Actor;
import cl.awakelab.model.service.ActorService;

@WebServlet("/actor")
public class ActorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	
	private ActorService service = new ActorService();
	
    public ActorServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    	String op = request.getParameter("op");
    	String jsp = "";
    	if (op==null) {
    		op = "list";
    	}
    	switch (op) {
		case "list": {
			request.setAttribute("actors", service.listar());
			jsp = "/view/actorList.jsp";
			break;
		}
		case "new": {
			jsp = "/view/actor.jsp";
			break;
		}
		case "edit":{
			String actorId = request.getParameter("actorId");
			request.setAttribute("actor", service.listar(Integer.parseInt(actorId)));
			jsp = "/view/actor.jsp";
			break;
		}
		case "del": {
			String actorId = request.getParameter("actorId");
			service.delete(Integer.parseInt(actorId));
			request.setAttribute("actors", service.listar());
			jsp = "/view/actorList.jsp";
			break;
		}
		default:
			throw new IllegalArgumentException("Valor inesperado: " + op);
		}
    	request.setAttribute("op", op);
		getServletContext().getRequestDispatcher(jsp).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		String jsp = "/view/actorList.jsp";
		
		switch (op) {
		case "new":{
			Actor a = new Actor();
			
			a.setFirstName(request.getParameter("firstName"));
			a.setLastName(request.getParameter("lastName"));
			
			service.crear(a);
			
			break;
		}
		case "edit":
			
			Actor a = service.listar(Integer.parseInt(request.getParameter("actorId")));
			
			a.setFirstName(request.getParameter("firstName"));
			a.setLastName(request.getParameter("lastName"));
			
			service.update(a);
			
			break;
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + op);
		}
		
		request.setAttribute("op", "list");
		request.setAttribute("actors", service.listar());
		getServletContext().getRequestDispatcher(jsp).forward(request, response);
	}

}
