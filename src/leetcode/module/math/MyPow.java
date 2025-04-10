package leetcode.module.math;

public class MyPow {
    public double myPow(double x, int n) {

        int ans = 1;

        if (n < 0){
            x = 1 / x;
        }
        while (n != 0){

            if ((n & 1) == 1 ){
                ans *= x;
            }

            x *=x;
            n = n >> 1;
        }
        return ans;

    }
}
