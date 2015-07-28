package View;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ImagePanel extends JPanel {
	
	private ImageIcon image;
	private JLabel imageLabel;
	
	public ImagePanel(BufferedImage image){
		setLayout(new BorderLayout());
		this.image = new ImageIcon(image);
		this.imageLabel = new JLabel("", this.image, JLabel.CENTER);
		add(imageLabel, BorderLayout.CENTER);
		
		
	}
	
	
}
