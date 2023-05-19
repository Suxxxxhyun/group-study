# https://www.acmicpc.net/problem/2468
# DFS
import copy

n = int(input())

graph = []

current_max = 0
for _ in range(n):
    l = list(map(int, input().split()))
    current_max = max(current_max, l)
    graph.append(l)


def dfs():
    pass


for a in range(current_max):
    for b in range(n):
        for c in range(n):
            if current_max
            dfs()