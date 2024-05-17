#include<stdio.h>
#include<stdbool.h>
#include<stdlib.h>

#define MAX_VERTICES 100
int colours[MAX_VERTICES];
int graph[MAX_VERTICES][MAX_VERTICES];

int graphColoring(int v, int e){
    int min_color=0;
    
    for(int vertex=0;vertex<v;vertex++){
        int available[MAX_VERTICES+1]; // colors start from 1
        for(int i=0;i<=v;i++){
            // initially all colors are available
            available[i] = true;
        }
        //check for adjacenet vertices and do colors available to false so no adjnacent vertex gets same color
        for(int i=0;i<vertex;i++){
            if(graph[vertex][i] && colours[i]!=-1){
                  available[colours[i]] = false;
            }
        }
        int color=0;
        // get lowest available color which is true
        for(color=1;color<=v;color++){
            if(available[color]){
                break;
            }
        }
        // assign that color to current vertex
        colours[vertex] = color;
        // if that color is greater than min_color update. mincolor
        if(color> min_color){
            min_color = color;
        }
    }
    return min_color;
}
int main(){
        int v,e;
        
    printf("Enter no of vertices: ");
    scanf("%d", &v);
    printf("Enter no of edegs");
    scanf("%d", &e);
    for(int i=0;i<v;i++){
        colours[i]=-1;
        for(int j=0;j<v;j++){
            graph[i][j] =0;
        }
    }
    
    for(int i=0;i<e;i++){
        int u,v;
        printf("Enter both vertices of edge %d", (i+1));
        scanf("%d %d", &u,&v);
        graph[u][v] = graph[v][u] = 1;
    }
    
    int res = graphColoring(v,e);
    printf("Min Color req is %d", res);
    printf("Vertices\tColours\n");
    for (int i = 0; i < v; i++) {
        printf("Vertex %d:\t%d\n", i, colours[i]);
    }
}
