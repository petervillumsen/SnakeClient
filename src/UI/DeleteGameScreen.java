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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class DeleteGameScreen extends JPanel
{
    //instantiere variabler
    private JLabel lblDelete;
    private JLabel lblDeleteGame;
    private JTextField textFieldGameID;
    private JButton btnBack;
    private JButton btnDeleteGame;

    private String gameID;

    /**
     * Create the panel.
     */
    public DeleteGameScreen()
    {
        setLayout(null);
        setBackground(new Color(0, 102, 0));
        setBounds(100, 100, 529, 475);

        //opretter,giver attributter og adder balance label
        lblDelete = new JLabel("Delete Game");
        lblDelete.setForeground(Color.WHITE);
        lblDelete.setHorizontalAlignment(SwingConstants.CENTER);
        lblDelete.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        lblDelete.setBounds(167, 10, 200, 50);
        add(lblDelete);

        //opretter,giver attributter og adder your balance is label
        lblDeleteGame = new JLabel("Game to delete");
        lblDeleteGame.setForeground(Color.WHITE);
        lblDeleteGame.setBounds(125, 88, 108, 16);
        add(lblDeleteGame);

        //opretter,giver attributter og adder balance textfield
        textFieldGameID = new JTextField();
        textFieldGameID.setBounds(245, 82, 134, 28);
        add(textFieldGameID);
        textFieldGameID.setColumns(10);

        //opretter,giver attributter og adder home knap
        btnBack = new JButton();
        btnBack.setIcon(new ImageIcon(DeleteGameScreen.class.getResource("/Resources/BackButton.png")));
        btnBack.setBounds(16, 10, 42, 38);
        add(btnBack);

        btnDeleteGame = new JButton("Delete Now");
        btnDeleteGame.setBounds(245, 150, 134, 38);
        add(btnDeleteGame);
    }//metode slut

    public JTextField getTextFieldGameID()
    {
        gameID = textFieldGameID.getText();
        return textFieldGameID;
    }//metode slut

    /**
     * Getter for
     * @return
     */
    public JButton getBtnBack()
    {
        return btnBack;
    }//metode slut

    public JButton getBtnDeleteGame()
    {
        return btnDeleteGame;
    }

    /**
     * opretter actionListernes for dette panel
     * @param l
     */
    public void addActionListener(ActionListener l)
    {
        btnBack.addActionListener(l);
        btnDeleteGame.addActionListener(l);
    }//metode slut
}//klasse slut

