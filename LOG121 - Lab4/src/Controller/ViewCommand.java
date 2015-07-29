package Controller;

public interface ViewCommand {

	public void execute();

	public void undo();

	public void redo();

}
