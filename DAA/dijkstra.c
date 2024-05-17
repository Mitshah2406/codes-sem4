
#include <stdio.h>
#include<stdbool.h>
#include<stdlib.h>
#define V 9
#define INF 9999
int min(int dist[V], bool sptSet[V]){
    int min_val = INF;
    int min_idx = -1;
    for(int i=0;i<V;i++){
        if(sptSet[i]==false && min_val> dist[i]){
            min_val = dist[i];
            min_idx = i;
        }
    }
    return min_idx;
}
void djikstra(int graph[V][V], int source){
    int dist[V]; // min distance of every vertex from source
    bool sptSet[V]; // vertex relaxed or not
    
    for(int i=0;i<V;i++){
        // initially all distance are unknown
        dist[i] = INF;
        // no vertex relaxed
        sptSet[i] = false;
    }
    dist[source] = 0; // make source dist as 0 because source to source is 0, and also coz it be included first otherwise infinte loop will run
    
    //relax till V-1
    for(int count=0;count<V-1;count++){
        // get min dist ka index from dist arr and check that vertex shouldnt be relaxed already
        int u = min(dist,sptSet);
        //relax u
        sptSet[u]=true;
        
        for(int v=0;v<V;v++){
            // if edge exist
            // if not relaxed
            // if dist of that edge is greater than distance from u + cost to reach v
            if(
                graph[u][v]!=0 &&
                sptSet[v] ==false &&
                dist[v] > dist[u]+ graph[u][v]
                ){
                    // then assign that distance to v
                     dist[v] = dist[u]+ graph[u][v];
                }
        }
    }
         printf("Node\t\t\tDistance\n");
    for(int i=0;i<V;i++){
        printf("%d\t\t\t\t\t\t%d\n", i, dist[i]);
        
    }
    
}
int main() {
    // edge cost graph
   int graph[V][V] = { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                        { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                        { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                        { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                        { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                        { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                        { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                        { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                        { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

    // Function call
    djikstra(graph, 0);
    return 0;
}

