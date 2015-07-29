/******************************************************
Cours:   LOG121
Session: E2015
Groupe:  02
Projet: Laboratoire #4
Étudiant(e)s:	Anthony Garneau
				Simon Larouche-Gagné
              	Pierre-Luc Cusson
              
Professeur : 	Francis Cardinal
Nom du fichier: MainPanel.java
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
import javax.swing.JPanel;

import Controller.Client.ViewListener;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = 502896813583984078L;
	private ImagePanel PerspectiveView1;
	private ImagePanel PerspectiveView2;
	private ImagePanel ThumbnailView;

	public MainPanel(BufferedImage image, ViewListener viewListener) {
		setLayout(new BorderLayout());
		this.PerspectiveView1 = new ImagePanel(image);
		this.PerspectiveView2 = new ImagePanel(image);
		PerspectiveView1.setName("P1");
		PerspectiveView2.setName("P2");
		this.ThumbnailView = new ImagePanel(image);
		PerspectiveView1.add(new ButtonPanel(viewListener), BorderLayout.NORTH);
		PerspectiveView2.add(new ButtonPanel(viewListener), BorderLayout.NORTH);
		add(PerspectiveView1, BorderLayout.LINE_START);
		add(PerspectiveView2, BorderLayout.LINE_END);
		add(ThumbnailView, BorderLayout.PAGE_START);
	}

	public ImagePanel getPerspectiveView1() {
		return PerspectiveView1;
	}

	public void setPerspectiveView1(ImagePanel perspectiveView1) {
		PerspectiveView1 = perspectiveView1;
	}

	public ImagePanel getPerspectiveView2() {
		return PerspectiveView2;
	}

	public void setPerspectiveView2(ImagePanel perspectiveView2) {
		PerspectiveView2 = perspectiveView2;
	}

	public ImagePanel getThumbnailView() {
		return ThumbnailView;
	}

	public void setThumbnailView(ImagePanel thumbnailView) {
		ThumbnailView = thumbnailView;
	}

}
