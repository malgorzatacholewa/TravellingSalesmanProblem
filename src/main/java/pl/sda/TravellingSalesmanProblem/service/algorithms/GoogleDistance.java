package pl.sda.TravellingSalesmanProblem.service.algorithms;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.sda.TravellingSalesmanProblem.model.GoogleApiResponse;
import pl.sda.TravellingSalesmanProblem.model.Point;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

class GoogleDistance {
    private static String url = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=";
    private static String keyAndLanguageApi = "&language=pl&key=AIzaSyDCIJlbp90hKzlfgXfBmK6GAXX_hmc2yek";

    public GoogleApiResponse getGoogleApiResponse(Point point1, Point point2) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        GoogleApiResponse googleApiResponse = mapper.readValue(createUrlToGoogleApi(point1, point2), GoogleApiResponse.class);
        return googleApiResponse;
    }

    private URL createUrlToGoogleApi(Point point1, Point point2) throws MalformedURLException {
        String finalUrl = url + getStringWithoutSpaces(point1.getStreet()) + "+" + point1.getStreetNumber().trim() + "+" + getStringWithoutSpaces(point1.getCity()) + "+"
                + point1.getPostCode().trim() + "+" + getStringWithoutSpaces(point1.getCountry()) + "&destinations="
                + getStringWithoutSpaces(point2.getStreet()) + "+" + point2.getStreetNumber().trim() + "+"
                + getStringWithoutSpaces(point2.getCity()) + "+" + point1.getPostCode().trim() + "+" + getStringWithoutSpaces(point1.getCountry()) + keyAndLanguageApi;
        return new URL(finalUrl);
    }

    private String getStringWithoutSpaces(String string) {
        String[] array = string.trim().split(" ");
        if (array.length > 1) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(array[0]);
            for (int i = 1; i < array.length; i++) {
                stringBuilder.append("+").append(array[i]);
            }
            return stringBuilder.toString();
        }
        return string;
    }
}
