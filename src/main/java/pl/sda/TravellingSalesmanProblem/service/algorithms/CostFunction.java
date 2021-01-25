package pl.sda.TravellingSalesmanProblem.service.algorithms;

import org.springframework.stereotype.Component;

import java.util.List;

public class CostFunction {

    private long[][] distanceMatrix;

    public CostFunction(long[][] distanceMatrix) {
        this.distanceMatrix = distanceMatrix;
    }

    public long getCost (List<Integer> orderOfPoints){
        long numberOfKilometers = 0;
        int point1;
        int point2;
        int size = orderOfPoints.size();
        for (int i = 0; i < size; i++){
            point1 = orderOfPoints.get(i);
            if (i == (size - 1)){
                point2 = orderOfPoints.get(0);
            } else {
                point2 = orderOfPoints.get(i + 1);
            }
            numberOfKilometers = numberOfKilometers + distanceMatrix[point1][point2];
        }
        return numberOfKilometers;
    }
}
