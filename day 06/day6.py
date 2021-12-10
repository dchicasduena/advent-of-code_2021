def reproduce(input, part):
    partS = ""
    if part == 80:
        partS = "part 1 = "
    elif part == 256:
        partS = "part 2 = "
    
    fish = [int(i) for i in input]
    days = [0,0,0,0,0,0,0,0,0]
    
    for f in fish:
        days[f] += 1
    
    for d in range(part):
        day = days[0]
        for i in range(len(days) - 1):
            days[i] = days[i + 1]
        days[8] = day
        days[6] += day    
    print(partS,sum(days))
    print("")

print("\nadvent of code day 6\n")
input = open('input.txt','r').read().split(',')
    
reproduce(input, 80)
reproduce(input, 256)





    