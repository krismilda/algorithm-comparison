package lt.vu.draughts.draughtsalgorithmscomparison.games.games;

import lt.vu.draughts.draughtsalgorithmscomparison.games.Game;
import lt.vu.draughts.draughtsalgorithmscomparison.games.GameMove;
import org.springframework.stereotype.Component;

@Component
public class Game13 {

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
        gameMove3.getMoves().add("d6-c5");
        gameMove3.setCurrentPosition(
                new int[][]{
                        {6, 2, 6, 2, 6, 2, 6, 2},
                        {2, 6, 2, 6, 2, 6, 2, 6},
                        {6, 2, 6, 5, 6, 2, 6, 2},
                        {5, 6, 2, 6, 5, 6, 5, 6},
                        {6, 5, 6, 1, 6, 5, 6, 5},
                        {1, 6, 5, 6, 1, 6, 1, 6},
                        {6, 1, 6, 1, 6, 1, 6, 1},
                        {1, 6, 1, 6, 1, 6, 1, 6}
                }
        );
        game.getPositions().add(gameMove3);
        GameMove gameMove4 = new GameMove();
        gameMove4.getMoves().add("d2-c3");
        gameMove4.setCurrentPosition(
                new int[][]{
                        {6, 2, 6, 2, 6, 2, 6, 2},
                        {2, 6, 2, 6, 2, 6, 2, 6},
                        {6, 2, 6, 5, 6, 2, 6, 2},
                        {5, 6, 2, 6, 5, 6, 5, 6},
                        {6, 5, 6, 1, 6, 5, 6, 5},
                        {1, 6, 1, 6, 1, 6, 1, 6},
                        {6, 1, 6, 5, 6, 1, 6, 1},
                        {1, 6, 1, 6, 1, 6, 1, 6}
                }
        );
        game.getPositions().add(gameMove4);
        GameMove gameMove6 = new GameMove();
        gameMove6.getMoves().add("c7-d6");
        gameMove6.setCurrentPosition(
                new int[][]{
                        {6, 2, 6, 2, 6, 2, 6, 2},
                        {2, 6, 5, 6, 2, 6, 2, 6},
                        {6, 2, 6, 2, 6, 2, 6, 2},
                        {5, 6, 2, 6, 5, 6, 5, 6},
                        {6, 5, 6, 1, 6, 5, 6, 5},
                        {1, 6, 1, 6, 1, 6, 1, 6},
                        {6, 1, 6, 5, 6, 1, 6, 1},
                        {1, 6, 1, 6, 1, 6, 1, 6}
                }
        );
        game.getPositions().add(gameMove6);
        GameMove gameMove7 = new GameMove();
        gameMove7.getMoves().add("c3-b4");
        gameMove7.setCurrentPosition(
                new int[][]{
                        {6, 2, 6, 2, 6, 2, 6, 2},
                        {2, 6, 5, 6, 2, 6, 2, 6},
                        {6, 2, 6, 2, 6, 2, 6, 2},
                        {5, 6, 2, 6, 5, 6, 5, 6},
                        {6, 1, 6, 1, 6, 5, 6, 5},
                        {1, 6, 5, 6, 1, 6, 1, 6},
                        {6, 1, 6, 5, 6, 1, 6, 1},
                        {1, 6, 1, 6, 1, 6, 1, 6}
                }
        );
        game.getPositions().add(gameMove7);
        GameMove gameMove8 = new GameMove();
        gameMove8.getMoves().add("b6-a5");
        gameMove8.setCurrentPosition(
                new int[][]{
                        {6, 2, 6, 2, 6, 2, 6, 2},
                        {2, 6, 5, 6, 2, 6, 2, 6},
                        {6, 5, 6, 2, 6, 2, 6, 2},
                        {2, 6, 2, 6, 5, 6, 5, 6},
                        {6, 1, 6, 1, 6, 5, 6, 5},
                        {1, 6, 5, 6, 1, 6, 1, 6},
                        {6, 1, 6, 5, 6, 1, 6, 1},
                        {1, 6, 1, 6, 1, 6, 1, 6}
                }
        );
        game.getPositions().add(gameMove8);
        GameMove gameMove9 = new GameMove();
        gameMove9.getMoves().add("d4:b6");
        gameMove9.setCurrentPosition(
                new int[][]{
                        {6, 2, 6, 2, 6, 2, 6, 2},
                        {2, 6, 5, 6, 2, 6, 2, 6},
                        {6, 1, 6, 2, 6, 2, 6, 2},
                        {2, 6, 5, 6, 5, 6, 5, 6},
                        {6, 1, 6, 5, 6, 5, 6, 5},
                        {1, 6, 5, 6, 1, 6, 1, 6},
                        {6, 1, 6, 5, 6, 1, 6, 1},
                        {1, 6, 1, 6, 1, 6, 1, 6}
                }
        );
        game.getPositions().add(gameMove9);
        GameMove gameMove10 = new GameMove();
        gameMove10.getMoves().add("a5:c7");
        gameMove10.setCurrentPosition(
                new int[][]{
                        {6, 2, 6, 2, 6, 2, 6, 2},
                        {2, 6, 2, 6, 2, 6, 2, 6},
                        {6, 5, 6, 2, 6, 2, 6, 2},
                        {5, 6, 5, 6, 5, 6, 5, 6},
                        {6, 1, 6, 5, 6, 5, 6, 5},
                        {1, 6, 5, 6, 1, 6, 1, 6},
                        {6, 1, 6, 5, 6, 1, 6, 1},
                        {1, 6, 1, 6, 1, 6, 1, 6}
                }
        );
        game.getPositions().add(gameMove10);
        GameMove gameMove11 = new GameMove();
        gameMove11.getMoves().add("b4-c5");
        gameMove11.setCurrentPosition(
                new int[][]{
                        {6, 2, 6, 2, 6, 2, 6, 2},
                        {2, 6, 2, 6, 2, 6, 2, 6},
                        {6, 5, 6, 2, 6, 2, 6, 2},
                        {5, 6, 1, 6, 5, 6, 5, 6},
                        {6, 5, 6, 5, 6, 5, 6, 5},
                        {1, 6, 5, 6, 1, 6, 1, 6},
                        {6, 1, 6, 5, 6, 1, 6, 1},
                        {1, 6, 1, 6, 1, 6, 1, 6}
                }
        );
        game.getPositions().add(gameMove11);
        GameMove gameMove12 = new GameMove();
        gameMove12.getMoves().add("d6:b4");
        gameMove12.setCurrentPosition(
                new int[][]{
                        {6, 2, 6, 2, 6, 2, 6, 2},
                        {2, 6, 2, 6, 2, 6, 2, 6},
                        {6, 5, 6, 5, 6, 2, 6, 2},
                        {5, 6, 5, 6, 5, 6, 5, 6},
                        {6, 2, 6, 5, 6, 5, 6, 5},
                        {1, 6, 5, 6, 1, 6, 1, 6},
                        {6, 1, 6, 5, 6, 1, 6, 1},
                        {1, 6, 1, 6, 1, 6, 1, 6}
                }
        );
        game.getPositions().add(gameMove12);
        GameMove gameMove13 = new GameMove();
        gameMove13.getMoves().add("a3:c5");
        gameMove13.setCurrentPosition(
                new int[][]{
                        {6, 2, 6, 2, 6, 2, 6, 2},
                        {2, 6, 2, 6, 2, 6, 2, 6},
                        {6, 5, 6, 5, 6, 2, 6, 2},
                        {5, 6, 1, 6, 5, 6, 5, 6},
                        {6, 5, 6, 5, 6, 5, 6, 5},
                        {5, 6, 5, 6, 1, 6, 1, 6},
                        {6, 1, 6, 5, 6, 1, 6, 1},
                        {1, 6, 1, 6, 1, 6, 1, 6}
                }
        );
        game.getPositions().add(gameMove13);
        GameMove gameMove14 = new GameMove();
        gameMove14.getMoves().add("f6-e5");
        gameMove14.setCurrentPosition(
                new int[][]{
                        {6, 2, 6, 2, 6, 2, 6, 2},
                        {2, 6, 2, 6, 2, 6, 2, 6},
                        {6, 5, 6, 5, 6, 5, 6, 2},
                        {5, 6, 1, 6, 2, 6, 5, 6},
                        {6, 5, 6, 5, 6, 5, 6, 5},
                        {5, 6, 5, 6, 1, 6, 1, 6},
                        {6, 1, 6, 5, 6, 1, 6, 1},
                        {1, 6, 1, 6, 1, 6, 1, 6}
                }
        );
        game.getPositions().add(gameMove14);
        GameMove gameMove15 = new GameMove();
        gameMove15.getMoves().add("g3-f4");
        gameMove15.setCurrentPosition(
                new int[][]{
                        {6, 2, 6, 2, 6, 2, 6, 2},
                        {2, 6, 2, 6, 2, 6, 2, 6},
                        {6, 5, 6, 5, 6, 5, 6, 2},
                        {5, 6, 1, 6, 2, 6, 5, 6},
                        {6, 5, 6, 5, 6, 1, 6, 5},
                        {5, 6, 5, 6, 1, 6, 5, 6},
                        {6, 1, 6, 5, 6, 1, 6, 1},
                        {1, 6, 1, 6, 1, 6, 1, 6}
                }
        );
        game.getPositions().add(gameMove15);
        GameMove gameMove16 = new GameMove();
        gameMove16.getMoves().add("e5:g3");
        gameMove16.setCurrentPosition(
                new int[][]{
                        {6, 2, 6, 2, 6, 2, 6, 2},
                        {2, 6, 2, 6, 2, 6, 2, 6},
                        {6, 5, 6, 5, 6, 5, 6, 2},
                        {5, 6, 1, 6, 5, 6, 5, 6},
                        {6, 5, 6, 5, 6, 5, 6, 5},
                        {5, 6, 5, 6, 1, 6, 2, 6},
                        {6, 1, 6, 5, 6, 1, 6, 1},
                        {1, 6, 1, 6, 1, 6, 1, 6}
                }
        );
        game.getPositions().add(gameMove16);
        GameMove gameMove17 = new GameMove();
        gameMove17.getMoves().add("h2:f4");
        gameMove17.setCurrentPosition(
                new int[][]{
                        {6, 2, 6, 2, 6, 2, 6, 2},
                        {2, 6, 2, 6, 2, 6, 2, 6},
                        {6, 5, 6, 5, 6, 5, 6, 2},
                        {5, 6, 1, 6, 5, 6, 5, 6},
                        {6, 5, 6, 5, 6, 1, 6, 5},
                        {5, 6, 5, 6, 1, 6, 5, 6},
                        {6, 1, 6, 5, 6, 1, 6, 5},
                        {1, 6, 1, 6, 1, 6, 1, 6}
                }
        );
        game.getPositions().add(gameMove17);
        GameMove gameMove18 = new GameMove();
        gameMove18.getMoves().add("g7-f6");
        gameMove18.setCurrentPosition(
                new int[][]{
                        {6, 2, 6, 2, 6, 2, 6, 2},
                        {2, 6, 2, 6, 2, 6, 5, 6},
                        {6, 5, 6, 5, 6, 2, 6, 2},
                        {5, 6, 1, 6, 5, 6, 5, 6},
                        {6, 5, 6, 5, 6, 1, 6, 5},
                        {5, 6, 5, 6, 1, 6, 5, 6},
                        {6, 1, 6, 5, 6, 1, 6, 5},
                        {1, 6, 1, 6, 1, 6, 1, 6}
                }
        );
        game.getPositions().add(gameMove18);
        GameMove gameMove19 = new GameMove();
        gameMove19.getMoves().add("b2-c3");
        gameMove19.setCurrentPosition(
                new int[][]{
                        {6, 2, 6, 2, 6, 2, 6, 2},
                        {2, 6, 2, 6, 2, 6, 5, 6},
                        {6, 5, 6, 5, 6, 2, 6, 2},
                        {5, 6, 1, 6, 5, 6, 5, 6},
                        {6, 5, 6, 5, 6, 1, 6, 5},
                        {5, 6, 1, 6, 1, 6, 5, 6},
                        {6, 5, 6, 5, 6, 1, 6, 5},
                        {1, 6, 1, 6, 1, 6, 1, 6}
                }
        );
        game.getPositions().add(gameMove19);
        GameMove gameMove20 = new GameMove();
        gameMove20.getMoves().add("f6-e5");
        gameMove20.setCurrentPosition(
                new int[][]{
                        {6, 2, 6, 2, 6, 2, 6, 2},
                        {2, 6, 2, 6, 2, 6, 5, 6},
                        {6, 5, 6, 5, 6, 5, 6, 2},
                        {5, 6, 1, 6, 2, 6, 5, 6},
                        {6, 5, 6, 5, 6, 1, 6, 5},
                        {5, 6, 1, 6, 1, 6, 5, 6},
                        {6, 5, 6, 5, 6, 1, 6, 5},
                        {1, 6, 1, 6, 1, 6, 1, 6}
                }
        );
        game.getPositions().add(gameMove20);
        GameMove gameMove21 = new GameMove();
        gameMove21.getMoves().add("f4:d6");
        gameMove21.setCurrentPosition(
                new int[][]{
                        {6, 2, 6, 2, 6, 2, 6, 2},
                        {2, 6, 2, 6, 2, 6, 5, 6},
                        {6, 5, 6, 1, 6, 5, 6, 2},
                        {5, 6, 1, 6, 5, 6, 5, 6},
                        {6, 5, 6, 5, 6, 5, 6, 5},
                        {5, 6, 1, 6, 1, 6, 5, 6},
                        {6, 5, 6, 5, 6, 1, 6, 5},
                        {1, 6, 1, 6, 1, 6, 1, 6}
                }
        );
        game.getPositions().add(gameMove21);
        GameMove gameMove22 = new GameMove();
        gameMove22.getMoves().add("c7:e5");
        gameMove22.setCurrentPosition(
                new int[][]{
                        {6, 2, 6, 2, 6, 2, 6, 2},
                        {2, 6, 5, 6, 2, 6, 5, 6},
                        {6, 5, 6, 5, 6, 5, 6, 2},
                        {5, 6, 1, 6, 2, 6, 5, 6},
                        {6, 5, 6, 5, 6, 5, 6, 5},
                        {5, 6, 1, 6, 1, 6, 5, 6},
                        {6, 5, 6, 5, 6, 1, 6, 5},
                        {1, 6, 1, 6, 1, 6, 1, 6}
                }
        );
        game.getPositions().add(gameMove22);
        GameMove gameMove23 = new GameMove();
        gameMove23.getMoves().add("a1-b2");
        gameMove23.setCurrentPosition(
                new int[][]{
                        {6, 2, 6, 2, 6, 2, 6, 2},
                        {2, 6, 5, 6, 2, 6, 5, 6},
                        {6, 5, 6, 5, 6, 5, 6, 2},
                        {5, 6, 1, 6, 2, 6, 5, 6},
                        {6, 5, 6, 5, 6, 5, 6, 5},
                        {5, 6, 1, 6, 1, 6, 5, 6},
                        {6, 1, 6, 5, 6, 1, 6, 5},
                        {5, 6, 1, 6, 1, 6, 1, 6}
                }
        );
        game.getPositions().add(gameMove23);
        GameMove gameMove24 = new GameMove();
        gameMove24.getMoves().add("h8-g7");
        gameMove24.setCurrentPosition(
                new int[][]{
                        {6, 2, 6, 2, 6, 2, 6, 5},
                        {2, 6, 5, 6, 2, 6, 2, 6},
                        {6, 5, 6, 5, 6, 5, 6, 2},
                        {5, 6, 1, 6, 2, 6, 5, 6},
                        {6, 5, 6, 5, 6, 5, 6, 5},
                        {5, 6, 1, 6, 1, 6, 5, 6},
                        {6, 1, 6, 5, 6, 1, 6, 5},
                        {5, 6, 1, 6, 1, 6, 1, 6}
                }
        );
        game.getPositions().add(gameMove24);
        GameMove gameMove25 = new GameMove();
        gameMove25.getMoves().add("c5-b6");
        gameMove25.setCurrentPosition(
                new int[][]{
                        {6, 2, 6, 2, 6, 2, 6, 5},
                        {2, 6, 5, 6, 2, 6, 2, 6},
                        {6, 1, 6, 5, 6, 5, 6, 2},
                        {5, 6, 5, 6, 2, 6, 5, 6},
                        {6, 5, 6, 5, 6, 5, 6, 5},
                        {5, 6, 1, 6, 1, 6, 5, 6},
                        {6, 1, 6, 5, 6, 1, 6, 5},
                        {5, 6, 1, 6, 1, 6, 1, 6}
                }
        );
        game.getPositions().add(gameMove25);
        GameMove gameMove26 = new GameMove();
        gameMove26.getMoves().add("a7:c5");
        gameMove26.setCurrentPosition(
                new int[][]{
                        {6, 2, 6, 2, 6, 2, 6, 5},
                        {5, 6, 5, 6, 2, 6, 2, 6},
                        {6, 5, 6, 5, 6, 5, 6, 2},
                        {5, 6, 2, 6, 2, 6, 5, 6},
                        {6, 5, 6, 5, 6, 5, 6, 5},
                        {5, 6, 1, 6, 1, 6, 5, 6},
                        {6, 1, 6, 5, 6, 1, 6, 5},
                        {5, 6, 1, 6, 1, 6, 1, 6}
                }
        );
        game.getPositions().add(gameMove26);
        GameMove gameMove27 = new GameMove();
        gameMove27.getMoves().add("e3-d4");
        gameMove27.setCurrentPosition(
                new int[][]{
                        {6, 2, 6, 2, 6, 2, 6, 5},
                        {5, 6, 5, 6, 2, 6, 2, 6},
                        {6, 5, 6, 5, 6, 5, 6, 2},
                        {5, 6, 2, 6, 2, 6, 5, 6},
                        {6, 5, 6, 1, 6, 5, 6, 5},
                        {5, 6, 1, 6, 5, 6, 5, 6},
                        {6, 1, 6, 5, 6, 1, 6, 5},
                        {5, 6, 1, 6, 1, 6, 1, 6}
                }
        );
        game.getPositions().add(gameMove27);
        GameMove gameMove28 = new GameMove();
        gameMove28.getMoves().add("c5:e3");
        gameMove28.setCurrentPosition(
                new int[][]{
                        {6, 2, 6, 2, 6, 2, 6, 5},
                        {5, 6, 5, 6, 2, 6, 2, 6},
                        {6, 5, 6, 5, 6, 5, 6, 2},
                        {5, 6, 5, 6, 2, 6, 5, 6},
                        {6, 5, 6, 5, 6, 5, 6, 5},
                        {5, 6, 1, 6, 2, 6, 5, 6},
                        {6, 1, 6, 5, 6, 1, 6, 5},
                        {5, 6, 1, 6, 1, 6, 1, 6}
                }
        );
        game.getPositions().add(gameMove28);
        GameMove gameMove29 = new GameMove();
        gameMove29.getMoves().add("f2:d4:f6:h8");
        gameMove29.setCurrentPosition(
                new int[][]{
                        {6, 2, 6, 2, 6, 2, 6, 3},
                        {5, 6, 5, 6, 2, 6, 5, 6},
                        {6, 5, 6, 5, 6, 5, 6, 2},
                        {5, 6, 5, 6, 5, 6, 5, 6},
                        {6, 5, 6, 5, 6, 5, 6, 5},
                        {5, 6, 1, 6, 5, 6, 5, 6},
                        {6, 1, 6, 5, 6, 5, 6, 5},
                        {5, 6, 1, 6, 1, 6, 1, 6}
                }
        );
        game.getPositions().add(gameMove29);
        return game;
    }
}
