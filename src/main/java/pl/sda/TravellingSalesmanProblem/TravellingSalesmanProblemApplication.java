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
//public static void main(String[] args) throws IOException {
//		List<Point> listPoint = new ArrayList<>();
//		listPoint.add(new Point("Jasielska","14B","Poznań","60-476","Polska"));
//		listPoint.add(new Point("Sezamkowa","3","Szamotuły","64-500","Polska"));
//		listPoint.add(new Point("Majkowska","5","Kalisz","62-800","Polska"));
//		listPoint.add(new Point("Popowicka","4","Wrocław","54-200","Polska"));

//		long [][] distanceMatrix = {
//				{0, 2451, 713, 1018, 1631, 1374, 2408, 213, 2571, 875, 1420, 2145, 1972},
//				{2451, 0, 1745, 1524, 831, 1240, 959, 2596, 403, 1589, 1374, 357, 579},
//				{713, 1745, 0, 355, 920, 803, 1737, 851, 1858, 262, 940, 1453, 1260},
//				{1018, 1524, 355, 0, 700, 862, 1395, 1123, 1584, 466, 1056, 1280, 987},
//				{1631, 831, 920, 700, 0, 663, 1021, 1769, 949, 796, 879, 586, 371},
//				{1374, 1240, 803, 862, 663, 0, 1681, 1551, 1765, 547, 225, 887, 999},
//				{2408, 959, 1737, 1395, 1021, 1681, 0, 2493, 678, 1724, 1891, 1114, 701},
//				{213, 2596, 851, 1123, 1769, 1551, 2493, 0, 2699, 1038, 1605, 2300, 2099},
//				{2571, 403, 1858, 1584, 949, 1765, 678, 2699, 0, 1744, 1645, 653, 600},
//				{875, 1589, 262, 466, 796, 547, 1724, 1038, 1744, 0, 679, 1272, 1162},
//				{1420, 1374, 940, 1056, 879, 225, 1891, 1605, 1645, 679, 0, 1017, 1200},
//				{2145, 357, 1453, 1280, 586, 887, 1114, 2300, 653, 1272, 1017, 0, 504},
//				{1972, 579, 1260, 987, 371, 999, 701, 2099, 600, 1162, 1200, 504, 0},
//		};
//		AlgorithmFacade algorithmFacade = new AlgorithmFacade(listPoint);
//		AlgorithmResponse algorithmResponse = algorithmFacade.getRoute("GOOGLE");
//		System.out.println(algorithmResponse.getNumberOfKilometers());
//		System.out.println(algorithmResponse.getOrderOfPoints());
//	}
}
