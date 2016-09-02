# SkylineGroup

Sample Input:

Enter tuple no: 
5
Enter attribute no: 
3
Enter Group Size less than or equal to 5 : 
3
Enter Tuple value(First element name and then the values):
p1
3
4
5
p2
4
2
3
p3
4
5
3
p4
2
1
2
p5
4
1
2


Sample Output:

Candidate Group_1: 
p1 : [3, 4, 5]
p2 : [4, 2, 3]
p3 : [4, 5, 3]
p4 : [2, 1, 2]
p5 : [4, 1, 2]
SkyLine Group_1: 
p1 : [3, 4, 5]
p3 : [4, 5, 3]
Candidate Group_2: 
p1, p2 : [3, 2, 3]
p1, p3 : [3, 4, 3]
p2, p3 : [4, 2, 3]
p1, p4 : [2, 1, 2]
p3, p4 : [2, 1, 2]
p1, p5 : [3, 1, 2]
p3, p5 : [4, 1, 2]
SkyLine Group_2: 
p1, p3 : [3, 4, 3]
p2, p3 : [4, 2, 3]
Candidate Group_3: 
p1, p2, p3 : [3, 2, 3]
p1, p3, p4 : [2, 1, 2]
p2, p3, p4 : [2, 1, 2]
p1, p3, p5 : [3, 1, 2]
p2, p3, p5 : [4, 1, 2]
SkyLine Group_3: 
p1, p2, p3 : [3, 2, 3]
p2, p3, p5 : [4, 1, 2]
