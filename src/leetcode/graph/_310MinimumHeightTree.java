package leetcode.graph;

import java.util.*;

public class _310MinimumHeightTree {

    public static void main(String[] args) {
        _310MinimumHeightTree obj = new _310MinimumHeightTree();
       /* int[][] edges = {{1,0},{1,2},{1,3}};
        int n = 4;*/
        int[][] edges = {{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};
        int n = 6;
/*        int[][] edges = {{0, 1}};
        int n = 2;*/
        List<Integer> nodes = obj.findMinHeightTrees(n, edges);
        System.out.println(nodes);
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n <= 1) {
            List<Integer> temp = new ArrayList<>();
            temp.add(0);
            return temp;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            List<Integer> list1 = map.computeIfAbsent(edge[0], t -> new ArrayList<>());
            list1.add(edge[1]);
            List<Integer> list2 = map.computeIfAbsent(edge[1], t -> new ArrayList<>());
            list2.add(edge[0]);
        }
        Map<Integer, List<Integer>> resultMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int path = findMinHeightTrees(i, map, new HashSet<>(), 0);
            List<Integer> nodes = resultMap.computeIfAbsent(path, t -> new ArrayList<>());
            nodes.add(i);
        }
        for (int i = 0; i < n; i++) {
            if (null != resultMap.get(i)) {
                return resultMap.get(i);
            }
        }
        return null;
    }

    public Integer findMinHeightTrees(int val, Map<Integer, List<Integer>> map, Set<Integer> navigated, Integer pathCount) {
        List<Integer> neighbors = map.get(val);
        boolean leafNode = true;
        for (Integer neighbor : neighbors) {
            if (!navigated.contains(neighbor)) {
                leafNode = false;
            }
        }
        if (leafNode) {
            return pathCount;
        }
        navigated.add(val);
        Integer path = Integer.MIN_VALUE;
        for (Integer neighbor : neighbors) {
            if (!navigated.contains(neighbor)) {
                int pathFound = findMinHeightTrees(neighbor, map, navigated, pathCount + 1);
                path = Math.max(path, pathFound);
            }
        }
        return path;
    }

}
