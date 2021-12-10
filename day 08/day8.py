def part1(input):
    input = [i.strip().split('|') for i in input]
    total = 0
    for line in input:
        for each in line[1].split():
            if len(each) in (2, 3, 4, 7):
                total += 1
    print("part one = ", total)
    
def part2(input):
    signal = []
    output = []
    total = 0
    
    for line in input:
        line = line.split('|')
        signal.append(line[0].split())
        output.append(line[1].split())
    
    total = 0
    for signal, output in zip(signal, output):
        digits = ['' for i in range(10)]
        signal = sorted(signal, key=len)
        for i in signal:
            
            # [1,4,7,8]
            if len(i) == 2:
                digits[1] = i
            elif len(i) == 3:
                digits[7] = i
            elif len(i) == 4:
                digits[4] = i
            elif len(i) == 7:
                digits[8] = i
                
            # [3,5,2]  
            elif len(i) == 5:
                if all([c in i for c in digits[1]]): 
                    digits[3] = i
                elif sum([c in i for c in digits[4]]) == 3:
                    digits[5] = i
                else: 
                    digits[2] = i
                    
            # [9,0,6]       
            elif len(i) == 6:
                if all([c in i for c in digits[4]]):
                    digits[9] = i
                elif all([c in i for c in digits[7]]):
                    digits[0] = i
                else: 
                    digits[6] = i
                
        result = 0
        output = output[::-1]
        for j, n in enumerate(output):
            for i in range(len(digits)):
                if all([c in n for c in digits[i]]) and len(digits[i]) == len(n):
                    result += i * len(digits) ** j
                    break

        total += int(result)
    print("part two = ", total)


print("\nadvent of code day 8\n")
input_p1 = open('input.txt','r')
input_p2 = open('input.txt','r')
part1(input_p1)
part2(input_p2)