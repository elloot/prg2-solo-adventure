import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * A Controller class that connects the Model and the View of this solo adventure together. It transfers the data on
 * the scenes and the links from the database to the Model and displays these in the View.
 */

public class Controller {
    private StoryGUI view;
    private Model model;
    private MySQLHandler mySQLHandler;
    private Scene currentScene;
    private EditorGUI editorView;

    //TODO: JavaDoc

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
        currentScene = getScene(1);
        updateView();
        setConfirmButtonListener();
    }

    public Controller(Model m, EditorGUI ev) {
        model = m;
        editorView = ev;
        mySQLHandler = new MySQLHandler();
        setScenes();
        setLinks();
        addAddSceneButtonListener();
        addSceneSelectorListener();
        addLinkSelectorListener();
        updateEditorView();
    }

    private void addLinkSelectorListener() {
        editorView.getLinkSelector().addActionListener(e -> {
            if (editorView.getLinkSelector().getItemCount() != 0) updateCurrentEditorLink();
        });
    }

    private void addSceneSelectorListener() {
        editorView.getSceneSelector().addActionListener(e -> {
            updateCurrentEditorScene();
            updateEditorLinks();
        });
    }

    private void clearEditorSceneSelector() {
        editorView.getSceneSelector().removeAllItems();
    }

    private void clearEditorLinkSelector() {
        editorView.getLinkSelector().removeAllItems();
    }

    private Scene getSelectedEditorScene() {
        return (Scene) editorView.getSceneSelector().getSelectedItem();
    }

    private Link getSelectedEditorLink() {
        return (Link) editorView.getLinkSelector().getSelectedItem();
    }

    private void updateEditorView() {
        updateEditorScenes();
        updateCurrentEditorScene();
        updateEditorLinks();
        updateCurrentEditorLink();
    }

    private void updateCurrentEditorLink() {
        Link currentLink = getSelectedEditorLink();
        editorView.getLinkDescription().setText(currentLink.getDescription());
    }

    private void updateEditorScenes() {
        HashMap<Integer, Scene> scenes = model.getScenes();
        clearEditorSceneSelector();
        Object[] keys = scenes.keySet().toArray();
        for (Object key : keys) {
            int id = (int) key;
            editorView.getSceneSelector().addItem(scenes.get(id));
        }
    }

    private void updateCurrentEditorScene() {
        Scene currentScene = getSelectedEditorScene();
        editorView.getSceneBody().setText(currentScene.getBody());
    }

    private void updateEditorLinks() {
        ArrayList<Link> links = model.getLinks(getSelectedEditorScene().getId());
        clearEditorLinkSelector();
        for (Link link : links) {
            editorView.getLinkSelector().addItem(link);
        }
    }

    private JComboBox<Scene> getSceneSelector() {
        return editorView.getSceneSelector();
    }

    private void addScene() {
        model.addScene(mySQLHandler.addScene(JOptionPane.showInputDialog("Input the body of the scene: ")));
    }

    private void addAddSceneButtonListener() {
        getAddSceneButton().addActionListener(e -> {
            addScene();
        });
    }

    private JButton getAddSceneButton() {
        return editorView.getAddSceneButton();
    }

    private void setConfirmButtonListener() {
        getConfirmButton().addActionListener(e -> {
            Link currentLink = (Link) view.getSceneSelector().getSelectedItem();
            if (currentLink != null) {
                setCurrentScene(currentLink.getTargetId());
                updateView();
            } else {
                setViewSceneText("That's the end of the adventure, thanks for playing!");
            }
        });
    }

    private void setViewSceneText(String text) {
        view.getSceneBody().setText(text);
    }

    private void setCurrentScene(int id) {
        currentScene = getScene(id);
    }

    private void updateView() {
        updateCurrentScene(currentScene.getId());
        updateCurrentLinks(currentScene.getId());
    }

    private JButton getConfirmButton() {
        return view.getConfirmSelection();
    }

    private Scene getScene(int id) {
        return model.getScene(id);
    }

    private void updateCurrentScene(int sceneId) {
        setViewSceneText(model.getScene(sceneId).getBody());
    }

    private void updateCurrentLinks(int sceneId) {
        ArrayList<Link> links = model.getLinks(sceneId);
        view.getSceneSelector().removeAllItems();
        for (Link link : links) {
            view.getSceneSelector().addItem(link);
        }
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
