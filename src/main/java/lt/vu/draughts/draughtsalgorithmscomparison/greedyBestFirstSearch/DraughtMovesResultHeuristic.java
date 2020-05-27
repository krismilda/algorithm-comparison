package lt.vu.draughts.draughtsalgorithmscomparison.greedyBestFirstSearch;

import lombok.Getter;
import lombok.Setter;
import lt.vu.draughts.draughtsalgorithmscomparison.model.DraughtColor;
import lt.vu.draughts.draughtsalgorithmscomparison.model.DraughtMovesResult;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class DraughtMovesResultHeuristic {
    private int [][] positionToCheck;
    private List<String> moves = new ArrayList<>();
    private DraughtColor lastCheck;
    private int heuristicResult;
}

