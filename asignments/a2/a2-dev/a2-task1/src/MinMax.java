
class MinMax{
    public static double minMaxAverage(int[] numbers) {
        return (min(numbers) + max(numbers)) / 2.0;
    }

    public static int min(int[] numbers)
    {
        int myMin = 0;
        int isArrayEven = numbers.length % 2;  // controls if the loop needs to stop before a remainder that cant pair.

        int current_pair = 0;
        /* comparisons made in for loop if numbers.length is: even = (n-2/2), odd = (n-3/2) */
        for(int index = 2; index < numbers.length - isArrayEven; index +=2 ) {

            if( numbers[current_pair] * numbers[current_pair + 1] > numbers[index] * numbers[index+1])
                current_pair = index;
        }

        /* comparisons made in this if and else statements when numbers.length is: odd = 1 or 2,  even = 1 */
        boolean isRemainderMin = false;
        if(isArrayEven != 0) {
            isRemainderMin = numbers[current_pair] * numbers[current_pair+1] > numbers[numbers.length - 1] * numbers[numbers.length - 1] ? true : false;  // comparison  (only 1 comparison if the remainder that cant pair is the min)
            myMin = numbers[numbers.length - 1];
        }
        if(!isRemainderMin)
            myMin = numbers[current_pair] < numbers[current_pair + 1] ? numbers[current_pair] : numbers[current_pair + 1]; // comparison (2 comparisons if the min is within the pair)

        return myMin;
    }

    public static int max(int[] numbers)
    {
        int myMax = 0;
        int isArrayEven = numbers.length % 2;  // controls if the loop needs to stop before a remainder that cant pair.

        int current_pair = 0;
        /* comparisons made in for loop if numbers.length is: even = (n-2/2), odd = (n-3/2) */
        for(int index = 2; index < numbers.length - isArrayEven; index +=2 ) {

            if( numbers[current_pair] * numbers[current_pair + 1] < numbers[index] * numbers[index+1])
                current_pair = index;
        }

        /* comparisons made in this if and else statements when numbers.length is: odd = 1 or 2,  even = 1 */
        boolean isRemainderMin = false;
        if(isArrayEven != 0) {
            isRemainderMin = numbers[current_pair] * numbers[current_pair+1] < numbers[numbers.length - 1] * numbers[numbers.length - 1] ? true : false;  // comparison  (only 1 comparison if the remainder that cant pair is the min)
            myMax = numbers[numbers.length - 1];
        }
        if(!isRemainderMin)
            myMax = numbers[current_pair] < numbers[current_pair + 1] ? numbers[current_pair] : numbers[current_pair + 1]; // comparison (2 comparisons if the min is within the pair)

        return myMax;
    }
    public static void main(String[] args) {
//        int[] a = {2, 3, 0, 5, 5, 5, 6, 1, -1, 6, 10};
        int[] a = {2, 3, 0, 5, 5 };

        assert(minMaxAverage({}) == 400);

        double min = min(a);
        double max = max(a);
        double avg = minMaxAverage(a);

        System.out.println(min);
        System.out.println(max);
        System.out.println(avg);
    }
}
