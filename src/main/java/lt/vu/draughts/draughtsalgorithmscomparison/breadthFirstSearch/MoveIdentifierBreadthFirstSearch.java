package lt.vu.draughts.draughtsalgorithmscomparison.breadthFirstSearch;

import lt.vu.draughts.draughtsalgorithmscomparison.common.PositionCalculation;
import lt.vu.draughts.draughtsalgorithmscomparison.common.jumps.AllBlackJumpsCalculation;
import lt.vu.draughts.draughtsalgorithmscomparison.common.jumps.AllWhiteJumpsCalculation;
import lt.vu.draughts.draughtsalgorithmscomparison.common.simpleMoves.BlackMovesCalculation;
import lt.vu.draughts.draughtsalgorithmscomparison.common.simpleMoves.WhiteMovesCalculation;
import lt.vu.draughts.draughtsalgorithmscomparison.model.DraughtColor;
import lt.vu.draughts.draughtsalgorithmscomparison.model.DraughtMovesResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@Component
public class MoveIdentifierBreadthFirstSearch {

    @Autowired
    PositionCalculation positionCalculation;

    @Autowired
    AllWhiteJumpsCalculation allWhiteJumpsCalculation;

    @Autowired
    WhiteMovesCalculation whiteMovesCalculation;


    @Autowired
    AllBlackJumpsCalculation allBlackJumpsCalculation;

    @Autowired
    BlackMovesCalculation blackMovesCalculation;

    private Queue<DraughtMovesResult> draughtsMovesQueue = new ArrayDeque<>();

    public int checkedNodes;
    public int numberOfNodesAdded;
    private DraughtMovesResult lastAdded;

    public List<String> identifyMove(int[][] previousPosition, int[][] currentPosition, boolean isWhiteMove) {
        draughtsMovesQueue.clear();
        checkedNodes = 0;
        DraughtMovesResult draughtMovesResult = new DraughtMovesResult();
        draughtMovesResult.setPositionToCheck(positionCalculation.copyBoard(previousPosition));
        draughtMovesResult.setMoves(new ArrayList<>());
        DraughtColor draughtColor = isWhiteMove ? DraughtColor.BLACK : DraughtColor.WHITE;
        draughtMovesResult.setLastCheck(draughtColor);
        draughtsMovesQueue.add(draughtMovesResult);
        numberOfNodesAdded = 1;
        lastAdded = draughtMovesResult;
        do {
            checkedNodes++;
            if (!draughtsMovesQueue.isEmpty()) {
                DraughtMovesResult positionToCheck = draughtsMovesQueue.poll();
                if (lastAdded.getMoves().size() >= 8) {
                    return new ArrayList<>();
                }
                boolean isEqualsPosition = positionCalculation.checkIfPositionsEqual(currentPosition, positionToCheck.getPositionToCheck());
                if (isEqualsPosition) {
                    return positionToCheck.getMoves();
                }
                if (positionToCheck.getLastCheck() == DraughtColor.BLACK) {
                    this.findWhiteMoveFromCurrentAndPreviousPositions(positionToCheck);
                } else {
                    this.findBlackMoveFromCurrentAndPreviousPositions(positionToCheck);
                }
            } else {
//                System.out.println("Not possible to identify move");
                return new ArrayList<>();
            }
        } while (draughtsMovesQueue != null);
        return null;
    }

    private void findWhiteMoveFromCurrentAndPreviousPositions(DraughtMovesResult draughtMovesResult) {
        List<DraughtMovesResult> moves = allWhiteJumpsCalculation.getAllWhiteJumps(draughtMovesResult.getPositionToCheck());
        if (moves.size() == 0) {
            moves = whiteMovesCalculation.getAllMoves(draughtMovesResult.getPositionToCheck());
        }
        moves.forEach(item -> {
            List<String> newMovesList = new ArrayList<>(draughtMovesResult.getMoves());
            newMovesList.add(item.getMoves().get(0));
            item.setMoves(newMovesList);
        });

        if (moves.size() - 1 > 0) {
            this.lastAdded = moves.get(moves.size() - 1);
        }
        this.draughtsMovesQueue.addAll(moves);
        numberOfNodesAdded += moves.size();
    }

    private void findBlackMoveFromCurrentAndPreviousPositions(DraughtMovesResult draughtMovesResult) {
        List<DraughtMovesResult> moves = allBlackJumpsCalculation.getAllBlackJumps(draughtMovesResult.getPositionToCheck());
        if (moves.size() == 0) {
            moves = blackMovesCalculation.getAllMoves(draughtMovesResult.getPositionToCheck());
        }
        moves.forEach(item -> {
            List<String> newMovesList = new ArrayList<>(draughtMovesResult.getMoves());
            newMovesList.add(item.getMoves().get(0));
            item.setMoves(newMovesList);
        });

        if (moves.size() - 1 > 0) {
            this.lastAdded = moves.get(moves.size() - 1);
        }
        this.draughtsMovesQueue.addAll(moves);
        numberOfNodesAdded += moves.size();
    }
}
