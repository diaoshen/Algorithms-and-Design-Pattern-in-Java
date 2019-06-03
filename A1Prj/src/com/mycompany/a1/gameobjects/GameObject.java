package com.mycompany.a1.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Point2D;

public abstract class GameObject {

	private Point2D coord;
	private ColorUtil color;
	
	public GameObject(int locationX , int locationY) {
		coord = new Point2D(locationX , locationY);
	}
	
	public double getX() { return coord.getX(); }
	public double getY() { return coord.getY(); }		
	public void setX(double x) { coord.setX(x); }
	public void setY(double y) { coord.setY(y); }
	
	
	
}
