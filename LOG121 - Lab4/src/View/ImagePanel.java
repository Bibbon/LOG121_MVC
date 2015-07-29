/******************************************************
Cours:   LOG121
Session: E2015
Groupe:  02
Projet: Laboratoire #4
Étudiant(e)s:	Anthony Garneau
				Simon Larouche-Gagné
              	Pierre-Luc Cusson
              
Professeur : 	Francis Cardinal
Nom du fichier: ImagePanel.java
Date créé: 2015-07-25
Date dern. modif. 2015-07-28
 *******************************************************
Historique des modifications
 *******************************************************
L'historique des modification est disponible sur github
 *******************************************************/

package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImagePanel extends JPanel implements Observer {

	private static final long serialVersionUID = 502896813583984078L;
	private ImageIcon image;
	private JLabel imageLabel;

	public ImagePanel(BufferedImage image) {
		setLayout(new BorderLayout());
		this.image = new ImageIcon(image);
		this.imageLabel = new JLabel("", this.image, JLabel.CENTER);
		add(imageLabel, BorderLayout.CENTER);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setPreferredSize(new Dimension(500, 370));

	}

	public void setImageLabel(BufferedImage image) {

	}

	@Override
	public void update(Observable arg0, Object arg1) {

		remove(imageLabel);
		this.image = new ImageIcon((BufferedImage) arg1);
		this.imageLabel = new JLabel("", this.image, JLabel.CENTER);
		add(imageLabel, BorderLayout.CENTER);
		validate();
		repaint();

	}

}
