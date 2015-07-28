package Controller;

import java.util.*;

import Model.Perspective;
import Model.Thumbnail;

public class CommandManager {

	private static CommandManager instance;
	private List<ViewCommand> history;
	
	private CommandManager(){

		instance = null;
		history = new ArrayList<ViewCommand>();

	}
	
	public static CommandManager getInstance(){
		if(instance == null) {
			instance = new CommandManager();
		}
		return instance;
	}
	
	private void storeAndExecute(ViewCommand cmd){
		this.history.add(cmd);
		cmd.execute();
	}
	
	private ViewCommand removeLastCommand (){
		if(!history.isEmpty())
			return this.history.remove(history.size() - 1);
		else
			return null;
	}
	
	public void undo(){
		ViewCommand cmd = removeLastCommand();
		if(cmd != null)
			cmd.undo();
	}
	

	public void zoomIn(Perspective perspective){
		storeAndExecute(new ZoomInCommand(perspective));
	}
	
	
	public void zoomOut(Perspective perspective){
		storeAndExecute(new ZoomOutCommand(perspective));
	}
	
	
	public void moveUp(Perspective perspective){
		storeAndExecute(new MoveUpCommand(perspective));
	}
	
	public void moveDown(Perspective perspective){
		storeAndExecute(new MoveDownCommand(perspective));
	}
	
	public void moveLeft(Perspective perspective){
		storeAndExecute(new MoveLeftCommand(perspective));
	}
	
	public void moveRight(Perspective perspective){
		storeAndExecute(new MoveRightCommand(perspective));
	}
}
