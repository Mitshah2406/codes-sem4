// Online C compiler to run C program online
#include <stdio.h>
void activitySelection(int s[], int f[], int n){
    int last = 0;
    printf("Activity Selected: %d\n",  last+1);
    for(int curr=1;curr<n;curr++){
        if(f[last]<=s[curr]){
                printf("Activity Selected: %d\n", curr+1);
                last = curr;
        }
    }
}
int main() {
   int s[] = { 1, 3, 0, 5, 8, 5 }; 
	int f[] = { 2, 4, 6, 7, 9, 9 }; 
	int n = sizeof(s) / sizeof(s[0]);
	activitySelection(s,f,n);
    return 0;
}
