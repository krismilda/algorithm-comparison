package lt.vu.draughts.draughtsalgorithmscomparison.games;

import lt.vu.draughts.draughtsalgorithmscomparison.games.games.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovesToCheck {
    @Autowired
    private Game1 game1;

    @Autowired
    private Game2 game2;

    @Autowired
    private Game3 game3;

    @Autowired
    private Game4 game4;

    @Autowired
    private Game5 game5;

    @Autowired
    private Game6 game6;
    @Autowired
    private Game7 game7;

    @Autowired
    private Game8 game8;

    @Autowired
    private Game9 game9;

    @Autowired
    private Game10 game10;

    @Autowired
    private Game11 game11;

    @Autowired
    private Game12 game12;

    @Autowired
    private Game13 game13;

    @Autowired
    private Game14 game14;

    @Autowired
    private Game15 game15;

    @Autowired
    private Game16 game16;

    public List<Game> getMovesToCheck() {
        List<Game> games = new ArrayList<>();
        games.add(game1.returnGame());
        games.add(game2.returnGame());
        games.add(game3.returnGame());
        games.add(game4.returnGame());
        games.add(game5.returnGame());
        games.add(game6.returnGame());
        games.add(game7.returnGame());
        games.add(game8.returnGame());
        games.add(game9.returnGame());
        games.add(game10.returnGame());
        games.add(game11.returnGame());
        games.add(game12.returnGame());
        games.add(game13.returnGame());
        games.add(game14.returnGame());
        games.add(game15.returnGame());
        games.add(game16.returnGame());
        return games;
    }
}
