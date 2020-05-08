'''
Input:
1 2 3 3 3
1 4 4 3 3
2 3 1 1 1

Expected output: 
7

Explanation:
Found 7 regions of the same number congregated together
'''


def count_num_islands(map):
    num_rows = len(map)
    num_cols = len(map[0])

    visited = []
    for i in range(num_rows):
        row = []
        for j in range(num_cols):
            row.append(False)
        visited.append(row)

    count = 0
    for i in range(num_rows):
        for j in range(num_cols):
            if visited[i][j] is False:
                traverse(map, i, j, map[i][j], visited)
                count += 1
    return count


def traverse(map, i, j, island_val, visited):
    # Base case 1: Outside of map
    if i < 0 or j < 0 or i >= len(map) or j >= len(map[0]):
        return

    # Base case 2: Outside of island
    if map[i][j] != island_val:
        return

    # Base case 3: Already visited
    if visited[i][j] is True:
        return

    visited[i][j] = True

    traverse(map, i + 1, j, island_val, visited)  # Go down
    traverse(map, i - 1, j, island_val, visited)  # Go up
    traverse(map, i, j + 1, island_val, visited)  # Go right
    traverse(map, i, j - 1, island_val, visited)  # Go left


input = [[1, 2, 3, 3, 3], [1, 4, 4, 3, 3], [2, 3, 1, 1, 1]]
result = count_num_islands(input)
print(result)
