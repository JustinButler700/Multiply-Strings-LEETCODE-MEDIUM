// Justin Butler
//11/7/2021
/*
Runtime: 3 ms
Memory Usage: 39.3 MB
Beats 93.29% of Solutions
*/
class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0")){return "0";} // edge cases
        if(num1.equals("1")){return num2;}
        if(num2.equals("1")){return num1;}
        int[] res = new int[num1.length()+num2.length()]; // holds our results
        for(int i = num1.length()-1; i >= 0; i--)
        {
            for(int j = num2.length()-1; j >= 0; j--)
            {
                int mul = (num1.charAt(i)-'0')*(num2.charAt(j)-'0'); // holds the results of our multiplication
                mul += res[i+j+1]; // add the last carry value
                res[i+j+1] = mul%10; // add the new decimal value to the array
                res[i+j] += mul/10; // set the next carry value
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i : res)
        {
            if(i ==0 && sb.length()==0)
            {
                continue;
            }
            sb.append(i);
        }
        return sb.toString();
    }
}
