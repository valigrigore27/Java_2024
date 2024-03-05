public class WheelGraphAdjacencyMatrix {
    private final int[][] adjacencyMatrix;

    public WheelGraphAdjacencyMatrix(int n) {
        adjacencyMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    adjacencyMatrix[i][j] = 0;
                } else if (i == 0 || j == 0) {
                    adjacencyMatrix[i][j] = 1;
                } else if (Math.abs(i - j) == 1 || Math.abs(i - j) == n - 2) {
                    adjacencyMatrix[i][j] = 1;
                } else {
                    adjacencyMatrix[i][j] = 0;
                }
            }
        }
    }

    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    public static void printAdjacencyMatrix(int[][] adjacencyMatrix) {
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix[i].length; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        //if (args.length != 1) {
            //System.out.println("Usage: java WheelGraphAdjacencyMatrix <n>");
        //} else {

            //int n = Integer.parseInt(args[0]);
            int n=5;
            WheelGraphAdjacencyMatrix wheelGraph = new WheelGraphAdjacencyMatrix(n);
            printAdjacencyMatrix(wheelGraph.getAdjacencyMatrix());
        }
    }


//}
