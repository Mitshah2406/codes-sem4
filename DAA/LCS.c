// Online C compiler to run C program online
#include <stdio.h>
#include<stdlib.h>
#include<string.h>
#define SIZE 50


void lcs(char str1[], char str2[], int table[][SIZE], int lcsAns[][SIZE]){
    int m = strlen(str1);
    int n = strlen(str2);
    
    for(int i=0;i<=m;i++){ // 1st ele of all row 0
        table[i][0] = 0;
    }
     for(int j=0;j<=n;j++){ // 1st ele of all col 0
        table[0][j] = 0;
    }
    
    for(int i=1;i<=m;i++){
        for(int j=1;j<=n;j++){
            if(str1[i-1] == str2[j-1]){ // if str1 ka char == str2 ka char
                lcsAns[i][j] = '\\';
                table[i][j] = table[i-1][j-1]+1; // diag +1
            }else if(table[i-1][j] >= table[i][j-1]){
                // if upper ele is greater than left ele
                lcsAns[i][j] = '|';
                table[i][j] = table[i-1][j];
            }else if(table[i-1][j] < table[i][j-1]){
                // if upper ele is lesser than left ele
                lcsAns[i][j] = '-';
                     table[i][j] = table[i][j-1];
            }
        }
    }

}

void printLCS(char str[],int i,int j, int lcsAns[][SIZE]){
    
    if(i==0||j==0){
        //if we reach 0th row or 0th column
        return;
    }
    
    if(lcsAns[i][j] == '\\'){
    // \\ means go diagonal and print ans
        printLCS(str,i-1,j-1, lcsAns);
                printf("%c", str[i-1]);
    }else if(lcsAns[i][j]=='|'){
        // go up 
        printLCS(str, i-1, j, lcsAns);
    }else{
        // go back
         printLCS(str, i, j-1, lcsAns);
    }
}
int main() {
    char str1[SIZE];
    char str2[SIZE];
    int table[SIZE][SIZE];
    int lcsAns[SIZE][SIZE];
    
    strcpy(str1, "stone");
    strcpy(str2,"longest");
    
    lcs(str1,str2, table, lcsAns);
    printf("DP TAble: \n");
    for(int i=0;i<=strlen(str1);i++){
        for(int j =0;j<=strlen(str2);j++){
            printf("%d ", table[i][j]);
        }
        printf("\n");
    }
    printf("\n");
    printLCS(str1, strlen(str1), strlen(str2), lcsAns);

    return 0;
}
