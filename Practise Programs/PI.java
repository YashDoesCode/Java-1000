package PractisePrograms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PI {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter no of terms : ");
        int n = Integer.parseInt(br.readLine());
        double PI = 1.0;
        for(int I=1;I<=n;I++){
            if(I%2!=0)
            PI-=1.0/(2*I+1);
            else
            PI+=1.0/(2*I+1);
        }
        PI*=4;
        System.out.println("π = "+PI);
    }
}
