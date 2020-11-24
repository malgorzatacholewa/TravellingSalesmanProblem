package pl.sda.TravellingSalesmanProblem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.sda.TravellingSalesmanProblem.model.AlgorithmResponse;
import pl.sda.TravellingSalesmanProblem.model.Point;
import pl.sda.TravellingSalesmanProblem.service.algorithms.AlgorithmFacade;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class TravellingSalesmanProblemApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravellingSalesmanProblemApplication.class, args);
	}

}
