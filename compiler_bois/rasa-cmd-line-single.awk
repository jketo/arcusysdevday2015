awk 'BEGIN{multiplier=1;rasaCount=0;lineCount=0;};{if(/{/)multiplier=multiplier+1;if(/;/){rasaCount=rasaCount+multiplier*1;}if(/}/){multiplier=multiplier-1;}lineCount=lineCount+1;};END{print  "total:lines "lineCount",RaSa "rasaCount}' TYPE_SINGLE_FILE_NAME_HERE

