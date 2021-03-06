package pl.sda.TravellingSalesmanProblem.service.algorithms;
import pl.sda.TravellingSalesmanProblem.model.GoogleApiResponse;
import pl.sda.TravellingSalesmanProblem.model.Point;
import java.io.IOException;
import java.util.List;

class DistanceMatrix {
    private static GoogleDistance googleDistance = new GoogleDistance();

    public static long[][] createDistanceMatrix(List<Point> listOfPoint) throws IOException {
        int numberOfPoints = listOfPoint.size();
        long[][] distanceMatrix = new long[numberOfPoints][numberOfPoints];
        for (int i = 0; i < numberOfPoints; i++) {
            for (int j = 0; j < numberOfPoints; j++) {
                GoogleApiResponse googleApiResponse = googleDistance.getGoogleApiResponse(listOfPoint.get(i), listOfPoint.get(j));
                distanceMatrix[i][j] = googleApiResponse.getDistance();
            }
        }
        return distanceMatrix;
    }
}
