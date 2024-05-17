#include<stdio.h>
#include<stdlib.h>

void add(int n, int A[][n], int B[][n], int C[][n]) {
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            C[i][j] = A[i][j] + B[i][j];
        }
    }
}

void sub(int n, int A[][n], int B[][n], int C[][n]) {
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            C[i][j] = A[i][j] - B[i][j];
        }
    }
}

void strassen(int n, int A[][n], int B[][n], int C[][n]){
    if(n==1){
        C[0][0] = A[0][0] * B[0][0];
        return;
    }
     int newSize = n / 2;
    int A11[newSize][newSize], A12[newSize][newSize], A21[newSize][newSize], A22[newSize][newSize];
    int B11[newSize][newSize], B12[newSize][newSize], B21[newSize][newSize], B22[newSize][newSize];
    int C11[newSize][newSize], C12[newSize][newSize], C21[newSize][newSize], C22[newSize][newSize];
    int P[newSize][newSize], Q[newSize][newSize], R[newSize][newSize], S[newSize][newSize], T[newSize][newSize], U[newSize][newSize], V[newSize][newSize];
    
    for(int i = 0; i < newSize; i++) {
        for(int j = 0; j < newSize; j++) {
            A11[i][j] = A[i][j];
            A12[i][j] = A[i][j + newSize];
            A21[i][j] = A[i + newSize][j];
            A22[i][j] = A[i + newSize][j + newSize];
            
            B11[i][j] = B[i][j];
            B12[i][j] = B[i][j + newSize];
            B21[i][j] = B[i + newSize][j];
            B22[i][j] = B[i + newSize][j + newSize];
        }
    }
    
    // P = (A11 + A22)(B11 + B22)
    add(newSize, A11, A22, C11);
    add(newSize, B11, B22, C12);
    strassen(newSize, C11, C12, P);
    
    // Q = (A21 + A22)B11
    add(newSize, A21, A22, C11);
    strassen(newSize, C11, B11, Q);
    
    // R = A11(B12 - B22)
    sub(newSize, B12, B22, C11);
    strassen(newSize, A11, C11, R);
    
    // S = A22(B21 - B11)
    sub(newSize, B21, B11, C11);
    strassen(newSize, A22, C11, S);
    
    // T = (A11 + A12)B22
    add(newSize, A11, A12, C11);
    strassen(newSize, C11, B22, T);
    
    // U = (A21 - A11)(B11 + B12)
    sub(newSize, A21, A11, C11);
    add(newSize, B11, B12, C12);
    strassen(newSize, C11, C12, U);
    
    // V = (A12 - A22)(B21 + B22)
    sub(newSize, A12, A22, C11);
    add(newSize, B21, B22, C12);
    strassen(newSize, C11, C12, V);
    
    // C11 = P + S - T + V
    add(newSize, P, S, C11);
    sub(newSize, C11, T, C11);
    add(newSize, C11, V, C11);
    
    // C12 = R + T
    add(newSize, R, T, C12);
    
    // C21 = Q + S
    add(newSize, Q, S, C21);
    
    // C22 = P - Q + R + U
    sub(newSize, P, Q, C22);
    add(newSize, C22, R, C22);
    add(newSize, C22, U, C22);
    
    for(int i = 0; i < newSize; i++) {
        for(int j = 0; j < newSize; j++) {
            C[i][j] = C11[i][j];
            C[i][j + newSize] = C12[i][j];
            C[i + newSize][j] = C21[i][j];
            C[i + newSize][j + newSize] = C22[i][j];
        }
    }
}

void main(){
     int n;
    printf("Enter the size of square matrices: ");
    scanf("%d", &n);
    
    int A[n][n], B[n][n], C[n][n];
    
    printf("Enter the elements of matrix A:\n");
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            scanf("%d", &A[i][j]);
        }
    }
    
    printf("Enter the elements of matrix B:\n");
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            scanf("%d", &B[i][j]);
        }
    }
    
    strassen(n, A, B, C);
    
    printf("Resultant matrix C:\n");
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            printf("%d ", C[i][j]);
        }
        printf("\n");
    }
    
}

// #include<stdio.h>
// #include<stdlib.h>

