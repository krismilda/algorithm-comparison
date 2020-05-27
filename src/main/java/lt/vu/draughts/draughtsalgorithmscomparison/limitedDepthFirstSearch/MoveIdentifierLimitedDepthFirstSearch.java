package lt.vu.draughts.draughtsalgorithmscomparison.limitedDepthFirstSearch;

import lt.vu.draughts.draughtsalgorithmscomparison.common.PositionCalculation;
import lt.vu.draughts.draughtsalgorithmscomparison.common.jumps.AllBlackJumpsCalculation;
import lt.vu.draughts.draughtsalgorithmscomparison.common.jumps.AllWhiteJumpsCalculation;
import lt.vu.draughts.draughtsalgorithmscomparison.common.simpleMoves.BlackMovesCalculation;
import lt.vu.draughts.draughtsalgorithmscomparison.common.simpleMoves.WhiteMovesCalculation;
import lt.vu.draughts.draughtsalgorithmscomparison.model.DraughtColor;
import lt.vu.draughts.draughtsalgorithmscomparison.model.DraughtMovesResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MoveIdentifierLimitedDepthFirstSearch {

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

    private Deque<DraughtMovesResult> movesStack = new ArrayDeque<>();

    public int checkedNodes;
    public int numberOfNodesAdded;

    public List<String> identifyMove(int[][] previousPosition, int[][] currentPosition, int depthLimit, boolean isWhiteMove) {
        movesStack.clear();
        checkedNodes = 0;
        DraughtMovesResult draughtMovesResult = new DraughtMovesResult();
        draughtMovesResult.setPositionToCheck(previousPosition);
        draughtMovesResult.setMoves(new ArrayList<>());
        DraughtColor draughtColor = isWhiteMove ? DraughtColor.BLACK : DraughtColor.WHITE;
        draughtMovesResult.setLastCheck(draughtColor);
        movesStack.push(draughtMovesResult);
        numberOfNodesAdded = 1;
        do {
            checkedNodes++;
            if (!movesStack.isEmpty()) {
                DraughtMovesResult positionToCheck = movesStack.pop();
                boolean isEqualsPosition = positionCalculation.checkIfPositionsEqual(currentPosition, positionToCheck.getPositionToCheck());
                if (isEqualsPosition) {
                    return positionToCheck.getMoves();
                }
                if (depthLimit > positionToCheck.getMoves().size()) {
                    if (positionToCheck.getLastCheck() == DraughtColor.BLACK) {
                        this.findWhiteMoveFromCurrentAndPreviousPositions(positionToCheck);
                    } else {
                        this.findBlackMoveFromCurrentAndPreviousPositions(positionToCheck);
                    }
                }
            } else {
//                System.out.println("Not possible to identify move");
                return new ArrayList<>();
            }
        } while (movesStack != null);
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
        Collections.reverse(moves);
        moves.forEach(item -> this.movesStack.push(item));
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
        Collections.reverse(moves);
        moves.forEach(item -> this.movesStack.push(item));
        numberOfNodesAdded += moves.size();
    }
}
