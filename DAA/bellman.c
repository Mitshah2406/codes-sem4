// Online C compiler to run C program online
#include <stdio.h>
#include<stdlib.h>
#define SIZE 7

//graph with cost of vertex
int graph[SIZE][SIZE] = {
    {0,6,5,5,0,0,0}, //1
    {0,0,0,0,-1,0,0}, //2
    {0,-2,0,0,1,0,0}, //3
    {0,0,-2,0,0,-1,0}, //4
    {0,0,0,0,0,0,3},//5
    {0,0,0,0,0,0,3},//6
    {0,0,0,0,0,0,0}//7
};
int inf = 9999;
int distance[SIZE];

void initDistance(){
    for(int i=0;i<SIZE;i++){
        // all distance are unknown at first i.e inf
        distance[i] = inf;
    }
    // we calc distance from 0 so distance of 0 from 0 is 0
    distance[0] = 0;
}

void printRes(){
    printf("NODE\t\t\t\t\tDISTANCE\n");
    for(int i=0;i<SIZE;i++){
         printf("%d\t\t\t\t\t\t%d\n", i, distance[i]);
    }
}
void detectCycle(){
   
     for(int u=0;u<SIZE;u++){
        for(int v=0;v<SIZE;v++){
             //if one more time edges relax then negative edge cycle is present
            if(graph[u][v]!=0 && distance[v] > distance[u] + graph[u][v]){
               printf("Negative edge cycle detected");
            }
        }
    }
}
void bellman(){
    for(int u=0;u<SIZE;u++){
        for(int v=0;v<SIZE;v++){
            // if graph has a valid edge
            // and if distance of next vertex is greater than distance of current vertex + cost of reaching next vertex from current vertex
            if(graph[u][v]!=0 && distance[v] > distance[u] + graph[u][v]){
                distance[v] = distance[u] + graph[u][v];
            }
        }
    }
}
int main() {
    initDistance();
    for(int i=0;i<SIZE-1;i++){ // relax edges till Vertices-1 times
        bellman();
    }
    printRes();
    detectCycle(); // for detecting negative edge cyle
    
    
    return 0;
}
