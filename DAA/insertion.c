#include <stdio.h>
#include<time.h>

//watch bari video - https://youtu.be/gbJzL6IJig0?si=vlWwroOJWMgDAoVO
void insertion_sort(int arr[], int n){
    int key, j;
    
    for(int i=1;i<n;i++){
        key = arr[i];
        j = i-1;
        
        while(j>=0 && arr[j] > key){
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = key;
    }
}

int main() {
    int arr[] = {12, 11, 13, 5, 6};
    time_t st,end;
    int n = sizeof(arr) / sizeof(arr[0]);
    st = clock();
    insertion_sort(arr, n);
    
    printf("Sorted array is: ");
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    end = clock();
    printf("\nTime %f", (float) (end-st));
    printf("\n");
    
    return 0;
}
