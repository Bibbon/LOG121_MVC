package View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicButtonListener;

import Controller.Client;
import Controller.Client.ViewListener;


public class ButtonPanel extends JPanel{
	
	private JButton ZoomIn;
	private JButton ZoomOut;
	private JButton Up;
	private JButton Down;
	private JButton Right;
	private JButton Left;
	private JPanel MovePanel;
	private ViewListener viewListener;
	
	public ButtonPanel(ViewListener viewListener, String perspective){
		
		this.viewListener = viewListener;
		this.ZoomIn = new JButton("ZoomIn " + perspective);
		this.ZoomOut = new JButton("ZoomOut " + perspective);
		this.Up = new JButton("Up " + perspective);
		this.Down = new JButton("Down " + perspective);
		this.Right = new JButton("Right " + perspective);
		this.Left = new JButton("Left " + perspective);
		ZoomIn.addActionListener(this.viewListener);
		ZoomOut.addActionListener(this.viewListener);
		Up.addActionListener(this.viewListener);
		Down.addActionListener(this.viewListener);
		Left.addActionListener(this.viewListener);
		Right.addActionListener(this.viewListener);
		this.MovePanel = new JPanel(new BorderLayout());
		MovePanel.add(Up,BorderLayout.NORTH);
		MovePanel.add(Down,BorderLayout.CENTER);
		MovePanel.add(Left,BorderLayout.WEST);
		MovePanel.add(Right,BorderLayout.EAST);
		add(ZoomIn);
		add(ZoomOut);
		add(MovePanel);	
		
	}

	public ViewListener getViewListener() {
		return viewListener;
	}

	public void setViewListener(ViewListener viewListener) {
		this.viewListener = viewListener;
	}

}