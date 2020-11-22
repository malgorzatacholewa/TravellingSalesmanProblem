package pl.sda.TravellingSalesmanProblem.service.algorithms;

import org.springframework.stereotype.Component;
import pl.sda.TravellingSalesmanProblem.model.AlgorithmResponse;
import pl.sda.TravellingSalesmanProblem.model.Point;

import java.util.List;

interface Algorithm {
    AlgorithmResponse getRoute(long[][] distanceMatrix, List<Point> listOfPoints);
}
