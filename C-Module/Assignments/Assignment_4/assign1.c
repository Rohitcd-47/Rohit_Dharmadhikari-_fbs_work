#include <stdio.h>
void main() {
    int n;
    printf("Enter the range (n): ");
    scanf("%d", &n);

    printf("Armstrong numbers between 1 and %d are: ", n);

    for (int i = 1; i <= n; i++) {
        int temp = i, sum = 0, digits = 0, num = i;

        // Count digits
        while (temp != 0) {
            digits++;
            temp /= 10;
        }

        temp = i;
        // Calculate sum of powers of digits manually
        while (temp != 0) {
            int r = temp % 10;
            int power = 1;
            for (int j = 1; j <= digits; j++) {
                power *= r;  // multiply digit by itself digits times
            }
            sum += power;
            temp /= 10;
        }

        if (sum == num)
            printf("%d ", num);
    }

}
