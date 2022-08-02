package cl.awakelab.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cl.awakelab.model.cnx.Conexion;
import cl.awakelab.model.entity.Film;

public class FilmDAOImpl implements FilmDAO{

	@Override
	public void create(Film film) {

		try {			
			String sql = "insert into film ( title, description, release_year, rating, special_features)"
					+ " values ('" + film.getTitle() + "', '" + film.getDescription() + "', "
					+ film.getReleaseYear() + " , '" + film.getRating() + "', '" 
					+ film.getSpecialFeatures() + "'";
			
			Connection cnx = Conexion.getConnection();
			Statement stt = cnx.createStatement();
			
			stt.execute(sql);
			
		} catch (SQLException e) {
			System.out.println("Error al consultar la BD");
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Film> read() {
		List<Film> films = new ArrayList<>();
		
		try {
			
			String sql = "select film_id, title, description, release_year, rating, special_features "
					+ "from film";
			
			Connection cnx = Conexion.getConnection();
			Statement stt = cnx.createStatement();
			ResultSet rs = stt.executeQuery(sql);
			
			while (rs.next()) {
				films.add(new Film(rs.getInt("film_id"), 
						rs.getString("title"), 
						rs.getString("description"), 
						rs.getInt("release_year"), 
						rs.getString("rating"),
						rs.getString("special_features")));
			}
			
			
		} catch (SQLException e) {
			System.out.println("Error al consultar la BD");
			e.printStackTrace();
		}
		
		return films;
	}

	@Override
	public Film read(int filmId) {

		Film film = new Film();
		
		try {
			
			String sql = "select film_id, title, description, release_year, rating, special_features "
					+ "from film where film_id = " + filmId;
			
			Connection cnx = Conexion.getConnection();
			Statement stt = cnx.createStatement();
			ResultSet rs = stt.executeQuery(sql);
			
			if (rs.next()) {
				film = new Film(rs.getInt("film_id"), 
						rs.getString("title"), 
						rs.getString("description"), 
						rs.getInt("release_year"), 
						rs.getString("rating"),
						rs.getString("special_features"));
			}
			
			
		} catch (SQLException e) {
			System.out.println("Error al consultar la BD");
			e.printStackTrace();
		}
		
		return film;
	}

	@Override
	public void update(Film film) {

		try {			
			String sql = "update film set title = '" + film.getTitle() + "', "
					+ "description = '" + film.getDescription() + "', "
					+ "release_year = " + film.getReleaseYear() + " , "
					+ "rating = '" + film.getRating() + "', "
					+ "special_features = '" + film.getSpecialFeatures() + "' "
					+ "where film_id = " + film.getFilmId();
			
			Connection cnx = Conexion.getConnection();
			Statement stt = cnx.createStatement();
			
			stt.execute(sql);
			
		} catch (SQLException e) {
			System.out.println("Error al consultar la BD");
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void delete(int filmId) {

		try {			
			String sql = "delete from film where film_id = " + filmId;
			
			Connection cnx = Conexion.getConnection();
			Statement stt = cnx.createStatement();
			
			stt.execute(sql);
			
		} catch (SQLException e) {
			System.out.println("Error al consultar la BD");
			e.printStackTrace();
		}
		
		
		
	}

}
