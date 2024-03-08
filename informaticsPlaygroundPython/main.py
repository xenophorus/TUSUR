# # This is a sample Python script.
#
# # Press Shift+F10 to execute it or replace it with your code.
# # Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.
#
#
# def print_hi(name):
#     # Use a breakpoint in the code line below to debug your script.
#     print(f'Hi, {name}')  # Press Ctrl+F8 to toggle the breakpoint.
#
#
# # Press the green button in the gutter to run the script.
# if __name__ == '__main__':
#     print_hi('PyCharm')
#
# # See PyCharm help at https://www.jetbrains.com/help/pycharm/

# n = 7
# # arr = [10, 6, 4, 5, 1, -3, 0]
# arr = [-3, 2, 10, -7, 4, 6, 1]
# p = -1
# m = -1
#
# i = 0
#
# while arr[i] >= 0 and i < n:
#     i += 1
#
#     if i == n:
#         p = i
#     elif i < n:
#         p = i
#         i += 1
#         while arr[i - 1] >= 0 and i < n:
#             i += 1
#         if i <= n:
#             m = i
#
# print(f"p = {p}, m = {m}")
# #
# A = [[5, 7, 3, 8, 6, 5, 7],
#      [7, 9, 8, 4, 1, 0, 8],
#      [2, 7, 3, 8, 10, 3, 9],
#      [1, 1, 3, 8, 8, 9, 3],
#      [2, 9, 8, 0, 2, 4, 9],
#      [5, 5, 10, 9, 1, 3, 10],
#      [7, 6, 7, 1, 4, 9, 0]]
#
# n = 7
# q = -1
# m = 11
#
# for j in range(n):
#     for i in range(n):
#         if A[i][j] == m:
#             q = j
#             i = n + 1
# print(q)

# A = [[8, 5, 7, 5, 7, 6],
#      [7, 6, 2, 4, 5, 8],
#      [2, 5, 7, 1, 1, 7],
#      [4, 10, 2, 8, 2, 8],
#      [2, 7, 3, 7, 7, 1],
#      [8, 5, 4, 9, 5, 5]]
#
# n = 5
# q = 0
# i = n
# m = 10
#
# while i >= 0:
#     j = 0
#     while j < n+1:
#         if A[i][j] < m:
#             m = A[i][j]
#             q = i
#         j += 1
#     i = i - 1
# print(q)

# A = [[-1, 10, 5, -6, 7, 0, -9],
#      [1, 1, 7, 3, 7, -8, -4],
#      [-4, -7, 7, 2, -5, -10, 6],
#      [-6, 1, -8, 5, 1, -1, 4],
#      [-1, 2, 3, 0, 4, -6, -6, ],
#      [-1, -8, -8, 9, 8, -5, -2],
#      [3, -1, 2, 7, 2, 1, -6]]
# n = 7
# q = 0
# i = 0
#
# while i < n:
#     j = 1
#     while j < n:
#         if A[i][j] == 0:
#             q = q + 1
#
#         j = j + 2
#     i = i + 1
# print(q)

# n = 7
#
# A = [[-34, -44, 57, -3, -51, -58, 57],
#      [47, 106, -138, -63, -118, 9, 133], [-120, 68, -2, 59, -13, -120, -29],
#      [148, -93, 22, -132, 133, -136, 136], [29, -131, 64, 94, -40, 122, -1],
#      [-18, -38, -52, 24, -28, -28, -47], [139, 75, 72, 47, 141, 90, -4]]
#
# q = 0
# for i in range(1, n, 2):
#     for j in range(n):
#         m = A[i][j]
#         if m > 0:
#             q = q + 1
#
# print(q)

# n = 14
# X = [6,8,3,4,5,
#      5,6,5,3,8,
#      5,3,5,1]
# M = [0,0,0,0,0,
#      0,0,0,0,0,
#      0,0,0,0]
# q = 0
#
# for i in range(n):
#     M[X[i]] = M[X[i]] + 1
# # for el in M:
# #     if el == 1:
# #         q = q + 1
# #
# for i in range(1, 11):
#     if M[i - 1] > 1:
#         q = q + i * M[i - 1]
#
# print(q)

# A = [[2, 9, 1, 6, 4], [7, 5, 9, 4, 8], [5, 7, 6, 3, 2], [6, 10, 2, 1, 3], [6, 4, 9, 8, 3]]
A = [
[5,6,3,4,2,1],
[3,1,4,8,2,4],
[7,6,3,9,2,3],
[6,3,4,4,9,8],
[4,6,2,6,4,3],
[1,6,0,5,2,0]]
S = [0,0,0,0,0,0]
q = 0
n = 6

for j in range(n):
    S[j] = 0
    for i in range(n):
        S[j] = S[j] + A[i][j]
    if S[q] > S[j]:
        q = j

print(q + 1)

# Array = [
#     [7, 0, 5, -1, 5, 2],
#     [5, 1, -7, -1, 0, 5],
#     [-7, 0, 4, -7, -7, 4],
#     [-1, 9, -7, 6, -6, 6],
#     [-7, 5, -4, 4, 4, -8],
#     [7, 0, -1, 9, 1, -1],
# ]
#
# n = 6
# q = 1
#
# for j in range(n):
#     if Array[0][j] < 0:
#         q = q * Array[0][j]
#
# print(q)


# n = 9
# X = [3, -1, 2, 7, 5, 1, -6, 10, 0]
# p = -1
# m = -1
# i = 1
#
# while X[i] < 0 or i > n:
#     i = i + 1
#
# if i == n:
#     p = i
#
# if i < n:
#     p = i
#     i += 1
#     while X[i] < 0 or i > n:
#         i = i + 1
#     if i <= n:
#         m = i
# print(p, m)

# ********************************************************************

# A = [[5, 7, 6, 0, 1], [9, 7, 4, 6, 10], [2, 1, 10, 0, 1], [1, 9, 7, 0, 7], [2, 2, 3, 4, 8]]
#
# n = 5
# m = -1
# q = -1
#
# for i in range(5):
#     for j in range(5):
#         if m < A[i][j]:
#             m = A[i][j]
#
# for i in range(5):
#     for j in range(5):
#         if m == A[i][j]:
#             q = i + 1
#
# print(q)


