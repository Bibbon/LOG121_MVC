package Controller;

import java.util.*;

public class CommandManager {

	// Instance unique du gestionnaire de commande
	private static CommandManager instance;
	//Pile des commandes effectuées
	private List<ViewCommand> commandStack;
	//Pile des commandes annulées pouvant être rétablies
	private List<ViewCommand> redoStack;
	
	
	//Créateur privé afin de respecter le patron singleton
	private CommandManager(){
		commandStack = new ArrayList<ViewCommand>();
		redoStack = new ArrayList<ViewCommand>();
	}
	
	//Crée l'instance si elle n'est pas déjà existante et la retourne
	public static CommandManager getInstance(){
		if(instance == null) {
			instance = new CommandManager();
		}
		return instance;
	}
	
	public void storeAndExecute(ViewCommand cmd){
		//Exécute la commande
		cmd.execute();
		//Ajoute la commande à la pile de commandes effectuées
		commandStack.add(0, cmd);
		//Vide la pile de commandes pouvant être rétablies
		redoStack.clear();
	}
	
	public void undo(){
		
		if(!commandStack.isEmpty()){
			//Prend la dernière commande effectuée
			ViewCommand cmd = commandStack.remove(0);
			//Défait la commande
			cmd.undo();
			//Ajoute la commande à la pile des commandes annulées
			redoStack.add(0, cmd);
		}
		
	}
	
	public void redo(){
		
		if(!redoStack.isEmpty()){
			//Prend la dernière commande annulée
			ViewCommand cmd = redoStack.remove(0);
			//Refait la commande
			cmd.redo();
			//Ajoute la commande à la pile de commandes effectuées
			commandStack.add(0, cmd);
		}
		
	}
}

