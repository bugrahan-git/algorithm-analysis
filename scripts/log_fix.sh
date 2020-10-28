#!/bin/bash
rm all.log 2>/dev/null
for file in ./logs/*; do
    echo -n `echo $file | awk -F'/' '{print $3}' | awk -F'.' '{print $1}' | awk '{ gsub("_", " ", $1); print $1 }'` >> all.log
    tempA=`head -2 $file | tail -1 | awk -F' ' '{print $2}' | awk -F'm' '{print $1}'`
    tempB=`head -2 $file | tail -1 | awk -F' ' '{print $2}' | awk -F'm' '{print $2}' | awk '{ gsub(",", "", $1); print $1 }' | awk '{ gsub("s", "", $1); print $1 }'`
    tempC=$(($tempA * 60000))
    tempC=$(($tempC + 10#$tempB))
    echo $tempC | sed 's/^/ /' >> all.log 
done