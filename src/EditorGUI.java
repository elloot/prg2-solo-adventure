import javax.swing.*;
import java.awt.*;

public class EditorGUI {
    private JPanel panel;
    private JComboBox sceneSelector;
    private JTextPane sceneBody;
    private JButton addSceneButton;
    private JButton editSceneButton;
    private JComboBox linkSelector;
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
}
