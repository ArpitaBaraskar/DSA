class Solution {
    public boolean lemonadeChange(int[] bills) {
        if(bills[0] > 5) return false;
        int five = 0, ten = 0;

        for(int bill : bills){
            if(bill == 5){
                five++;
            }else if(bill == 10){
                ten++;
                five--;
            }else{ //20
                if(ten > 0 && five > 0){
                    ten--;
                    five--;
                }else if(five >= 3){
                    five -= 3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}