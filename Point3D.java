/**
 * Represents a point in 3D space.
 */
public class Point3D {
    private double _x;
    private double _y;
    private double _z;

    /**
     * Constructs and initializes a Point3D from the specified x, y, z coordinates.
     *
     * @param x the x coordinate
     * @param y the y coordinate
     * @param z the z coordinate
     */
    public Point3D() {
        _x = 0;
        _y = 0;
        _z = 0;
    }

    /**
     * Constructs and initializes a Point3D from the specified x, y, z coordinates.
     *
     * @param x the x coordinate
     * @param y the y coordinate
     * @param z the z coordinate
     */
    public Point3D(double x, double y, double z) {
        _x = x;
        _y = y;
        _z = z;
    }

    /**
     * Constructs and initializes a Point3D from the specified Point3D.
     *
     * @param other the Point3D which the new instance initialization will be based
     *              on
     */
    public Point3D(Point3D other) {
        _x = other._x;
        _y = other._y;
        _z = other._z;
    }

    /**
     * Returns the x coordinate of this Point3D.
     *
     * @return the x coordinate of this Point3D.
     */
    public double getX() {
        return _x;
    }

    /**
     * Returns the y coordinate of this Point3D.
     *
     * @return the y coordinate of this Point3D.
     */
    public double getY() {
        return _y;
    }

    /**
     * Returns the z coordinate of this Point3D.
     *
     * @return the z coordinate of this Point3D.
     */
    public double getZ() {
        return _z;
    }

    /**
     * Sets the x coordinate of this Point3D.
     *
     * @param num the new x coordinate.
     */
    public void setX(double num) {
        _x = num;
    }

    /**
     * Sets the y coordinate of this Point3D.
     *
     * @param num the new y coordinate.
     */
    public void setY(double num) {
        _y = num;
    }

    /**
     * Sets the z coordinate of this Point3D.
     *
     * @param num the new z coordinate.
     */
    public void setZ(double num) {
        _z = num;
    }

    @Override
    public String toString() {
        return "(" + _x + ", " + _y + ", " + _z + ")";
    }
}