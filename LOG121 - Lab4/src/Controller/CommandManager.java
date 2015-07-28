package Controller;

import java.util.*;

public class CommandManager {

	private static CommandManager instance;
	private List<ViewCommand> commandList;
	private List<ViewCommand> redoList;
	
	private CommandManager(){

		instance = null;
		commandList = new ArrayList<ViewCommand>();
		redoList = new ArrayList<ViewCommand>();

	}
	
	public static CommandManager getInstance(){
		if(instance == null) {
			instance = new CommandManager();
		}
		return instance;
	}
	
	public void storeAndExecute(ViewCommand cmd){
		
		cmd.execute();
		commandList.add(0, cmd);
		redoList.clear();
		
	}
	
	public void undo(){
		
		if(!commandList.isEmpty()){
			ViewCommand cmd = commandList.remove(0);
			cmd.undo();
			redoList.add(0, cmd);
		}
		
	}
	
	public void redo(){
		
		if(!redoList.isEmpty()){
			ViewCommand cmd = redoList.remove(0);
			cmd.redo();
			commandList.add(0, cmd);
		}
		
	}
}

