DATA SEGMENT
A DB 04H
B DB 02H
DATA ENDS

CODE SEGMENT
START:
MOV AX,DATA
MOV DS, AX

MOV AX, A
MOV BX, B

DIV BX

ENDS
ENDS START
