import javax.swing.*;
import java.awt.*;

public class LinkCreationGUI {
    private JPanel panel;
    private JTextPane targetSceneBody;
    private JTextPane linkDescription;
    private JTextPane sourceSceneBody;
    private JComboBox targetSceneSelector;
    private JPanel textFieldPanel;
    private JButton addLinkButton;

    public LinkCreationGUI(String title) {
        JFrame frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(700, 700));
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
