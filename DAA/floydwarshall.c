// Online C compiler to run C program online
#include <stdio.h>
#include<stdlib.h>
#define v 4
int distance[v][v] = {
    {0,4,0,3},{0,0,2,1},{5,3,0,0},{1,0,2,0}
};
int inf = 999;
void printMatrix(){
     
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                if(distance[i][j]==inf){
                    printf("INF\t");
                }
                printf("%d\t", distance[i][j]);
            }
            printf("\n");
        }
    
}
void warshall()
{
    for(int i=0;i<v;i++){
        for(int j=0;j<v;j++){
            if(i==j){ // reflexive elements are 0
                distance[i][j]=0;
            }
            else if(distance[i][j]==0){ // if 0 then reassign infinity
                  distance[i][j]=inf;
            }
        }
    }
    
    for(int k=0;k<v;k++){ // update matrix v times
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                if(distance[i][j] > distance[i][k]+distance[k][j]){
                    //condition for updation
                    distance[i][j] = distance[i][k]+distance[k][j];
                }
            }
        }
    }
    printMatrix();
    
}

int main() {
   warshall();

    return 0;
}
