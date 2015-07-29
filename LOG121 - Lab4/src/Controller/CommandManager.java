package Controller;

import java.util.*;

public class CommandManager {

	private static CommandManager instance;
	private List<ViewCommand> commandStack;
	private List<ViewCommand> redoStack;
	
	private CommandManager(){

		instance = null;
		commandStack = new ArrayList<ViewCommand>();
		redoStack = new ArrayList<ViewCommand>();

	}
	
	public static CommandManager getInstance(){
		if(instance == null) {
			instance = new CommandManager();
		}
		return instance;
	}
	
	public void storeAndExecute(ViewCommand cmd){
		
		cmd.execute();
		commandStack.add(0, cmd);
		redoStack.clear();
		
	}
	
	public void undo(){
		
		if(!commandStack.isEmpty()){
			ViewCommand cmd = commandStack.remove(0);
			cmd.undo();
			redoStack.add(0, cmd);
		}
		
	}
	
	public void clearStacks(){
		commandStack.clear();
		redoStack.clear();
	}
	
	public void redo(){
		
		if(!redoStack.isEmpty()){
			ViewCommand cmd = redoStack.remove(0);
			cmd.redo();
			commandStack.add(0, cmd);
		}
		
	}
}

