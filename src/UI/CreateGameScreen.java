package UI;

/**
 * Created by ejer on 30/11/15.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CreateGameScreen extends JPanel
{
    //instantiere variabler
    private JLabel lblCreateGame;
    private JLabel lblGameName;
    private JButton btnBack;
    private JLabel lblControls;
    private JTextField textFieldGameName;
    private JTextField textFieldControls;
    private JLabel lblInstructions;
    private JButton btnStartGameNow;

    private String gameName;
    private String controls;
    private JLabel lblGameWasCreated;

    public CreateGameScreen()
    {
        setLayout(null);
        setBackground(new Color(0, 102, 0));
        setBounds(100, 100, 529, 475);

        //opretter,giver attributter og adder transfer label
        lblCreateGame = new JLabel("Create Game");
        lblCreateGame.setForeground(Color.WHITE);
        lblCreateGame.setHorizontalAlignment(SwingConstants.CENTER);
        lblCreateGame.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        lblCreateGame.setBounds(167, 10, 200, 50);
        add(lblCreateGame);

        //opretter,giver attributter og adder users label
        lblGameName = new JLabel("Game name: ");
        lblGameName.setForeground(Color.WHITE);
        lblGameName.setBounds(123, 84, 89, 16);
        add(lblGameName);

        //opretter,giver attributter og adder home knap
        btnBack = new JButton();
        btnBack.setIcon(new ImageIcon(CreateGameScreen.class.getResource("/Resources/BackButton.png")));
        btnBack.setBounds(31, 23, 40, 40);
        add(btnBack);

        lblControls = new JLabel("Enter controls:");
        lblControls.setForeground(Color.WHITE);
        lblControls.setBounds(123, 356, 118, 16);
        add(lblControls);

        textFieldGameName = new JTextField();
        textFieldGameName.setBounds(253, 82, 134, 28);
        add(textFieldGameName);
        textFieldGameName.setColumns(10);

        textFieldControls = new JTextField();
        textFieldControls.setBounds(253, 354, 134, 28);
        add(textFieldControls);
        textFieldControls.setColumns(10);

        lblInstructions = new JLabel("");
        //lblNewLabel.setIcon(new ImageIcon(CreateGameScreen.class.getResource("/Resources/control.png")));
        lblInstructions.setIcon(new ImageIcon(CreateGameScreen.class.getResource("/Resources/control.png")));
        lblInstructions.setBounds(180, 122, 288, 208);
        add(lblInstructions);

        btnStartGameNow = new JButton("Start game now");
        btnStartGameNow.setBounds(253, 406, 132, 28);
        add(btnStartGameNow);

        lblGameWasCreated = new JLabel("Game was created!");
        lblGameWasCreated.setForeground(new Color(255, 255, 0));
        lblGameWasCreated.setBounds(263, 378, 134, 16);
        lblGameWasCreated.setVisible(false);
        add(lblGameWasCreated);

    }//metode slut

    /**
     * Getter for btnHome
     * @return btnHome
     */
    public JButton getBtnStartGameNow()
    {
        return btnStartGameNow;
    }

    public JButton getBtnBack()
    {
        return btnBack;
    }//metode slut

    public void setLblCreateGame(JLabel lblCreateGame) {
        this.lblCreateGame = lblCreateGame;
    }

    public JLabel getLblCreateGame() {
        return lblCreateGame;
    }

    public JLabel getLblGameWasCreated() {
        return lblGameWasCreated;
    }

    public JTextField getGameName()
    {

        return textFieldGameName;
    }

    public JTextField getControls()
    {
        return textFieldControls;
    }

    public void addActionListener(ActionListener l)
    {
        btnStartGameNow.addActionListener(l);
        btnBack.addActionListener(l);
    }

}//klasse slut

