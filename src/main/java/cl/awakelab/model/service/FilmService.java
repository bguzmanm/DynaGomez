package cl.awakelab.model.service;

import java.util.List;

import cl.awakelab.model.dao.FilmDAO;
import cl.awakelab.model.dao.FilmDAOImpl;
import cl.awakelab.model.entity.Film;

public class FilmService {

	FilmDAO dao = new FilmDAOImpl();

	public List<Film> read(){
		return dao.read();
	}
	public Film read(int filmId){
		return dao.read(filmId);
	}
	public void create(Film film){
		dao.create(film);
	}
	
	public void delete(int filmId) {
		dao.delete(filmId);
	}

}
