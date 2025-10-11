#include <stdio.h>

void main() {
    int n;
    printf("Enter the range (n): ");
    scanf("%d", &n);

    printf("Perfect numbers between 1 and %d are: ", n);

    for (int i = 1; i <= n; i++) {
        int sum = 0;

        for (int j = 1; j <= i / 2; j++) {
            if (i % j == 0)
                sum += j;
        }

        if (sum == i)
            printf("%d ", i);
    }

}
