#!/bin/bash
for f in $@;do echo "$f:" $(awk 'BEGIN{r=0;l=0;d=1;}/$/{l++;}/{/{d++;}/;/{r+=d;}/}/{d--;}END{print "lines",l,"RaSa",r;}' $f);done

