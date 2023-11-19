public class Box3D {
    private Point3D _base;
    private int _length;
    private int _width;
    private int _height;

    /**
     * Constructs and initializes a box with base point, length, width and height.
     *
     * @param base   the base point of the box
     * @param length the length of the box
     * @param width  the width of the box
     * @param height the height of the box
     */
    public Box3D(Point3D base, int length, int width, int height) {
        _base = new Point3D(base);
        _length = length;
        _width = width;
        _height = height;
    }

    /**
     * Constructs and initializes a box with base point, length, width and height.
     *
     * @param x      the x coordinate of the base point of the box
     * @param y      the y coordinate of the base point of the box
     * @param z      the z coordinate of the base point of the box
     * @param length the length of the box
     * @param width  the width of the box
     * @param height the height of the box
     */
    public Box3D(double x, double y, double z, int length, int width, int height) {
        _base = new Point3D(x, y, z);
        _length = length;
        _width = width;
        _height = height;
    }

    /**
     * Constructs and initializes a box with base point, length, width and height.
     *
     * @param other the box which the new instance initialization will be based on
     */
    public Box3D(Box3D other) {
        _base = new Point3D(other._base);
        _length = other._length;
        _width = other._width;
        _height = other._height;
    }

    /**
     * Returns the base point of this box.
     *
     * @return the base point of this box.
     */
    public Point3D getBase() {
        return new Point3D(_base);
    }

    /**
     * Returns the length of this box.
     *
     * @return the length of this box.
     */
    public int getLength() {
        return _length;
    }

    /**
     * Returns the width of this box.
     *
     * @return the width of this box.
     */
    public int getWidth() {
        return _width;
    }

    public int getHeight() {
        return _height;
    }

    public void setLength(int num) {
        _length = num;
    }

    public void setWidth(int num) {
        _width = num;
    }

    public int getVolume() {
        return _length * _width * _height;
    }

    public double getSurfaceArea() {
        return 2 * (_length * _width + _length * _height + _width * _height);
    }

    @Override
    public String toString() {
        return "Base: " + _base.toString() + ", Length: " + _length + ", Width: " + _width + ", Height: " + _height;
    }

    public boolean isLargerCapacity(Box3D other) {
        return this.getVolume() > other.getVolume();
    }

    public boolean contains(Box3D other) {
        return this._length > other._length && this._width > other._width && this._height > other._height;
    }

    public int distance(Box3D other) {
        return (int) Math.sqrt(Math.pow(this._base.getX() - other._base.getX(), 2)
                + Math.pow(this._base.getY() - other._base.getY(), 2)
                + Math.pow(this._base.getZ() - other._base.getZ(), 2));
    }
}
