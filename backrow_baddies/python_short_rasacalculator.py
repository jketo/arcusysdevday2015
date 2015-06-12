import sys
a=b=0
for f in sys.argv[1:]:
	r=l=0
	m=1
	for s in open(f).read():
		if s=='{':m+=1
		elif s=='}':m-=1
		elif s==';':r+=m
		elif s=='\n':l+=1
	print("%s: lines %s, RaSa %s"%(f,l,r))
	a+=l
	b+=r
print("total: lines %s, RaSa %s"%(a,b))
