/******************************************************
Cours:   LOG121
Session: E2015
Groupe:  02
Projet: Laboratoire #4
Étudiant(e)s:	Anthony Garneau
				Simon Larouche-Gagné
              	Pierre-Luc Cusson
              
Professeur : 	Francis Cardinal
Nom du fichier: ProjectSelector.java
Date créé: 2015-07-25
Date dern. modif. 2015-07-28
 *******************************************************
Historique des modifications
 *******************************************************
L'historique des modification est disponible sur github
 *******************************************************/

package Controller;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ProjectSelector {

	private static final String EXTENSION_TYPE = "Image Project";
	private static final String EXTENTION = "ser";

	private JFileChooser projectChooser;
	private FileNameExtensionFilter projectFilter;
	private File projectFile;

	public ProjectSelector() {
		this.projectChooser = new JFileChooser();
		this.projectFilter = new FileNameExtensionFilter(EXTENSION_TYPE,
				EXTENTION);
		// this.projectChooser.setFileFilter(projectFilter);
	}

	public JFileChooser getprojectChooser() {
		return projectChooser;
	}

	public void setprojectChooser(JFileChooser projectChooser) {
		this.projectChooser = projectChooser;
	}

	public FileNameExtensionFilter getprojectFilter() {
		return projectFilter;
	}

	public void setprojectFilter(FileNameExtensionFilter projectFilter) {
		this.projectFilter = projectFilter;
	}

	public File getprojectFile() {
		return projectFile;
	}

	public void setprojectFile(File projectFile) {
		this.projectFile = projectFile;
	}

	public void LoadProject() {

		projectChooser.showOpenDialog(null);
		this.projectFile = projectChooser.getSelectedFile();
	}

	public void SaveProject() {
		projectChooser.showSaveDialog(null);
		this.projectFile = projectChooser.getSelectedFile();
	}

}
