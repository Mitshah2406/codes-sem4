#include<stdio.h>
#include<stdlib.h>
#include<time.h>
void swap(int a, int b, int arr[]){
    int temp = arr[a];
   arr[a] =arr[b];
    arr[b] =temp;
}
int partition(int low, int high, int arr[]){
    int pivot = arr[high];
    int i = low-1;
    
    for(int j=low;j<=high-1;j++){
        if(arr[j] < pivot){
            i++;
            swap(i,j,arr);
        }
    }
    swap(i+1, high, arr);
    return i+1;
}
void quicksort(int arr[], int low, int high){
    if(low<high){
        int loc = partition(low, high, arr);
        quicksort(arr, low, loc-1);
        quicksort(arr, loc+1, high);
    }
}
int main(){
    int n;
    printf("Enter no of elements: ");
    scanf("%d", &n);
    int arr[n];
    for(int i = 0; i < n; i++){
        arr[i] = rand() % 1000;
    }
    int low = 0, high = n - 1;
    clock_t st, end;
    double timeTook;
    
    st = clock();
    quicksort(arr, low, high);
    end = clock();
    
    timeTook = ((double)(end - st)) / CLOCKS_PER_SEC;
    
    for(int i = 0; i < n; i++){
        printf("%d\n", arr[i]);
    }
    
    printf("\nTime taken was %f seconds", timeTook);
    return 0;
}


