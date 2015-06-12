#!/bin/bash

 # ** Calculate each statement ending with ";". 
 # Each block inside another block { }, increments the RaSa depth multiplier by 1.
 # Thus { ; } is of depth 2 with one statement = 2 * 1. 
 # ** Level 1 is statements outside blocks, like java import -statements. 
 # ** Levels 2...N are statements inside blocks

if [ -z ${#} ]; then
	exit 1;
fi

declare -a FILES=(${*});

let TOTAL_LINES=0;
let TOTAL_COUNT=0;

for o in ${FILES[@]}; do

	let COUNT=0;
	let MULTI=1;
	let LINES=0;

	while read -r i
	do
		#if [[ $(echo ${i} |grep "^#") ]]; then
		#	:
		if [[ $(echo ${i} |grep "{") ]]; then
			#echo "${i}";
			let "MULTI += 1";		
		elif [[ $(echo ${i} |grep "}") ]]; then
			#echo ${i};
			let "MULTI -= 1";		
		elif [[ $(echo ${i} |grep "\;") ]]; then
			#echo ${i};
			let "COUNT += MULTI";
		fi
		let "LINES += 1";
	done < "${o}"
	echo "${o}: lines ${LINES}, RaSa ${COUNT}"
	let "TOTAL_LINES += LINES";
	let "TOTAL_COUNT += COUNT";
done

echo "total: lines ${TOTAL_LINES}, RaSa ${TOTAL_COUNT}";
