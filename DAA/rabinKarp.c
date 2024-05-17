#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int rabin(char text[], char pattern[], int d, int q)
{
    int t = 0;
    int p = 0;
    int n = strlen(text);
    int m = strlen(pattern);
    // int h = d^m-1 % q;
    int h = 1;
    for (int i = 0; i < m - 1; i++)
        h = (h * d) % q;
    for (int i = 0; i < m; i++)
    {
        t = (d * t + text[i]) % q;
        p = (d * p + pattern[i]) % q;
    }

    for (int s = 0; s <= n - m; s++)
    {
        if (t == p)
        {
            printf("In");
            for (int i = 0; i < m; i++)
            {
                if (text[i + s] != pattern[i])
                {
                    return 0;
                }
            }
            return s;
        }
        if (s < n - m)
        {
            t = (d * (t - text[s] * h) + text[s + m]) % q;
            if (t < 0)
            {
                t = t + q;
            }
        }
    }
    return 0;
}
int main()
{
    char text[10], pattern[10];

    int d = 10;
    int q = 13;
    strcpy(text, "23413445");

    strcpy(pattern, "114");
    int res = rabin(text, pattern, d, q);
    if (res != 0)
    {
        printf("Pattern Found at shift %d", res);
    }
    else
    {
        printf("pattern not found");
    }
    return 0;
}