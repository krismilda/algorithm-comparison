package lt.vu.draughts.draughtsalgorithmscomparison.games;

import lt.vu.draughts.draughtsalgorithmscomparison.breadthFirstSearch.MoveIdentifierBreadthFirstSearch;
import lt.vu.draughts.draughtsalgorithmscomparison.greedyBestFirstSearch.MoveIdentifierGreedyBestFirstSearch;
import lt.vu.draughts.draughtsalgorithmscomparison.limitedDepthFirstSearch.MoveIdentifierLimitedDepthFirstSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class CorruptionSimulation {


    @Autowired
    MovesToCheck movesToCheck;

    @Autowired
    MoveIdentifierBreadthFirstSearch moveIdentifierBreadthFirstSearch;

    @Autowired
    MoveIdentifierLimitedDepthFirstSearch moveIdentifierLimitedDepthFirstSearch;

    @Autowired
    MoveIdentifierGreedyBestFirstSearch moveIdentifierGreedyBestFirstSearch;

    private List<String> result = new ArrayList<>();

    public int numberOfMistakesBFS = 0;
    public int numberOfMistakesLimitedDFS = 0;
    public int numberOfMistakesGBFS = 0;


    public int numberOfAddedNodesBFS = 0;
    public int numberOfAddedNodesLimitedDFS = 0;
    public int numberOfAddedNodesGBFS = 0;

    public int numberOfVisitedNodesBFS = 0;
    public int numberOfVisitedNodesLimitedDFS = 0;
    public int numberOfVisitedNodesGBFS = 0;

    public int numberOfMissedMoves = 0;

    public int numberOfItems = 0;

    public void testAlgorithms(double probabilityToBeMissed, FileWriter writer) throws IOException {
        numberOfMistakesBFS = 0;
        numberOfMistakesLimitedDFS = 0;
        numberOfMistakesGBFS = 0;

        numberOfAddedNodesBFS = 0;
        numberOfAddedNodesLimitedDFS = 0;
        numberOfAddedNodesGBFS = 0;

        numberOfVisitedNodesBFS = 0;
        numberOfVisitedNodesLimitedDFS = 0;
        numberOfVisitedNodesGBFS = 0;

        numberOfMissedMoves = 0;

        numberOfItems = 0;

        Random random = new Random();
        List<Game> games = movesToCheck.getMovesToCheck();

        for (Game item : games) {
            for (int i = 0; i < item.getPositions().size() - 1; i++) {
                double generatedNumber = random.nextDouble();
                if (generatedNumber < probabilityToBeMissed && i + 2 <= item.getPositions().size() - 1) {
                    item.getPositions().get(i + 1).getMoves().addAll(
                            item.getPositions().get(i + 2).getMoves()
                    );
                    item.getPositions().get(i + 2).setMoves(item.getPositions().get(i + 1).getMoves());
                    item.getPositions().get(i + 1).setCurrentPosition(item.getPositions().get(i).getCurrentPosition());
                    this.numberOfMissedMoves++;
                } else {
                    List<String> expectedResult = item.getPositions().get(i + 1).getMoves();
                    this.numberOfItems++;
//
//                    writer.write("\n----------------------------------\n");
//                    writer.write("\nExpected: ");
//                    for (String move : expectedResult) {
//                        writer.write(move + " ");
//                    }
//                    writer.write("\n");

                    //TEST BFS
                    this.result = moveIdentifierBreadthFirstSearch.identifyMove(item.getPositions().get(i).getCurrentPosition(),
                            item.getPositions().get(i + 1).getCurrentPosition(),
                            (i + item.getPositions().get(i + 1).getMoves().size() - 1) % 2 == 0);
                    if (!this.checkIfCorrectResult(result, expectedResult)) {
                        this.numberOfMistakesBFS++;
//                        writer.write("NOT THE SAME MOVES! ");
//                        for (String move : result) {
//                            writer.write(move + " ");
//                        }
                    } else {
                        this.numberOfAddedNodesBFS += moveIdentifierBreadthFirstSearch.numberOfNodesAdded;
                        this.numberOfVisitedNodesBFS += moveIdentifierBreadthFirstSearch.checkedNodes;
                    }

//                    writer.write("\nBFS: \n");
//                    for (String move : result) {
//                        writer.write(move + " ");
//                    }
//                    writer.write("\nNumber of added nodes: " + moveIdentifierBreadthFirstSearch.numberOfNodesAdded + "\n");
//                    writer.write("Number of visited nodes: " + moveIdentifierBreadthFirstSearch.checkedNodes + "\n");

                    //TEST LIMITED DFS
                    int numberOfVisited = 0;
                    int numberOfAdded = 0;
                    for (int t = 1; t <= 8; t++) {
                        result = moveIdentifierLimitedDepthFirstSearch.identifyMove(item.getPositions().get(i).getCurrentPosition(),
                                item.getPositions().get(i + 1).getCurrentPosition(),
                                t,
                                (i + item.getPositions().get(i + 1).getMoves().size() - 1) % 2 == 0);
                        numberOfAdded += moveIdentifierLimitedDepthFirstSearch.numberOfNodesAdded;
                        numberOfVisited += moveIdentifierLimitedDepthFirstSearch.checkedNodes;
                        if (result.size() != 0) {
                            t = 11;
                        }
                    }
//                    writer.write("\nLDFS: \n");
                    if (!this.checkIfCorrectResult(result, expectedResult)) {
                        this.numberOfMistakesLimitedDFS++;
//                        writer.write("NOT THE SAME MOVES! ");
                    } else {
                        this.numberOfAddedNodesLimitedDFS += numberOfAdded;
                        this.numberOfVisitedNodesLimitedDFS += numberOfVisited;
                    }
//                    for (String move : result) {
//                        writer.write(move + " ");
//                    }
//                    writer.write("\nNumber of added nodes: " + moveIdentifierLimitedDepthFirstSearch.numberOfNodesAdded + "\n");
//                    writer.write("Number of visited nodes: " + moveIdentifierLimitedDepthFirstSearch.checkedNodes + "\n");

                    //TEST GREEDY BFS
//                    writer.write("\nGBFS: \n");
                    this.result = moveIdentifierGreedyBestFirstSearch.identifyMove(item.getPositions().get(i).getCurrentPosition(),
                            item.getPositions().get(i + 1).getCurrentPosition(),
                            (i + item.getPositions().get(i + 1).getMoves().size() - 1) % 2 == 0);
                    if (!this.checkIfCorrectResult(result, expectedResult)) {
                        this.numberOfMistakesGBFS++;
//                        writer.write("NOT THE SAME MOVES! ");
                    } else {
                        this.numberOfAddedNodesGBFS += moveIdentifierGreedyBestFirstSearch.numberOfNodesAdded;
                        this.numberOfVisitedNodesGBFS += moveIdentifierGreedyBestFirstSearch.checkedNodes;
                    }
//                    for (String move : result) {
//                        writer.write(move + " ");
//                    }
//                    writer.write("\nNumber of added nodes: " + moveIdentifierGreedyBestFirstSearch.numberOfNodesAdded + "\n");
//                    writer.write("Number of visited nodes: " + moveIdentifierGreedyBestFirstSearch.checkedNodes + "\n");
//                    writer.write("\n----------------------------------\n");
                }
            }
        }
    }


    private boolean checkIfCorrectResult(List<String> gotResult, List<String> expectedResult) {
        if (gotResult.size() != expectedResult.size()) {
//            System.out.println("SIZES NOT EQUALS!");
            return false;
        }

        for (int j = 0; j < result.size(); j++) {
            if (!result.get(j).equals(expectedResult.get(j))) {
                return false;
            }
        }
//        result.forEach(item -> System.out.print(item + " "));
        return true;
    }

}
