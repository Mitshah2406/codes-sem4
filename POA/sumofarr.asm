DATA SEGMENT
N1 DB 01H,02H,03H,04H,05H
RES DB ?
LEN DW $-N1
DATA ENDS

CODE SEGMENT
START:
MOV AX, DATA
MOV DS, AX

LEA SI, N1
MOV CX, LEN
MOV AX, 00H
REP:
ADD AX,[SI]
INC SI
DEC CL
JNZ REP
MOV RES, AX
ENDS
ENDS START