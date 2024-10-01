#!/bin/bash
read -p "Enter a five digit number: " num
sum=0
while((num!=0))
do
digit=$((num%10))
sum=$((sum+digit))
num=$((num/10))
done
echo "sum of the digits is : $sum"
