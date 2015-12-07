package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JoinGameScreen extends JPanel {

    private JLabel lblCreateGame;

    private JLabel lblJoinGame;
    private JLabel lblGameToJoin;
    private JLabel lblJoinControl;
    private JLabel lblEnterControls;
    private JButton btnBack;
    private JButton btnJoin;
    private JTextField textGameId;
    private JTextField textFieldEnterControls;
    private String gameID;
    private String enterControls;
    private JLabel lblError;
    private JLabel lblNoControls;
    private JLabel lblGameJoined;

    /**
     * Create the panel.
     */
    public JoinGameScreen() {
        setBackground(new Color(0, 102, 0));
        setLayout(null);

        lblGameToJoin = new JLabel("GameID to join:");
        lblGameToJoin.setForeground(new Color(255, 255, 255));
        lblGameToJoin.setBounds(88, 106, 98, 16);
        add(lblGameToJoin);

        lblJoinGame = new JLabel("Join Game");
        lblJoinGame.setForeground(new Color(255, 255, 255));
        lblJoinGame.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        lblJoinGame.setBounds(220, 47, 117, 28);
        add(lblJoinGame);

        textGameId = new JTextField();
        textGameId.setBounds(220, 100, 134, 28);
        add(textGameId);
        textGameId.setColumns(10);

        btnJoin = new JButton("Join");
        btnJoin.setBounds(220, 320, 117, 29);
        add(btnJoin);

        btnBack = new JButton();
        btnBack.setIcon(new ImageIcon(CreateGameScreen.class.getResource("/Resources/BackButton.png")));
        btnBack.setBounds(31, 23, 40, 40);
        add(btnBack);

        lblEnterControls = new JLabel("Enter Controls");
        lblEnterControls.setForeground(new Color(255, 255, 255));
        lblEnterControls.setBounds(88, 287, 109, 16);
        add(lblEnterControls);

        textFieldEnterControls = new JTextField();
        textFieldEnterControls.setBounds(220, 281, 134, 28);
        add(textFieldEnterControls);
        textFieldEnterControls.setColumns(10);

        lblJoinControl = new JLabel("");
        lblJoinControl.setIcon(new ImageIcon(JoinGameScreen.class.getResource("/Resources/control.png")));
        lblJoinControl.setBounds(162, 134, 192, 146);
        add(lblJoinControl);

        //opretter,giver attributter og adder error label
        lblError = new JLabel("Game not found");
        lblError.setForeground(new Color(255, 204, 51));
        lblError.setHorizontalAlignment(SwingConstants.CENTER);
        lblError.setBounds(116, 336, 309, 16);
        lblError.setVisible(false);
        add(lblError);


        //opretter,giver attributter og adder error label
        lblNoControls = new JLabel("Please enter Controls and Game Name");
        lblNoControls.setForeground(new Color(255, 204, 51));
        lblNoControls.setHorizontalAlignment(SwingConstants.CENTER);
        lblNoControls.setBounds(116, 336, 309, 16);
        lblNoControls.setVisible(false);
        add(lblNoControls);

        //opretter,giver attributter og adder error label
        lblGameJoined = new JLabel("Game Joined");
        lblGameJoined.setForeground(new Color(255, 204, 51));
        lblGameJoined.setHorizontalAlignment(SwingConstants.CENTER);
        lblGameJoined.setBounds(116, 336, 309, 16);
        lblGameJoined.setVisible(false);
        add(lblGameJoined);
    }

    public JLabel getLblNoControls() {
        return lblNoControls;
    }

    public JLabel getLblGameJoined() {
        return lblGameJoined;
    }

    public JTextField getTextFieldEnterControls() {
        return textFieldEnterControls;
    }

    public JTextField getTextGameId() {
        return textGameId;
    }

    public JLabel getLblError()
    {
        return lblError;
    }

    public JButton getBtnBack()
    {
        return btnBack;
    }//metode slut

    public JButton getBtnJoin()
    {
        return btnJoin;
    }

    public void addActionListener(ActionListener l)
    {
        btnJoin.addActionListener(l);
        btnBack.addActionListener(l);
    }
}
