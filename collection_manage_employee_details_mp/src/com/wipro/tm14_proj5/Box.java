package com.wipro.tm14_proj5;

import java.util.Objects;

class Box {
    double length;
    double width;
    double height;

    Box(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    double getVolume() {
        return length * width * height;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Box box = (Box) obj;
        return Double.compare(box.getVolume(), this.getVolume()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVolume());
    }

    @Override
    public String toString() {
        return "Length = " + length + " Width = " + width + " Height = " + height + " Volume = " + getVolume();
    }
}
