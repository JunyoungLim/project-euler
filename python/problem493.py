from math import prod
ans = 7 * (1 - prod([i+41 for i in range(10)]) / prod([i+61 for i in range(10)]))
print('{0:.9f}'.format(ans))
