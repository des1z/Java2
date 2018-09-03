import javax.swing.*;
import java.awt.*;

class Frame extends JFrame {
    Frame(){
        setTitle("Chat");
        setSize(new Dimension(400, 400));
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        TextPanel textPanel = new TextPanel();
        SendPanel sendPanel = new SendPanel(textPanel.getTextArea());

        add(textPanel, BorderLayout.CENTER);
        add(sendPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
