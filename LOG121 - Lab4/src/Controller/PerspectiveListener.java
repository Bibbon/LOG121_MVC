package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class PerspectiveListener implements ActionListener{




	// Memorise the title of a bouton
	private String bouton;

	public void actionPerformed(ActionEvent arg0) {

		//Memorise the value of the click bouton
		bouton = arg0.getActionCommand();

		if(bouton.equals("Up")){				



			//APPELLE L ACTION QUI DOIT ETRE TRAITER DANS LE MODELE
			//test
			System.out.println("Le bouton Up a ete appuyer");


		}
		else if(bouton.equals("Down")){				



			//APPELLE L ACTION QUI DOIT ETRE TRAITER DANS LE MODELE



		}
		else if(bouton.equals("Left")){				



			//APPELLE L ACTION QUI DOIT ETRE TRAITER DANS LE MODELE



		}
		else if(bouton.equals("Right")){				



			//APPELLE L ACTION QUI DOIT ETRE TRAITER DANS LE MODELE



		}
		else if(bouton.equals("Zoom In")){				



			//APPELLE L ACTION QUI DOIT ETRE TRAITER DANS LE MODELE



		}
		else if(bouton.equals("Zoom Out")){				



			//APPELLE L ACTION QUI DOIT ETRE TRAITER DANS LE MODELE



		}



	} // END actionPerformed()
}
