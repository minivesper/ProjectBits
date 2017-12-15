import random

x = [0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25]
d = {}
for i in range(0,26):
    d[i] = x.pop(random.randint(0,len(x)-1))
print(d.values())
