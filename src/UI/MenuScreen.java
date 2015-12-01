package UI;

/**
 * Created by ejer on 30/11/15.
 */


import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;


public class MenuScreen extends JPanel {

    //instantiere variabler
    private JButton btnHome;
    private JButton btnCreateGame;
    private JButton btnHighscores;
    private JButton btnDeleteGame;
    private JButton btnLogout;
    private JButton btnTOM;

    /**
     * Create the panel.
     */
    public MenuScreen()
    {
        setBackground(new Color(0, 102, 0));
        setBounds(100, 100, 529, 475);
        setLayout(null);

        //opretter,giver attributter og adder home knap
        btnHome = new JButton();
        btnHome.setBounds(0, 0, 0, 0);

        add(btnHome);

        //opretter,giver attributter og adder deposit knap
        btnCreateGame = new JButton("Create Game");
        btnCreateGame.setBounds(186, 88, 142, 50);
        btnCreateGame.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        btnCreateGame.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
            }
        });
        add(btnCreateGame);

        btnHighscores = new JButton("High Score");
        btnHighscores.setBounds(186, 150, 142, 50);
        btnHighscores.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        add(btnHighscores);

        btnDeleteGame = new JButton("Delete Game");
        btnDeleteGame.setBounds(186, 209, 142, 46);
        btnDeleteGame.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        add(btnDeleteGame);

        btnLogout = new JButton("Log out");
        btnLogout.setBounds(186, 267, 142, 46);
        btnLogout.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        add(btnLogout);

        btnTOM = new JButton("TOM");
        btnTOM.setBounds(186, 325, 142, 46);
        btnTOM.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        add(btnTOM);

    }//metode slut



    public JButton getBtnHome() {
        return btnHome;
    }

    public void setBtnHome(JButton btnHome) {
        this.btnHome = btnHome;
    }

    public JButton getBtnCreateGame() {
        return btnCreateGame;
    }

    public void setBtnCreateGame(JButton btnCreateGame) {
        this.btnCreateGame = btnCreateGame;
    }

    public JButton getBtnHighscores() {
        return btnHighscores;
    }

    public void setBtnHighscores(JButton btnHighscores) {
        this.btnHighscores = btnHighscores;
    }

    public JButton getBtnDeleteGame() {
        return btnDeleteGame;
    }

    public void setBtnDeleteGame(JButton btnDeleteGame) {
        this.btnDeleteGame = btnDeleteGame;
    }

    public JButton getBtnLogout() {
        return btnLogout;
    }

    public void setBtnLogout(JButton btnLogout) {
        this.btnLogout = btnLogout;
    }


    public void addActionListener(ActionListener l)
    {
        btnHome.addActionListener(l);
        btnCreateGame.addActionListener(l);
        btnLogout.addActionListener(l);
        btnDeleteGame.addActionListener(l);
        btnHighscores.addActionListener(l);
    }//metode slut
}//klasse slut