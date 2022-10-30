public class maxIndex {

    public static void main(String[] args) {
        System.out.println(maxIndex(4, 6));
    }

    static int maxIndex(int steps, int badIndex) {
        int maxSum = getSumN(steps);
        return (isOnConsecutiveAddition(badIndex)) ?
                maxSum - 1 : maxSum;
    }

    static int getSumN(int n) {
        return (n * (n + 1) / 2);
    }

    static boolean isOnConsecutiveAddition(int badIndex) {
        double sqrtBI = Math.sqrt(badIndex);
        int indexToTest = (int) Math.ceil(sqrtBI);
        return badIndex == getSumN(indexToTest);
    }
}
