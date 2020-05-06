import sys

ASCII_a = ord('a')
ASCII_A = ord('A')
ASCII_z = ord('z')
ASCII_Z = ord('Z')

LENGTH_OF_ALPHABET = 26


def caesar_cipher(str, num):
    result = ''
    for char in str:
        ascii_val = ord(char)
        if ascii_val >= ASCII_a and ascii_val <= ASCII_z:
            new_ascii_val = ascii_val + num
            if new_ascii_val > ASCII_z:
                new_ascii_val = new_ascii_val - ASCII_z + ASCII_a - 1
            result += chr(new_ascii_val)
        elif ascii_val >= ASCII_A and ascii_val <= ASCII_Z:
            new_ascii_val = ascii_val + num
            if new_ascii_val > ASCII_Z:
                new_ascii_val = new_ascii_val - ASCII_Z + ASCII_A - 1
            result += chr(new_ascii_val)
        else:
            result += char
    return result


str, num = sys.argv[1], int(sys.argv[2])
result = caesar_cipher(str, num)
print(result)
