package View;


import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Controller.Client.ViewListener;

 

public class MainWindow extends JFrame
{
	private MainPanel mainPanel;
	private MenuWindow menu;

	

	public MainWindow(BufferedImage image, ViewListener viewListener)
	{	
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