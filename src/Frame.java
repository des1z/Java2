import javax.swing.*;
import java.awt.*;
/**
 * @version 03.09.2018
 * @author Viktor Chernyaev
 * @Java2 homework Lesson-4
 * @link https://github.com/des1z
 */

class Frame extends JFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Frame::new);
    }
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
