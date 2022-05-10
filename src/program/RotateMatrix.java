package program;

public class RotateMatrix {
    public static void main(String[] args) {
        final int[][] matrix = {{0, 1, 1}, {1, 1, 1}, {1, 0, 7}};
        int[][] copyMatrix = new int[matrix.length][matrix[0].length];
        copyMatrix(matrix, copyMatrix);
        int r = 0;
        for (int i = 0; i < matrix.length; i++) {
            int c = 0;
            for (int j = matrix[i].length - 1; j >= 0; j--) {
                updateCopyMatrix(copyMatrix, matrix[j][i], r, c);
                c++;
            }
            r++;
        }
        printMatrix(copyMatrix);
    }

    private static void updateCopyMatrix(int[][] copyMatrix, int value, int row, int column) {
        copyMatrix[row][column] = value;
    }

    private static void copyMatrix(int[][] fromMatrix, int[][] toMatrix) {
        for (int i = 0; i < fromMatrix.length; i++) {
            for (int j = 0; j < fromMatrix[i].length; j++) {
                toMatrix[i][j] = fromMatrix[i][j];
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
}
