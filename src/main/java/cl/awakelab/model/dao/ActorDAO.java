package cl.awakelab.model.dao;

import java.util.List;

import cl.awakelab.model.entity.Actor;

/**
 * C -> create 	| crear 
 * R -> read 	| leer 
 * U -> update	| actualizar
 * D -> delete 	| borrar
 */

public interface ActorDAO {

	public void create(Actor actor);
	public List<Actor> read();
	public Actor read(int actorId);
	public void update(Actor actor);
	public void delete(int actorId);
	
}
