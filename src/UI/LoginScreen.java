package UI;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

/**
 * @author Peter
 *Panel for login screen
 *extends JPanel
 */
public class LoginScreen extends JPanel
{
    //instantiere variabler
    private JTextField txtUser;
    private JPasswordField txtPassword;
    private JLabel lblLogin;
    private JLabel lblPassword;
    private JButton btnLogin;
    private JLabel lblNewLabel;
    private JLabel lblError;
    private JLabel lblLogo;

    private String username;
    private String password;

    /**
     * Create the panel.
     */
    public LoginScreen()
    {
        setBackground(new Color(0, 102, 0));
        setLayout(null);
        setBounds(100, 100, 529, 475);

        //opretter,giver attributter og adder username textfield
        txtUser = new JTextField();
        txtUser.setBounds(129, 269, 266, 28);
        add(txtUser);
        txtUser.setColumns(10);

        //opretter,giver attributter og adder password textfield
        txtPassword = new JPasswordField();
        txtPassword.setColumns(10);
        txtPassword.setBounds(129, 309, 266, 28);
        add(txtPassword);

        //opretter,giver attributter og adder lofin label
        lblLogin = new JLabel("Username:");
        lblLogin.setForeground(Color.WHITE);
        lblLogin.setBounds(43, 266, 85, 34);
        add(lblLogin);

        //opretter,giver attributter og adder password label
        lblPassword = new JLabel("Password:");
        lblPassword.setForeground(Color.WHITE);
        lblPassword.setBounds(43, 306, 85, 34);
        add(lblPassword);

        //opretter,giver attributter og adder login knap
        btnLogin = new JButton("Login");
        btnLogin.setBounds(198, 364, 117, 29);
        add(btnLogin);

        //opretter,giver attributter og adder error label
        lblError = new JLabel("Incorrect Username or Password, please try again");
        lblError.setForeground(new Color(255, 204, 51));
        lblError.setHorizontalAlignment(SwingConstants.CENTER);
        lblError.setBounds(116, 336, 309, 16);
        lblError.setVisible(false);
        add(lblError);

        lblLogo = new JLabel("");
        lblLogo.setIcon(new ImageIcon(LoginScreen.class.getResource("/Resources/Snake.png")));
        lblLogo.setBounds(170, 100, 203, 117);
        add(lblLogo);

    }//metode slut

    /**
     * Getters for btnLogin
     * @return btnLogin
     */

    public JButton getBtnLogin()
    {
        return btnLogin;
    }//metode slut

    /**
     * Getters for txtUser
     * @return txtUser
     */
    public String getTxtUsername()
    {
        username = txtUser.getText();
        return username;
    }//metode slut

    /**
     * Getters for txtPassword
     * @return txtPassword
     */
    public String getTxtPassword()
    {
        password = txtPassword.getText();
        return password;
    }//metode slut

    /**
     * Getters for lblError
     * @return lblError
     */
    public JLabel getLblError()
    {
        return lblError;
    }//metode slut

    /**
     * opretter actionlistener for dette panel
     * @param l
     */
    public void addActionListener(ActionListener l)
    {
        btnLogin.addActionListener(l);
    }//metode slut
}//klasse slut
