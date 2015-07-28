package Controller;

import java.util.*;
import Model.Perspective;

public class CommandManager {

	private CommandManager instance;
	private List<ViewCommand> history;
	
	private CommandManager(){

		CommandManager instance = null;
		List<ViewCommand> history = new ArrayList<ViewCommand>();

	}
	
	public CommandManager getInstance(){
		if(instance == null) {
			instance = new CommandManager();
		}
		return instance;
	}
	
	private void storeAndExecute(ViewCommand cmd){
		this.history.add(cmd);
		cmd.execute();
	}
	
	private ViewCommand getLastCommand (){
		return this.history.get(history.size() - 1);
	}
	
	private ViewCommand removeLastCommand (){
		return this.history.remove(history.size() - 1);
	}
	

	
	public void zoomIn(Perspective perspective){
		storeAndExecute(new ZoomInCommand(perspective));
	}
	
	public void zoomIn(Perspective perspective, int x, int y){
		storeAndExecute(new ZoomInCommand(perspective, x, y));
	}
	
	public void zoomOut(Perspective perspective){
		storeAndExecute(new ZoomOutCommand(perspective));
	}
	
	public void zoomOut(Perspective perspective, int x, int y){
		storeAndExecute(new ZoomOutCommand(perspective, x, y));
	}
	
	public void move(Perspective perspective, int xDist, int yDist){
		storeAndExecute(new MoveCommand(perspective, xDist, yDist));
	}
}
