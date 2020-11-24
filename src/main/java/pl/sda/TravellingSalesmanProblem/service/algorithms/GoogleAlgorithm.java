package pl.sda.TravellingSalesmanProblem.service.algorithms;
import com.google.ortools.Loader;
import com.google.ortools.constraintsolver.*;
import org.springframework.stereotype.Component;
import pl.sda.TravellingSalesmanProblem.model.AlgorithmResponse;
import pl.sda.TravellingSalesmanProblem.model.Point;
import java.util.ArrayList;
import java.util.List;

@Component
class GoogleAlgorithm implements Algorithm {
    private int vehicleNumber;
    private int firstPoint;

    public GoogleAlgorithm() {
        this.vehicleNumber = 1;
        this.firstPoint = 0;
    }

    public AlgorithmResponse getRoute(long[][] distanceMatrix, List<Point> listOfPoints ){
        Loader.loadNativeLibraries();
        RoutingIndexManager manager = new RoutingIndexManager(distanceMatrix.length, vehicleNumber, firstPoint);
        RoutingModel routing = new RoutingModel(manager);
        int transitCallbackIndex =
                routing.registerTransitCallback((long fromIndex, long toIndex) -> {
                    int fromNode = manager.indexToNode(fromIndex);
                    int toNode = manager.indexToNode(toIndex);
                    return distanceMatrix[fromNode][toNode];
                });

        routing.setArcCostEvaluatorOfAllVehicles(transitCallbackIndex);

        RoutingSearchParameters searchParameters =
                main.defaultRoutingSearchParameters()
                        .toBuilder()
                        .setFirstSolutionStrategy(FirstSolutionStrategy.Value.PATH_CHEAPEST_ARC)
                        .build();
        Assignment solution = routing.solveWithParameters(searchParameters);

        AlgorithmResponse algorithmResponse = new AlgorithmResponse();
        algorithmResponse.setListOfPoints(listOfPoints);
        algorithmResponse.setNumberOfKilometers(solution.objectiveValue());
        List<Integer> orderOfPoints = new ArrayList<>();
        long index = routing.start(firstPoint);
        while (!routing.isEnd(index)) {
            orderOfPoints.add(manager.indexToNode(index));
            index = solution.value(routing.nextVar(index));
        }
        algorithmResponse.setOrderOfPoints(orderOfPoints);
        return algorithmResponse;
    }
}


