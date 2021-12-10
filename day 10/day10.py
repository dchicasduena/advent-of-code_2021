import statistics

def part1(input):
    completes = {'(':')','[':']', '{':'}', '<':'>'}
    scores = {')': 3, ']': 57, '}': 1197, '>': 25137}
    
    errors = []
    closing = []
    
    for line in input:
        for char in line:
            if char in completes.keys():
                closing.append(completes[char])
            else:
                closing_char = closing.pop()
                if closing_char != char:
                    errors.append(char)
                    break

    syn_errors = "".join(errors)
    print("part 1 =",sum(scores[il_char] for il_char in syn_errors))
    
def part2(input):
    completes = {'(':')','[':']', '{':'}', '<':'>'}
    scores = {')': 3, ']': 57, '}': 1197, '>': 25137}
    scores_p2 = {")": 1, "]": 2, "}": 3, ">": 4}
    scores = []
    
    for line in input:
        closing = []
        skip = False
        for char in line:
            if char in completes:
                closing.append(char)
            else:
                closing_char = completes[closing.pop()]
                if closing_char != char:
                    skip = True
                    break
        if skip: continue

        total = 0
        while(len(closing) > 0):
            a = closing.pop()
            close = completes[a]
            total = (total * 5) + scores_p2[close]

        scores.append(total)

    scores.sort()
    print("part 2 =",scores[len(scores)//2])
    
print("\nadvent of code day 10\n")
input = [line.rstrip() for line in open('input.txt')]

part1(input)
part2(input)
