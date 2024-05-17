// Online C compiler to run C program online
#include <stdio.h>
void bubbleSort(int weights[], int profits[], float ratios[], int n){
    for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
            if(ratios[i] < ratios[j]){
                int temp1 = profits[i];
                profits[i] = profits[j];
                profits[j] = temp1;
                
                 int temp2 = weights[i];
                weights[i] = weights[j];
                weights[j] = temp2;
                
                 float temp3 = ratios[i];
                ratios[i] = ratios[j];
                ratios[j] = temp3;
            }
        }
    }
}
void knapsack(int profits[], int weights[], int n , int m){
    
        float current_profit=0.0;
    float ratios[n]; // calc profit/weight ratios
    for(int i=0;i<n;i++){
        ratios[i] = (float) profits[i]/weights[i];
    }
    
    //sort profits,weights, ratios acc to ratios in descending ordeer
    bubbleSort(weights, profits, ratios, n);
   
    float frac[n]; // frac array - if included fully then 1.0, not then 0.0, if fractional incl then that frac
    for(int i=0;i<n;i++){
        if(weights[i] <= m){ // weight of object less than current capacity left then include it
            frac[i] = 1.0;
            m-=weights[i]; // minus the current bag capacity by the current object weight included
            
             current_profit = (float) current_profit + profits[i];// add current obj profit
        }else{
            // if frac part of obj can be included
            frac[i] = (float)m/weights[i];  // calc frac 
           
          
            current_profit+= frac[i] * ratios[i]; // get frac profit that can be included
        }
    }
    
    printf("The profit is %f", current_profit);
}
int main() {
  //eg from javatpoint
    int profits[7] = {
       5 ,    10,     15,     7,     8 ,    9 ,    4
    };
    int weights[7] = {
       1 ,    3,     5,    4,     1,     3,     2
    };
    int m = 15; // bag capacity
    knapsack(profits, weights, 7, m);
    return 0;
}
