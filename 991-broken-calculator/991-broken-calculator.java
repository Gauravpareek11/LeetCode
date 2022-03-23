class Solution {
    public int brokenCalc(int startValue, int target) {
        if(startValue>target) return startValue-target;
        int count=0;
        while(startValue!=target){
            if(target%2==0 && target>=startValue) target=target/2;
            else target++;
            count++;
        }
        return count;
    }
}