#include<stdio.h>
#include<limits.h>
int matrixMul(int p[], int n){
    int m[n][n];
    
    for(int i=1;i<n;i++){
        m[i][i] = 0;
    }
    
    for(int l=2;l<n;l++){
        for(int i=1;i<n-l+1;i++){
            int j = i+l-1;
            m[i][j] = INT_MAX;
            for(int k=i;k<=j-1;k++){
                int q = m[i][k] + m[k+1][j] + p[i-1] *p[k]*p[j];
                if(q< m[i][j]){
                    m[i][j] = q;
                }
            }
        }
    }
    return m[1][n-1];
}


int main(){
    printf("Enter no of matrices: ");
    int n;
    scanf("%d", &n);
    int arr[n];
    printf("Enter dimensions of matrices: ");
    for(int i=0;i<=n;i++){
        scanf("%d", &arr[i]);
    }
    printf("Result is %d", matrixMul(arr, n+1));
}
