package pl.sda.TravellingSalesmanProblem.controller;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<AlgorithmResponse> getRoute(@RequestBody ArrayList<Point> listOfPoints) {
        try {
            return new ResponseEntity<>(facade.getRoute("simulatedAnnealing", listOfPoints), HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();

           AlgorithmResponse algorithmResponse = new AlgorithmResponse();
           algorithmResponse.setErrorMessage("Wystąpił błąd podczas łączenia z Google: " + e.getMessage());

           return new ResponseEntity<>(algorithmResponse,HttpStatus.BAD_REQUEST);
        }
    }
}

