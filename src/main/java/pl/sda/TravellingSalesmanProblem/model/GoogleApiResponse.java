package pl.sda.TravellingSalesmanProblem.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.persistence.criteria.CriteriaBuilder;
import java.lang.reflect.Array;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GoogleApiResponse {

    private String[] destination_addresses;
    private String[] origin_addresses;
    private String status;
    private int distance;
    private int duration;

//    @SuppressWarnings("unchecked")
    @JsonProperty("rows")
    private void unpackNested(List<Map<String, Object>> rows) {
        List<Map<String,Object>> elements = (List<Map<String,Object>>) rows.get(0).get("elements");

        if (elements.size() == 1){
            Map<String, Integer> distanceMap = (Map<String, Integer>) elements.get(0).get("distance");
            this.distance = distanceMap.get("value");

            Map<String, Integer> durationMap = (Map<String, Integer>) elements.get(0).get("duration");
            this.duration = durationMap.get("value");
        }
    }

    @Override
    public String toString() {
        return "GoogleApiResponse{" +
                "destination_addresses=" + Arrays.toString(destination_addresses) +
                ", origin_addresses=" + Arrays.toString(origin_addresses) +
                ", status='" + status + '\'' +
                ", distance=" + distance +
                ", duration=" + duration +
                '}';
    }
}

