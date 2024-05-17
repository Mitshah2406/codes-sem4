#include <stdio.h>
#include<time.h>

// watch --> https://www.youtube.com/watch?v=g-PGLbMth_g

void selection_sort(int arr[], int n) {
   int min, min_idx;
   
   for(int i=0;i<n;i++){
       min_idx = i;
       for(int j=i+1;j<n;j++){
          if(arr[min_idx] > arr[j]){
              min_idx = j;
          }
       }
       int temp = arr[min_idx];
       arr[min_idx] = arr[i];
       arr[i] = temp;
   }
}

int main() {
    time_t st,end;
    st = clock();
    int arr[] = {64, 25, 12, 22, 11};
    int n = sizeof(arr) / sizeof(arr[0]);
    
    selection_sort(arr, n);
    
    printf("Sorted array is: ");
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    end = clock();
    
    printf("\n");
    printf("Time is %f", (float)(end-st));
    
    return 0;
}
