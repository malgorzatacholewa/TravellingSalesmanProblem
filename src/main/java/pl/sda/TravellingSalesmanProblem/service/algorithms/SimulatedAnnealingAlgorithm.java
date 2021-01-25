package pl.sda.TravellingSalesmanProblem.service.algorithms;


import org.springframework.stereotype.Component;
import pl.sda.TravellingSalesmanProblem.model.AlgorithmResponse;
import pl.sda.TravellingSalesmanProblem.model.Point;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Component
public class SimulatedAnnealingAlgorithm implements Algorithm {

    private final int cMax;
    private final double a;

    public SimulatedAnnealingAlgorithm() {
        this.cMax = 1000;
        this.a = 0.5;
    }

    @Override
    public AlgorithmResponse getRoute(long[][] distanceMatrix, List<Point> listOfPoints) {
        CostFunction costFunction = new CostFunction(distanceMatrix);
        int c = 1;
        List<Integer> bestOrder = getRandomOrderOfPoints(listOfPoints);
        List<Integer> currentOrder = new ArrayList<>(bestOrder);
        double cost = costFunction.getCost(bestOrder);
        List<Integer> newOrder;
        Random random = new Random();

        while (c <= cMax){
            newOrder = swapTwoRandomElem(currentOrder);
            if (costFunction.getCost(newOrder) < costFunction.getCost(currentOrder)){
                currentOrder = newOrder;
                if (costFunction.getCost(currentOrder) < costFunction.getCost(bestOrder)){
                    bestOrder = currentOrder;
                }
            } else {
                double r = random.nextDouble();
                if (r < Math.exp(-(costFunction.getCost(newOrder) - costFunction.getCost(currentOrder))/cost)){
                    currentOrder = newOrder;
                }
            }
            c++;
            cost = a * cost;
        }

        AlgorithmResponse algorithmResponse = new AlgorithmResponse();
        algorithmResponse.setOrderOfPoints(doPointZeroFirst(bestOrder));
        algorithmResponse.setListOfPoints(listOfPoints);
        algorithmResponse.setNumberOfKilometers(costFunction.getCost(bestOrder));
        return algorithmResponse;

    }

    private List<Integer> getRandomOrderOfPoints (List<Point> listOfPoints){
        int size = listOfPoints.size();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < size ; i++){
            list.add(i);
        }
        Collections.shuffle(list);
        return list;
    }

    private List<Integer> swapTwoRandomElem (List<Integer> list){
        List<Integer> newList = new ArrayList<>(list);

        Random random = new Random();
        int i = random.nextInt(newList.size());
        int j = random.nextInt(newList.size());

        while (i == j){
            j = random.nextInt(newList.size());
        }

        int temp = newList.get(i);

        list.set(i, newList.get(j));
        list.set(j, temp);

        return newList;
    }

    public List<Integer> doPointZeroFirst (List<Integer> list){
        List<Integer> finalOrder = new ArrayList<>();
        int j = -1;
        for (int i = 0; i < list.size(); i++){
            if (j != -1){
                finalOrder.add(list.get(i));
            }
            if (list.get(i) == 0){
                j = i;
                finalOrder.add(list.get(i));
            }
        }
        for (int i = 0; i < j; i++ ){
            finalOrder.add(list.get(i));
        }
        return finalOrder;
    }


}
