BEGIN { 
    timer=1;
    lines=0;
    rask=0;
    allLines=0;
}
BEGINFILE {
    Rask[FILENAME]=0;
    Lines[FILENAME]=0;
    File[FILENAME]=FILENAME;
    timer=1;
    lines=0;
    rask=0;
    allLines=0;
}

ENDFILE {
    rask += lines * timer;
    Rask[FILENAME]=rask;
    Lines[FILENAME]=allLines;
}

END {
    for (var in File) {
        print File[var], ": lines ", Lines[var], ", RaSa ", Rask[var];
    }
}

{
    allLines+=1;
    i = 0;
    line = $0;
    while (i < length(line)) {
        c = substr(line, 1, 1);
        line = substr(line, 2);
        
        if (c == ";") {
            lines += 1;
        }
        if (c == "{") {
            rask += lines * timer;
            timer += 1;
            lines = 0;
        }
        if (c == "}") {
            rask += lines * timer;
            if (timer > 1) {
                timer -= 1;
            }
            lines = 0;
        }
    }
}
