#include<stdio.h>
#include<stdlib.h>

void minMax(int x[], int left, int right, int *min, int *max){
    if(left==right){
        *max = x[left];
        *min = x[left];
    }else if(left+1 == right){
        if(x[left] > x[right]){
            *max = x[left];
            *min = x[right];
        }else{
            *max = x[right];
            *min = x[left];
        }
    }else{
        int mid = (left+right)/2;
        int leftMin, leftMax, rightMin, rightMax;
        
        minMax(x, left, mid, &leftMin, &leftMax);
        minMax(x, mid+1, right, &rightMin, &rightMax);
        
        *min = (leftMin>rightMin) ? rightMin : leftMin;
        *max = (leftMax>rightMax) ? leftMax: rightMax;
    }
}

int main(){
    int arr[10] = {34,67,32,87,21,7,342,12,78,2112}; 
    int min, max;
    int size = sizeof(arr) / sizeof(arr[0]);
    minMax(arr, 0, size-1, &min, &max);
    
    printf("Min: %d\n", min);
    printf("Max: %d", max);
}
