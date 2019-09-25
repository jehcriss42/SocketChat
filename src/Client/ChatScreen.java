package Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatScreen {
    private final JFrame frame;
    private final JPanel panel;
    private final JScrollPane scrollPane;
    private final JTextArea textArea1;
    private final JLabel label1;
    private final JTextField textField;
    private final JButton button;

    private final MessageEmitter messageEmitter;

    public ChatScreen(MessageEmitter emitter) {
        this.messageEmitter = emitter;

        this.frame = new JFrame("CHAT - TEST");
        this.panel = new JPanel();
        this.textArea1 = new JTextArea(10, 60);
        this.textArea1.setEditable(false);
        this.scrollPane = new JScrollPane(this.textArea1);
        this.label1 = new JLabel("Send a message ...");
        this.textField = new JTextField(60);
        this.button = new JButton("Send");

        this.frame.setContentPane(this.panel);
        this.panel.add(this.scrollPane);
        this.panel.add(this.label1);
        this.panel.add(this.textField);
        this.panel.add(button);

        class SendMessageListener implements ActionListener {

            public void actionPerformed(ActionEvent e) {
                messageEmitter.sent(textField.getText());
                textField.setText("");
            }
        }

        this.button.addActionListener(new SendMessageListener());

        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(700, 300);
        this.frame.setVisible(true);
    }

    public void addMessage(String message) {

        this.textArea1.append(message + "\n");
    }

}
