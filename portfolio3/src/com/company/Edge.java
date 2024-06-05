package com.company;
import java.util.Objects;

public class Edge implements Comparable<Edge> {
    private final String source;
    private String destination;
    private int days;


    public Edge(String source, String destination, int days) {
        this.source = source;
        this.destination = destination;
        this.days = days;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public int getDays() {
        return days;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return days == edge.days && Objects.equals(destination, edge.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destination, days);
    }
    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.days, other.days);
    }
}
