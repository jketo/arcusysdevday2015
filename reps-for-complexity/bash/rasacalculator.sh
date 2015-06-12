#!/bin/bash
FILE=$1
k=1
RASA_SUM=0
MULTI=1
while read line;do
    if [[ $line =~ \{ ]]; then
        ((MULTI++))
    fi
    if [[ $line =~ \} ]]; then
        ((MULTI--))
    fi
    if [[ $line =~ \; ]]; then
        RASA_SUM=$(($RASA_SUM+$MULTI*1))
    fi
    ((k++))
done < $FILE
echo "$FILE: lines $k, RaSa $RASA_SUM"
