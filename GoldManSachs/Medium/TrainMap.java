package GoldManSachs.Medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Represents Station in the rail network. Each station is identified by unique
 * name.
 * Station is connected with other stations - this information is stored in the
 * 'neighbours' field.
 * Two station objects with the same name are equal therefore they are
 * considered to be same station.
 */
class Station {
    private String name;
    private List<Station> neighbours;

    Station(String name) {
        this.name = name;
        this.neighbours = new ArrayList<>(3);
    }

    String getName() {
        return name;
    }

    void addNeighbour(Station v) {
        this.neighbours.add(v);
    }

    List<Station> getNeighbours() {
        return this.neighbours;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Station && this.name.equals(((Station) obj).getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }
}

/**
 * class TrainMap
 * <p>
 * Respresents whole rail network - consists of number of the Station objects.
 * Stations in the map are bi-directionally connected. Distance between any 2
 * stations
 * is of same constant distance unit. This implies that shortest distance
 * between any
 * 2 stations depends only on number of stations in between
 */
public class TrainMap {

    private HashMap<String, Station> stations;

    TrainMap() {
        this.stations = new HashMap<>();
    }

    TrainMap addStation(String name) {
        Station s = new Station(name);
        this.stations.putIfAbsent(name, s);
        return this;
    }

    Station getStation(String name) {
        return this.stations.get(name);
    }

    TrainMap connectStations(Station fromStation, Station toStation) {
        if (fromStation == null)
            throw new IllegalArgumentException("From station is null");
        if (toStation == null)
            throw new IllegalArgumentException("From station is null");

        fromStation.addNeighbour(toStation);
        toStation.addNeighbour(fromStation);
        return this;
    }

    List<Station> shortestPath(final String from, final String to) {
        Queue<Station> queue = new LinkedList<>();
        Map<Station, Station> parentMap = new HashMap<>();

        Station startStation = stations.get(from);
        Station endStation = stations.get(to);

        queue.add(startStation);
        parentMap.put(startStation, null);

        while (!queue.isEmpty()) {
            Station currentStation = queue.poll();

            if (currentStation == endStation) {
                break; // Found the destination
            }

            for (Station neighbor : currentStation.getNeighbours()) {
                if (!parentMap.containsKey(neighbor)) {
                    queue.add(neighbor);
                    parentMap.put(neighbor, currentStation);
                }
            }
        }

        // Reconstruct the path
        List<Station> path = new ArrayList<>();
        Station current = endStation;
        while (current != null) {
            path.add(current);
            current = parentMap.get(current);
        }
        Collections.reverse(path);

        return path;
    }

    public static void main(String[] args) {
        if (doTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.out.println("Tests fail.");
        }
    }

    private static boolean doTestsPass() {
        // todo: implement more tests, please
        // feel free to make testing more elegant
        TrainMap trainMap = new TrainMap();

        trainMap.addStation("King's Cross St Pancras").addStation("Angel").addStation("Old Street")
                .addStation("Moorgate")
                .addStation("Farringdon").addStation("Barbican").addStation("Russel Square").addStation("Holborn")
                .addStation("Chancery Lane").addStation("St Paul's").addStation("Bank");

        trainMap.connectStations(trainMap.getStation("King's Cross St Pancras"), trainMap.getStation("Angel"))
                .connectStations(trainMap.getStation("King's Cross St Pancras"), trainMap.getStation("Farringdon"))
                .connectStations(trainMap.getStation("King's Cross St Pancras"), trainMap.getStation("Russel Square"))
                .connectStations(trainMap.getStation("Russel Square"), trainMap.getStation("Holborn"))
                .connectStations(trainMap.getStation("Holborn"), trainMap.getStation("Chancery Lane"))
                .connectStations(trainMap.getStation("Chancery Lane"), trainMap.getStation("St Paul's"))
                .connectStations(trainMap.getStation("St Paul's"), trainMap.getStation("Bank"))
                .connectStations(trainMap.getStation("Angel"), trainMap.getStation("Old Street"))
                .connectStations(trainMap.getStation("Old Street"), trainMap.getStation("Moorgate"))
                .connectStations(trainMap.getStation("Moorgate"), trainMap.getStation("Bank"))
                .connectStations(trainMap.getStation("Farringdon"), trainMap.getStation("Barbican"))
                .connectStations(trainMap.getStation("Barbican"), trainMap.getStation("Moorgate"));

        String solution = "King's Cross St Pancras->Russel Square->Holborn->Chancery Lane->St Paul's";
        List<Station> result = trainMap.shortestPath("King's Cross St Pancras", "St Paul's");
        return solution.equals(result.stream().map(Station::getName).collect(Collectors.joining("->")));
    }
}