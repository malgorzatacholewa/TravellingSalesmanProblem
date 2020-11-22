package pl.sda.TravellingSalesmanProblem.service.algorithms;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
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

    public AlgorithmFacade(GoogleAlgorithm googleAlgorithm)  {
        this.algorithms = new HashMap<>();
        this.algorithms.put("GOOGLE", googleAlgorithm);
    }

    public AlgorithmResponse getRoute(String algotihmType, List<Point> points) throws IOException {
        if(this.distanceMatrix == null){
            this.distanceMatrix = DistanceMatrix.createDistanceMatrix(points);
        }

        Algorithm algorithm = this.algorithms.get(algotihmType);

        if (algorithm != null) {
            return algorithm.getRoute(this.distanceMatrix, points);
        } else {
            throw new NullPointerException();
        }
    }
}
