#!/usr/bin/awk -f
BEGIN {
    multiplier = 1;
    rasaCount = 0;
    lineCount = 0;

    for (i = 0; i < ARGC; i++) {
       if(i != 0) {
            lines[ARGV[i]] = 0
            rasa[ARGV[i]] = 0             
        } 
    }

    file = ARGV[1]
}
{
    if(file != FILENAME) {
        multiplier = 1;
        file = FILENAME
    }

    if (/{/)
        multiplier= multiplier + 1;
    if (/;/) {
        rasaCount = rasaCount + multiplier * 1;
        rasa[FILENAME] = rasa[FILENAME] + multiplier * 1;
    }
    if (/}/)
        multiplier = multiplier - 1;

    lines[FILENAME] = lines[FILENAME] + 1;
    lineCount = lineCount + 1;
}
END {
    for (i = 0; i < ARGC; i++) {
        if(i != 0) {
            print ARGV[i] ": lines " lines[ARGV[i]] ", RaSa " rasa[ARGV[i]]            
        } 
    }
	print "total: lines " lineCount ", RaSa " rasaCount
}
