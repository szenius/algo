import sys


def alternating_characters(str):
    i = 0
    count = 0
    while i < len(str) - 1:
        j = i + 1
        while j < len(str) and str[i] == str[j]:
            count += 1
            j += 1
        i = j
    return count


str = sys.argv[1]
count = alternating_characters(str)
print(count)
