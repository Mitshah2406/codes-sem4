DATA SEGMENT 
STRING1 DB 45H,12H,76H,23H,80H   
min db ?
max db ?  
secmin db ?
secmax db ?
DATA ENDS
CODE SEGMENT
ASSUME CS:CODE DS:DATA
START:
MOV AX, DATA
MOV DS, AX

MOV CH,04H
UP2:
MOV CL,04H
LEA SI, STRING1
UP1:
MOV AL, [SI]
MOV BL, [ SI+1]
CMP AL,BL
JC DOWN
MOV DL, [SI+1]
XCHG [SI], DL
MOV [SI+1], DL
DOWN:
INC SI
DEC CL
JNZ UP1
DEC CH
JNZ UP2  
mov dl, [si-4]    
mov min,dl
mov dl, [si]  
mov max, dl
mov dl, [si-3]
mov secmin, dl
mov dl, [si-1]
mov secmax, dl
INT 21H
CODE ENDS
END START
