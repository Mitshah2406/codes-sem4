def twosComplement(num):
    l = list(num)  
    for i in range(len(l)):
        if l[i] == "1":
            l[i] = "0"
        else:
            l[i] = "1"
    b = "1".zfill(len(l))
    return addNum("".join(l), b)

def addNum(x, y):
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

num1 = int(input('Enter number: '))
num2 = int(input('Enter 2nd number: '))

binNum1 = bin(abs(num1)).replace("0b", '')
binNum2 = bin(abs(num2)).replace("0b", '')

maxlen = len(binNum1)

binNum1 = binNum1.zfill(maxlen)
binNum2 = binNum2.zfill(maxlen + 1)

binCompNum2 = twosComplement(binNum2)
binCompNum2 = binCompNum2.zfill(maxlen)

print("Iteration\t\tA\t\tQ")
count = maxlen
m = binNum2
minusm = binCompNum2
q = binNum1
a = "0"
a = a.zfill(maxlen + 1)
leftshift = ""

while count > 0:
    merged = a + q
    leftshift = merged[1:]
    a = leftshift[:maxlen + 1]
    a = bin(int(a, 2) + int(minusm, 2)).replace("0b", "")
    Op="LS AQ"
    if len(a) > maxlen + 1:
        a = a[1:]
    a = a.zfill(maxlen + 1)

    if a[0] == "0":
        leftshift = a + q[1:]
        leftshift += "1"
    else:
        a = bin(int(a, 2) + int(m, 2)).replace("0b", "")
        if len(a) > maxlen + 1:
            a = a[1:]
        a = a.zfill(maxlen + 1)
        leftshift = a + q[1:]
        leftshift += "0"

    a = leftshift[:maxlen + 1]
    q = leftshift[maxlen + 1:]
    count -= 1

    print(f"{maxlen - count}\t\t {a}\t\t {q}")

if a[0] == "1":
    a = bin(int(a, 2) + int(m, 2)).replace("0b", "")
    if len(a) > maxlen + 1:
        a = a[1:]

print(f"Remainder {int(a, 2)}")
print(f"Quotient {int(q, 2)}")
