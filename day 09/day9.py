from math import prod

def part1(input):
    moves = [
        (-1,0), # north 
        (0,-1), # west
        (0,1),  # east 
        (1,0),  # south
    ]

    low_pts = []
    len_y = len(input)
    len_x = len(input[0])

    for y in range(len_y):
        for x in range(len_x):
            point = input[y][x]
            low = True
            for mov in moves:
                y1, x1 = mov
                if (y + y1 in range(len_y)) and (x + x1 in range(len_x)):
                    next = input[y + y1][x + x1]
                    if next <= point:
                        low = False
                        break
            if low:
                low_pts.append(point + 1)
    return low_pts

print("\nadvent of code day 9\n")

def part2(input):
    height = (len(input[0]))
    width = len(input)
    
    basins = []
    for x in range(width):
        for y in range(height):
            basins.append(floodFill(x, y, input))
    basins = sorted(basins)
    return basins[-3] * basins[-2] * basins[-1]
                    
def floodFill(x, y, input):
    height = (len(input[0]))
    width = len(input)
    
    # keep in bounds
    if x < 0 or y < 0:
        return 0
    if x >= width or y >= height:
        return 0
    
    # stop at hill
    if input[x][y] == 9:
        return 0
    
    input[x][y] = 9
    xplus = floodFill(x+1, y, input)
    yplus = floodFill(x, y+1, input)
    xminus = floodFill(x-1, y, input)
    yminus = floodFill(x, y-1, input)
    return xplus + yplus + xminus +yminus + 1
            
input = open('input.txt','r').read().split()
matrix = [[int(x) for x in list(line.strip())] for line in input]

p1 = part1(matrix)
print("part 1 =", sum(p1))

p2 = part2(matrix)
print("part 2 =", p2)

