public class Main {

    public static void main(String[] args) {
        System.out.println(getSumOfEvenValuedTerms()); //Sum: 4613732
    }

    public static int getSumOfEvenValuedTerms(){
        int sum = 0;
        int previous = 0;
        int current = 1;
        int a;
        while(current <= 4000000){
            if(current % 2 == 0) {
                sum = sum + current;
            }
            a = current;
            current = previous + a;
            previous = a;
        }
        return sum;
    }
}
