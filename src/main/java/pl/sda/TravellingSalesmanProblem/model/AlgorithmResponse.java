package pl.sda.TravellingSalesmanProblem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlgorithmResponse {
    private long numberOfKilometers;
    private List<Point> listOfPoints;
    private List<Integer> orderOfPoints;


}
