package Controller;

import java.util.*;

public class CommandManager {

	// Instance unique du gestionnaire de commande
	private static CommandManager instance;
	//Pile des commandes effectu�es
	private List<ViewCommand> commandStack;
	//Pile des commandes annul�es pouvant �tre r�tablies
	private List<ViewCommand> redoStack;
	
	
	//Cr�ateur priv� afin de respecter le patron singleton
	private CommandManager(){
		commandStack = new ArrayList<ViewCommand>();
		redoStack = new ArrayList<ViewCommand>();
	}
	
	//Cr�e l'instance si elle n'est pas d�j� existante et la retourne
	public static CommandManager getInstance(){
		if(instance == null) {
			instance = new CommandManager();
		}
		return instance;
	}
	
	public void storeAndExecute(ViewCommand cmd){
		//Ex�cute la commande
		cmd.execute();
		//Ajoute la commande � la pile de commandes effectu�es
		commandStack.add(0, cmd);
		//Vide la pile de commandes pouvant �tre r�tablies
		redoStack.clear();
	}
	
	public void undo(){
		
		if(!commandStack.isEmpty()){
			//Prend la derni�re commande effectu�e
			ViewCommand cmd = commandStack.remove(0);
			//D�fait la commande
			cmd.undo();
			//Ajoute la commande � la pile des commandes annul�es
			redoStack.add(0, cmd);
		}
		
	}
	
	public void redo(){
		
		if(!redoStack.isEmpty()){
			//Prend la derni�re commande annul�e
			ViewCommand cmd = redoStack.remove(0);
			//Refait la commande
			cmd.redo();
			//Ajoute la commande � la pile de commandes effectu�es
			commandStack.add(0, cmd);
		}
		
	}
}

