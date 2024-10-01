#!/bin/bash
read -p "Enter distancebetween two cities(in km):" dist
m=$(echo "$dist*1000"|bc)
echo "distance in metres : $m metres"
feet=$(echo "$dist*3280.84"|bc)
echo "distance in feet : $feet feet"
inch=$(echo "$dist*39370.01"|bc)
echo "distance in inches :$inch inches"
centi=$(echo "$dist*100000"|bc)
echo "distance in centimetres :$centi cm"
