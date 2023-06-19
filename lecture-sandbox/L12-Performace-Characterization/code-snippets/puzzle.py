import numpy as np
import timeit
from copy import copy

def foobar(numbers: list[int]) -> list[int]:
    # make a copy of numbers
    numbers = copy(list(numbers))
    for j in range(1, len(numbers)):
        key = numbers[j]
        i = j-1
        while i >= 0 and numbers[i] > key:
            numbers[i+1] = numbers[i]
            i = i-1
        numbers[i+1] = key
    return numbers


numbers = [10, 3, 100, 201, 42]

print("Timeit Results:")
print(timeit.timeit(lambda: foobar(range(500)), number=1))
print(timeit.timeit(lambda: foobar(range(1000)), number=1))
print(timeit.timeit(lambda: foobar(range(2000)), number=1))
print(timeit.timeit(lambda: foobar(range(4000)), number=1))
print(timeit.timeit(lambda: foobar(range(500)[::-1]), number=1))
print(timeit.timeit(lambda: foobar(np.random.rand(500).tolist()), number=1))

