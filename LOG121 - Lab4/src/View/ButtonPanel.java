package View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicButtonListener;

import Controller.ViewListener;

public class ButtonPanel extends JPanel{
	
	private JButton ZoomIn;
	private JButton ZoomOut;
	private JButton Up;
	private JButton Down;
	private JButton Right;
	private JButton Left;
	private JPanel MovePanel;
	private ViewListener viewListener;
	
	public ButtonPanel(){
		
		this.viewListener = new ViewListener();
		this.ZoomIn = new JButton("ZoomIn");
		this.ZoomOut = new JButton("ZoomOut");
		this.Up = new JButton("Up");
		this.Down = new JButton("Down");
		this.Right = new JButton("Right");
		this.Left = new JButton("Left");
		ZoomIn.addActionListener(viewListener);
		ZoomOut.addActionListener(viewListener);
		Up.addActionListener(viewListener);
		Down.addActionListener(viewListener);
		Left.addActionListener(viewListener);
		Right.addActionListener(viewListener);
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