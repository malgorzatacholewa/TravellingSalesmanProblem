package pl.sda.TravellingSalesmanProblem.service.algorithms;

import org.springframework.stereotype.Component;
import pl.sda.TravellingSalesmanProblem.model.AlgorithmResponse;


interface Algorithm {
    AlgorithmResponse getRoute();
}
