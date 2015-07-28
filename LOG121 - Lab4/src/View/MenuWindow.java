package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Controller.ViewListener;

public class MenuWindow extends JMenuBar
{

	JMenu menuFile = new JMenu("File");
	JMenuItem fileOpenImage = new JMenuItem("Open Image");
	JMenuItem fileOpenProject = new JMenuItem("Open Project");
	JMenuItem fileSave = new JMenuItem("Save");
		
	JMenu menuZoom = new JMenu("Zoom");
	JMenuItem zoomIn = new JMenuItem("Zoom In");
	JMenuItem zoomOut = new JMenuItem("Zoom Out");
	
	JMenu menuAction = new JMenu("Action");
	JMenuItem actionNewThumbnail = new JMenuItem("New Thumbnail");
	JMenuItem actionUndo = new JMenuItem("Undo");
	JMenuItem actionRedo = new JMenuItem("Redo");
		

	public MenuWindow(){

		initMenu();

	}

	
	/**
	 * Initialise Menu
	 */
	private void initMenu(){

        ViewListener viewListener = new ViewListener();
		fileOpenImage.addActionListener(viewListener);
		menuFile.add(fileOpenImage);
		fileOpenProject.addActionListener(viewListener);
		menuFile.add(fileOpenProject);	
		fileSave.addActionListener(viewListener);
		menuFile.add(fileSave);
		add(menuFile);
		actionNewThumbnail.addActionListener(viewListener);
		menuAction.add(actionNewThumbnail);
		actionUndo.addActionListener(viewListener);
		menuAction.add(actionUndo);
		actionRedo.addActionListener(viewListener);
		menuAction.add(actionRedo);
		add(menuAction);

		
	}

	

}