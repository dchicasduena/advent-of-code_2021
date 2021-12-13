def fold(axis, value, coord):
    points = set()
    for coord in coords:
        if axis == 'x':
            if coord[0] < value:
                points.add((coord[0], coord[1]))
            else:
                points.add((2 * value - coord[0], coord[1]))
        elif axis == 'y':
            if coord[1] < value:
                points.add((coord[0], coord[1]))
            else:
                points.add((coord[0], 2 * value - coord[1]))
    return points 

print("\nadvent of code day 13\n")

with open("input.txt") as file:
    lines = file.read().strip()
dots, instructions = lines.split('\n\n')

coords = set()
for dot in dots.splitlines():
    x, y = dot.split(',')
    x = int(x)
    y = int(y)
    coords.add((x, y))

count = 0
for instruction in instructions.splitlines():
    count += 1
    text, value = instruction.split('=')
    axis = text.replace('fold along ','')
    coords = fold(axis[-1], int(value), coords)

    if count == 1: # print first fold for part 1
        print('part one =',(len(coords)),'\n') 
    
max_x, max_y = map(max, zip(*coords)) 
display = [['█' if (x, y) in coords else ' ' for x in range(max_x + 1)] for y in range(max_y + 1)]

print('part 2 code:')
for row in display:
    print(''.join(row))
print('')