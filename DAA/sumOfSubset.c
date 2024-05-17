// Online C compiler to run C program online
#include <stdio.h>
void sumOfSubset(int wt[], int n, int current_index, int current_sum, int target_sum, int solution[], int solution_index){
    if(current_sum==target_sum){
        //if curent sum is eqaul to target then print soltuion and do \n for next sol,
        // and finally return
        for(int i=0;i<solution_index;i++){
            printf("%d\t", solution[i]);
        }
        printf("\n");
        return;
    }
    // if current sum exceeds target sum || we have processed all weights
    if(current_sum>target_sum || current_index>=n){
        return;
    }
    // include wt in solution
    solution[solution_index] = wt[current_index];
    // include solution
    sumOfSubset(wt,n,current_index+1, current_sum+wt[current_index], target_sum, solution, solution_index+1);
    // exlcude solution and backtrack
    sumOfSubset(wt,n,current_index+1, current_sum, target_sum, solution, solution_index);
}
int main() {
      int n = 6;
    int weights[6] = {5,10,12,13,15,18};
    int m=30;
    int solution[6];
    sumOfSubset(weights, n, 0, 0, m, solution, 0);

    return 0;
}
