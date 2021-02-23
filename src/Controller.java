import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * A Controller class that connects the Model and the View of this solo adventure together. It transfers the data on
 * the scenes and the links from the database to the Model and displays these in the View.
 */

public class Controller {
    private StoryGUI view;
    private final Model model;
    private final MySQLHandler mySQLHandler;
    private Scene currentScene;
    private EditorGUI editorView;
    private LinkCreationGUI linkCreationGUI;

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
        addAddLinkListener();
        addRemoveLinkListener();
        addRemoveSceneListener();
        addSceneSelectorListener();
        addLinkSelectorListener();
        updateEditorView();
    }

    private void removeSelectedScene() {
        Scene scene = getSelectedEditorScene();
        removeLinks(model.getLinks(scene.getId()));
        mySQLHandler.removeScene(scene.getId());
        model.removeScene(scene);
    }

    private void removeLinks(ArrayList<Link> links) {
        if (links != null && links.size() > 0) {
            for (Link link : links) {
                removeLink(link);
            }
        }
    }

    private void removeLink(Link l) {
        mySQLHandler.removeLink(l.getSceneId(), l.getTargetId(), l.getDescription());
    }

    private void addRemoveSceneListener() {
        editorView.getRemoveSceneButton().addActionListener(e -> {
            removeSelectedScene();
            updateEditorScenes();
            updateEditorLinks();
        });
    }

    private void removeSelectedLink() {
        Link link = getSelectedEditorLink();
        removeLink(link);
        model.removeLink(link);
        updateEditorLinks();
    }

    private void addRemoveLinkListener() {
        editorView.getRemoveLinkButton().addActionListener(e -> removeSelectedLink());
    }

    private Link addLinkToDB(int sourceId, int targetId, String desc) {
        return mySQLHandler.addLink(sourceId, targetId, desc);
    }

    private void updateLinkGUI() {
        updateLinkGUIScenes();
        updateLinkGUITargetScene();
        updateLinkGUISourceScene();
    }

    private void updateLinkGUITargetScene() {
        linkCreationGUI.getTargetSceneBody().setText(getLinkGUISelectedTargetScene().getBody());
    }

    private void addLinkGUISceneSelectorListener() {
        getLinkGUISceneSelector().addActionListener(e -> {
            if (getLinkGUISceneSelector().getItemCount() != 0) updateLinkGUITargetScene();
        });
    }

    private Scene getLinkGUISelectedTargetScene() {
        return (Scene) getLinkGUISceneSelector().getSelectedItem();
    }

    private JComboBox<Scene> getLinkGUISceneSelector() {
        return linkCreationGUI.getTargetSceneSelector();
    }

    private void clearLinkGUISceneSelector() {
        getLinkGUISceneSelector().removeAllItems();
    }

    private void updateLinkGUIScenes() {
        HashMap<Integer, Scene> scenes = model.getScenes();
        clearLinkGUISceneSelector();
        Object[] keys = scenes.keySet().toArray();
        for (Object key : keys) {
            int id = (int) key;
            getLinkGUISceneSelector().addItem(scenes.get(id));
        }
    }

    private void updateLinkGUISourceScene() {
        linkCreationGUI.getSourceSceneBody().setText(getLinkGUISelectedTargetScene().getBody());
    }

    private void addLinkGUIAddLinkListener() {
        linkCreationGUI.getAddLinkButton().addActionListener(e -> model.addLink(addLinkToDB(getSelectedEditorScene().getId(), getLinkGUISelectedTargetScene().getId(),
                linkCreationGUI.getLinkDescription().getText())));
    }

    private void addAddLinkListener() {
        editorView.getAddLinkButton().addActionListener(e -> {
            linkCreationGUI = new LinkCreationGUI("Link creation");
            addLinkGUIAddLinkListener();
            updateLinkGUI();
            addLinkGUISceneSelectorListener();
        });
    }

    private void setEditorSceneBody(String text) {
        editorView.getSceneBody().setText(text);
    }

    private void setEditorLinkDescription(String text) {
        editorView.getLinkDescription().setText(text);
    }

    private void addLinkSelectorListener() {
        getEditorLinkSelector().addActionListener(e -> {
            if (getEditorLinkSelector().getItemCount() != 0) updateCurrentEditorLink();
        });
    }

    private void addSceneSelectorListener() {
        getEditorSceneSelector().addActionListener(e -> {
            if (getEditorSceneSelector().getItemCount() > 0) {
                updateCurrentEditorScene();
                updateEditorLinks();
            }
        });
    }

    private void clearEditorSceneSelector() {
        getEditorSceneSelector().removeAllItems();
    }

    private void clearEditorLinkSelector() {
        getEditorLinkSelector().removeAllItems();
    }

    private Scene getSelectedEditorScene() {
        return (Scene) getEditorSceneSelector().getSelectedItem();
    }

    private Link getSelectedEditorLink() {
        return (Link) getEditorLinkSelector().getSelectedItem();
    }

    private void updateEditorView() {
        updateEditorScenes();
        updateCurrentEditorScene();
        updateEditorLinks();
        updateCurrentEditorLink();
    }

    private void updateCurrentEditorLink() {
        Link currentLink = getSelectedEditorLink();
        setEditorLinkDescription(currentLink.getDescription());
    }

    private void updateEditorScenes() {
        HashMap<Integer, Scene> scenes = model.getScenes();
        clearEditorSceneSelector();
        Object[] keys = scenes.keySet().toArray();
        for (Object key : keys) {
            int id = (int) key;
            getEditorSceneSelector().addItem(scenes.get(id));
        }
    }

    private void updateCurrentEditorScene() {
        Scene currentScene = getSelectedEditorScene();
        setEditorSceneBody(currentScene.getBody());
    }

    private void updateEditorLinks() {
        ArrayList<Link> links = model.getLinks(getSelectedEditorScene().getId());
        clearEditorLinkSelector();
        if (links != null) {
            for (Link link : links) {
                getEditorLinkSelector().addItem(link);
            }
        } else {
            setEditorLinkDescription("");
        }
    }

    private JComboBox<Scene> getEditorSceneSelector() {
        return editorView.getSceneSelector();
    }

    private JComboBox<Link> getEditorLinkSelector() {
        return editorView.getLinkSelector();
    }

    private void addScene() {
        model.addScene(mySQLHandler.addScene(JOptionPane.showInputDialog("Input the body of the scene: ")));
    }

    private void addAddSceneButtonListener() {
        getAddSceneButton().addActionListener(e -> addScene());
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
