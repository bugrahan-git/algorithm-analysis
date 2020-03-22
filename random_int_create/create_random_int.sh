#!/bin/bash
rm *.class 2>/dev/null
javac randomInt.java
rand=(4096 16384 65536 131072 262144 524288)
for int in ${rand[@]}; do
    for i in {1..25}; do
        java randomInt $int "${int}_$i"
        mv "${int}_$i" ./randints
    done
done