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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class HighScoreScreen extends JPanel
{
    //instantiere variabler
    private JButton btnBack;
    private JLabel lblHighScore;

    /**
     * Create the panel.
     */
    public HighScoreScreen()
    {
        setLayout(null);
        setBackground(new Color(0, 102, 0));
        setBounds(100, 100, 529, 475);

        lblHighScore = new JLabel("High Score");
        lblHighScore.setForeground(Color.WHITE);
        lblHighScore.setHorizontalAlignment(SwingConstants.CENTER);
        lblHighScore.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        lblHighScore.setBounds(167, 10, 200, 50);
        add(lblHighScore);

        //opretter,giver attributter og adder home knap
        btnBack = new JButton();
        btnBack.setIcon(new ImageIcon(HighScoreScreen.class.getResource("/Resources/BackButton.png")));
        btnBack.setBounds(16, 10, 42, 38);
        add(btnBack);

    }//metode slut

    /**
     * Getter for btnHome
     * @return btnHome
     */
    public JButton getBtnBack()
    {
        return btnBack;
    }//opretter,giver attributter og adder

    public void addActionListener(ActionListener l)
    {
        btnBack.addActionListener(l);
    }
}//Metode slut
//klasse slut
