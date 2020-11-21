package pl.sda.TravellingSalesmanProblem.service.algorithms;
import pl.sda.TravellingSalesmanProblem.model.AlgorithmResponse;
import pl.sda.TravellingSalesmanProblem.model.Point;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlgorithmFacade {
    private List<Point> points;
    private long[][] distanceMatrix;
    private Map<String, Algorithm> algorithms;

    public AlgorithmFacade(List<Point> points) throws IOException {
        this.points = points;
        this.distanceMatrix = DistanceMatrix.createDistanceMatrix(points);
        this.algorithms = new HashMap<>();
        this.algorithms.put("GOOGLE", new GoogleAlgorithm(this.distanceMatrix, points));
    }

    public AlgorithmResponse getRoute(String algotihmType) {
        Algorithm algorithm = this.algorithms.get(algotihmType);

        if (algorithm != null) {
            return algorithm.getRoute();
        } else {
            throw new NullPointerException();
        }
    }
}
