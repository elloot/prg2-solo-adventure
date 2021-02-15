import javax.swing.*;
import java.awt.*;

public class EditorGUI {
    private JPanel panel;
    private JComboBox<Scene> sceneSelector;
    private JTextPane sceneBody;
    private JButton addSceneButton;
    private JButton editSceneButton;
    private JComboBox<Scene> linkSelector;
    private JTextPane linkDescription;
    private JPanel sceneButtonsPanel;
    private JButton addLinkButton;
    private JButton editLinkButton;
    private JPanel linkButtonsPanel;
    private JButton removeSceneButton;
    private JButton removeLinkButton;

    public EditorGUI(String title) {
        JFrame frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(500, 700));
        frame.setContentPane(getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JPanel getPanel() {
        return panel;
    }

    public JButton getAddSceneButton() {
        return addSceneButton;
    }

    public JComboBox<Scene> getSceneSelector() {
        return sceneSelector;
    }

    public JTextPane getSceneBody() {
        return sceneBody;
    }

    public JButton getEditSceneButton() {
        return editSceneButton;
    }

    public JComboBox<Scene> getLinkSelector() {
        return linkSelector;
    }

    public JTextPane getLinkDescription() {
        return linkDescription;
    }

    public JButton getAddLinkButton() {
        return addLinkButton;
    }

    public JButton getEditLinkButton() {
        return editLinkButton;
    }

    public JButton getRemoveSceneButton() {
        return removeSceneButton;
    }

    public JButton getRemoveLinkButton() {
        return removeLinkButton;
    }
}
