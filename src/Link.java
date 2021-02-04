/**
 * A Model class for the links in the solo adventure. A Link contains a story id for the scene it is showed in, a
 * target id for the scene it will direct the player to and a description that tells the player what choosing this
 * Link/option will do. The Link also contains an id of its own that is handled by a database.
 */

public class Link {
    private int id;
    private int sceneId;
    private int targetId;
    private String description;

    /**
     * Constructs a link with an id and data on where it leads, which scene it is linked to and what it does story-wise.
     * @param id The id of the link.
     * @param storyId The id of the scene to which the link is linked.
     * @param targetId The id of the scene to which the link leads.
     * @param description A description of what the player does if it chooses this link.
     */
    public Link(int id, int storyId, int targetId, String description) {
        this.id = id;
        this.storyId = storyId;
        this.targetId = targetId;
        this.description = description;
    }

    /**
     * Constructs a link without an id but with data on where it leads, which scene it is linked to and what it does
     * story-wise.
     * @param sceneId The id of the scene to which the link is linked.
     * @param targetId The id of the scene to which the link leads.
     * @param description A description of what the player does if it chooses this link.
     */
    public Link(int sceneId, int targetId, String description) {
        this.sceneId = sceneId;
        this.targetId = targetId;
        this.description = description;
    }

    /**
     * @param id The id of the Link.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param sceneId The id of the scene to which the link is linked.
     */
    public void setSceneId(int sceneId) {
        this.sceneId = sceneId;
    }

    /**
     * @param targetId The id of the scene to which the link leads.
     */
    public void setTargetId(int targetId) {
        this.targetId = targetId;
    }

    /**
     * @param description A description of what the player does if it chooses this link.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return The id of the link.
     */
    public int getId() {
        return id;
    }

    /**
     * @return The id of the scene to which the link is linked.
     */
    public int getSceneId() {
        return sceneId;
    }

    /**
     * @return The id of the scene to which the link leads.
     */
    public int getTargetId() {
        return targetId;
    }

    /**
     * @return The description of what the player does if it chooses this link.
     */
    public String getDescription() {
        return description;
    }
}
