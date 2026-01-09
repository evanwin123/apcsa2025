package warmup;

public class Main {

    public static void main(String[] args) {
        // Your code here.
    int sum = 0;
for (int i = 1; i < 1000; i++) {
 if (i % 3 == 0 || i % 5 == 0)  {
    sum += i;
 }
}
System.out.println(sum);

    int fib1 = 1;
int fib2= 2;
int fibsum = 2;

while (fib2 < 4000000) {
    int next = fib1 + fib2;

    if(next > 4000000) {
        break;
    }
    if (next % 2 == 0) {
        fibsum += next;
    }
    fib1 = fib2;
    fib2 = next;
    }
System.out.println (fibsum);
}
}






