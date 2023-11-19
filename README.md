# 📚 JavaBoxKit3D: Geometry Classes Example in Java

## 📌 Overview

This repository contains Java classes for 3D geometric calculations, developed as part of my coursework for the _"20441 Introduction to Computer Science"_ class at the Open University of Israel in 2019b (Assignment 13), and earned a grade of `94`. 🏆

These classes include `Point3D`, `Box3D`, `Matrix`, and `Collection`, showcasing my skills in object-oriented programming and array manipulations in Java. This project is a testament to my foundational skills in Java, complementing my primary work in C, C++, and Python.

![cover image](java_cover.png)

---

## 📋 Classes Description

1. [**`Point3D`**:](Point3D.java) Represents a point in 3D space with x, y, and z coordinates.
2. [**`Box3D`**:](Box3D.java) Represents a 3D box with properties such as length, width, height, and a base point (`Point3D`).
3. [**`Matrix`**:](Box3D.java) A class that represents a two-dimensional matrix with various methods for matrix manipulation like rotation and averaging.
4. [**`Collection`**:](Collection.java) Represents a collection of `Box3D` objects, showcasing how to manage and manipulate a group of objects. It includes methods to add boxes, find the box with the most upper base corner, calculate total surface area, longest distance between boxes, and more.

## 🌟 Key Concepts Covered

- Object-Oriented Programming in Java.
- Working with 3D coordinates and geometric shapes.
- Implementing and manipulating matrices.
- Organizing and manipulating collections of objects.
- Calculating distances and volumes in a 3D space.

## 🚀 Getting Started

Clone the repository and compile the desired class file:

```java
javac Point3D.java
javac Box3D.java
javac Matrix.java
javac Collection.java
```

Run the compiled class file:

```java
java Point3D
java Box3D
java Matrix
java Collection
```

## 📝 Notes

- The `Collection` class demonstrates management of a collection of `Box3D` objects, with methods to add boxes, calculate total surface area, find the box with the highest base corner, determine the longest distance between two boxes, and more.
- The `Collection` class is specifically designed for `Box3D` objects and demonstrates array manipulation and object-oriented design principles in Java.

## 📜 License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
