/**
 * @version 06.09.2018
 * @author Viktor Chernyaev
 * @Java2 homework Lesson-5
 * @link https://github.com/des1z
 */

public class Java2HW5 {
    private static final int size = 10000000;
    private static final int h = size / 2;

    public float[] calculate(float[] arr) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = (float) (arr[i] * Math.sin(0.2f + arr[i] / 5) * Math.cos(0.2f + arr[i] / 5) * Math.cos(0.4f + arr[i] / 2));
        return arr;
    }

    public void runOneThread() {
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) arr[i] = 1.0f;
        long a = System.currentTimeMillis();
        calculate(arr);
        System.out.println("One thread method ends with: " + (System.currentTimeMillis() - a));
    }
}
