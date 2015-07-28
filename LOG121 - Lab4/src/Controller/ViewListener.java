package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Observable;

public class ViewListener implements ActionListener  {

	// Memorise the title of a bouton
	private String bouton;
	private BufferedImage image;


	public void actionPerformed(ActionEvent arg0) {

		//Memorise the value of the click bouton
		bouton = arg0.getActionCommand();

		if(bouton.equals("Open Image")){
			
			ImageSelector IS = new ImageSelector();
			this.image = IS.getBufferedImage();



			//APPELLE L ACTION QUI DOIT ETRE TRAITER DANS LE MODELE



		}
		else if(bouton.equals("Open Project")){				


            System.out.println("OP");
			//APPELLE L ACTION QUI DOIT ETRE TRAITER DANS LE MODELE



		}
		else if(bouton.equals("Save")){	
			
			System.out.println("Save");



			//APPELLE L ACTION QUI DOIT ETRE TRAITER DANS LE MODELE



		}
		else if(bouton.equals("ZoomIn")){
			
			System.out.println("Zoom in");



			//APPELLE L ACTION QUI DOIT ETRE TRAITER DANS LE MODELE



		}
		else if(bouton.equals("ZoomOut")){	
			
			System.out.println("Zoom out");
			CommandManager.getInstance().zoomIn(perspective);



			//APPELLE L ACTION QUI DOIT ETRE TRAITER DANS LE MODELE



		}
		else if(bouton.equals("New Thumbnail")){
			
			System.out.println("new thumb");



			//APPELLE L ACTION QUI DOIT ETRE TRAITER DANS LE MODELE



		}
		else if(bouton.equals("Undo")){		
			
			System.out.println("Undo");



			//APPELLE L ACTION QUI DOIT ETRE TRAITER DANS LE MODELE



		}
		else if(bouton.equals("Redo")){			
			
			System.out.println("Redo");



			//APPELLE L ACTION QUI DOIT ETRE TRAITER DANS LE MODELE



		}
		else if(bouton.equals("Up")){			
			
			System.out.println("Up");



			//APPELLE L ACTION QUI DOIT ETRE TRAITER DANS LE MODELE



		}
		else if(bouton.equals("Down")){			
			
			System.out.println("Down");



			//APPELLE L ACTION QUI DOIT ETRE TRAITER DANS LE MODELE



		}
		else if(bouton.equals("Right")){			
			
			System.out.println("right");



			//APPELLE L ACTION QUI DOIT ETRE TRAITER DANS LE MODELE



		}
		else if(bouton.equals("Left")){			
			
			System.out.println("left");



			//APPELLE L ACTION QUI DOIT ETRE TRAITER DANS LE MODELE



		}
		
		


	} // END actionPerformed()
}
