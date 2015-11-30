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
    private JLabel lblDeposit;
    private JLabel label;
    private JButton btnHome;
    private JButton btnCreateGame;
    private JLabel lblConfirm;
    private JLabel lblErrorZero;
    private JLabel lblErrorLetter;
    private JButton btnHighscores;
    private JButton btnDeleteGame;
    private JButton btnLogout;
    private JButton btnNewButton_3;

    /**
     * Create the panel.
     */
    public MenuScreen()
    {
        setLayout(null);
        setBackground(new Color(62, 77, 86));

        //opretter,giver attributter og adder deposit label
        lblDeposit = new JLabel("Menu");
        lblDeposit.setForeground(Color.WHITE);
        lblDeposit.setHorizontalAlignment(SwingConstants.CENTER);
        lblDeposit.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        lblDeposit.setBounds(167, 10, 200, 50);
        add(lblDeposit);

        //opretter,giver attributter og adderbalance label
        label = new JLabel("");
        label.setBounds(60, 191, 61, 16);
        add(label);

        //opretter,giver attributter og adder home knap
        btnHome = new JButton();

        add(btnHome);

        //opretter,giver attributter og adder deposit knap
        btnCreateGame = new JButton("Create Game");
        btnCreateGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnCreateGame.setBounds(211, 58, 117, 29);
        add(btnCreateGame);

        //opretter,giver attributter og adder confirm label
        lblConfirm = new JLabel("");
        lblConfirm.setHorizontalAlignment(SwingConstants.CENTER);
        lblConfirm.setVisible(false);
        lblConfirm.setForeground(Color.WHITE);
        lblConfirm.setBounds(112, 316, 370, 16);
        add(lblConfirm);

        //opretter,giver attributter og adder eroor label
        lblErrorZero = new JLabel("Please enter a number higher than 0. try again");
        lblErrorZero.setHorizontalAlignment(SwingConstants.CENTER);
        lblErrorZero.setVisible(false);
        lblErrorZero.setForeground(Color.RED);
        lblErrorZero.setBounds(112, 344, 370, 16);
        add(lblErrorZero);

        //opretter,giver attributter og adder error label
        lblErrorLetter = new JLabel("Only numbers allowed! dot(.) for decimal, try again");
        lblErrorLetter.setHorizontalAlignment(SwingConstants.CENTER);
        lblErrorLetter.setVisible(false);
        lblErrorLetter.setForeground(Color.RED);
        lblErrorLetter.setBounds(112, 344, 370, 16);
        add(lblErrorLetter);

        btnHighscores = new JButton("High Score");
        btnHighscores.setBounds(211, 106, 117, 29);
        add(btnHighscores);

        btnDeleteGame = new JButton("Delete Game");
        btnDeleteGame.setBounds(211, 160, 117, 29);
        add(btnDeleteGame);

        btnLogout = new JButton("Log out");
        btnLogout.setBounds(211, 218, 117, 29);
        add(btnLogout);

        btnNewButton_3 = new JButton("TOM");
        btnNewButton_3.setBounds(211, 259, 117, 29);
        add(btnNewButton_3);

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



    public JLabel getLblErrorZero() {
        return lblErrorZero;
    }



    public void setLblErrorZero(JLabel lblErrorZero) {
        this.lblErrorZero = lblErrorZero;
    }



    public JLabel getLblErrorLetter() {
        return lblErrorLetter;
    }



    public void setLblErrorLetter(JLabel lblErrorLetter) {
        this.lblErrorLetter = lblErrorLetter;
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