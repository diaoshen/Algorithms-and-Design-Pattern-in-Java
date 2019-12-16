package edu.diao.design.observer;

public interface Subject {
	public void registerListener(Listener o);
	public void unregisterListrner(Listener o);
	public void notifyListeners();
}
