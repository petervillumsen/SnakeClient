package Logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import UI.Screen;
import sdk.Logic;

public class LogicController
{
    public Screen screen;

    Logic logic = new Logic();
    /**
     * kontruktør. laver objekt af database og screen.
     */
    public LogicController()
    {
        screen = new Screen();
        screen.setVisible(true);
    }//konstruktør slut

    /**
     * metoden Main klassen kalder for at starte programmet
     */
    public void run()
    {
        // injection af listeners i panels
        screen.loginScreen.addActionListener(new LoginActionListener());
        screen.menuScreen.addActionListener(new MenuScreenActionListener());
        screen.createGameScreen.addActionListener(new CreateGameScreenActionListener());
        screen.joinGameScreen.addActionListener(new JoinGameScreenActionListener());
        screen.deleteGameScreen.addActionListener(new DeleteGameScreenActionListener());
        screen.highScoreScreen.addActionListener(new HighScoreScreenActionListener());

        // vis startskaerm
        screen.show(Screen.LOGINSCREEN);
    }


    private class LoginActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String username = screen.getLogin().getTxtUsername();
            String password = screen.getLogin().getTxtPassword();

            //der trykked på login knap
            if (e.getSource() == screen.getLogin().getBtnLogin())
            {
                screen.getLogin().getLblError().setVisible(true);
                if(logic.login(username,password)) {
                    screen.show(Screen.MENUSCREEN);

                }else{
                    screen.getLogin().getLblError().setVisible(true);
                }
            }
        }//if listener slut
    }//actionPerformed slut

    private class MenuScreenActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            // TODO Auto-generated method stub
            if(e.getSource() == screen.getMenuScreen().getBtnCreateGame())
            {
                screen.show(Screen.CREATEGAMESCREEN);
            }
            if(e.getSource() == screen.getMenuScreen().getBtnJoinGame())
            {
                screen.show(Screen.JOINGAMESCREEN);
            }
            if(e.getSource() == screen.getMenuScreen().getBtnDeleteGame())
            {
                screen.show(Screen.DELETEGAMESCREEN);
            }
            if(e.getSource() == screen.getMenuScreen().getBtnHighScores())
            {
                screen.show(Screen.HIGHSCORESCREEN);
            }
            if(e.getSource() == screen.getMenuScreen().getBtnLogout())
            {
                screen.show(Screen.LOGINSCREEN);
            }
        }
    }

    private class CreateGameScreenActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {

            String gameName = screen.createGameScreen.getGameName();
            String moves = screen.createGameScreen.getControls();

            // TODO Auto-generated method stub
            if(e.getSource() == screen.getCreateGameScreen().getBtnBack())
            {
                screen.show(Screen.MENUSCREEN);
            }

            if(e.getSource() == screen.getCreateGameScreen().getBtnStartGameNow())
            {
                if(logic.createGame(gameName,moves)) {
                    screen.getCreateGameScreen().getLblCreateGame().setVisible(true);

                }else {

                    screen.getCreateGameScreen().getLblCreateGame().setVisible(false);

                }

            }
        }
    }

    private class JoinGameScreenActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            // TODO Auto-generated method stub
            if(e.getSource() == screen.getJoinGameScreen().getBtnBack())
            {
                screen.show(Screen.MENUSCREEN);
            }

            if(e.getSource() == screen.getJoinGameScreen().getBtnJoin())
            {
                //SKAL ÆNDRES TIL WHAT EVER Join GAME ER!!!
                screen.show(Screen.MENUSCREEN);
            }
        }
    }

    private class DeleteGameScreenActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            // TODO Auto-generated method stub
            if(e.getSource() == screen.getDeleteGameScreen().getBtnBack())
            {
                screen.show(Screen.MENUSCREEN);
            }
            if(e.getSource() == screen.getDeleteGameScreen().getBtnDeleteGame())
            {
                //SKAL ÆNDRES TIL WHAT EVER START GAME ER!!!
                screen.show(Screen.MENUSCREEN);
            }
        }
    }

    private class HighScoreScreenActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            // TODO Auto-generated method stub
            if(e.getSource() == screen.getHighScoreScreen().getBtnBack())
            {
                screen.show(Screen.MENUSCREEN);
            }
        }
    }
}//inner class slit



   








