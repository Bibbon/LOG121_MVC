/******************************************************
Cours:   LOG121
Session: E2015
Groupe:  02
Projet: Laboratoire #4
�tudiant(e)s:	Anthony Garneau
				Simon Larouche-Gagn�
              	Pierre-Luc Cusson
              
Professeur : 	Francis Cardinal
Nom du fichier: ViewCommand.java
Date cr��: 2015-07-25
Date dern. modif. 2015-07-28
 *******************************************************
Historique des modifications
 *******************************************************
L'historique des modification est disponible sur github
 *******************************************************/

package Controller;

public interface ViewCommand {

	public void execute();

	public void undo();

	public void redo();

}
