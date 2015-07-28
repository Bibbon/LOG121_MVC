package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class MainPanel extends JPanel{




	private ImagePanel PerspectiveView1;
	private ImagePanel PerspectiveView2;
	private ImagePanel ThumbnailView;
	
	/*
	 * constructor
	 */
	public MainPanel(BufferedImage image){
		setLayout(new BorderLayout());
		this.PerspectiveView1 = new ImagePanel(image);
		this.PerspectiveView2 = new ImagePanel(image);
		this.ThumbnailView = new ImagePanel(image);
		PerspectiveView1.add(new ButtonPanel(), BorderLayout.NORTH);
		PerspectiveView2.add(new ButtonPanel(), BorderLayout.NORTH);
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
