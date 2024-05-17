#include <stdio.h>
#include <string.h>

void computeLPS(char *pattern, int M, int *lps) {
    int len = 0;
    lps[0] = 0;
    int i = 1;  //abdababdfh // ababd
    while (i < M) {
        if (pattern[i] == pattern[len]) {
            len++;
            lps[i] = len;
            i++;
        } else {
            if (len != 0) {
                len = lps[len - 1];
            } else {
                lps[i] = 0;
                i++;
            }
        }
    }
}

void KMP(char *text, char *pattern) {
    int N = strlen(text);
    int M = strlen(pattern);

    int lps[M];
    computeLPS(pattern, M, lps);

    int i = 0;  // index for text[]
    int j = 0;  // index for pattern[]
    while (i < N) {
        if (pattern[j] == text[i]) {
            j++;
            i++;
        }
        if (j == M) {
            printf("Found pattern at index %d\n", i - j);
            j = lps[j - 1];
        } else if (i < N && pattern[j] != text[i]) {
            if (j != 0)
                j = lps[j - 1];
            else
                i = i + 1;
        }
    }
}

int main() {
    char text[] = "ABmitBABCABAB";
    char pattern[] = "mit";
    KMP(text, pattern);
    return 0;
}
