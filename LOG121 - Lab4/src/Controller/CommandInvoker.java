/******************************************************
Cours:   LOG121
Session: E2015
Groupe:  02
Projet: Laboratoire #4
Étudiant(e)s:	Anthony Garneau
				Simon Larouche-Gagné
              	Pierre-Luc Cusson
              
Professeur : 	Francis Cardinal
Nom du fichier: CommandInvoker.java
Date créé: 2015-07-25
Date dern. modif. 2015-07-28
 *******************************************************
Historique des modifications
 *******************************************************
L'historique des modification est disponible sur github
 *******************************************************/

package Controller;

import Model.Perspective;

public class CommandInvoker {

	public CommandInvoker() {

	}

	public static void zoomIn(Perspective perspective) {
		CommandManager.getInstance().storeAndExecute(
				new ZoomInCommand(perspective));
	}

	public static void zoomOut(Perspective perspective) {
		CommandManager.getInstance().storeAndExecute(
				new ZoomOutCommand(perspective));
	}

	public static void moveUp(Perspective perspective) {
		CommandManager.getInstance().storeAndExecute(
				new MoveUpCommand(perspective));
	}

	public static void moveDown(Perspective perspective) {
		CommandManager.getInstance().storeAndExecute(
				new MoveDownCommand(perspective));
	}

	public static void moveLeft(Perspective perspective) {
		CommandManager.getInstance().storeAndExecute(
				new MoveLeftCommand(perspective));
	}

	public static void moveRight(Perspective perspective) {
		CommandManager.getInstance().storeAndExecute(
				new MoveRightCommand(perspective));
	}
}
