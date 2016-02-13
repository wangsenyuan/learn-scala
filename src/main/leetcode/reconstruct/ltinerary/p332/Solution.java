package reconstruct.ltinerary.p332;

import geeks.max.flow.Graph;

import java.util.*;

/**
 * Created by senyuanwang on 16/2/5.
 */
public class Solution {

    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> targets = new HashMap<>();
        List<String> route = new LinkedList();

        for (String[] ticket : tickets)
            targets.computeIfAbsent(ticket[0], k -> new PriorityQueue()).add(ticket[1]);
        visit("JFK", targets, route);
        return route;
    }

    void visit(String airport, Map<String, PriorityQueue<String>> targets, List<String> route) {
        while (targets.containsKey(airport) && !targets.get(airport).isEmpty())
            visit(targets.get(airport).poll(), targets, route);
        route.add(0, airport);
    }

    public static void main(String[] args) {
        String[][] tickets = {{"JFK", "KUL"}, {"JFK", "NRT"}, {"NRT", "JFK"}};
        List<String> result = new Solution().findItinerary(tickets);
        System.out.println(result);
    }
}
