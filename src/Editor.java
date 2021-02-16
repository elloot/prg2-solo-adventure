public class Editor {
    public static void main(String[] args) {
        Model m = new Model();
        EditorGUI ev = new EditorGUI("Solo adventure editor");
        Controller c = new Controller(m, ev);
    }
}
