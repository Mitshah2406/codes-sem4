// Online C compiler to run C program online
#include <stdio.h>
#include<stdlib.h>
#define MAX_V 100
int parent[100];
int rank[100];

int find(int x){
    if(parent[x]==x){
        return x;
    }
    int temp = find(parent[x]);
    parent[x] = temp;
    return temp;
}
int unionset(int x, int y){
    int parX = find(x);
    int parY = find(y);
    if(parX==parY){
        return 0;
    }
    if(rank[parX]< rank[parY]){
        parent[parX] = parY;
    }else if(rank[parY]< rank[parX]){
        parent[parY] = parX;
    }else{
        parent[parY] = parX;
        rank[parX]++; 
    }
    return 1;
}
int compare(const void  *a, const void  *b){
    int *edge1 = (int *)a;
    int *edge2 = (int *)b;
    return edge1[2] - edge2[2];
}
void kruskal(int V,int E, int edges[][3]){
    for(int i=0;i<V;i++){
        parent[i] = i;
        rank[i] = 1;
    }
    qsort(edges,E, sizeof(edges[0]), compare);
    int min_cost = 0;
    for(int i=0;i<V;i++){
        int u = edges[i][0];
         int v = edges[i][1];
          int w = edges[i][2];
          
         int res = unionset(u,v);
         if(res==1){
             printf("The edge %d to %d included with weight %d\n" ,u,v,w);
            min_cost+=w;
         }
    }
    printf("\n the min cost is. %d", min_cost);
}


int main() {
    int V = 5, E = 7;
    int edges[7][3] = {
         {0, 1, 1},
        {0, 2, 7},
        {0, 3, 10},
        {0, 4, 5},
        {1, 2, 3},
        {2, 3, 4},
        {3, 4, 2}
    };
    
    kruskal(V,E,edges);
    
    
    return 0;
}
