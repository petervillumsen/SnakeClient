package Logic;

import UI.Screen;
import sdk.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;





public class LogicController
{
    public Screen screen;
    //public User currentUser;
    public Logic logic;

    //Logic logic = new Logic();
    /**
     * kontruktør. laver objekt af database og screen.
     */
    public LogicController()
    {
        //currentUser = new User();
        screen = new Screen();
        screen.setVisible(true);
        logic = new Logic();
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
            String password = screen.getLogin().getTxtPassword().getText();
            String username = screen.getLogin().getTxtUsername().getText();

            //der trykked på login knap
            if (e.getSource() == screen.getLogin().getBtnLogin())
            {
                screen.getLogin().getLblError().setVisible(false);
                if(logic.login(username, password)) {
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
                System.out.print("Når der klikkes fra menu " + logic.getCurrentUser().getId());
                screen.show(Screen.JOINGAMESCREEN);
            }
            if(e.getSource() == screen.getMenuScreen().getBtnDeleteGame())
            {
                screen.show(Screen.DELETEGAMESCREEN);
            }
            if(e.getSource() == screen.getMenuScreen().getBtnHighScores())
            {
                screen.show(Screen.HIGHSCORESCREEN);
                ArrayList<Score> highScores = logic.getHighScore();
                HighScoreTableModel highScoreTableModel = new HighScoreTableModel(highScores);
                screen.getHighScoreScreen().getTable().setModel(highScoreTableModel);

            }
            if(e.getSource() == screen.getMenuScreen().getBtnLogout())
            {
                screen.show(Screen.LOGINSCREEN);
                screen.getLogin().getTxtPassword().setText("");
                screen.getLogin().getTxtUsername().setText("");
            }
        }
    }

    private class CreateGameScreenActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {

            String gameName = screen.createGameScreen.getGameName().getText();
            String moves = screen.createGameScreen.getControls().getText();

            // TODO Auto-generated method stub
            if(e.getSource() == screen.getCreateGameScreen().getBtnBack())
            {
                screen.getCreateGameScreen().getControls().setText("");
                screen.getCreateGameScreen().getGameName().setText("");
                screen.show(Screen.MENUSCREEN);
            }

