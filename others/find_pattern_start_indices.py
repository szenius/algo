def find_pattern_start_indices(str, pattern):
    start_indices = []
    for i in range(len(str)):
        if str[i] != pattern[0]:
            continue

        if len(str) - i < len(pattern):
            break

        is_match = True
        for j in pattern:
            if str[i] != j:
                is_match = False
                break
        if is_match:
            start_indices.append(i)
    return start_indices


print(find_pattern_start_indices('aaaaaa', 'aaa'))
print(find_pattern_start_indices('abracadabra', 'abr'))
