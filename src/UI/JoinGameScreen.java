package UI;

import Logic.LogicController;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
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
    }


    public JTextField getTextFieldGameID()
    {
        gameID = textGameId.getText();
        return textGameId;
    }//metode slut

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
