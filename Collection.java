
/**
 * This class represent a collection of boxes, ordered by their capacity.
 *
 * @author studentp
 * @version 14.4.2019
 */
public class Collection {
    private Box3D[] _boxes;
    private int _noOfBoxes;
    static final int MAX_NUM_BOXES = 100;

    /**
     * Constructs and initializes a Collection with a default max max size.
     */
    public Collection() {
        _noOfBoxes = 0;
        _boxes = new Box3D[MAX_NUM_BOXES];
    }

    /**
     * A method for adding a box to the collection.
     * It's placed the box accoding to it's capacity.
     *
     * @param base   a base point for the box
     * @param length length of the box
     * @param width  width of the box
     * @param height height of the box
     * @return true if it's possible to add a box (the collection is not full)
     */
    public boolean addBox(Point3D base, int length, int width, int height) {
        if (_noOfBoxes >= MAX_NUM_BOXES) {
            return false;
        } // The collection is full, cant add more boxes

        Box3D boxToAdd = new Box3D(base, length, width, height);
        int BoxToAddPlace = 0; /*
                                * the default is that there is no
                                * larger box, so the box will be blaced 0.
                                */

        if (_noOfBoxes == BoxToAddPlace) {
            _boxes[0] = new Box3D(boxToAdd);
            _noOfBoxes++;
            return true;
        } // if the array is empty it an easy case - the box will be placed 1st.

        // if there are more boxes and enough spasce:
        for (int i = _noOfBoxes - 1; i >= 0; i--) {
            if (boxToAdd.isLargerCapacity(_boxes[i])) {
                if (_noOfBoxes == 1) {
                    BoxToAddPlace = 1;
                } else {
                    BoxToAddPlace = i + 1;
                    break;
                }
            } // SHAY: Correct
        } /*
           * because the loop is frome the biggest to the smallsest,
           * if the box larger than a box it's also bigger from boxes before.
           * if the box is not bigger than any box the place stays 0
           */

        for (int j = _noOfBoxes; j > BoxToAddPlace; j--) {
            _boxes[j] = new Box3D(_boxes[j - 1]);
        } /*
           * change the places of the larger boxes place before addind the new box
           * start from upper place because its empty
           */

        _boxes[BoxToAddPlace] = boxToAdd;
        _noOfBoxes++;
        return true;
    }

    /**
     * A method to find the box with the most upper base corner in the collection.
     *
     * @return The box with the most upper base corner in the collection.
     */
    public Box3D mostUpperBaseCorner() {
        if (_noOfBoxes == 0) {
            return null;
        } // The collection is empty

        int higherPlace = 0;
        for (int i = 0; i < _noOfBoxes; i++) {
            if (_boxes[i].getBase().getZ() > _boxes[higherPlace].getBase().getZ()) {
                higherPlace = i;
            } // SHAY: Use Box's isAbove method (-3)
        }
        return new Box3D(_boxes[higherPlace]);
    }

    /**
     * Calculates the total surface area of all the boxes in the collection.
     *
     * @return the total surface are of the boxes in the collection.
     */
    public int totalSurfaceArea() {
        if (_noOfBoxes == 0) {
            return 0;
        } // The collection is empty

        int totalSurfaceArea = 0;
        for (int i = 0; i < _noOfBoxes; i++) {
            totalSurfaceArea += this._boxes[i].getSurfaceArea();
        }
        return totalSurfaceArea;
    }

    /**
     * Calculates the longest distance between 2 box's centers.
     *
     * @return the total the longest distance between 2 box's centers.
     */
    public double longestDistance() {
        if (_noOfBoxes < 2) {
            return 0;
        } // Ther'e less than 2 boxes in the collection

        double longestDistance = 0.0;
        for (int i = 0; i < _noOfBoxes; i++) {
            for (int k = 0; k < _noOfBoxes; k++) {
                if (this._boxes[i].distance(this._boxes[k]) > longestDistance) {
                    longestDistance = _boxes[i].distance(this._boxes[k]);
                }
            }
        }
        return longestDistance;
    }

    /**
     * Calculates how many boxes in the collection can contain a given box.
     *
     * @param other a box to check how many boxes in the collection can contain.
     * @return the number of boxes in the collection that can contain the given box.
     */
    public int howManyContains(Box3D other) {
        Collection canContainBoxes = new Collection();
        // collection to collect the boxes that can contain
        for (int k = 0; k < this._noOfBoxes; k++) {
            if (this._boxes[k].contains(other)) {
                canContainBoxes.addBox(_boxes[k].getBase(), _boxes[k].getLength(),
                        _boxes[k].getWidth(), _boxes[k].getHeight());
            }
        }
        return canContainBoxes.getNumOfBoxes();
    }

