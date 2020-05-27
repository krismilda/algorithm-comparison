package lt.vu.draughts.draughtsalgorithmscomparison.games;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GameMove {
    private int[][] currentPosition;
    private List<String> moves = new ArrayList<>();
}
