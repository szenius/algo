'''
https://www.hackerrank.com/challenges/gem-stones
'''

import sys



def gemstones(arr):
    counts = {}
    for i, stone in enumerate(arr):
        for mineral in stone:
            if mineral not in counts:
                counts[mineral] = set()
            counts[mineral].add(i)

    num_gemstones = 0
    for mineral in counts:
        if len(counts[mineral]) == len(arr):
            num_gemstones += 1

    return num_gemstones


arr = sys.argv[1:]
result = gemstones(arr)
print(result)
