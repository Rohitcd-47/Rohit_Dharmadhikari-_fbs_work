#include <stdio.h>

// Function to calculate factorial of a number
int factorial(int n) {
    int fact = 1;
    for (int i = 1; i <= n; i++)
        fact *= i;
    return fact;
}

int main() {
    int n;
    printf("Enter the range (n): ");
    scanf("%d", &n);

    printf("Strong numbers between 1 and %d are: ", n);

    for (int i = 1; i <= n; i++) {
        int temp = i, sum = 0;

        while (temp != 0) {
            int r = temp % 10;
            sum += factorial(r);
            temp /= 10;
        }

        if (sum == i)
            printf("%d ", i);
    }

    return 0;
}
