package oj.leetcode.hard;
import java.util.*;

public class ReconstructItinerary_332 {
    public List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> path = new LinkedList<>();
        Map<String, PriorityQueue<String>> itineraryGraph = new LinkedHashMap<>();

        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            itineraryGraph.computeIfAbsent(from, val -> new PriorityQueue<>()).add(to);
        }
        path.add("JFK");
        traversal(path.get(path.size()-1), itineraryGraph, path);

        return path;
    }

    private void traversal(String current, Map<String, PriorityQueue<String>> graph, LinkedList<String> path)
    {
        PriorityQueue<String> neighbours = graph.get(current);
        while (neighbours != null && !neighbours.isEmpty())
        {
            traversal(neighbours.poll(), graph, path);

        }
        path.addFirst(current);

    }
}
