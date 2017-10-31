object Solution {
    def myPow(x: Double, n: Int): Double = {
        var r = 1.0
        if (n < 0) 
            myPow(1 / x,-(n + 1)) / x
        else if (n == 0)
            1
        else if(n % 2 == 0)
            myPow(x * x, n / 2)
        else
            x * myPow(x, n - 1)
    }
}