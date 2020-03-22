#!/bin/bash
rm *.class 2>/dev/null
rm -r logs/
for file in *.java; do
    javac $file 
done
mkdir logs/
for file in *.class; do
    for randint in random_int_create/randints/*; do
        echo "Processing file $file with input $randint"
        temp=`echo $file | awk -F'.' '{print $1}'`"_"`echo $randint | awk -F'/' '{print $3}'`".log"
        touch "$temp"
        { time java `echo $file | awk -F'.' '{print $1}'` $randint ;} 2> $temp
        mv "$temp" logs/
    done
done
