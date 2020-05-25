package root.controllers.Editors;

import root.model.Wall.Wall;


public class EditorWall<T extends Wall> extends EditorBreakableObject<T> {

    public EditorWall(String title){
        super(title);
        jcbDirection.setVisible(false);
    }


    @Override
    public void updateFrame(T model) {
        super.updateFrame(model);

    }



//    public static void main(String[] args) {
//        EditorWall<Wall> wallEditorWall = new EditorWall<>("wall");
//        wallEditorWall.setVisible(true);
//    }
}
