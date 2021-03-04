
package LeetCodeSolutions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Problem35{

    public int searchInsert(int[] nums, int target) {
        int st = 0, end = nums.length-1;
        while(st<=end){
            int mid = st + (end-st)/2;
            if(nums[mid]<target){
                st = mid+1;
            }
            if(nums[mid]==target){
                return mid;
            }
            else{
                end = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number of elements in java : ");
        int n = Integer.parseInt(br.readLine());
        int nums[] = new int[n];
        System.out.println("Input the array : ");
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        System.out.println("Enter the element to be searched : ");
        int target = Integer.parseInt(br.readLine());
        Problem35 ob = new Problem35();
        int r= ob.searchInsert(nums, target);
        if(r==-1)
        System.out.println("Element not found.");
        else
        System.out.println("Element found at index "+r+".");
    }
}
