from collections import defaultdict

def dfs(part2, seen, cave):
    if cave == 'end': 
        return 1
    if cave in seen:
        if cave == 'start': 
            return 0
        if cave.islower():
            if part2 == False: 
                return 0
            elif part2 == True: 
                part2 = False

    return sum(dfs(part2, (seen|{cave}), c) for c in caves[cave])

print("\nadvent of code day 12\n")

caves = defaultdict(list)
for line in open('input.txt'):
    a, b = line.strip().split('-')
    caves[a] += [b]
    caves[b] += [a]
    
print("part 1 =", dfs(False, set(), 'start'))
print("part 2 =", dfs(True, set(), 'start'))
