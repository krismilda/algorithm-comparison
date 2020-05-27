package lt.vu.draughts.draughtsalgorithmscomparison.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DraughtMove {
    private int row;
    private int column;
    private int [][] newPosition;
    private String move;
}
