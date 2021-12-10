from collections import defaultdict
import re

def getPoints(points, p2):
    check = defaultdict(int)
    for point in points:
        x1,y1,x2,y2 = point
        x1 = int(x1)
        y1 = int(y1)
        x2 = int(x2)
        y2 = int(y2)
        min_x,min_y = min(x1, x2),min(y1, y2)
        max_x,max_y = max(x1, x2),max(y1, y2)

        
        if y1 == y2:
            for i in range(min_x,max_x + 1):
                check[(i, y1)] += 1
        elif x1 == x2:
            for i in range(min_y, max_y + 1):
                check[(x1, i)] += 1

        if (p2):   
            x = x1
            y = y1
            while x != x2 and y != y2:
                check[(x,y)] += 1 if (x,y) in check else 1
                x += 1 if x1 < x2 else -1
                y += 1 if y1 < y2 else -1
                if x == x2 and y == y2:
                    check[(x,y)] += 1 if (x,y) in check else 1
                      
    result = 0
    for i in check:
        if check[i] >= 2:
            result += 1
    if (p2):
        print("results p2 = ", result, "\n")
    else:    
        print("results p1 = ", result)


if __name__ == "__main__":
    input = open('input.txt','r')
    points = []
    pat = '^(\d+),(\d+) -> (\d+),(\d+)$'

    for line in input:
        match = re.findall(pat,line)
        points.append(match[0])
    
    print("\nadvent of code day 5\n")
    getPoints(points, False)
    getPoints(points, True)

    