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