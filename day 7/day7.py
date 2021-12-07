def part1(input):
    crabs = [int(x) for x in input]

    line = []
    for pos in crabs:
        fuel = []
        for crab in crabs:
            fuel.append(abs(crab - pos))
        line.append(sum(fuel))

    print("part one")
    print("fuel needed = ", min(line))

def part2(input):
    crabs = [int(x) for x in input]
    minPos = min(crabs)
    maxPos = max(crabs)

    line = []
    for pos in crabs:
        fuel = []
        for crab in crabs:
            val = abs(crab - pos)
            fuel.append(((val ** 2) + val) // 2)
        line.append(sum(fuel))
     
    print("\npart two")
    print("fuel needed = ", min(line))

print("\nadvent of code day 7\n")
input = open('input.txt','r').read().split(',')
part1(input)
part2(input)