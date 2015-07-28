package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ThumbnailListener implements ActionListener{




	// Memorise the title of a bouton
	private String bouton;

	public void actionPerformed(ActionEvent arg0) {

		//Memorise the value of the click bouton
		bouton = arg0.getActionCommand();

		if(bouton.equals("posX")){				



			//APPELLE L ACTION QUI DOIT ETRE TRAITER DANS LE MODELE



		}
		else if(bouton.equals("posY")){				



			//APPELLE L ACTION QUI DOIT ETRE TRAITER DANS LE MODELE



		}
		else if(bouton.equals("zoomRatio")){				



			//APPELLE L ACTION QUI DOIT ETRE TRAITER DANS LE MODELE



		}
		else if(bouton.equals("zoomIn")){				



			//APPELLE L ACTION QUI DOIT ETRE TRAITER DANS LE MODELE



		}
		else if(bouton.equals("zoomOut")){				



			//APPELLE L ACTION QUI DOIT ETRE TRAITER DANS LE MODELE



		}



	} // END actionPerformed()
}
