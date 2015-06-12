import argparse
G=open
K=argparse.ArgumentParser
def u(z):
 r=0
 b=1
 I=0
 for m in G(z):
  r+=1
  for k in m:
   if '{' in k:b+=1
   if ';' in k:I+=b
   if '}' in k:b-=1
 return(r,I)
def B(args):
 c=0
 D=0
 for z in args.argument:
  r,I=u(z)
  c+=r
  D+=I
  print '%s: lines %d, RaSa: %d'%(z,r,I)
 print 'total: lines %d, RaSa: %d'%(c,D)
C=K()
C.add_argument('argument',nargs='*')
B(C.parse_args())