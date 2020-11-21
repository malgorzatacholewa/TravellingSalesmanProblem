package pl.sda.TravellingSalesmanProblem.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.TravellingSalesmanProblem.model.AlgorithmResponse;
import pl.sda.TravellingSalesmanProblem.model.Point;
import pl.sda.TravellingSalesmanProblem.service.algorithms.AlgorithmFacade;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping
public class RouteController {
    @PostMapping("/route")
    public AlgorithmResponse getRoute(@RequestBody ArrayList<Point> listOfPoints) {
        try {
            AlgorithmFacade facade = new AlgorithmFacade(listOfPoints);
            return facade.getRoute("GOOGLE");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new AlgorithmResponse();
    }
}
