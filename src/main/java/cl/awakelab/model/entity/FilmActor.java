package cl.awakelab.model.entity;

public class FilmActor {

	private int actorId;
	private int filmId;
	private Actor actor;
	private Film film;
	public FilmActor() {
		super();
	}
	public FilmActor(int actorId, int filmId, Actor actor, Film film) {
		super();
		this.actorId = actorId;
		this.filmId = filmId;
		this.actor = actor;
		this.film = film;
	}
	public int getActorId() {
		return actorId;
	}
	public void setActorId(int actorId) {
		this.actorId = actorId;
	}
	public int getFilmId() {
		return filmId;
	}
	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}
	public Actor getActor() {
		return actor;
	}
	public void setActor(Actor actor) {
		this.actor = actor;
	}
	public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film = film;
	}
	
	
}