    /**
     * Calculates how many boxes in the collection can contain given boxex.
     *
     * @param other a box to check how many boxes in the collection can contain.
     * @return the number of boxes in the collection that can contain the given box.
     */
    public int volumeOfSmallestBox(int i, int j) {
        if (i < 0 || j < 0 || i >= _noOfBoxes || j >= _noOfBoxes || i > j) {
            return 0;
        } // Invalid indexes
        int biggestLength = 0;
        int biggestWidth = 0;
        int biggestHight = 0;
        for (; i <= j; i++) {
            if (_boxes[i].getLength() > biggestLength) {
                biggestLength = _boxes[i].getLength();
            }
            if (_boxes[i].getWidth() > biggestWidth) {
                biggestWidth = _boxes[i].getWidth();
            }
            if (_boxes[i].getHeight() > biggestWidth) {
                biggestHight = _boxes[i].getHeight();
            }
        }
        return ((biggestLength + 1) * (biggestWidth + 1) * (biggestHight + 1));
    }

    /**
     * Create from a collection a new collection, in the size the number of boxes
     * the original collection has.
     *
     * @return a new collection in the size the number of boxesthe original
     *         collection has.
     */
    public Box3D[] getBoxes() {
        Box3D[] newCollection = new Box3D[_noOfBoxes];
        for (int i = 0; i < _noOfBoxes; i++) {
            newCollection[i] = new Box3D(this._boxes[i]);
        }
        return newCollection;
    }

    /**
     * Calculates how many boxes are in the collection.
     *
     * @return the number of boxes in the collection.
     */
    public int getNumOfBoxes() {
        return _noOfBoxes;
    }

    /**
     * Returns a string representation of this Collection object.
     *
     * @override toString in class java.lang.Object
     */
    public String toString() {
        String returnString = new String();
        for (int i = 0; i < _noOfBoxes; i++) {// adding to the string every box in the collection
            returnString += ("Box no. " + (i + 1) + ": The base point is " + _boxes[i].getBase()
                    + ", length = " + _boxes[i].getLength() + ", width = " + _boxes[i].getWidth()
                    + ", height = " + _boxes[i].getHeight() + "\n");
        }
        return returnString;
    }

    public void printCollection() {
        for (int i = 0; i < _noOfBoxes; i++) {
            System.out.println(_boxes[i].toString());
        }
    }

    public static void main(String[] args) {
        Collection boxCollection = new Collection();

        // Add boxes and check if addition was successful
        System.out.println("Adding box: " + boxCollection.addBox(new Point3D(1, 2, 3), 4, 5, 6));
        System.out.println("Adding box: " + boxCollection.addBox(new Point3D(2, 3, 4), 5, 6, 7));
        System.out.println("Adding box: " + boxCollection.addBox(new Point3D(3, 4, 5), 6, 7, 8));

        // Print the current collection
        System.out.println("Current Collection:");
        boxCollection.printCollection();

        // Test for the box with the most upper base corner
        Box3D upperBox = boxCollection.mostUpperBaseCorner();
        if (upperBox != null) {
            System.out.println("Box with the most upper base corner: " + upperBox);
        } else {
            System.out.println("Collection is empty.");
        }

        // Test for the total surface area
        int totalSurfaceArea = boxCollection.totalSurfaceArea();
        System.out.println("Total surface area of all boxes: " + totalSurfaceArea);

        // Test for the longest distance between any two boxes
        double longestDist = boxCollection.longestDistance();
        System.out.println("Longest distance between any two boxes: " + longestDist);

        // Test for how many boxes can contain a given box
        Box3D testBox = new Box3D(new Point3D(1, 1, 1), 2, 2, 2);
        int containCount = boxCollection.howManyContains(testBox);
        System.out.println("Number of boxes that can contain the test box: " + containCount);

        // Test for volume of the smallest box that can contain boxes in a range
        int volume = boxCollection.volumeOfSmallestBox(0, 2); // Test with the first three boxes
        System.out.println("Volume of the smallest box that can contain boxes from index 0 to 2: " + volume);

        // Test edge case: Adding a box when the collection is full
        for (int i = 0; i < Collection.MAX_NUM_BOXES - 3; i++) { // -3 because 3 boxes are already added
            boxCollection.addBox(new Point3D(i, i + 1, i + 2), i + 3, i + 4, i + 5);
        }
        System.out.println("Attempting to add another box to a full collection: " +
                boxCollection.addBox(new Point3D(100, 100, 100), 10, 10, 10));
    }
}