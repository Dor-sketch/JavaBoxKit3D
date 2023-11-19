/**
 * This class represtents a photo matrix.
 *
 * @author studentp
 * @version 15.04.19
 */
public class Matrix {
    private int[][] _matrixArray;

    /**
     * Constructs a Matric from a two-dimensional array, the dimensions as well as
     * the values of thes Matrix will be the same as the dimensions and values of
     * the two-dimensional array,
     *
     * @param array array to build upon a new array.
     */
    public Matrix(int[][] array) {
        int numberOfRows = array.length;
        int numberOfColumns = array[0].length;
        _matrixArray = new int[numberOfRows][numberOfColumns];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                _matrixArray[i][j] = array[i][j];
            }
        }
    }

    /**
     * Constructs a size1 by size2 Matrix of zeones.
     *
     * @param size1 the number of the array rows
     * @param size2 the number of the array columns
     */
    public Matrix(int size1, int size2) {
        _matrixArray = new int[size1][size2];
    }

    /**
     * Returns a string representation of this Matrix object.
     * Every line represented in a new line
     *
     * @override toString in class java.lang.Object
     */
    public String toString() {
        String returnString = new String();
        for (int i = 0; i < _matrixArray.length; i++) {
            for (int j = 0; j < _matrixArray[i].length; j++) {
                returnString += _matrixArray[i][j];
                if (j == _matrixArray[i].length - 1) {
                    returnString += "\n";
                } // in case there are no more elements in the line
                else {
                    returnString += "\t";
                } // in case there are more elemnts in the line
            }
        }
        return returnString;
    }

    /**
     * Create a negative matrix.
     *
     * @retern new Matrix with the negative values in each cell.
     */
    public Matrix makeNegative() {
        Matrix negativeArray = new Matrix(this._matrixArray);
        for (int i = 0; i < negativeArray._matrixArray.length; i++) {
            for (int j = 0; j < negativeArray._matrixArray[i].length; j++) {
                negativeArray._matrixArray[i][j] -= 255;// minus 225 creates the negative value // SHAY: Use finals (-3)
                negativeArray._matrixArray[i][j] *= -1;// the value should be positive
            }
        }
        return negativeArray;
    }

    /**
     * Check if a specific loactaion is included in an array.
     *
     * @param other the array to check if it contains the location
     * @return true if the location is inside the bounderies of the array.
     */
    private boolean cellExists(Matrix other, int line, int row) {
        if (0 <= line && line < other._matrixArray.length &&
                0 <= row && row < other._matrixArray[0].length) {
            // if the cell index aren't negative
            // and if ther'e not bigger than the array length (max row and column index)
            return true;
        }
        return false;
    }

    /**
     * Create a new, softner (more even) matrix.
     *
     * @retrurn a matrix with more even values.
     */
    public Matrix imageFilterAverage() {
        int sum = 0, divide = 0;
        Matrix copyMatrix = new Matrix(this._matrixArray);
        // create a new object to check avarages off cells before chcnges
        for (int i = 0; i < copyMatrix._matrixArray.length; i++) {
            for (int j = 0; j < copyMatrix._matrixArray[i].length; j++) {
                for (int k = i - 1; k <= i + 1; k++) {
                    for (int p = j - 1; p <= j + 1; p++) {
                        if (cellExists(copyMatrix, k, p) == true) {
                            sum += copyMatrix._matrixArray[k][p];
                            divide++;
                        } /*
                           * the method checks elements: in the colume indexes
                           * before, on,and after the cell (i-1,i,i+1)
                           * in the row indexes under,on, and above the cell (j-1,j,j+1)
                           * if there are cells, it adds their values to the sum
                           * and +1 to the divide
                           */
                    }
                }
                this._matrixArray[i][j] = sum / divide;
                // than it calcultes the avarage and changes the cell value.
                sum = 0;
                divide = 0; // reset the sum and divide for the next cell.
            }
        }
        return this;
    }

    /**
     * Rotate the matrix 90 degrees right.
     *
     * @return a right-rotated matrix.
     */
    public Matrix rotateClockwise() {
        Matrix rightRotated = new Matrix(this._matrixArray[0].length,
                this._matrixArray.length);
        // the new matrix column number is the the original row number
        // and its row number is ther original column number
        int k = 0, z = rightRotated._matrixArray[0].length - 1;
        for (int i = 0; i < this._matrixArray.length; i++) {
            for (int j = 0; j < this._matrixArray[0].length; j++, k++) {
                rightRotated._matrixArray[k][z] = this._matrixArray[i][j];
            } /*
               * the method places one element in each row every time:
               * from the farest cell in each column until the lowest one (0),
               * while moving up in the rows.
               */
            z--;
            k = 0;
        }
        return rightRotated;
    }

    /**
     * Rotate the matrix 90 degrees left.
     *
     * @return a left-rotated matrix.
     */
    public Matrix rotateCounterClockwise() {
        Matrix leftRotated = new Matrix(this._matrixArray[0].length,
                this._matrixArray.length);
        int k = leftRotated._matrixArray.length - 1, z = 0;
        for (int i = 0; i < this._matrixArray.length; i++) {
            for (int j = 0; j < this._matrixArray[0].length; j++, k--) {
                leftRotated._matrixArray[k][z] = this._matrixArray[i][j];
            } /*
               * the method places one element in each row every time:
               * from the closest cell in each column (0) until the farest one.
               * while moving down in the rows.
               */
            z++;
            k = leftRotated._matrixArray.length - 1;
        }
        return leftRotated;
    }

    public static void main(String[] args) {
        int[][] array = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        Matrix matrix = new Matrix(array);
        System.out.println(matrix);
        System.out.println(matrix.makeNegative());
        System.out.println(matrix.imageFilterAverage());
        System.out.println(matrix.rotateClockwise());
        System.out.println(matrix.rotateCounterClockwise());
    }
}