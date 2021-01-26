/**
 * A Model class for the links in the solo adventure. A Link contains a story id for the scene it is showed in, a
 * target id for the scene it will direct the player to and a description that tells the player what choosing this
 * Link/option will do. The Link also contains an id of its own that is handled by a database.
 */

public class Link {
    private int id;
    private int storyId;
    private int targetId;
    private String description;

    //TODO: JavaDoc getters and setters

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
     * @param storyId The id of the scene to which the link is linked.
     * @param targetId The id of the scene to which the link leads.
     * @param description A description of what the player does if it chooses this link.
     */
    public Link(int storyId, int targetId, String description) {
        this.storyId = storyId;
        this.targetId = targetId;
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStoryId(int storyId) {
        this.storyId = storyId;
    }

    public void setTargetId(int targetId) {
        this.targetId = targetId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public int getStoryId() {
        return storyId;
    }

    public int getTargetId() {
        return targetId;
    }

    public String getDescription() {
        return description;
    }
}
