package lt.vu.draughts.draughtsalgorithmscomparison;

import lt.vu.draughts.draughtsalgorithmscomparison.games.CorruptionSimulation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class TestAlgorithms {

    private float numberOfMistakesBFSAll = 0;
    private float numberOfMistakesLimitedDFSAll = 0;
    private float numberOfMistakesGBFSAll = 0;

    private float numberOfAddedNodesBFSAll = 0;
    private float numberOfAddedNodesLimitedDFSAll = 0;
    private float numberOfAddedNodesGBFSAll = 0;

    private float numberOfVisitedNodesBFSAll = 0;
    private float numberOfVisitedNodesLimitedDFSAll = 0;
    private float numberOfVisitedNodesGBFSAll = 0;

    private float numberOfMissedMovesAll = 0;

    private float numberOfItemsAll = 0;

    @Autowired
    private CorruptionSimulation corruptionSimulation;

    public void testResult(){
        try {
            for(double prob = 0; prob<0.41; prob+=0.05) {
                System.out.println(prob);
                double probability = Math.round(prob*100)*1.0/100;
                long filenameNumber = Math.round(probability*100);
                String filename = "results"+ filenameNumber+".txt";
                File fileToSave = new File(filename);
                fileToSave.createNewFile();

                numberOfMistakesBFSAll = 0;
                numberOfMistakesLimitedDFSAll = 0;
                numberOfMistakesGBFSAll = 0;

                numberOfAddedNodesBFSAll = 0;
                numberOfAddedNodesLimitedDFSAll = 0;
                numberOfAddedNodesGBFSAll = 0;

                numberOfVisitedNodesBFSAll = 0;
                numberOfVisitedNodesLimitedDFSAll = 0;
                numberOfVisitedNodesGBFSAll = 0;

                numberOfMissedMovesAll = 0;
                numberOfItemsAll = 0;

                int numberOfTests = 500;

                String filenameLogs = "logs"+ filenameNumber +".txt";
                File fileToSaveLogs = new File(filenameLogs);
                fileToSaveLogs.createNewFile();
                FileWriter writerLogs = new FileWriter(filenameLogs);

                for (int i = 0; i < numberOfTests; i++) {
                    corruptionSimulation.testAlgorithms(probability, writerLogs);

                    this.numberOfMistakesBFSAll += Math.round(corruptionSimulation.numberOfMistakesBFS * 1.0 / corruptionSimulation.numberOfItems * 100.0) / 100.0;
                    this.numberOfMistakesLimitedDFSAll += Math.round(corruptionSimulation.numberOfMistakesLimitedDFS * 1.0 / corruptionSimulation.numberOfItems * 100.0) / 100.0;
                    this.numberOfMistakesGBFSAll += Math.round(corruptionSimulation.numberOfMistakesGBFS * 1.0 / corruptionSimulation.numberOfItems * 100.0) / 100.0;

                    this.numberOfAddedNodesBFSAll += Math.round(corruptionSimulation.numberOfAddedNodesBFS * 1.0 / corruptionSimulation.numberOfItems * 100.0) / 100.0;
                    this.numberOfAddedNodesLimitedDFSAll += Math.round(corruptionSimulation.numberOfAddedNodesLimitedDFS * 1.0 / corruptionSimulation.numberOfItems * 100.0) / 100.0;
                    this.numberOfAddedNodesGBFSAll += Math.round(corruptionSimulation.numberOfAddedNodesGBFS * 1.0 / corruptionSimulation.numberOfItems * 100.0) / 100.0;

                    this.numberOfVisitedNodesBFSAll += Math.round(corruptionSimulation.numberOfVisitedNodesBFS * 1.0 / corruptionSimulation.numberOfItems * 100.0) / 100.0;
                    this.numberOfVisitedNodesLimitedDFSAll += Math.round(corruptionSimulation.numberOfVisitedNodesLimitedDFS * 1.0 / corruptionSimulation.numberOfItems * 100.0) / 100.0;
                    this.numberOfVisitedNodesGBFSAll += Math.round(corruptionSimulation.numberOfVisitedNodesGBFS * 1.0 / corruptionSimulation.numberOfItems * 100.0) / 100.0;

                    this.numberOfMissedMovesAll += corruptionSimulation.numberOfMissedMoves;

                    this.numberOfItemsAll += corruptionSimulation.numberOfItems;
                    this.printResults(0, filenameLogs, numberOfTests);
                }
                writerLogs.close();
                this.printResults(0, filename, numberOfTests);
            }

        } catch (Exception w) {
            System.out.println("An error occurred.");
            w.printStackTrace();
        }
    }

    private void printResults(double probability, String filename, int numberOfTests) throws IOException {

        FileWriter writer = new FileWriter(filename);
        writer.write("\n-----------------------------------------------\n");
        writer.write("\nProbability: " + probability);
        writer.write("\nNumber of items: " + Math.round(this.numberOfItemsAll)*1.0/numberOfTests);
        writer.write("\nNumber of missed items: " + Math.round(this.numberOfMissedMovesAll)*1.0/numberOfTests);

        writer.write("\n\nBreadth First Search");
        writer.write("\nNumber of mistakes: " + Math.round(this.numberOfMistakesBFSAll)*1.0/numberOfTests);
        writer.write("\nAverage of visited nodes: " + Math.round(this.numberOfVisitedNodesBFSAll)*1.0/numberOfTests);
        writer.write("\nAverage of added nodes: " + Math.round(this.numberOfAddedNodesBFSAll)*1.0/numberOfTests);

        writer.write("\n\nIterative Depth First Search");
        writer.write("\nNumber of mistakes: " + Math.round(this.numberOfMistakesLimitedDFSAll)*1.0/numberOfTests);
        writer.write("\nAverage of visited nodes: " + Math.round(this.numberOfVisitedNodesLimitedDFSAll)*1.0/numberOfTests);
        writer.write("\nAverage of added nodes: " + Math.round(this.numberOfAddedNodesLimitedDFSAll)*1.0/numberOfTests);

        writer.write("\n\nGreedy Breadth First Search");
        writer.write("\nNumber of mistakes: " + Math.round(this.numberOfMistakesGBFSAll)*1.0/numberOfTests);
        writer.write("\nAverage of visited nodes: " + Math.round(this.numberOfVisitedNodesGBFSAll)*1.0/numberOfTests);
        writer.write("\nAverage of added nodes: " + Math.round(this.numberOfAddedNodesGBFSAll)*1.0/numberOfTests);
        writer.write("\n-----------------------------------------------\n");
        writer.close();
    }
}
