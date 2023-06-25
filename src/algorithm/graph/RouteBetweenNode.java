package algorithm.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RouteBetweenNode {

    public static void main(String[] args) {
        int[][] prerequisites = {{0, 1}, {1, 2}, {2, 3}, {3, 5}, {4, 6}, {5, 7}, {6, 7}};
        int[] route = {3, 6};
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] data : prerequisites) {
            List<Integer> neighbors = map.computeIfAbsent(data[0], t -> new ArrayList<>());
            neighbors.add(data[1]);
        }
        boolean isRoutePresent = checkRoute(map, route[0], route[1]);
        System.out.println(isRoutePresent);
    }

    private static boolean checkRoute(Map<Integer, List<Integer>> map, int start, int end) {
        boolean routeFound = false;
        List<Integer> neighbors = map.get(start);
        if (neighbors == null) {
            return false;
        }
        if (neighbors.contains(end)) {
            return true;
        }
        for (Integer neighbor : neighbors) {
            routeFound = checkRoute(map, neighbor, end);
            if (routeFound) {
                return routeFound;
            }
        }
        return routeFound;
    }

}
