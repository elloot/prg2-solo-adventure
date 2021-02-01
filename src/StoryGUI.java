import javax.swing.*;

/**
 * A View class to show the current scene and options to the player of the solo adventure. A StoryGUI has a text
 * panel for showing the story body, a dropdown menu to show the current options available to the player and a button
 * for the player to confirm their choice.
 */
public class StoryGUI {
    private JPanel panel;
    private JTextPane sceneBody;
    private JComboBox<Scene> sceneSelector;
    private JButton confirmSelection;

    //TODO: JavaDoc

    public JTextPane getSceneBody() {
        return sceneBody;
    }

    public JComboBox<Scene> getSceneSelector() {
        return sceneSelector;
    }

    public JButton getConfirmSelection() {
        return confirmSelection;
    }
}
