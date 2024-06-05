package com.company;

import java.util.HashMap;
import java.util.Map;

public class DisjointSet {
    private final Map<String, String> parent = new HashMap<>();
    private final Map<String, Integer> rank = new HashMap<>();

    public void makeSet(String x) {
        parent.put(x, x);
        rank.put(x, 0);
    }

    public String find(String x) {
        if (!parent.get(x).equals(x)) {
            parent.put(x, find(parent.get(x)));
        }
        return parent.get(x);
    }

    public boolean union(String x, String y) {
        String rootX = find(x);
        String rootY = find(y);

        if (rootX.equals(rootY)) {
            return false;
        }

        int rankX = rank.get(rootX);
        int rankY = rank.get(rootY);

        if (rankX < rankY) {
            parent.put(rootX, rootY);
        } else if (rankX > rankY) {
            parent.put(rootY, rootX);
        } else {
            parent.put(rootY, rootX);
            rank.put(rootX, rankX + 1);
        }

        return true;
    }
}
