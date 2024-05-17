// Online C compiler to run C program online
#include <stdio.h>
#include<stdlib.h>
int x[16];
int place(int k, int i){
    for(int j=0;j<k;j++){
        if(x[j]==i || abs(x[j]-i) == abs(j-k)){
            // return false if. 1) same column
            // 2) abs diff btwn col pos and row pos is same i.e diagonal
            return 0;
        }
    }
    // if all case pass, then return true
    return 1;
}
void NQueen(int k, int n){
    for(int i=1;i<=n;i++){
        if(place(k,i)){ // check if queen can be placed
            x[k] = i; // if yes, then place
            if(k==n){ // if this is last queen, print res
                printf("\nSolution: ");
                for(int j=1;j<=n;j++){
                    printf("%d ", x[j]);
                }
            }else{ // else k+1 for next queen
                NQueen(k+1, n);
            }
        }
    }
}
int main() {
   NQueen(1,4); // k means current queen , n means total queens

    return 0;
}
