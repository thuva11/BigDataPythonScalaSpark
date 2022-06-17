import matplotlib.pyplot as plt
import numpy as np
import functools as ft

print("hello world")

x = np.linspace(0, 20, 100)  # Create a list of evenly-spaced numbers over the range
plt.plot(x, np.sin(x))       # Plot the sine of each x point
plt.show()                   # Display the plot

#r=reduce(lambda x, y: int(x)* int(y), input())

#print(r)

print([1,2,3])

print(ft.reduce(lambda x, y:int(x)*int(y),input()))

nums = [int(num) for num in input()]
print(nums)
r = ft.reduce(lambda x,y:x*y, nums)
print(r)