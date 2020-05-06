'''
Determine if it is possible to create a palindromic string of min length 3 characters by removing 1 or 2 characters. If 1 or 2 characters cannot be removed to produce a palindrome, then return the string "nah cannot lah". If the input string is already a palindrome, your program should return the string palindrome.
'''

import sys

IMPOSSIBLE = 'nah cannot lah'


def palindrome_creator(str):
    result = create(str, 0, len(str) - 1, '')
    if result is None:
        return IMPOSSIBLE
    return result


def create(str, start, end, discarded):
    if start >= end:
        if len(discarded) == 0:
            return str
        if len(discarded) <= 2:
            return discarded

    if len(discarded) >= 3:
        return None

    if len(str) - len(discarded) < 3:
        return None

    if str[start] == str[end]:
        return create(str, start + 1, end - 1, discarded)

    skip_left = create(str, start + 1, end, discarded + str[start])
    if skip_left is not None:
        return skip_left

    skip_right = create(str, start, end - 1, discarded + str[end])
    if skip_right is not None:
        return skip_right

    return None


str = sys.argv[1]
answer = palindrome_creator(str)
print(answer)