            if(e.getSource() == screen.getCreateGameScreen().getBtnStartGameNow())
            {
                if(logic.createGame(gameName, moves)) {


                }else {


                }

            }
        }
    }

    private class JoinGameScreenActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {

            if(e.getSource() == screen.getJoinGameScreen().getBtnBack())
            {
                screen.getJoinGameScreen().getTextGameId().setText("");
                screen.getJoinGameScreen().getLblError().setVisible(false);
                screen.getJoinGameScreen().getLblNoControls().setVisible(false);
                screen.getJoinGameScreen().getLblGameJoined().setVisible(false);
                screen.show(Screen.MENUSCREEN);
            }

            //If the join game button is pressed
            if (e.getSource() == screen.getJoinGameScreen().getBtnJoin())
            {
                //If statement to check if there is an empty text field
                if(screen.getJoinGameScreen().getTextGameId().getText().equals("")
                        ||screen.getJoinGameScreen().getTextFieldEnterControls().getText().equals(""))
                {
                    //If there is an empty field an error label will show
                    screen.getJoinGameScreen().getLblNoControls().setVisible(true);
                    screen.getJoinGameScreen().getLblError().setVisible(false);
                    screen.getJoinGameScreen().getLblGameJoined().setVisible(false);
                }
                else
                {
                    //Saves the moves of the user
                    String moves = screen.getJoinGameScreen().getTextFieldEnterControls().getText();

                    //Creates a gamer opponent with id and controls of the currentUser
                    System.out.print(logic.getCurrentUser().getId());
                    Gamer opponent = new Gamer();
                    opponent.setId(logic.getCurrentUser().getId());
                    opponent.setControls(moves);

                    //Creates an object of game and sets the opponent and his controls.
                    Game game = new Game();
                    game.setOpponent(opponent);

                    //Searches for a game by the game name typed by the user
                    for (Game g : logic.openGames())
                    {
                        //For loop for finding an open game with the name that the user has entered
                        if (g.getName().equals(screen.getJoinGameScreen().getTextGameId().getText()))
                        {
                            game.setGameId(g.getGameId());
                        }
                    }
                    int response = logic.joinGame(game);
                    //If statement to check the response code from the server
                    if (response == 201)
                    {
                        //Starts the game
                        logic.startGame(game);
                        //If the game has been joined a confirm label will show
                        screen.getJoinGameScreen().getLblGameJoined().setVisible(true);
                        screen.getJoinGameScreen().getLblError().setVisible(false);
                        screen.getJoinGameScreen().getLblNoControls().setVisible(false);
                    } else if (response == 400)
                    {
                        //If the game was not joined an error label will show
                        screen.getJoinGameScreen().getLblError().setVisible(true);
                        screen.getJoinGameScreen().getLblGameJoined().setVisible(false);
                        screen.getJoinGameScreen().getLblNoControls().setVisible(false);
                    }
                }
            }
        }
    }

    private class DeleteGameScreenActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            if(e.getSource() == screen.getDeleteGameScreen().getBtnBack())
            {
                screen.show(Screen.MENUSCREEN);
                screen.getDeleteGameScreen().getLblGameDeleted().setVisible(false);
                screen.getDeleteGameScreen().getLblWrongInput().setVisible(false);
                screen.getDeleteGameScreen().getTextFieldGameID().setText("");
            }
            try {
                if (e.getSource() == screen.getDeleteGameScreen().getBtnDeleteGame())
                {
                    int gameId=Integer.parseInt(screen.getDeleteGameScreen().getTextFieldGameID().getText());
                    int response = logic.deleteGame(gameId);
                    if (response == 200)
                    {
                        screen.getDeleteGameScreen().getLblGameDeleted().setVisible(true);
                        screen.getDeleteGameScreen().getLblWrongInput().setVisible(false);
                    }
                    else if (response == 400)
                    {
                        screen.getDeleteGameScreen().getLblGameDeleted().setVisible(false);
                        screen.getDeleteGameScreen().getLblWrongInput().setVisible(true);
                    }
                }
            } catch (Exception error)
            {
                screen.getDeleteGameScreen().getLblGameDeleted().setVisible(false);
                screen.getDeleteGameScreen().getLblWrongInput().setVisible(true);
            }
        }
    }

    private class HighScoreScreenActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            if (e.getSource() == screen.getHighScoreScreen().getBtnBack()) {
                screen.show(Screen.MENUSCREEN);
            }
        }
    }

    public class HighScoreTableModel extends AbstractTableModel
    {
        private static final long serialVersionUID = 1l;
        private ArrayList<Score> highScores;
        private String[] columns = {"Username", "Score"};
        private int numberOfRows;


    public HighScoreTableModel(ArrayList<Score> highScores)
    {
        this.highScores = highScores;
        fireTableStructureChanged();
    }
        @Override
        public int getColumnCount()
        {
            return columns.length;
        }
        @Override
        public Class <?> getColumnClass(int columnIndex)
        {
            return super.getColumnClass(columnIndex);
        }

        @Override
        public  int getRowCount()
        {
            numberOfRows = highScores.size();
            return numberOfRows;
        }
        public String getColumnName(int columnIndex)
        {
            return columns[columnIndex];
        }

        @Override
        public Object getValueAt (int rowIndex, int columnIndex)
        {
            switch (columnIndex)
            {
                case 0 :
                    return highScores.get(rowIndex).getGame().getWinner().getUsername();
                case 1 :
                    return highScores.get(rowIndex).getScore();
            }
            return null;
        }
    }



}//inner class slit



   








