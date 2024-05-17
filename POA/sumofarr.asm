DATA SEGMENT
    ARR DB 01H,02H,03H,04H,05H  
     LEN DW $-ARR
    SUM DW ?
   
    AVG DW ?  
DATA ENDS

CODE SEGMENT
    ASSUME DS:DATA, DS:DATA
   START:
    
    MOV AX, DATA
    MOV DS, AX
    
    MOV CX, LEN
    lea SI,ARR
    
    MOV AX, 0000H
    MOV BX, 0000H
    
LOOP_SUM:
    
    MOV BL, [SI]
    ADD AX,BX
    INC SI
    DEC CX
    JNZ LOOP_SUM
    
    MOV SUM , AX
    
    MOV BX, 0
    MOV Bx ,LEN
    MOV AX,SUM
    DIV BL    
    MOV AVG, AX
    
    
    MOV AH, 4CH
    INT 21H
    
 CODE ENDS
END START
    
