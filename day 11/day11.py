from graphics import * 

def solve(input):
    speed = 10 # <- change this for the speed
    steps = 400 # <- change this for the number of steps
    
    part1 = 0
    part2 = 0
    win = GraphWin("Day 11", 500, 500, autoflush=False)
    win.setBackground(color_rgb(3, 182, 252))

    for step in range(steps):
        old = part1 + 1
        if step == 0: cont = False
        else: cont = True
            
        for i in input:
            input[i] += 1

        while cont:
            flashed = False
            for (x, y), value in input.items():
                
                if value < 10: 
                    continue
                else:  
                    input[(x, y)], flashed = 0, True
                    
                if step < 100:
                    c = Rectangle(Point(0+(y*50),0+(x*50)), Point(49.75+(y*50),49.75+(x*50)))
                    c.setFill(color_rgb(245, 227, 66))
                    c.draw(win)
                    part1 += 1
                    new = old 
                    
                for neighbor in ((x+1, y),
                                 (x-1, y),
                                 (x, y-1),
                                 (x, y+1),
                                 (x+1, y+1),
                                 (x+1, y-1),
                                 (x-1, y+1),
                                 (x-1, y-1)):
            
                    if neighbor not in input or input[neighbor] == 0:
                         continue
                    else:
                        input[neighbor] += 1
            if not flashed: 
                break
            
        if sum(input.values()) == 0:
            part2 = step + 1
            break
        update(speed)
        win.delete('all')

    print('part 1 =', part1)
    print('part 2 =', part2)
    
    win.setBackground("white")
    
    p1 = Text(Point(225,260), f'Part One: {part1}')
    p1.setTextColor("black")
    p1.setSize(18)
    p1.draw(win)
    
    p2 = Text(Point(225,280), f'Part Two: {part2}')
    p2.setTextColor("black")
    p2.setSize(18)
    p2.draw(win)
    
    t = Text(Point(225,300), 'Press the window to close')
    t.setTextColor("black")
    t.setSize(18)
    t.draw(win)
    
    win.getMouse()
    win.close()


      
def main():  
    print("\nadvent of code day 11\n")
    with open('input.txt') as f:
        input = {(x, y): int(n) for y, row in enumerate(f.readlines()) for x, n in enumerate(row.strip())}

    solve(input)
    
main()
