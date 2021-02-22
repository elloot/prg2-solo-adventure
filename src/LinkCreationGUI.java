import javax.swing.*;
import java.awt.*;

public class LinkCreationGUI {
    private JPanel panel;
    private JTextPane targetSceneBody;
    private JTextPane linkDescription;
    private JTextPane sourceSceneBody;
    private JComboBox<Scene> targetSceneSelector;
    private JPanel textFieldPanel;
    private JButton addLinkButton;

    public LinkCreationGUI(String title) {
        JFrame frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(700, 700));
        frame.setContentPane(getPanel());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public JTextPane getTargetSceneBody() {
        return targetSceneBody;
    }

    public JTextPane getLinkDescription() {
        return linkDescription;
    }

    public JTextPane getSourceSceneBody() {
        return sourceSceneBody;
    }

    public JComboBox<Scene> getTargetSceneSelector() {
        return targetSceneSelector;
    }

    public JButton getAddLinkButton() {
        return addLinkButton;
    }

    private JPanel getPanel() {
        return panel;
    }
}
