package com.company;
import java.util.List;
import java.util.Map;
public class Main {
    public static void main(String[] args) {
        ShippingNetwork shippingNetwork = new ShippingNetwork("C:\\Users\\sebas\\IdeaProjects\\portfolio3\\src\\network.txt");
        Map<String, List<Edge>> graph = shippingNetwork.getGraph();

        for (String port : graph.keySet()) {
            System.out.println("Port: " + port);
            for (Edge edge : graph.get(port)) {
                System.out.println("  Destination: " + edge.getDestination() + ", Days: " + edge.getDays());
            }
        }
        System.out.println();
        System.out.println("Graph is connected: " + shippingNetwork.isConnected());
        System.out.println();

        List<Edge> mstEdges = shippingNetwork.minimumSpanningTree();
        int totalDuration = mstEdges.stream().mapToInt(Edge::getDays).sum();

        System.out.println("Minimum Spanning Tree edges:");
        for (Edge edge : mstEdges) {
            System.out.println(edge.getSource() + " -> " + edge.getDestination() + ", Days: " + edge.getDays());
        }

        System.out.println("Total duration of the Minimum Spanning Tree: " + totalDuration + " Days");

    }
}

