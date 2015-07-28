package View;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ImagePanel extends JPanel implements Observer {
	
	private ImageIcon image;
	private JLabel imageLabel;
	
	public ImagePanel(BufferedImage image){
		setLayout(new BorderLayout());
		this.image = new ImageIcon(image);
		this.imageLabel = new JLabel("", this.image, JLabel.CENTER);
		add(imageLabel, BorderLayout.CENTER);
		
		
	}
	
	public void setImageLabel(BufferedImage image){
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		
		remove(imageLabel);
		this.image = new ImageIcon((BufferedImage)arg1);
		this.imageLabel = new JLabel("", this.image, JLabel.CENTER);
		add(imageLabel, BorderLayout.CENTER);
		validate();
		repaint();
		
	}
	
	
}
