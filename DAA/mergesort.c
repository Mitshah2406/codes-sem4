#include<stdio.h>
#include<stdlib.h>
#include<time.h>
// watch --> https://www.youtube.com/watch?v=4VqmGXwpLqc
void mergesort(int a[], int low, int mid, int high){
   int b[10000];
   int i= low;
   int j= mid+1;
   int k = low;
   
   while(i<=mid && j<=high){
       if(a[i]<a[j]){
           b[k] = a[i];
           i++;
       }else{
           b[k] = a[j];
           j++;
       }
       k++;
   }
   if(i>mid){
       while(j<=high){
             b[k] = a[j];
           j++;
           k++;
       }
   }
     if(j>high){
       while(i<=mid){
             b[k] = a[i];
           i++;
           k++;
       }
   }
   
   for(int i=low;i<=high;i++){
       a[i] = b[i];
   }
}
void merge(int arr[], int low, int high){
   if(low<high){
       int mid = (low+high)/2;
       merge(arr, low,mid);
       merge(arr, mid+1, high);
       mergesort(arr, low, mid, high);
   }
}
int main(){
    int n;
    time_t st,end;
    double timeTook;
    st = clock();
    printf("Enter no of elements: ");
    scanf("%d", &n);
    int arr[n];
    for(int i=0;i<n;i++){
        arr[i] = rand() % (10000 + 1 - 0) + 0;
    }
    int low=0, high=n-1;
   
   
    merge(arr,low,high);
    end = clock();
    timeTook = (double) (end-st) / CLOCKS_PER_SEC;
     for(int i=0;i<n;i++){
       printf("%d\n", arr[i]);
    }
    printf("\n Time taken was %f", timeTook);
    return 0;
}
