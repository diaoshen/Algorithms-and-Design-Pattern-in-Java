package edu.diao.design.factory;

import java.util.Random;

public class EnemyDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Randomly generate an EnemyShip
		Random rand = new Random();
		int shipType = rand.nextInt(2); // Randomly select an enemy blueprint from factory
		
		EnemyFactory factory = new EnemyFactory(); //Create factory

		EnemyShip enemy = factory.makeEnemyShip(shipType); 
		if(enemy != null) {
			doStuff(enemy);
		}

	}
	
	public static void doStuff(EnemyShip anEnemyShip) {
		anEnemyShip.displayEnemy();
		anEnemyShip.followHeroShip();
		anEnemyShip.enemyShipShoots();
	}
}
