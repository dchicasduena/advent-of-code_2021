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
    total =  sum(low_pts)

    print("part 1 =", total)

print("\nadvent of code day 8\n")

# setup matrix
input = open('input.txt','r').read().split()
matrix = [[int(x) for x in list(line.strip())] for line in input]

part1(matrix)
