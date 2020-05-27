package lt.vu.draughts.draughtsalgorithmscomparison.common.simpleMoves;

import lt.vu.draughts.draughtsalgorithmscomparison.breadthFirstSearch.MoveIdentifierBreadthFirstSearch;
import lt.vu.draughts.draughtsalgorithmscomparison.common.MoveDecoding;
import lt.vu.draughts.draughtsalgorithmscomparison.common.PositionCalculation;
import lt.vu.draughts.draughtsalgorithmscomparison.model.DraughtColor;
import lt.vu.draughts.draughtsalgorithmscomparison.model.DraughtMovesResult;
import lt.vu.draughts.draughtsalgorithmscomparison.model.DraughtsPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WhiteMovesCalculation {

    @Autowired
    PositionCalculation positionCalculation;

    @Autowired
    MoveDecoding moveDecoding;

    @Autowired
    MoveIdentifierBreadthFirstSearch moveIdentifierBreadthFirstSearch;

    public List<DraughtMovesResult> getAllMoves(int[][] position) {
        List<DraughtsPosition> whiteDraughts = positionCalculation.getWhites(position);
        List<DraughtMovesResult> allMovesList = new ArrayList<>();
        for (DraughtsPosition whiteDraught : whiteDraughts
        ) {
            if (whiteDraught.getType() == 1) {
                List<DraughtMovesResult> draughtMovesList = this.getDraughtMoves(position, whiteDraught.getRow(), whiteDraught.getColumn());
                allMovesList.addAll(draughtMovesList);
            } else {
                List<DraughtMovesResult> kingMovesList = this.getAllKingMoves(position, whiteDraught.getRow(), whiteDraught.getColumn());
                allMovesList.addAll(kingMovesList);
            }
        }
        return allMovesList;
    }

    public List<DraughtMovesResult> getDraughtMoves(int[][] position, int row, int column) {
        List<DraughtMovesResult> moves = new ArrayList<>();
        if (column >= 1 && row >= 1 && position[row - 1][column - 1] == 5) {
            moves.add(this.getDraughtMove(position, row, column, -1));
        }
        if (column <= 6 && row >= 1 && position[row - 1][column + 1] == 5) {
            moves.add(this.getDraughtMove(position, row, column, 1));
        }
        return moves;
    }

    private DraughtMovesResult getDraughtMove(int[][] position, int row, int column, int columnDirection) {
        DraughtMovesResult draughtMovesResult = new DraughtMovesResult();
        int[][] copyPosition = positionCalculation.copyBoard(position);
        copyPosition[row][column] = 5;
        if (row == 1) {
            copyPosition[row - 1][column + columnDirection] = 3;
        } else {
            copyPosition[row - 1][column + columnDirection] = 1;
        }
        draughtMovesResult.setPositionToCheck(copyPosition);
        String move = moveDecoding.getSimpleMove(row, column, row - 1, column + columnDirection);
        draughtMovesResult.getMoves().add(move);
        draughtMovesResult.setLastCheck(DraughtColor.WHITE);
        return draughtMovesResult;
    }


    private List<DraughtMovesResult> getAllKingMoves(int[][] position,
                                                     int row,
                                                     int column) {
        List<DraughtMovesResult> moves = new ArrayList<>();
        moves.addAll(this.getKingMoves(position, row, column, 1, 1));
        moves.addAll(this.getKingMoves(position, row, column, 1, -1));
        moves.addAll(this.getKingMoves(position, row, column, -1, 1));
        moves.addAll(this.getKingMoves(position, row, column, -1, -1));
        return moves;
    }

    private List<DraughtMovesResult> getKingMoves(int[][] position,
                                                  int row,
                                                  int column,
                                                  int rowDirection,
                                                  int columnDirection
    ) {
        List<DraughtMovesResult> moves = new ArrayList<>();
        int columnNumberToCheck = columnDirection > 0 ? 7 - column : column;
        for (int i = 1; i <= columnNumberToCheck; i++) {
            int rowChange = i * rowDirection;
            int columnChange = i * columnDirection;
            if (((rowDirection < 0 && row + rowChange >= 0) || (rowDirection > 0 && row + rowChange < 8))
                    && ((columnDirection < 0 && column + columnChange >= 0) || (column > 0 && column + columnChange < 8))
                    && position[row + rowChange][column + columnChange] == 5
            ) {
                DraughtMovesResult draughtMovesResult = new DraughtMovesResult();
                int[][] copyPosition = positionCalculation.copyBoard(position);
                copyPosition[row][column] = 5;
                copyPosition[row + rowChange][column + columnChange] = 3;
                draughtMovesResult.setPositionToCheck(copyPosition);
                String move = moveDecoding.getSimpleMove(row, column, row + rowChange, column + columnChange);
                draughtMovesResult.getMoves().add(move);
                draughtMovesResult.setLastCheck(DraughtColor.WHITE);
                moves.add(draughtMovesResult);
            } else {
                return moves;
            }
        }
        return moves;
    }
}
