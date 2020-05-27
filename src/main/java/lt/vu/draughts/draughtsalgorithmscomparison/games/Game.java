package lt.vu.draughts.draughtsalgorithmscomparison.games;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class Game {
    private List<GameMove> positions = new ArrayList<>();
}
