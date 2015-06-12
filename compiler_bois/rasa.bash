#!/bin/bash
totalRasa=0
totalLines=0
for arg in "$@" 
do
    rasaCount=0
    lineCount=0
    multiplier=1

    while read -r line 
    do
        if [[ "$line" =~ { ]]; then
            multiplier=$((multiplier + 1))
        fi
        if [[ "$line" =~ \; ]]; then
            rasaCount=$((rasaCount + 1 * multiplier))
        fi
        if [[ "$line" =~ } ]]; then
            multiplier=$((multiplier - 1))
        fi
        lineCount=$((lineCount + 1))
    done < "$arg"

    totalRasa=$((totalRasa + rasaCount))
    totalLines=$((totalLines + lineCount))
    echo $arg ": lines " $lineCount ", RaSa " $rasaCount 
done

echo "total: lines " $totalLines ", RaSa " $totalRasa
