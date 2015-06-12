import sys;s='%s: lines %d, RaSa: %d'
def u(z):
 r=I=0;b=1
 for m in open(z):
  r+=1
  for k in m:
   if '{'==k:b+=1
   if ';'==k:I+=b
   if '}'==k:b-=1
 return(r,I)
c=D=0
for z in sys.argv[1:]:
 r,I=u(z);c+=r;D+=I;print s%(z,r,I)
print s%('total',c,D)