#include <stdio.h>
#include <stdbool.h>

#define V 4

void printConfiguration(int colorArray[]) {
    printf("The assigned colors are as follows:\n");
    for (int i = 0; i < V; i++)
        printf("Vertex: %d Color: %d\n", i, colorArray[i]);
}

bool isSafe(bool graph[V][V], int colorArray[]) {
    for (int i = 0; i < V; i++)
        for (int j = i + 1; j < V; j++)
            if (graph[i][j] && colorArray[j] == colorArray[i])
                return false;
    return true;
}

bool graphColoringAlgorithm(bool graph[V][V], int m, int i, int colorArray[V]) {
    if (i == V) {
        if (isSafe(graph, colorArray)) {
            printConfiguration(colorArray);
            return true;
        }
        return false;
    }

    for (int j = 1; j <= m; j++) {
        colorArray[i] = j;

        if (graphColoringAlgorithm(graph, m, i + 1, colorArray))
            return true;

        colorArray[i] = 0;
    }

    return false;
}

int main() {
    bool graph[V][V] = {
        {0, 1, 1, 1},
        {1, 0, 1, 0},
        {1, 1, 0, 1},
        {1, 0, 1, 0}
    };
    int m = 3;

    int colorArray[V];
    for (int i = 0; i < V; i++)
        colorArray[i] = 0;

    if (graphColoringAlgorithm(graph, m, 0, colorArray))
        printf("Coloring is possible!\n");
    else
        printf("Coloring is not possible!\n");

    return 0;
}
