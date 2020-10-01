# Performing Jump search Algorithm in a sorted array

import math

print("Enter the elements of the array separated by space ")
a_s = (input().split(' '))
a = [int(i) for i in a_s]
n = len(a)
x = int(input("Enter the number to be searched "))
step = int(math.sqrt(n))
i=0
while(i<n):
    if(a[i]==x) :
        print("Element found at index "+str(i))
        break
    elif(a[i]<x):
        i=i+step
    elif(a[i]>x):
        i=i-step
        for j in range (step):
            i=i+1
            if(a[i]==x):
                print("Element found at index "+str(i))
                break
        break

print(n)

