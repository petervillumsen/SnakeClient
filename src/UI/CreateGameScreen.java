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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;

public class CreateGameScreen extends JPanel
{
    //instantiere variabler
    private JLabel lblCreateGame;
    private JLabel lblGameName;
    private JButton btnHome;
    private JLabel lblControls;
    private JTextField textField;
    private JTextField textField_1;
    private JLabel lblNewLabel;
    private JButton btnStartGameNow;

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
        btnHome = new JButton();
        btnHome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        try
        {
            Image imgHome = ImageIO.read(getClass().getResource("BackBottom.png"));
            btnHome.setIcon(new ImageIcon(imgHome));
        }
        catch (IOException ex)
        {
        }
        btnHome.setBounds(31, 23, 40, 40);
        add(btnHome);

        //opretter,giver attributter og adder balance label
        lblControls = new JLabel("Enter controls:");
        lblControls.setForeground(Color.WHITE);
        lblControls.setBounds(123, 356, 118, 16);
        add(lblControls);

        textField = new JTextField();
        textField.setBounds(253, 82, 134, 28);
        add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(253, 354, 134, 28);
        add(textField_1);
        textField_1.setColumns(10);

        lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(CreateGameScreen.class.getResource("/control.png")));
        lblNewLabel.setBounds(180, 122, 288, 208);
        add(lblNewLabel);

        btnStartGameNow = new JButton("Start game now");
        btnStartGameNow.setBounds(409, 423, 134, 28);
        add(btnStartGameNow);

    }//metode slut

    /**
     * Getter for btnHome
     * @return btnHome
     */
    public JButton getBtnHome()
    {
        return btnHome;
    }//metode slut
}//klasse slut
