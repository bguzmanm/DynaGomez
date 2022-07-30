package cl.awakelab.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.awakelab.model.service.ActorService;

@WebServlet("/actor")
public class ActorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	
	private ActorService service = new ActorService();
	
    public ActorServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("actors", service.listar());
		
		getServletContext().getRequestDispatcher("/view/actorList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
