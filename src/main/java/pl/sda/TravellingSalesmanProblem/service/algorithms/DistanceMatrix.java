package pl.sda.TravellingSalesmanProblem.service.algorithms;


import pl.sda.TravellingSalesmanProblem.model.GoogleApiResponse;
import pl.sda.TravellingSalesmanProblem.model.Point;
import java.io.IOException;
import java.util.List;

class DistanceMatrix {
    private static GoogleDistance googleDistance = new GoogleDistance();

    public static long[][] createDistanceMatrix (List<Point> listOfPoint) throws IOException {
        long[][] distanceMatrix = new long[listOfPoint.size()][listOfPoint.size()];
        for (int i = 0; i < listOfPoint.size(); i++){
            for (int j = 0; j < listOfPoint.size(); j++){
                GoogleApiResponse googleApiResponse = googleDistance.getGoogleApiResponse(listOfPoint.get(i), listOfPoint.get(j));
                distanceMatrix[i][j] = googleApiResponse.getDistance();
            }
        }
        return distanceMatrix;
    }

}
