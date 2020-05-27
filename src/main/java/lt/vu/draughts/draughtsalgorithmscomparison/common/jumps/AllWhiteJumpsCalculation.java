package lt.vu.draughts.draughtsalgorithmscomparison.common.jumps;

import lt.vu.draughts.draughtsalgorithmscomparison.common.MoveDecoding;
import lt.vu.draughts.draughtsalgorithmscomparison.common.PositionCalculation;
import lt.vu.draughts.draughtsalgorithmscomparison.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AllWhiteJumpsCalculation {

    @Autowired
    PositionCalculation positionCalculation;

    @Autowired
    MoveDecoding moveDecoding;

    @Autowired
    WhiteDraughtJumpsCalculation whiteDraughtJumpsCalculation;

    private List<DraughtMovesResult> allWhiteJumps = new ArrayList<>();

    private List<RemovedDraughtCoordinates> removedDraughts = new ArrayList<>();

    private boolean foundNewMoves = false;

    public List<DraughtMovesResult> getAllWhiteJumps (int[][] previousPosition) {
        allWhiteJumps.clear();
        List<DraughtsPosition> whiteDraughts = positionCalculation.getWhites(previousPosition);
        for (DraughtsPosition whiteDraught : whiteDraughts
        ) {
            DraughtJump initialDraughtJump = new DraughtJump();
            initialDraughtJump.setIsFinished(false);
            initialDraughtJump.setCurrentPosition(positionCalculation.copyBoard(previousPosition));
            initialDraughtJump.setType(whiteDraught.getType());
            initialDraughtJump.setRow(whiteDraught.getRow());
            initialDraughtJump.setColumn(whiteDraught.getColumn());
            initialDraughtJump.setPositionToCheck(positionCalculation.copyBoard(previousPosition));
            removedDraughts.clear();
            foundNewMoves = false;
            getJump(initialDraughtJump);
        }
        return this.allWhiteJumps;
    }

    private void getJump(DraughtJump draughtJump) {
        List<DraughtsPosition> draughtsPositionsList;
        if(draughtJump.getType()==1){
            draughtsPositionsList = whiteDraughtJumpsCalculation.getPossibleWhiteDraughtJumps(draughtJump.getPositionToCheck(), draughtJump.getRow(), draughtJump.getColumn());
        }
        else{
            draughtsPositionsList = whiteDraughtJumpsCalculation.getPossibleWhiteKingJumps(draughtJump.getPositionToCheck(),
                    draughtJump.getRow(), draughtJump.getColumn());
        }
        List<DraughtsPosition> draughtsPositionsListWithoutPrevious = new ArrayList<>();
        for (int i = 0; i < draughtsPositionsList.size(); i++) {
            int t = i;
            int size = removedDraughts.stream().filter(item ->
                    item.getRow() == draughtsPositionsList.get(t).getRemovedDraughtRow()
                            && item.getColumn() == draughtsPositionsList.get(t).getRemovedDraughtColumn()
            ).collect(Collectors.toList()).size();
            if (size == 0) {
                draughtsPositionsListWithoutPrevious.add(draughtsPositionsList.get(i));
            }
        }
        if (draughtsPositionsListWithoutPrevious.size() != 0) {
            foundNewMoves = true;
        }
        if (draughtsPositionsListWithoutPrevious.size() == 0 && foundNewMoves) {
            draughtJump.setIsFinished(true);
            DraughtMovesResult draughtMovesResult = new DraughtMovesResult();
            int[][] copyPosition = positionCalculation.copyBoard(draughtJump.getCurrentPosition());
            draughtMovesResult.setPositionToCheck(copyPosition);
            draughtMovesResult.getMoves().add(draughtJump.getMove());
            draughtMovesResult.setLastCheck(DraughtColor.WHITE);
            this.allWhiteJumps.add(draughtMovesResult);
        }
        for (DraughtsPosition draughtsPosition : draughtsPositionsListWithoutPrevious
        ) {
            DraughtJump draughtJumpNew = setNewJump(draughtsPosition, draughtJump);
            getJump(draughtJumpNew);
        }
    }


    private DraughtJump setNewJump(DraughtsPosition draughtsPosition, DraughtJump previousJump) {
        DraughtJump draughtJump = new DraughtJump();
        int[][] currentPosition = positionCalculation.copyBoard(previousJump.getCurrentPosition());
        int[][] positionToCheck = positionCalculation.copyBoard(previousJump.getPositionToCheck());
        currentPosition[draughtsPosition.getRemovedDraughtRow()][draughtsPosition.getRemovedDraughtColumn()] = 5;
        currentPosition[previousJump.getRow()][previousJump.getColumn()] = 5;
        if (draughtsPosition.getRow() == 0 || previousJump.getType() == 3) {
            draughtJump.setType(3);
            currentPosition[draughtsPosition.getRow()][draughtsPosition.getColumn()] = 3;
            previousJump.getPositionToCheck()[previousJump.getRow()][previousJump.getColumn()] = 3;
        } else {
            draughtJump.setType(1);
            currentPosition[draughtsPosition.getRow()][draughtsPosition.getColumn()] = 1;
            positionToCheck[previousJump.getRow()][previousJump.getColumn()] = 1;
        }
        positionToCheck[previousJump.getRow()][previousJump.getColumn()] = 5;
        draughtJump.setCurrentPosition(currentPosition);
        draughtJump.setPositionToCheck(positionToCheck);
        RemovedDraughtCoordinates removedDraughtCoordinates = new RemovedDraughtCoordinates();
        removedDraughtCoordinates.setRow(draughtsPosition.getRemovedDraughtRow());
        removedDraughtCoordinates.setColumn(draughtsPosition.getRemovedDraughtColumn());
        removedDraughts.add(removedDraughtCoordinates);
        draughtJump.setMove(moveDecoding.getJumps(previousJump.getMove(), previousJump.getRow(), previousJump.getColumn(), draughtsPosition.getRow(), draughtsPosition.getColumn()));
        draughtJump.setRow(draughtsPosition.getRow());
        draughtJump.setColumn(draughtsPosition.getColumn());
        draughtJump.setIsFinished(false);
        return draughtJump;
    }
}
