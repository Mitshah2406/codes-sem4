#include <stdio.h>
#include<stdlib.h>
#include<time.h>

int binarySearch(int arr[],int size, int target){
    int left = 0;
    int right = size - 1;
    
    while(left<=right){
        int mid = (left+right)/2;
        if(arr[mid] == target){
            return mid;
        }else if(arr[mid] < target){
            left = mid+1;
        }else{
            right = mid-1;
        }
    }
    return -1;
    
}
int main() {
   
    int arr[10];
     time_t st,end;
    for(int i=0;i<10;i++){
        arr[i] = i;
    }
       int size = sizeof(arr) / sizeof(arr[0]);
       st= clock();
    printf("Res is %d ", binarySearch(arr,size, 7));
    end = clock();
    
    float diff = end-st;
    
    printf("\nThe time taken is %f", diff);
    return 0;
}
