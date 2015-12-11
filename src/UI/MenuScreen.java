package UI;

/**
 * Created by Peter Villumsen on 30/11/15.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MenuScreen extends JPanel {

    //Declaring variables
    private JLabel   lblMenu;
    private JButton btnCreateGame;
    private JButton btnJoinGame;
    private JButton btnHighScores;
    private JButton btnDeleteGame;
    private JButton btnLogout;

    public MenuScreen()
    {
        setBackground(new Color(0, 102, 0));
        setBounds(100, 100, 529, 475);
        setLayout(null);

        btnCreateGame = new JButton("Create Game");
        btnCreateGame.setBounds(193, 88, 142, 50);
        btnCreateGame.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        add(btnCreateGame);

        btnJoinGame = new JButton("Join Game");
        btnJoinGame.setBounds(193, 266, 142, 46);
        btnJoinGame.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        add(btnJoinGame);

        btnHighScores = new JButton("High Score");
        btnHighScores.setBounds(193, 150, 142, 50);
        btnHighScores.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        add(btnHighScores);

        btnDeleteGame = new JButton("Delete Game");
        btnDeleteGame.setBounds(193, 209, 142, 46);
        btnDeleteGame.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        add(btnDeleteGame);

        btnLogout = new JButton("Log out");
        btnLogout.setBounds(193, 324, 142, 46);
        btnLogout.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        add(btnLogout);

        lblMenu = new JLabel("Menu");
        lblMenu.setForeground(Color.WHITE);
        lblMenu.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
        lblMenu.setBounds(220, 41, 88, 35);
        add(lblMenu);

    }

    public JButton getBtnCreateGame()
    {
        return btnCreateGame;
    }

    public JButton getBtnJoinGame()
    {
        return btnJoinGame;
    }

    public JButton getBtnHighScores()
    {
        return btnHighScores;
    }

    public JButton getBtnDeleteGame()
    {
        return btnDeleteGame;
    }

    public JButton getBtnLogout() { return btnLogout; }

    public void addActionListener(ActionListener l)
    {
        btnCreateGame.addActionListener(l);
        btnJoinGame.addActionListener(l);
        btnHighScores.addActionListener(l);
        btnDeleteGame.addActionListener(l);
        btnLogout.addActionListener(l);

    }
}
