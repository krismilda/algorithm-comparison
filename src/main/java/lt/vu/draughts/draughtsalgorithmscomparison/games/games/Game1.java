package lt.vu.draughts.draughtsalgorithmscomparison.games.games;

import lt.vu.draughts.draughtsalgorithmscomparison.games.Game;
import lt.vu.draughts.draughtsalgorithmscomparison.games.GameMove;
import org.springframework.stereotype.Component;

@Component
public class Game1 {

    public Game returnGame(){

        Game game = new Game();
        GameMove gameMove1 = new GameMove();
        gameMove1.setCurrentPosition(
                new int[][]{
                        {6, 2, 6, 2, 6, 2, 6, 2},
                        {2, 6, 2, 6, 2, 6, 2, 6},
                        {6, 2, 6, 2, 6, 2, 6, 2},
                        {5, 6, 5, 6, 5, 6, 5, 6},
                        {6, 5, 6, 5, 6, 5, 6, 5},
                        {1, 6, 1, 6, 1, 6, 1, 6},
                        {6, 1, 6, 1, 6, 1, 6, 1},
                        {1, 6, 1, 6, 1, 6, 1, 6}
                }
        );
        game.getPositions().add(gameMove1);
        GameMove gameMove2 = new GameMove();
        gameMove2.getMoves().add("c3-d4");
        gameMove2.setCurrentPosition(
                new int[][]{
                        {6, 2, 6, 2, 6, 2, 6, 2},
                        {2, 6, 2, 6, 2, 6, 2, 6},
                        {6, 2, 6, 2, 6, 2, 6, 2},
                        {5, 6, 5, 6, 5, 6, 5, 6},
                        {6, 5, 6, 1, 6, 5, 6, 5},
                        {1, 6, 5, 6, 1, 6, 1, 6},
                        {6, 1, 6, 1, 6, 1, 6, 1},
                        {1, 6, 1, 6, 1, 6, 1, 6}
                }
        );
        game.getPositions().add(gameMove2);
        GameMove gameMove3 = new GameMove();
        gameMove3.getMoves().add("b6-a5");
        gameMove3.setCurrentPosition(
                new int[][]{
                        {6, 2, 6, 2, 6, 2, 6, 2},
                        {2, 6, 2, 6, 2, 6, 2, 6},
                        {6, 5, 6, 2, 6, 2, 6, 2},
                        {2, 6, 5, 6, 5, 6, 5, 6},
                        {6, 5, 6, 1, 6, 5, 6, 5},
                        {1, 6, 5, 6, 1, 6, 1, 6},
                        {6, 1, 6, 1, 6, 1, 6, 1},
                        {1, 6, 1, 6, 1, 6, 1, 6}
                }
        );
        game.getPositions().add(gameMove3);
        GameMove gameMove4 = new GameMove();
        gameMove4.getMoves().add("d4-c5");
        gameMove4.setCurrentPosition(
                new int[][]{
                        {6, 2, 6, 2, 6, 2, 6, 2},
                        {2, 6, 2, 6, 2, 6, 2, 6},
                        {6, 5, 6, 2, 6, 2, 6, 2},
                        {2, 6, 1, 6, 5, 6, 5, 6},
                        {6, 5, 6, 5, 6, 5, 6, 5},
                        {1, 6, 5, 6, 1, 6, 1, 6},
                        {6, 1, 6, 1, 6, 1, 6, 1},
                        {1, 6, 1, 6, 1, 6, 1, 6}
                }
        );
        game.getPositions().add(gameMove4);
        GameMove gameMove5 = new GameMove();
        gameMove5.getMoves().add("d6:b4");
        gameMove5.setCurrentPosition(
                new int[][]{
                        {6, 2, 6, 2, 6, 2, 6, 2},
                        {2, 6, 2, 6, 2, 6, 2, 6},
                        {6, 5, 6, 5, 6, 2, 6, 2},
                        {2, 6, 5, 6, 5, 6, 5, 6},
                        {6, 2, 6, 5, 6, 5, 6, 5},
                        {1, 6, 5, 6, 1, 6, 1, 6},
                        {6, 1, 6, 1, 6, 1, 6, 1},
                        {1, 6, 1, 6, 1, 6, 1, 6}
                }
        );
        game.getPositions().add(gameMove5);
        GameMove gameMove6 = new GameMove();
        gameMove6.getMoves().add("a3:c5");
        gameMove6.setCurrentPosition(
                new int[][]{
                        {6, 2, 6, 2, 6, 2, 6, 2},
                        {2, 6, 2, 6, 2, 6, 2, 6},
                        {6, 5, 6, 5, 6, 2, 6, 2},
                        {2, 6, 1, 6, 5, 6, 5, 6},
                        {6, 5, 6, 5, 6, 5, 6, 5},
                        {5, 6, 5, 6, 1, 6, 1, 6},
                        {6, 1, 6, 1, 6, 1, 6, 1},
                        {1, 6, 1, 6, 1, 6, 1, 6}
                }
        );
        game.getPositions().add(gameMove6);
        GameMove gameMove7 = new GameMove();
        gameMove7.getMoves().add("f6-g5");
        gameMove7.setCurrentPosition(
                new int[][]{
                        {6, 2, 6, 2, 6, 2, 6, 2},
                        {2, 6, 2, 6, 2, 6, 2, 6},
                        {6, 5, 6, 5, 6, 5, 6, 2},
                        {2, 6, 1, 6, 5, 6, 2, 6},
                        {6, 5, 6, 5, 6, 5, 6, 5},
                        {5, 6, 5, 6, 1, 6, 1, 6},
                        {6, 1, 6, 1, 6, 1, 6, 1},
                        {1, 6, 1, 6, 1, 6, 1, 6}
                }
        );
        game.getPositions().add(gameMove7);
        GameMove gameMove8 = new GameMove();
        gameMove8.getMoves().add("e3-d4");
        gameMove8.setCurrentPosition(
                new int[][]{
                        {6, 2, 6, 2, 6, 2, 6, 2},
                        {2, 6, 2, 6, 2, 6, 2, 6},
                        {6, 5, 6, 5, 6, 5, 6, 2},
                        {2, 6, 1, 6, 5, 6, 2, 6},
                        {6, 5, 6, 1, 6, 5, 6, 5},
                        {5, 6, 5, 6, 5, 6, 1, 6},
                        {6, 1, 6, 1, 6, 1, 6, 1},
                        {1, 6, 1, 6, 1, 6, 1, 6}
                }
        );
        game.getPositions().add(gameMove8);
        GameMove gameMove9 = new GameMove();
        gameMove9.getMoves().add("g5-h4");
        gameMove9.setCurrentPosition(
                new int[][]{
                        {6, 2, 6, 2, 6, 2, 6, 2},
                        {2, 6, 2, 6, 2, 6, 2, 6},
                        {6, 5, 6, 5, 6, 5, 6, 2},
                        {2, 6, 1, 6, 5, 6, 5, 6},
                        {6, 5, 6, 1, 6, 5, 6, 2},
                        {5, 6, 5, 6, 5, 6, 1, 6},
                        {6, 1, 6, 1, 6, 1, 6, 1},
                        {1, 6, 1, 6, 1, 6, 1, 6}
                }
        );
        game.getPositions().add(gameMove9);
        GameMove gameMove10 = new GameMove();
        gameMove10.getMoves().add("g3-f4");
        gameMove10.setCurrentPosition(
                new int[][]{
                        {6, 2, 6, 2, 6, 2, 6, 2},
                        {2, 6, 2, 6, 2, 6, 2, 6},
                        {6, 5, 6, 5, 6, 5, 6, 2},
                        {2, 6, 1, 6, 5, 6, 5, 6},
                        {6, 5, 6, 1, 6, 1, 6, 2},
                        {5, 6, 5, 6, 5, 6, 5, 6},
                        {6, 1, 6, 1, 6, 1, 6, 1},
                        {1, 6, 1, 6, 1, 6, 1, 6}
                }
        );
        game.getPositions().add(gameMove10);
        GameMove gameMove11 = new GameMove();
        gameMove11.getMoves().add("g7-f6");
        gameMove11.setCurrentPosition(
                new int[][]{
                        {6, 2, 6, 2, 6, 2, 6, 2},
                        {2, 6, 2, 6, 2, 6, 5, 6},
                        {6, 5, 6, 5, 6, 2, 6, 2},
                        {2, 6, 1, 6, 5, 6, 5, 6},
                        {6, 5, 6, 1, 6, 1, 6, 2},
                        {5, 6, 5, 6, 5, 6, 5, 6},
                        {6, 1, 6, 1, 6, 1, 6, 1},
                        {1, 6, 1, 6, 1, 6, 1, 6}
                }
        );
        game.getPositions().add(gameMove11);
        GameMove gameMove12 = new GameMove();
        gameMove12.getMoves().add("f4-g5");
        gameMove12.setCurrentPosition(
                new int[][]{
                        {6, 2, 6, 2, 6, 2, 6, 2},
                        {2, 6, 2, 6, 2, 6, 5, 6},
                        {6, 5, 6, 5, 6, 2, 6, 2},
                        {2, 6, 1, 6, 5, 6, 1, 6},
                        {6, 5, 6, 1, 6, 5, 6, 2},
                        {5, 6, 5, 6, 5, 6, 5, 6},
                        {6, 1, 6, 1, 6, 1, 6, 1},
                        {1, 6, 1, 6, 1, 6, 1, 6}
                }
        );
        game.getPositions().add(gameMove12);
        GameMove gameMove13 = new GameMove();
        gameMove13.getMoves().add("h6:f4");
        gameMove13.setCurrentPosition(
                new int[][]{
                        {6, 2, 6, 2, 6, 2, 6, 2},
                        {2, 6, 2, 6, 2, 6, 5, 6},
                        {6, 5, 6, 5, 6, 2, 6, 5},
                        {2, 6, 1, 6, 5, 6, 5, 6},
                        {6, 5, 6, 1, 6, 2, 6, 2},
                        {5, 6, 5, 6, 5, 6, 5, 6},
                        {6, 1, 6, 1, 6, 1, 6, 1},
                        {1, 6, 1, 6, 1, 6, 1, 6}
                }
        );
        game.getPositions().add(gameMove13);
        GameMove gameMove14 = new GameMove();
        gameMove14.getMoves().add("f2-g3");
        gameMove14.setCurrentPosition(
                new int[][]{
                        {6, 2, 6, 2, 6, 2, 6, 2},
                        {2, 6, 2, 6, 2, 6, 5, 6},
                        {6, 5, 6, 5, 6, 2, 6, 5},
                        {2, 6, 1, 6, 5, 6, 5, 6},
                        {6, 5, 6, 1, 6, 2, 6, 2},
                        {5, 6, 5, 6, 5, 6, 1, 6},
                        {6, 1, 6, 1, 6, 5, 6, 1},
                        {1, 6, 1, 6, 1, 6, 1, 6}
                }
        );
        game.getPositions().add(gameMove14);
        GameMove gameMove15 = new GameMove();
        gameMove15.getMoves().add("h4:f2");
        gameMove15.setCurrentPosition(
                new int[][]{
                        {6, 2, 6, 2, 6, 2, 6, 2},
                        {2, 6, 2, 6, 2, 6, 5, 6},
                        {6, 5, 6, 5, 6, 2, 6, 5},
                        {2, 6, 1, 6, 5, 6, 5, 6},
                        {6, 5, 6, 1, 6, 2, 6, 5},
                        {5, 6, 5, 6, 5, 6, 5, 6},
                        {6, 1, 6, 1, 6, 2, 6, 1},
                        {1, 6, 1, 6, 1, 6, 1, 6}
                }
        );
        game.getPositions().add(gameMove15);
        GameMove gameMove16 = new GameMove();
        gameMove16.getMoves().add("e1:g3:e5:g7");
        gameMove16.setCurrentPosition(
                new int[][]{
                        {6, 2, 6, 2, 6, 2, 6, 2},
                        {2, 6, 2, 6, 2, 6, 1, 6},
                        {6, 5, 6, 5, 6, 5, 6, 5},
                        {2, 6, 1, 6, 5, 6, 5, 6},
                        {6, 5, 6, 1, 6, 5, 6, 5},
                        {5, 6, 5, 6, 5, 6, 5, 6},
                        {6, 1, 6, 1, 6, 5, 6, 1},
                        {1, 6, 1, 6, 5, 6, 1, 6}
                }
        );
        game.getPositions().add(gameMove16);
        GameMove gameMove17 = new GameMove();
        gameMove17.getMoves().add("h8:f6");
        gameMove17.setCurrentPosition(
                new int[][]{
                        {6, 2, 6, 2, 6, 2, 6, 5},
                        {2, 6, 2, 6, 2, 6, 5, 6},
                        {6, 5, 6, 5, 6, 2, 6, 5},
                        {2, 6, 1, 6, 5, 6, 5, 6},
                        {6, 5, 6, 1, 6, 5, 6, 5},
                        {5, 6, 5, 6, 5, 6, 5, 6},
                        {6, 1, 6, 1, 6, 5, 6, 1},
                        {1, 6, 1, 6, 5, 6, 1, 6}
                }
        );
        game.getPositions().add(gameMove17);
        GameMove gameMove18 = new GameMove();
        gameMove18.getMoves().add("h2-g3");
        gameMove18.setCurrentPosition(
                new int[][]{
                        {6, 2, 6, 2, 6, 2, 6, 5},
                        {2, 6, 2, 6, 2, 6, 5, 6},
                        {6, 5, 6, 5, 6, 2, 6, 5},
                        {2, 6, 1, 6, 5, 6, 5, 6},
                        {6, 5, 6, 1, 6, 5, 6, 5},
                        {5, 6, 5, 6, 5, 6, 1, 6},
                        {6, 1, 6, 1, 6, 5, 6, 5},
                        {1, 6, 1, 6, 5, 6, 1, 6}
                }
        );
        game.getPositions().add(gameMove18);
        GameMove gameMove19 = new GameMove();
        gameMove19.getMoves().add("f8-g7");
        gameMove19.setCurrentPosition(
                new int[][]{
                        {6, 2, 6, 2, 6, 5, 6, 5},
                        {2, 6, 2, 6, 2, 6, 2, 6},
                        {6, 5, 6, 5, 6, 2, 6, 5},
                        {2, 6, 1, 6, 5, 6, 5, 6},
                        {6, 5, 6, 1, 6, 5, 6, 5},
                        {5, 6, 5, 6, 5, 6, 1, 6},
                        {6, 1, 6, 1, 6, 5, 6, 5},
                        {1, 6, 1, 6, 5, 6, 1, 6}
                }
        );
        game.getPositions().add(gameMove19);
        GameMove gameMove20 = new GameMove();
        gameMove20.getMoves().add("g3-f4");
        gameMove20.setCurrentPosition(
                new int[][]{
                        {6, 2, 6, 2, 6, 5, 6, 5},
                        {2, 6, 2, 6, 2, 6, 2, 6},
                        {6, 5, 6, 5, 6, 2, 6, 5},
                        {2, 6, 1, 6, 5, 6, 5, 6},
                        {6, 5, 6, 1, 6, 1, 6, 5},
                        {5, 6, 5, 6, 5, 6, 5, 6},
                        {6, 1, 6, 1, 6, 5, 6, 5},
                        {1, 6, 1, 6, 5, 6, 1, 6}
                }
        );
        game.getPositions().add(gameMove20);
        GameMove gameMove21 = new GameMove();
        gameMove21.getMoves().add("f6-g5");
        gameMove21.setCurrentPosition(
                new int[][]{
                        {6, 2, 6, 2, 6, 5, 6, 5},
                        {2, 6, 2, 6, 2, 6, 2, 6},
                        {6, 5, 6, 5, 6, 5, 6, 5},
                        {2, 6, 1, 6, 5, 6, 2, 6},
                        {6, 5, 6, 1, 6, 1, 6, 5},
                        {5, 6, 5, 6, 5, 6, 5, 6},
                        {6, 1, 6, 1, 6, 5, 6, 5},
                        {1, 6, 1, 6, 5, 6, 1, 6}
                }
        );
        game.getPositions().add(gameMove21);
        GameMove gameMove22 = new GameMove();
        gameMove22.getMoves().add("f4:h6:f8:d6");
        gameMove22.setCurrentPosition(
                new int[][]{
                        {6, 2, 6, 2, 6, 5, 6, 5},
                        {2, 6, 2, 6, 5, 6, 5, 6},
                        {6, 5, 6, 3, 6, 5, 6, 5},
                        {2, 6, 1, 6, 5, 6, 5, 6},
                        {6, 5, 6, 1, 6, 5, 6, 5},
                        {5, 6, 5, 6, 5, 6, 5, 6},
                        {6, 1, 6, 1, 6, 5, 6, 5},
                        {1, 6, 1, 6, 5, 6, 1, 6}
                }
        );
        game.getPositions().add(gameMove22);
        GameMove gameMove23 = new GameMove();
        gameMove23.getMoves().add("c7:e5:c3:e1");
        gameMove23.setCurrentPosition(
                new int[][]{
                        {6, 2, 6, 2, 6, 5, 6, 5},
                        {2, 6, 5, 6, 5, 6, 5, 6},
                        {6, 5, 6, 5, 6, 5, 6, 5},
                        {2, 6, 1, 6, 5, 6, 5, 6},
                        {6, 5, 6, 5, 6, 5, 6, 5},
                        {5, 6, 5, 6, 5, 6, 5, 6},
                        {6, 1, 6, 5, 6, 5, 6, 5},
                        {1, 6, 1, 6, 4, 6, 1, 6}
                }
        );
        game.getPositions().add(gameMove23);
        return game;
    }
}
