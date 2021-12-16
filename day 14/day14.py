from collections import defaultdict

def part1(template, pairs, steps):
    for s in range(steps):
        tmp = []
        for i in range(len(template)-1):
            tmp.append(template[i])
            if template[i]+template[i+1] in pairs:
                tmp.append(pairs[template[i]+template[i+1]])
        tmp.append(template[-1])
        template = tmp
        
    count = {i : template.count(i) for i in set(template)} 
    all_values = count.values()

    print('part one =', max(all_values) - min(all_values))
    
def part2(template, pairs, steps):
    polyCount = defaultdict(int)
    pairCount = defaultdict(int)

    for x in template:
        polyCount[x] += 1
        
    for pair in ("".join(pair) for pair in zip(template[:-1], template[1:])):
        pairCount[pair] += 1

    for s in range(steps):
        for pair, count in pairCount.copy().items():
            new_char = pairs[pair] 
            polyCount[new_char] += count
            pairCount[pair] -= count
            pairCount[pair[0] + new_char] += count
            pairCount[new_char + pair[1]] += count	
    
    maxVal = max(polyCount.values())
    minVal = min(polyCount.values())

    print('part two =', maxVal - minVal)
        
print("\nadvent of code day 14\n")

with open("input.txt") as f:
    lines = [line.strip() for line in f.readlines()]
template = [x for x in lines[0]]
pairs = dict(line.split(" -> ")  for line in lines[2:])

part1(template, pairs, 10)
part2(template, pairs, 40)