// void add(int n, int A[][n], int B[][n], int C[][n]){
//     for(int i=0;i<n;i++){
//         for(int j=0;j<n;j++){
//             C[i][j] = A[i][j] + B[i][j];
//         }
//     }
// }
// void sub(int n, int A[][n], int B[][n], int C[][n]){
//       for(int i=0;i<n;i++){
//         for(int j=0;j<n;j++){
//             C[i][j] = A[i][j] - B[i][j];
//         }
//     }
// }
// void strassen(int n, int A[][n], int B[][n], int C[][n]){
//     if(n==1){
//         C[0][0] = A[0][0] * B[0][0];
//         return;
//     }
//     int newSize = n/2;
    
//     int A11[newSize][newSize]; 
//     int A12[newSize][newSize]; 
//     int A21[newSize][newSize]; 
//     int A22[newSize][newSize]; 
//     int B11[newSize][newSize]; 
//     int B12[newSize][newSize]; 
//     int B21[newSize][newSize]; 
//     int B22[newSize][newSize]; 
//     int C11[newSize][newSize]; 
//     int C12[newSize][newSize]; 
//     int C21[newSize][newSize]; 
//     int C22[newSize][newSize]; 

//     int P[newSize][newSize];
//     int Q[newSize][newSize];
//     int R[newSize][newSize];
//     int S[newSize][newSize];
//     int T[newSize][newSize];
//     int U[newSize][newSize];
//     int V[newSize][newSize];


//     for(int i=0;i<newSize;i++){
//         for(int j=0;j<newSize;j++){
//             A11[i][j] = A[i][j];
//             A12[i][j] = A[i][j+newSize];
//             A21[i][j] = A[i+newSize][j];
//             A22[i][j] = A[i+newSize][j+newSize];
//             B11[i][j] = B[i][j];
//             B12[i][j] = B[i][j+newSize];
//             B21[i][j] = B[i+newSize][j];
//             B22[i][j] = B[i+newSize][j+newSize];
//         }
//     }

//     //P = 
//     add(newSize, A11,A22, C11);
//     add(newSize, B11,B22, C12);
//     strassen(newSize, C11, C12, P);

//     //Q
//      add(newSize, A21,A22, C11);
//     strassen(newSize, B11, C11, Q);

//     //R
//      sub(newSize, B12,B22, C11);
//     strassen(newSize, A11, C11, R);

//     //S
//      sub(newSize, B21,B11, C11);
//     strassen(newSize, A22, C11, S);

//     //T
//      add(newSize, A11,A12, C11);
//     strassen(newSize,B22, C11, T);

//     //U
//      sub(newSize, A21,A11, C11);
//      add(newSize, B11,B12, C12);
//     strassen(newSize,C11, C12, U);

//     //V
//      add(newSize, B21,B21, C11);
//      sub(newSize, A12,A22, C12);
//     strassen(newSize,C11, C12,V);
    
    
//     //C11
//     add(newSize, P,S, C11);
//     sub(newSize, C11, T, C11);
//     add(newSize, C11, V, C11);

//     //C12
//     add(newSize, R,T,C12);
//     //C21
// add(newSize, Q,S,C21);
//     //C22
//      sub(newSize, P,Q, C22);
//     add(newSize, C22, R, C22);
//     add(newSize, C22, U, C22);

//     for(int i=0;i<newSize;i++){
//         for(int j=0;j<newSize;j++){
//             C[i][j] = C11[i][j];
//             C[i][j+newSize] = C12[i][j];
//             C[i+newSize][j] = C21[i][j];
//             C[i+newSize][j+newSize] = C22[i][j];
//         }
//     }
// }

// void main(){
//     int n;

//     printf("Enter size of matrix:");
//     scanf("%d", &n);
//     int A[n][n], 
//      B[n][n] ,
//      C[n][n];
//     printf("\nEnter elements of matrix a: \n");
//     for(int i=0;i<n;i++){
//         for(int j=0;j<n;j++){
//             scanf("%d", &A[i][j]);
//         }
//     }
//     printf("\nEnter elements of matrix b: \n");
//     for(int i=0;i<n;i++){
//         for(int j=0;j<n;j++){
//             scanf("%d", &B[i][j]);
//         }
//     }
//     strassen(n, A,B,C);
//     for(int i=0;i<n;i++){
//         for(int j=0;j<n;j++){
//            printf("%d ", C[i][j]);
//         }
//         printf("\n");
//     }
// }

// 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
//1 0 0 0 0 1 0 0 0 0 1 0 0 0 0 1
