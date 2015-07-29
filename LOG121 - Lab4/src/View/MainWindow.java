/******************************************************
Cours:   LOG121
Session: E2015
Groupe:  02
Projet: Laboratoire #4
Étudiant(e)s:	Anthony Garneau
				Simon Larouche-Gagné
              	Pierre-Luc Cusson
              
Professeur : 	Francis Cardinal
Nom du fichier: MainWindow.java
Date créé: 2015-07-25
Date dern. modif. 2015-07-28
 *******************************************************
Historique des modifications
 *******************************************************
L'historique des modification est disponible sur github
 *******************************************************/

package View;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import Controller.Client.ViewListener;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 502896813583984078L;
	private MainPanel mainPanel;
	private MenuWindow menu;

	public MainWindow(BufferedImage image, ViewListener viewListener) {
		setLayout(new BorderLayout());
		menu = new MenuWindow(viewListener);
		add(menu, BorderLayout.NORTH);
		mainPanel = new MainPanel(image, viewListener);
		add(mainPanel, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);

	}

	public MainPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	public MenuWindow getMenu() {
		return menu;
	}

	public void setMenu(MenuWindow menu) {
		this.menu = menu;
	}

}