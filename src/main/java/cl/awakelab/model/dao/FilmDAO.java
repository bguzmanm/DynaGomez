package cl.awakelab.model.dao;

import java.util.List;

import cl.awakelab.model.entity.Film;


public interface FilmDAO {
	public void create(Film actor);
	public List<Film> read();
	public Film read(int filmId);
	public void update(Film film);
	public void delete(int filmId);

}
