#include<stdio.h>
#include<stdlib.h>

int max(int a, int b){
    return (a>b)? a:b;
}
void printDP(int dp[4][9], int n ,int m){
    for(int i=0;i<=n;i++){
        for(int j=0;j<=m;j++){
            printf("%d\t", dp[i][j]);
        }
        printf("\n");
    }
}

void knapSack(int profit[], int weight[], int n, int m){
    int dp[n+1][m+1]; //1st row col set to 0 
    //weight[i-1] used coz we have dp of n+1 len and weight is of n len and weight is 0 indexed array
    for(int i=0;i<=n;i++){
        for(int j=0;j<=m;j++){
            if(i==0||j==0){ // first row and col 0
                dp[i][j] = 0;
            }else if(weight[i-1]<=j){ // if weight array has weight less than equal to current bag capacity then use formula
                dp[i][j] = max(dp[i-1][j], dp[i-1][j- weight[i-1]] + profit[i-1]);
            }else{ // if weight of current item is greater then current bag capacity then simply copy above val from table
                dp[i][j] = dp[i-1][j];
            }
        }
    }
    
    printDP(dp,n,m);
}


int main(){
    int profit[] = {1,2,5,6};
    int weight[] = {2,3,4,5};
    int n=4; // no of items
    int m=8; // total bag capacity
    
    knapSack(profit, weight, n, m);
}
