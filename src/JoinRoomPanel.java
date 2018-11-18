import theme.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by pc on 12/11/2018.
 */
public class JoinRoomPanel extends SPanel {
    public JoinRoomPanel(){
        this.setBackground(theme.Theme.DARKER_MIDNIGHT_BLUE);
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        JLabel enterUsername = new JLabel("Enter your username");
        enterUsername.setHorizontalTextPosition(SwingConstants.CENTER);
        enterUsername.setForeground(Color.WHITE);
        enterUsername.setFont(Theme.FONT_DEFAULT_LARGE);

        STextField username = new STextField();
        username.setFont(Theme.FONT_DEFAULT_MEDIUM);

        SPanel usernamePanel = new SPanel();
        usernamePanel.setBackground(theme.Theme.DARKER_MIDNIGHT_BLUE);
        usernamePanel.setLayout(new BorderLayout());

        SButton joinButton = new SButton("Join");

        //Host and port
        STextField host = new STextField();
        STextField port = new STextField();

        this.add(enterUsername);
        this.add(usernamePanel);
        usernamePanel.add(username, BorderLayout.NORTH);
        this.add(joinButton);

        joinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainWindow.getInstance().joinGame(username.getText(), SocketPeerConnection.DEFAULT_HOST, SocketPeerConnection.DEFAULT_PORT);
            }
        });

        username.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               /// TODO : read from textfiel host and port(int)
               // MainWindow.getInstance().joinGame(username.getText());
                //check if all the textField are filled
            }
        });
    }
}
