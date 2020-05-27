package lt.vu.draughts.draughtsalgorithmscomparison.greedyBestFirstSearch;

import lt.vu.draughts.draughtsalgorithmscomparison.common.*;
import lt.vu.draughts.draughtsalgorithmscomparison.common.jumps.AllBlackJumpsCalculation;
import lt.vu.draughts.draughtsalgorithmscomparison.common.jumps.AllWhiteJumpsCalculation;
import lt.vu.draughts.draughtsalgorithmscomparison.common.simpleMoves.BlackMovesCalculation;
import lt.vu.draughts.draughtsalgorithmscomparison.common.simpleMoves.WhiteMovesCalculation;
import lt.vu.draughts.draughtsalgorithmscomparison.model.DraughtColor;
import lt.vu.draughts.draughtsalgorithmscomparison.model.DraughtMovesResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MoveIdentifierGreedyBestFirstSearch {


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

    private List<DraughtMovesResultHeuristic> movesList = new ArrayList<>();

    public int checkedNodes;
    public int numberOfNodesAdded;

    public List<String> identifyMove(int[][] previousPosition, int[][] currentPosition, boolean isWhiteMove) {
        movesList.clear();
        this.checkedNodes = 0;
        DraughtMovesResultHeuristic moveToCheck = new DraughtMovesResultHeuristic();
        moveToCheck.setPositionToCheck(previousPosition);
        moveToCheck.setMoves(new ArrayList<>());
        DraughtColor draughtColor = isWhiteMove ? DraughtColor.BLACK : DraughtColor.WHITE;
        moveToCheck.setLastCheck(draughtColor);
        movesList.add(moveToCheck);
        numberOfNodesAdded = 1;
        do {
            if (!movesList.isEmpty()) {
                this.checkedNodes++;
                DraughtMovesResultHeuristic positionToCheck = movesList.get(0);
                movesList.remove(0);
                boolean isEqualsPosition = positionCalculation.checkIfPositionsEqual(currentPosition, positionToCheck.getPositionToCheck());
                if (isEqualsPosition) {
                    return positionToCheck.getMoves();
                }
                if(positionToCheck.getMoves().size()<9) {
                    if (positionToCheck.getLastCheck() == DraughtColor.BLACK) {
                        this.findWhiteMoveFromCurrentAndPreviousPositions(currentPosition, positionToCheck);
                    } else {
                        this.findBlackMoveFromCurrentAndPreviousPositions(currentPosition, positionToCheck);
                    }
                    this.movesList = this.movesList.stream().sorted((item1, item2) -> Integer.compare(item2.getHeuristicResult(), item1.getHeuristicResult()))
                            .collect(Collectors.toList());
                }
            } else {
//                System.out.println("Not possible to identify move");
                return new ArrayList<>();
            }
        } while (this.movesList != null);

        return null;
    }


    private void findWhiteMoveFromCurrentAndPreviousPositions(int[][] finalPosition, DraughtMovesResultHeuristic moveToCheck) {
        List<DraughtMovesResult> moves =  allWhiteJumpsCalculation.getAllWhiteJumps(moveToCheck.getPositionToCheck());
        if(moves.size()==0){
            moves = whiteMovesCalculation.getAllMoves(moveToCheck.getPositionToCheck());
        }
        moves.forEach(item -> {
            DraughtMovesResultHeuristic move = new DraughtMovesResultHeuristic();
            move.setHeuristicResult(calculateHeuristicValue(finalPosition, item.getPositionToCheck()));
            move.setLastCheck(DraughtColor.WHITE);
            move.setPositionToCheck(item.getPositionToCheck());
            List<String> movesList = new ArrayList<>(moveToCheck.getMoves());
            movesList.add(item.getMoves().get(0));
            move.setMoves(movesList);
            this.movesList.add(move);
            this.numberOfNodesAdded++;
        });
    }

    private void findBlackMoveFromCurrentAndPreviousPositions(int[][] finalPosition, DraughtMovesResultHeuristic moveToCheck) {

        List<DraughtMovesResult> moves = allBlackJumpsCalculation.getAllBlackJumps(moveToCheck.getPositionToCheck());
        if(moves.size()==0){
            moves = blackMovesCalculation.getAllMoves(moveToCheck.getPositionToCheck());
        }
        moves.forEach(item -> {
            DraughtMovesResultHeuristic move = new DraughtMovesResultHeuristic();
            move.setHeuristicResult(calculateHeuristicValue(finalPosition, item.getPositionToCheck()));
            move.setLastCheck(DraughtColor.BLACK);
            move.setPositionToCheck(item.getPositionToCheck());
            List<String> movesList = new ArrayList<>(moveToCheck.getMoves());
            movesList.add(item.getMoves().get(0));
            move.setMoves(movesList);
            this.movesList.add(move);
            this.numberOfNodesAdded++;
        });
    }


    private int calculateHeuristicValue(int[][] finalPosition, int[][] position) {
        int calculatedValue = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (position[i][j] == finalPosition[i][j]) {
                    calculatedValue++;
                }
            }
        }
        return calculatedValue;
    }
}