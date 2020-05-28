package http.cancel;


public interface Subject {
	public void attach(Listener o);

	public void detach(Listener o);

	public void notice();
}
