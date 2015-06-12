#include <stdio.h>
#include <stdlib.h>
 
int main(int argc, char** argv)
{
   char ch, file_name[25];
   FILE *fp;
   
  
   int i = 0, totaltotal = 0;;
   
   for (i = 1; i < argc; ++i)
   {
       printf(argv[i]);
    
    fp = fopen(argv[i],"r"); // read mode
    
    if( fp == NULL )
    {
        perror("Error while opening the file.\n");
        exit(EXIT_FAILURE);
    }
    
    int i = 1, total = 0;
    
    while( ( ch = fgetc(fp) ) != EOF )
    {
        if(ch == '{') i++;
        else if(ch == '}') i--;
        else if(ch == ';') total += i;
    }
    
    fclose(fp);
    
    printf("result: %d\n",total);
    totaltotal += total;
   }
   printf("total: %d\n",totaltotal);
   return 0;
}
