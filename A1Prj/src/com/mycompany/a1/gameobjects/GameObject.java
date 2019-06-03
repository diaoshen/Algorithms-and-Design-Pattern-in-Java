package com.mycompany.a1.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Point2D;

public abstract class GameObject {

	private Point2D coord;
	private ColorUtil color;
	
	public GameObject(int locationX , int locationY , ColorUtil color) {
		coord = new Point2D(locationX , locationY);
	}
	
	public double getX() { return coord.getX(); }
	public double getY() { return coord.getY(); }		
	public void setX(double x) { coord.setX(x); }
	public void setY(double y) { coord.setY(y); }
	public int getColor() { return color.GRAY; } //Change later
//	public void setColor(int color) { this.color.r
	public void setLocation(double x , double y) { 
		this.coord.setX(x);
		this.coord.setY(y);
	}
	
	
	
}
