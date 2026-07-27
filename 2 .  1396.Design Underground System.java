import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {

    private Map<Integer, CheckIn> checkInMap;
    private Map<String, int[]> travelMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        travelMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckIn checkIn = checkInMap.get(id);

        String route = checkIn.station + "->" + stationName;
        int time = t - checkIn.time;

        travelMap.putIfAbsent(route, new int[2]);

        travelMap.get(route)[0] += time;
        travelMap.get(route)[1]++;

        checkInMap.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "->" + endStation;
        int[] data = travelMap.get(route);

        return (double) data[0] / data[1];
    }

    private static class CheckIn {
        String station;
        int time;

        CheckIn(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }
}
