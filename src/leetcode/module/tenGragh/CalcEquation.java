package leetcode.module.tenGragh;

import java.util.*;

public class CalcEquation {
    class Cell {
        String parent;
        double weight;

        Cell(String parent, double weight) {
            this.parent = parent;
            this.weight = weight;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Cell>> graph = new HashMap<>();

        //创建一个双向图
        for (int i = 0; i < values.length; i++){
            graph.computeIfAbsent(equations.get(i).get(0), k -> new ArrayList<>()).add(new Cell(equations.get(i).get(1), values[i]));
            graph.computeIfAbsent(equations.get(i).get(1), k -> new ArrayList<>()).add(new Cell(equations.get(i).get(0), 1/values[i]));
        }

        double[] res = new double[queries.size()];

        Arrays.fill(res,-1.0);
        for (int i = 0; i < queries.size(); i++){
            dfs(queries.get(i).get(0), queries.get(i).get(1), 1.0, graph, res, i, new HashSet<>());
        }

        return res;



    }

    private void dfs(String start, String end, double curWeight, Map<String, List<Cell>> graph, double[] res, int idx, Set<String> visited){
        if (!visited.add(start)){
            return;
        }

        if (start.equals(end) && graph.containsKey(start)){
            res[idx] = curWeight;
            return;
        }

        for(Cell neighbor : graph.getOrDefault(start, new ArrayList<>())){
            dfs(neighbor.parent, end, curWeight * neighbor.weight, graph, res, idx, visited);
        }
    }


    // Main method to test the solution with example input
    public static void main(String[] args) {
        CalcEquation solution = new CalcEquation();

        // Example input for equations, values, and queries
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));

        double[] values = {2.0, 3.0};

        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("a", "e"));
        queries.add(Arrays.asList("a", "a"));
        queries.add(Arrays.asList("x", "x"));

        // Call the method to calculate the result
        double[] result = solution.calcEquation(equations, values, queries);

        // Print the result
        System.out.println(Arrays.toString(result));  // Output: [6.0, 0.5, -1.0, 1.0, -1.0]
    }
}
