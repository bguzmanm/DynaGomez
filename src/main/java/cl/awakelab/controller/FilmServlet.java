package cl.awakelab.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.awakelab.model.entity.Actor;
import cl.awakelab.model.entity.Film;
import cl.awakelab.model.service.FilmService;

@WebServlet("/film")
public class FilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private FilmService service = new FilmService();
	
    public FilmServlet() {
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
			request.setAttribute("films", service.read());
			jsp="/view/filmList.jsp";
			break;
		} 
		case "new": {
			jsp="/view/film.jsp";
			break;
		}
		case "edit":{
			String filmId = request.getParameter("filmId");
			request.setAttribute("film", service.read(Integer.parseInt(filmId)));
			jsp = "/view/film.jsp";
			break;
		}
		case "del": {
			String filmId = request.getParameter("filmId");
			service.delete(Integer.parseInt(filmId));
			request.setAttribute("films", service.read());
			jsp = "/view/filmList.jsp";
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
		String jsp = "/view/filmList.jsp";
		
		switch (op) {
		case "new":{
			Film f = new Film();
			
			f.setTitle(request.getParameter("title"));
			f.setDescription(request.getParameter("description"));
			f.setFilmId(0);
			f.setRating(request.getParameter("rating"));
			f.setReleaseYear(Integer.parseInt(request.getParameter("releaseYear")));
			f.setSpecialFeatures(request.getParameter("specialFeatures"));			
			
			service.create(f);
			
			break;
		}
		case "edit":
			
			Film f = service.read(Integer.parseInt(request.getParameter("filmId")));
			
			f.setTitle(request.getParameter("title"));
			f.setDescription(request.getParameter("description"));
			f.setRating(request.getParameter("rating"));
			f.setReleaseYear(Integer.parseInt(request.getParameter("releaseYear")));
			f.setSpecialFeatures(request.getParameter("specialFeatures"));			
			
			service.update(f);
			
			break;
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + op);
		}
		
		request.setAttribute("op", "list");
		request.setAttribute("films", service.read());
		getServletContext().getRequestDispatcher(jsp).forward(request, response);
	}

}
