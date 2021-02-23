import java.util.ArrayList;
import java.util.HashMap;

public class Model {
    private HashMap<Integer, ArrayList<Link>> links;
    private HashMap<Integer, Scene> scenes;

    // TODO: JavaDoc

    public Model() {
        links = new HashMap<>();
        scenes = new HashMap<>();
    }

    public void setScenes(ArrayList<Scene> s) {
        for (Scene scene : s) {
            scenes.put(scene.getId(), scene);
        }
    }

    public void setLinks(ArrayList<Link> l) {
        for (Link link : l) {
            if (!links.containsKey(link.getSceneId())) {
                links.put(link.getSceneId(), new ArrayList<>());
            }
            links.get(link.getSceneId()).add(link);
        }
    }

    public Scene getScene(int id) {
        return scenes.get(id);
    }

    public ArrayList<Link> getLinks(int sceneId) {
        return links.get(sceneId);
    }

    public void addScene(Scene s) {
        scenes.put(s.getId(), s);
    }

    public void addLink(Link l) {
        if (!links.containsKey(l.getSceneId())) {
            links.put(l.getSceneId(), new ArrayList<>());
        }
        links.get(l.getSceneId()).add(l);
    }

    public void removeLink(Link l) {
        links.get(l.getSceneId()).remove(l);
    }

    public HashMap<Integer, ArrayList<Link>> getLinks() {
        return links;
    }

    public HashMap<Integer, Scene> getScenes() {
        return scenes;
    }
}
