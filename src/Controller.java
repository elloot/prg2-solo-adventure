import java.util.ArrayList;

/**
 * A Controller class that connects the Model and the View of this solo adventure together. It transfers the data on
 * the scenes and the links from the database to the Model and displays these in the View.
 */

public class Controller {
    private StoryGUI view;
    private Model model;
    private MySQLHandler mySQLHandler;

    /**
     * Constructs a controller with a model and a view.
     * @param m A model that will contain the story of a solo adventure.
     * @param v A view that the controller will display a solo adventure in.
     */
    public Controller(Model m, StoryGUI v) {
        model = m;
        view = v;
        mySQLHandler = new MySQLHandler();
        setScenes();
        setLinks();
    }

    /**
     * Populates the scene hashmap in the model with scenes gathered from a database.
     */
    private void setScenes() {
        model.setScenes(getScenes());
    }

    /**
     * Populates the links hashmap in the model with links gathered from a database.
     */
    private void setLinks() {
        model.setLinks(getLinks());
    }

    /**
     * @return The scenes read from the database.
     */
    private ArrayList<Scene> getScenes() {
        return mySQLHandler.readScenes();
    }

    /**
     * @return The links read from the database.
     */
    private ArrayList<Link> getLinks() {
        return mySQLHandler.readLinks();
    }
}
