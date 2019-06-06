/*
 * Author : DIAO
 */

package com.mycompany.a1.game;

import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import java.lang.String;

//Controller Game : To capture user input and execute game functions
public class Game extends Form{
	
	private GameWorld gw;
	
	public Game() {
		gw = GameWorld.getInstance();
		gw.init();
		play();
	}
	
	
	@SuppressWarnings("rawtypes")
	private void play() {
		System.out.println("In Play");
		//TODO :  Accept and Execute User commands that operate on the game world.
		Label myLabel = new Label("Enter a Command: ");
		final TextField inputTextField = new TextField();
		
		this.addComponent(myLabel);
		this.addComponent(inputTextField);
		
		this.show();
		
		inputTextField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				String sCommand = inputTextField.getText().toString();
				inputTextField.clear();
				if(sCommand == null || sCommand.isEmpty()) return;
				switch(sCommand.charAt(0)) {
					case 'a' :
						gw.addAsteroid();
						break;
						
					case 'y' :
						gw.addNonPlayerShip();
						break;
						
					case 'b' :
						gw.addSpaceStation();
						break;
						
					case 's' :
						gw.addPlayerShip();
						break;
						
					case 'f' :
						gw.addPlayerMissile();
						break;
						
					case 'L' :
						gw.addNonPlayerMissile();
						break;
						
					case 'm' :
						System.out.println("Map:");
						gw.printMap();
						break;
						
					case 'p' : 
						System.out.println("Player Status :");
						gw.printDisplay();
						break;
						
						
						
					case '>' :
						//TODO
						break;
					case 'n' :
						//TODO
						break;
					case 'k' :
						//TODO
						break;
					case 'e' :
						//TODO
						break;
					case 'E' :
						//TODO
						break;
					case 'c' :
						//TODO
						break;
					case 'h' :
						//TODO
						break;
					case 'x' :
						//TODO
						break;
					case 'l' :
						//TODO
						break;					
				} //End Switch
			} //End ActionPerformed()	
		}); //End ActionListner()
	} //End Play()
}
