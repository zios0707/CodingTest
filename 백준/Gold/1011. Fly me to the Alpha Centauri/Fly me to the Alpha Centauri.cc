#include <stdio.h>

long long got(long long va) {
    long long val = 0;
    for (long long j = 0; j < 50000; j++) {
        if (j * j > va) {
            val = j - 1;
            break;
        }
        else if (j * j == va) return 2 * j - 1;
    }

    if (va <= val * val + val) return val * 2;
    else return val * 2 + 1;
}

int main() {
    long long k, n, m;
    scanf("%lld", &k);
    for (int i = 0; i < k; i++) {
        scanf("%lld %lld", &n, &m);
        m -= n;
        if (m <= 3) printf("%lld\n", m);
        else printf("%lld\n", got(m));
    }
}