package program;

public class SetMatrixZero {

    public static void main(String[] args) {
        final int[][] matrix = {{0, 1, 1, 6}, {1, 1, 1, 7}, {1, 0, 7, 3}};
        int[][] copyMatrix = new int[matrix.length][matrix[0].length];
        copyMatrix(matrix, copyMatrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    System.out.println("Found Zero at i=" + i + "j=" + j);
                    updateMatrix(copyMatrix, i, j);
                }
            }
        }
        printMatrix(copyMatrix);
    }

    private static void updateMatrix(int[][] copyMatrix, int rowIndex, int columnIndex) {
        for (int i = 0; i < copyMatrix.length; i++) {
            for (int j = 0; j < copyMatrix[i].length; j++) {
                if (i == rowIndex) {
                    copyMatrix[i][j] = 0;
                }
                if (j == columnIndex) {
                    copyMatrix[i][j] = 0;
                }
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void copyMatrix(int[][] fromMatrix, int[][] toMatrix) {
        for (int i = 0; i < fromMatrix.length; i++) {
            for (int j = 0; j < fromMatrix[i].length; j++) {
                toMatrix[i][j] = fromMatrix[i][j];
            }
        }
    }
}
