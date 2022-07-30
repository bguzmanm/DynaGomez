package cl.awakelab.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cl.awakelab.model.cnx.Conexion;
import cl.awakelab.model.entity.Actor;

public class ActorDAOImpl implements ActorDAO {

	@Override
	public void create(Actor actor) {
		
		try {
			String sql = "insert into actor (actor_id, first_name, last_name) values (" 
					+ actor.getActorId() + ", '" + actor.getFirstName() + "', '" + actor.getLastName() + "')";
			
			Connection cnx = Conexion.getConnection();
			Statement snt = cnx.createStatement();
			snt.execute(sql);

		} catch (SQLException e) {
			System.out.println("Error al conectar con la Base de Datos");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error desconocido: ");
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Actor> read() {
		
		List<Actor> actors = new ArrayList<Actor>();
		
		try {
			String sql = "select actor_id, first_name, last_name from actor";
			
			Connection cnx = Conexion.getConnection();
			Statement snt = cnx.createStatement();
			ResultSet rs = snt.executeQuery(sql);
			
			while (rs.next()) {
				actors.add(new Actor(rs.getInt("actor_id"), rs.getString("first_name"), rs.getString("last_name")));
			}

		} catch (SQLException e) {
			System.out.println("Error al conectar con la Base de Datos");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error desconocido: ");
			e.printStackTrace();
		}
		
		
		
		return actors;
	}

	@Override
	public Actor read(int actorId) {

		Actor actor = new Actor();
		
		try {
			String sql = "select actor_id, first_name, last_name from actor where actor_id = " + actorId;
			
			Connection cnx = Conexion.getConnection();
			Statement snt = cnx.createStatement();
			ResultSet rs = snt.executeQuery(sql);
			
			if(rs.next()) {
				actor = new Actor(rs.getInt("actor_id"), rs.getString("first_name"), rs.getString("last_name"));
			}

		} catch (SQLException e) {
			System.out.println("Error al conectar con la Base de Datos");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error desconocido: ");
			e.printStackTrace();
		}
		
		return actor;
	}

	@Override
	public void update(Actor actor) {
		
		try {
			String sql = "update actor set first_name = '" + actor.getFirstName() 
			+ "', last_name = '" + actor.getLastName() + "' where actor_id = " + actor.getActorId();
			
			Connection cnx = Conexion.getConnection();
			Statement snt = cnx.createStatement();
			snt.execute(sql);

		} catch (SQLException e) {
			System.out.println("Error al conectar con la Base de Datos");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error desconocido: ");
			e.printStackTrace();
		}
	
		
	}

	@Override
	public void delete(int actorId) {

		try {
			String sql = "delete from actor where actor_id = " + actorId;
			
			Connection cnx = Conexion.getConnection();
			Statement snt = cnx.createStatement();
			snt.execute(sql);

		} catch (SQLException e) {
			System.out.println("Error al conectar con la Base de Datos");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error desconocido: ");
			e.printStackTrace();
		}
		
	}

}
