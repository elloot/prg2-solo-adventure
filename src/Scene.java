/**
 * A Model class for the scenes in this solo adventure. A Scene contains an id and a body. The body holds part of the
 * story of the solo adventure and tells the player what happens in this scene.
 */

public class Scene {
    private int id;
    private String body;

    //TODO: JavaDoc getters and setters

    /**
     * Constructs a scene with a body.
     * @param body A String describing what part of the solo adventure's story the player is currently in.
     */
    public Scene(String body) {
        this.body = body;
    }

    /**
     * Constructs a scene with an id and a body.
     * @param id The id of the scene.
     * @param body A String describing what part of the solo adventure's story the player is currently in.
     */
    public Scene(int id, String body) {
        this.id = id;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return body;
    }
}
