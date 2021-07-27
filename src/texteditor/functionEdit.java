package texteditor;


import javax.swing.undo.UndoManager;

public class functionEdit {

    public void undo(UndoManager um){
        um.undo();
        }
    public void redo(UndoManager um){
        um.redo();
    }
}
