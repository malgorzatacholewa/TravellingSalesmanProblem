package pl.sda.TravellingSalesmanProblem.service.algorithms;

import org.springframework.stereotype.Component;
import pl.sda.TravellingSalesmanProblem.model.AlgorithmResponse;
import pl.sda.TravellingSalesmanProblem.model.Point;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AlgorithmFacade {
    private long[][] distanceMatrix;
    private Map<String, Algorithm> algorithms;

    public AlgorithmFacade(GoogleAlgorithm googleAlgorithm, SimulatedAnnealingAlgorithm simulatedAnnealingAlgorithm) {
        this.algorithms = new HashMap<>();
        this.algorithms.put("GOOGLE", googleAlgorithm);
        this.algorithms.put("simulatedAnnealing", simulatedAnnealingAlgorithm);
    }

    public AlgorithmResponse getRoute(String algorithmType, List<Point> points) throws IOException {
        this.distanceMatrix = DistanceMatrix.createDistanceMatrix(points);
        Algorithm algorithm = this.algorithms.get(algorithmType);
        return algorithm.getRoute(this.distanceMatrix, points);
    }
}
