package edu.diao.design.observer;

import java.util.ArrayList;
import java.util.Iterator;

//Uses listeners to update GPS (x,y) position
public class GPS implements Subject{
	
	int x = 0;
	int y = 0;
	ArrayList<Listener> listenerList;
	
	public GPS() {
		listenerList = new ArrayList<Listener>();
	}
	
	@Override
	public void registerListener(Listener o) { //Uses Listener object , so again doesn't care what kind of listener.
		// TODO Auto-generated method stub
		listenerList.add(o);
	}

	@Override
	public void unregisterListrner(Listener o) {
		// TODO Auto-generated method stub
		listenerList.remove(listenerList.indexOf(o));
	}

	@Override 
	public void notifyListeners() { //listenerList contains the type Listener , so doesn't matter what care of listener
		// TODO Auto-generated method stub
		for(Iterator<Listener> it = listenerList.iterator() ; it.hasNext() ; ) {
			Listener o = it.next();
			o.update(x, y);
		}
	}
	
	public void changePosition(int x , int y) {
		this.x = x;
		this.y = y;
		
		notifyListeners();
	}

	
	
}
