package View;


import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
 

public class MainWindow extends JFrame
{
	private MainPanel mainPanel;
	MenuWindow menu;

	

	public MainWindow(BufferedImage image)
	{	
		setLayout(new BorderLayout());
		menu = new MenuWindow();
		add(menu, BorderLayout.NORTH);
		mainPanel = new MainPanel(image);
		add(mainPanel, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		
	}
	
}