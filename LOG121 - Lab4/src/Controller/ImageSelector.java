package Controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ImageSelector {
	
	private static final String EXTENSION_TYPE = "Image Type";
	private static final String JPG = "JPG";
	private static final String JPEG = "JPEG";
	private static final String PNG = "PNG";
	
	private JFileChooser imageChooser;
	private FileNameExtensionFilter imageFilter;
	private File imageFile;
	
	
	public ImageSelector(){
		this.imageChooser = new JFileChooser();
		this.imageFilter = new FileNameExtensionFilter(EXTENSION_TYPE, JPG, JPEG, PNG);
		this.imageChooser.setFileFilter(imageFilter);
		SelectImage();
	}


	public JFileChooser getImageChooser() {
		return imageChooser;
	}


	public void setImageChooser(JFileChooser imageChooser) {
		this.imageChooser = imageChooser;
	}


	public FileNameExtensionFilter getImageFilter() {
		return imageFilter;
	}


	public void setImageFilter(FileNameExtensionFilter imageFilter) {
		this.imageFilter = imageFilter;
	}


	public File getImageFile() {
		return imageFile;
	}


	public void setImageFile(File imageFile) {
		this.imageFile = imageFile;
	}
	
	public void SelectImage(){
		
		imageChooser.showOpenDialog(null);
		this.imageFile = imageChooser.getSelectedFile();
	}
	
	public void SaveImage(){
		imageChooser.showSaveDialog(null);
		this.imageFile = imageChooser.getSelectedFile();
	}
	
	public BufferedImage getBufferedImage(){
		
		BufferedImage img = null;
		
		try {
			img = ImageIO.read(imageFile);		
		} 
		
		catch (IOException e) {	
			e.printStackTrace();		
		}
		
		return img;
		
	}
	
	public String getImagePath(){
		
		return imageFile.getAbsolutePath();
		
	}

}
