def arithmeticRightShift(AC,Q,Q1):
    a = AC[0]
    for i in range(1, len(AC)):
        a+=AC[i-1]
    b = AC[-1]
    for j in range(1, len(Q)):
        b+=Q[j-1]
    c = Q[-1]
    return a, b ,c

def twoComp(a):
    l = list(a)  
    for i in range(len(l)):
        if l[i] == "1":
            l[i] = "0"
        else:
            l[i] = "1"
    b = "1".zfill(len(l))
    return addNums("".join(l), b) 

def addNums(x, y):
    max_len = max(len(x), len(y)) 
    result = ''  
    carry = 0  
    for i in range(max_len - 1, -1, -1):
        r = carry 
        if x[i] == '1':
            r += 1
        if y[i] == '1':
            r += 1
        if r % 2 == 1:
            result = "1" + result
        else:
            result = "0" + result
        if r < 2:
            carry = 0
        else:
            carry = 1 
    return result

isANeg=0
isBNeg = 0
x = int(input("Enter First Number: "))
y= int(input("Enter Second Number: "))

a = bin(x).replace("0b","")
b = bin(y).replace("0b", "")
print(f"A is {a}")
print(f"B is {b}")
if(a[0]=="-"):
    a = a.replace("-","")
    isANeg = 1
if(b[0]=="-"):
    print("Neg")
    b = b.replace("-", "")
    isBNeg = 1

count = max(len(a), len(b))
count+=1

firstPadded = a.zfill(count)
secondPadded = b.zfill(count)

firstNum = twoComp(firstPadded)
secondNum = twoComp(secondPadded)

if isANeg==0:
    M = firstPadded
    M2 = firstNum
else:
    M = firstNum
    M2 = firstPadded
if isBNeg==0:
    Q = secondPadded
else:
    Q = secondNum
print(f"Count is {count}")
AC = "0".zfill(count)
Q1 ="0"

print("The table for Booth's Algorithm is:")
print("Count\tAC\tQ\tQ1\tOperation")
print(str(count) + "\t" + AC + "\t" + Q + "\t" + Q1 + "\tinitial")
print("\n")
while count> 0 :
    compare = Q[-1]+Q1

    if(compare[0]==compare[-1]):
        AC,Q,Q1 = arithmeticRightShift(AC, Q,Q1)
        op = "right shift"
    elif(compare=="01"):
        AC = addNums(AC, M)
        AC,Q,Q1 = arithmeticRightShift(AC,Q,Q1)
        op = "AC = AC + M and right shift"
    elif(compare=="10"):
        AC = addNums(AC, M2)
        AC,Q,Q1 = arithmeticRightShift(AC,Q,Q1)
        op = "AC = AC - M and right shift"
    
    print(str(count) + "\t" + AC + "\t" + Q + "\t" + Q1 + "\t" + op)
    print("\n")
    count-=1

ans = AC+Q


if(isANeg == isBNeg):
    ans_d = str(int(ans,2))
else:
    ans_d = "-"+str(int(twoComp(ans),2))

print("The product in binary is " + ans)
print("The decimal form of product is " + ans_d)
