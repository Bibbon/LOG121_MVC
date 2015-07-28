package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CommandMenu extends JPanel{
	
	private static final int TEXT_LENGHT = 4;

	//private JPanel panelImage = new JPanel();

	/*
	 * constructor
	 */
	public CommandMenu(){
		initThumbnail();
	}
	

	private void initThumbnail() {
		add(addThumbnail());
		add(addThumbnail());
		add(addThumbnail());
	}
	
	private Component addThumbnail() {

		JPanel panelThumbnail = new JPanel();

		setBackground(Color.GREEN);
		panelThumbnail.setLayout(new BorderLayout());

		panelThumbnail.add(addThumbnailParameter(), BorderLayout.NORTH);
		ImageIcon image = new ImageIcon("image/pic1");
		JLabel imageLabel = new JLabel("", image, JLabel.CENTER);
		panelThumbnail.add(imageLabel, BorderLayout.CENTER);
		panelThumbnail.add(addThumbnailZoom(), BorderLayout.EAST);
		
		return add(panelThumbnail);

	}

	private Component addThumbnailParameter(){

		JPanel panelThumbnailParameter = new JPanel();
		
		//add initial position field
		JLabel labelPosition = new JLabel("Position (X;Y):");
		panelThumbnailParameter.add(labelPosition, BorderLayout.NORTH);
		JTextField posX = new JTextField(TEXT_LENGHT);
		panelThumbnailParameter.add(posX, BorderLayout.NORTH);
		JTextField posY = new JTextField(TEXT_LENGHT);
		panelThumbnailParameter.add(posY, BorderLayout.NORTH);

		//add width field
		JLabel labelWidth = new JLabel("Width:");
		panelThumbnailParameter.add(labelWidth, BorderLayout.NORTH);
		JTextField width = new JTextField(TEXT_LENGHT);
		panelThumbnailParameter.add(width, BorderLayout.NORTH);

		//add height field
		JLabel labelHeight = new JLabel("Height:");
		panelThumbnailParameter.add(labelHeight, BorderLayout.NORTH);
		JTextField height = new JTextField(TEXT_LENGHT);
		panelThumbnailParameter.add(height, BorderLayout.NORTH);
		
		JButton close = new JButton("X");
		panelThumbnailParameter.add(close);

		//add(panelThumbnailParameter);

		return panelThumbnailParameter;
	} 
	
	private Component addThumbnailZoom(){
		JPanel panelThumbnailZoom = new JPanel();
		
		panelThumbnailZoom.setLayout(new BoxLayout(panelThumbnailZoom ,BoxLayout.PAGE_AXIS));
		//panelThumbnailZoom.setLayout(new BorderLayout());
		
		JButton zoomIn = new JButton("+");
		panelThumbnailZoom.add(zoomIn);
		
		JButton zoomOut = new JButton("-");
		panelThumbnailZoom.add(zoomOut);
		
		return panelThumbnailZoom;
	}



	private class ListenerImage implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {

		}

	}

}
