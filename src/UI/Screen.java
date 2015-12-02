package UI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * @author alexanderlindkjaer
 *Denne klasse er det Jframe der indeholder alle de andre panels. alt skærm trafikken samles og går igennem denne klasse
 */
public class Screen extends JFrame
{
    //Tilegener ID
    public static final String LOGINSCREEN = "name_1";
    public static final String MENUSCREEN = "name_2";
    public static final String CREATEGAMESCREEN = "name_3";
    public static final String HIGHSCORESCREEN = "name_4";
    public static final String DELETEGAMESCREEN = "name_5";

    //instantiere variabler
    public LoginScreen loginScreen;
    public MenuScreen menuScreen;
    public CreateGameScreen createGameScreen;
    public HighScoreScreen highScoreScreen;
    public DeleteGameScreen deleteGameScreen;

    private CardLayout c;
    private JPanel contentPane;

    /**
     * create the frame
     */
    public Screen()
    {
        //setter atributter
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 529, 475);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(62, 77, 86));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        //layout sættes til cardlayout
        contentPane.setLayout(new CardLayout(0, 0));

        //adder alle panels til dette contentpane

        loginScreen = new LoginScreen();
        contentPane.add(loginScreen, LOGINSCREEN);

        menuScreen = new MenuScreen();
        contentPane.add(menuScreen,MENUSCREEN);

        createGameScreen = new CreateGameScreen();
        contentPane.add(createGameScreen,CREATEGAMESCREEN);

        highScoreScreen = new HighScoreScreen();
        contentPane.add(highScoreScreen,HIGHSCORESCREEN);

        deleteGameScreen = new DeleteGameScreen();
        contentPane.add(deleteGameScreen,DELETEGAMESCREEN);

        c = (CardLayout) getContentPane().getLayout();

    }//metode slut

    /**
     * denne metode sender de forskellige cards til framet.
     * @param card
     */
    public void show(String card)
    {
        c.show(this.getContentPane(), card);
    }//metode slut

    /**
     * Getter for login
     * @return login
     */
    public LoginScreen getLogin()
    {
        return loginScreen;
    }//metode slut

    /**
     * Getter for userMenu
     * @return userMenu
     */
    public MenuScreen getMenuScreen()
    {
        return menuScreen;
    }//metode slut

    /**
     * Getter for createGameScreen
     * @return createGameScreen
     */
    public CreateGameScreen getCreateGameScreen()
    {
        return createGameScreen;
    }//metode slut

    /**
     * Getter for highScoreScreen
     * @return highScoreScreen
     */
    public HighScoreScreen getHighScoreScreen()
    {
        return highScoreScreen;
    }//metode slut

    /**
     * Getter for deleteGameScreen
     * @return deleteGameScreen
     */
    public DeleteGameScreen getDeleteGameScreen()
    {
        return deleteGameScreen;
    }//metode slut


}//klasse slut
