#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>
#define V 5
#define INF 999
int min(int key[V], int mstSet[V]){
    int min_ele = INF;
    int min_idx;
    for(int i=0;i<V;i++){
        if(mstSet[i]==false && min_ele > key[i]){
            min_ele = key[i];
            min_idx = i;
        }
    }
    return min_idx;
}

void prims(int graph[V][V]){
    int key[V], mstSet[V], parent[V];
    // key array for min cost of vertices
    //mstSet - included vertices to be true in arr
    //parent - parent node of vertex
    
    for(int i=0;i<V;i++){
        // initially all mstSet are false, weights i.e key for all are infinity
        mstSet[i] = false;
        key[i] = INF;
    }
    // 0 ka parent is no one
    parent[0] = -1;
    // 0 ka weight is 0, so yeh min hai from array and get selected first
    key[0] = 0;
    // store min cost of spanning tree
    int min_cost =0;
    for(int count=0;count<V-1;count++){
        // find index of min vertex from key arr which are not included in MST
        int u = min(key, mstSet);
        // include u in mST
        mstSet[u] = true;
        
        for(int v=0;v<V;v++){
            // if there exists a edge &&
            // vertex is not in MST &&
            // weight of existing edge is less than of key arr
            if(
                graph[u][v]!=0 &&
                mstSet[v] == false &&
                graph[u][v] < key[v]
                )
                {
                    // make v ka parent u ko
                    // key of v me less wala weight daalo
                    // add to mincost
                    parent[v] = u;
                    key[v] = graph[u][v];
                    min_cost += key[v];
                }
        }
    }
    printf("Min cost %d" , min_cost);
}

int main(){
    
    // matrix representing cost/weight of edges (undirected graph)
     int graph[V][V] = { { 0, 2, 0, 6, 0 },
                        { 2, 0, 3, 8, 5 },
                        { 0, 3, 0, 0, 7 },
                        { 6, 8, 0, 0, 9 },
                        { 0, 5, 7, 9, 0 } };
    prims(graph);
    return 0;
}
