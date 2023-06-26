package leetcode.graph;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

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
        List<Integer> leafs = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() == 1) {
                leafs.add(entry.getKey());
            }
        }
        while (map.size() > 2) {
            List<Integer> newLeaf = new ArrayList<>();
            for (Integer leaf : leafs) {
                Integer val = map.get(leaf).get(0);
                map.remove(leaf);
                List<Integer> list = map.get(val);
                list.remove(leaf);
                if (list.size() == 1) {
                    newLeaf.add(val);
                }
            }
            leafs = newLeaf;
        }
        return new ArrayList<>(map.keySet());
    }
}
