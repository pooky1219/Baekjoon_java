import sys

t = int(sys.stdin.readline())

for _ in range(t):
    s = sys.stdin.readline().strip()

    alphabet_present = [False] * 26

    for char in s:
        alphabet_present[ord(char) - 65] = True

    total_sum = 0
    for i in range(26):
        if not alphabet_present[i]:
            total_sum += (i + 65)

    print(total_sum)