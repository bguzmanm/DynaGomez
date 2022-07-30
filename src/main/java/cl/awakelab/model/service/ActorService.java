package cl.awakelab.model.service;

import java.util.List;

import cl.awakelab.model.dao.ActorDAO;
import cl.awakelab.model.dao.ActorDAOImpl;
import cl.awakelab.model.entity.Actor;

public class ActorService {

	ActorDAO dao = new ActorDAOImpl();
	
	public List<Actor> listar(){
		return dao.read();
	}
	
	public Actor listar(int actorId) {
		return dao.read(actorId);
	}
	
	public void crear(Actor actor) {
		dao.create(actor);
	}
	
	public void update(Actor actor) {
		dao.update(actor);
	}
	public void delete(int actorId) {
		dao.delete(actorId);
	}
	
}
