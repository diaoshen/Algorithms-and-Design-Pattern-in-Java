package edu.diao.design.factory;

public class EnemyFactory {

	public EnemyShip makeEnemyShip(int shipType) {
		
		EnemyShip newShip = null;
		
		if(shipType == 1) {
			 newShip = new UFOEnemyShip();
		}
		else if(shipType == 0) {
			 newShip = new RocketEnemyShip();
		}
		return newShip;
	}
}
