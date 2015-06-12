#!/bin/bash

timer=1;
lines=0;
rask=0;
allLines=0;

function DoRasa() {
    local file;
    local allLines;
    local timer;
    local lines;
    local rask;
    local allLines;

    timer=1;
    lines=0;
    rask=0;
    allLines=0;
    file=$1;
    shift
    allLines=0;
    
    while read R ; do
        ((allLines+=1))
        while [ ${#R} -gt 0 ]; do
            c=${R:0:1};
            R=${R:1}
            if [ "$c" = ";" ]; then
                ((lines += 1));
            fi
            if [ "$c" = "{" ]; then
                ((rask += lines * timer));
                ((timer += 1));
                ((lines = 0));
            fi
            if [ "$c" = "}" ]; then
                ((rask += lines * timer));
                if [ $timer -gt 1 ]; then
                    ((timer -= 1));
                fi
                lines=0;
            fi
            
        done
    done < "$file";
    ((rask += lines * timer));
    echo "$file: lines $allLines, Rasa $rask";
}

while [ $# -gt 0 ]; do
    DoRasa $1
    shift;
done

