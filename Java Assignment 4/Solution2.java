/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class Solution2
{
    public static void main(String[] args)
    {
        int num = -1;
        byte b = (byte)num;
        int n = b;
        char c = (char)b, c1 = (char)n;
        int final_num = c;
        System.out.println("Initial integer: "+ num);
        System.out.println("Byte: "+ b + " " + n + " " + c1);
        System.out.println("Character: "+ c);
        System.out.println("Final integer: "+ final_num);
    }
}

// Explanation:

/*The range of byte is -128 to 127 and when integer of -1 is typecasted to byte it remains within the range
and byte_value is -1. Now in java character is in the form unicode which is has a range of 0 to 2^16-1. Hence when
byte_value is typecasted to char it takes the value of 2^16-1 because -1 is not in the range of char.
When char_value is changed to int, since the value can be fit in the range of int that is why no change
of value will occur here.
*/

