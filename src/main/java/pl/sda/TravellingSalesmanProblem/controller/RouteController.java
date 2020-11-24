package pl.sda.TravellingSalesmanProblem.controller;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.sda.TravellingSalesmanProblem.model.AlgorithmResponse;
import pl.sda.TravellingSalesmanProblem.model.Point;
import pl.sda.TravellingSalesmanProblem.service.algorithms.AlgorithmFacade;
import java.io.IOException;
import java.util.ArrayList;

@RestController
@AllArgsConstructor
@RequestMapping
public class RouteController {
    private AlgorithmFacade facade;

    @PostMapping("/route")
    public AlgorithmResponse getRoute(@RequestBody ArrayList<Point> listOfPoints) throws IOException {
            return facade.getRoute("GOOGLE", listOfPoints);
    }
}
