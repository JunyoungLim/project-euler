import math

def sieve(N):
  # prepare sieve boolean array with 0 and 1 False
  s = [True for _ in range(N)]
  s[0] = False
  s[1] = False
  for i in range(4, N, 2):
    s[i] = False
  end = int(math.sqrt(N))
  for i in range(3, end+1, 2):
    if s[i]:
      for j in range(i*i, N,  2*i):
        s[j] = False
  return s

L = 10**10
N = int(10**10 / (2 * 7037))
n = 0
n_is_odd = False
s = sieve(N)
for p in range(2, N):
  if s[p]:
    n += 1
    n_is_odd = not n_is_odd
    if n_is_odd and 2 * n * p > L:
      print(n, p)
      break

