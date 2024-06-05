package com.company;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ShippingNetwork {
    private final Map<String, List<Edge>> graph = new HashMap<>();

    public ShippingNetwork(String filename) {

        readNetworkFromFile(filename);
    }

    private void readNetworkFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens.length != 3) {
                    System.err.println("Invalid line format: " + line);
                    continue;
                }
                String port1 = tokens[0].trim();
                String port2 = tokens[1].trim();
                int days = Integer.parseInt(tokens[2].trim());

                addEdge(port1, port2, days);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void addEdge(String port1, String port2, int days) {
        graph.putIfAbsent(port1, new ArrayList<>());
        graph.putIfAbsent(port2, new ArrayList<>());
        graph.get(port1).add(new Edge(port1,port2, days));
        graph.get(port2).add(new Edge(port1,port2, days));
    }

    public Map<String, List<Edge>> getGraph() {
        return graph;
    }

    public boolean isConnected() {
        if (graph.isEmpty()) {
            return false;
        }

        String startingPort = graph.keySet().iterator().next();
        Set<String> visitedPorts = new HashSet<>();
        dfs(startingPort, visitedPorts);

        return visitedPorts.size() == graph.size();
    }

    private void dfs(String currentPort, Set<String> visitedPorts) {
        visitedPorts.add(currentPort);

        for (Edge edge : graph.get(currentPort)) {
            String destination = edge.getDestination();
            if (!visitedPorts.contains(destination)) {
                dfs(destination, visitedPorts);
            }
        }
    }

    // MST
    public List<Edge> minimumSpanningTree() {
        List<Edge> allEdges = new ArrayList<>();
        for (List<Edge> edges : graph.values()) {
            allEdges.addAll(edges);
        }

        Collections.sort(allEdges);

        DisjointSet disjointSet = new DisjointSet();
        for (String port : graph.keySet()) {
            disjointSet.makeSet(port);
        }

        List<Edge> mstEdges = new ArrayList<>();
        for (Edge edge : allEdges) {
            String port1 = edge.getSource();
            String port2 = edge.getDestination();

            if (disjointSet.union(port1, port2)) {
                mstEdges.add(edge);
            }
        }

        return mstEdges;
    }

}
