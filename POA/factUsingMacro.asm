FACTORIAL MACRO F
UP:
MUL F
DEC F
JNZ UP 

ENDM



DATA SEGMENT
NUM DW 05H  
FACT DW ?
DATA ENDS

CODE SEGMENT
ASSUME DS:DATA, CS:CODE
START:
MOV AX,DATA
MOV DS,AX  
MOV AX,0001H
FACTORIAL NUM
MOV FACT,AX
CODE ENDS
END START
