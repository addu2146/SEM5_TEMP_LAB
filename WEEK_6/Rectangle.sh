#!/bin/bash
echo "Enter the length of the rectangle"
read length
echo "Enter the Breadth of the rectangle"
read breadth
echo "Enter the radius of the circle"
read radius
rect_area=$(echo "$length*$breadth"|bc)
rect_perim=$(echo "2*($length+$breadth)"|bc)

circle_area=$(echo "3.14*$radius*$radius"|bc)
circle_circum=$(echo "2*3.14*$radius"|bc)
echo "Rectangle::"
echo "AREA :: $rect_area"
echo "PERIMETER :: $rect_perim"

echo "CIRCLE::"
echo "AREA :: $circle_area"
echo "CIRCUMFERENCE :: $circle_circum"
