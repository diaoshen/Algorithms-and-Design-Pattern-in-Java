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

public class Game extends Form{
	
	private GameWorld gw;
	
	public Game() {
		gw = GameWorld.getInstance();
		gw.init();
		play();
	}
	
	
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
						//System.out.println("A new ASTEROID has been created.");
						break;
					case 'y' :
						//TODO
						break;
					case 'b' :
						//TODO
						break;
					case 's' :
						//TODO
						break;
					case 'f' :
						//TODO
						break;
					case 'L' :
						//TODO
						break;
					case 'm' :
						//TODO
						break;
					case 'p' : //MAY 5
						//TODO
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
