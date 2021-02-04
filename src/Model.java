import java.util.ArrayList;
import java.util.HashMap;

public class Model {
    // The keys of the links are their story ids
    private HashMap<Integer, Link> links;
    private HashMap<Integer, Scene> scenes;

    // TODO: JavaDoc

    public Model() {
        links = new HashMap<>();
        scenes = new HashMap<>();
    }

    public void addScenes(ArrayList<Scene> s) {
        for (Scene scene : s) {
            scenes.put(scene.getId(), scene);
        }
    }

    public void addLinks(ArrayList<Link> l) {
        for (Link link : l) {
            links.put(link.getStoryId(), link);
        }
    }

    public Scene getScene(int id) {
        return scenes.get(id);
    }

    public Link getLink(int id) {
        return links.get(id);
    }

    public void addScene(Scene s) {
        scenes.put(s.getId(), s);
    }

    public void addLink(Link l) {
        links.put(l.getId(), l);
    }

    public HashMap<Integer, Link> getLinks() {
        return links;
    }

    public void setLinks(HashMap<Integer, Link> links) {
        this.links = links;
    }

    public HashMap<Integer, Scene> getScenes() {
        return scenes;
    }

    public void setScenes(HashMap<Integer, Scene> scenes) {
        this.scenes = scenes;
    }
}
