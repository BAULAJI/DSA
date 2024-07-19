import java.util.*;

class Main {
    public static boolean dfs(boolean[] vis, ArrayList<ArrayList<Integer>> al, int source, int destination) {
        if (source == destination) {
            return true;
        }
        vis[source] = true;
        for (int i = 0; i < al.get(source).size(); i++) {
            int neighbor = al.get(source).get(i);
            if (!vis[neighbor]) {
                if (dfs(vis, al, neighbor, destination)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int n = s.nextInt(); // Number of nodes
        int[] a = new int[n];
        int maxNodeValue = 0;
        
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
            if (a[i] > maxNodeValue) {
                maxNodeValue = a[i];
            }
        }
        
        int m = s.nextInt(); // Number of edges
        ArrayList<ArrayList<Integer>> al = new ArrayList<>(maxNodeValue + 1);
        
        for (int i = 0; i <= maxNodeValue; i++) {
            al.add(new ArrayList<>());
        }
        
        for (int i = 0; i < m; i++) {
            int u = s.nextInt();
            int v = s.nextInt();
            al.get(u).add(v);
            // al.get(v).add(u);
        }
        
        int source = s.nextInt();
        int destination = s.nextInt();
        
        boolean[] vis = new boolean[maxNodeValue + 1];
        boolean result = dfs(vis, al, source, destination);
        
        if (result) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
        
        s.close();
    }
}
