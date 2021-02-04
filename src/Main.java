public class Main {
    public static void main(String[] args) {
        Model m = new Model();
        StoryGUI v = new StoryGUI("Solo adventure");
        Controller c = new Controller(m, v);
    }
}
