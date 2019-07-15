/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singleserverqueue;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Mehedi Shovon
 */
public class SingleServerQueue {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random random=new Random();
        
        Scanner sc = new Scanner(System.in);
        System.out.print ("Enter No Of Process : ");
		int size = sc.nextInt();
        int x, y;
        int pid[] = new int[size];
        int [] inter=new int [size];
        int [] service=new int [size];
        int [] arrival=new int [size];
        int [] begain=new int [size];
        int [] ends=new int [size];
        int [] sum=new int [size];
        
        for (int i = 0; i < size; i++) {
            inter[i]=random.nextInt(5)+1;
            service[i]=random.nextInt(5)+1;
            //arrival[i]=inter[i]+arrival[i];
            //System.out.println(i + " "+ s1[i]);
        }
/*************************For Arrival Time**************************/
        for (int i = 0; i < size; i++) {
            if(i==0)
                    arrival[i]=0;
            else
                arrival[i]=arrival[i-1]+inter[i];
            }
        
/*************************For Ends Time**************************/       
        for (int i = 0; i < size; i++) {
         //   if(arrival[i]>inter[i])
              if(i==0)
                  ends[i]=service[i];
              else if(ends[i-1]>arrival[i]){
                  ends[i]=service[i]+ends[i-1];
              }
              else if(arrival[i]>ends[i-1]){
                  ends[i]=service[i]+arrival[i];
              }
                }
        
/*************************For Begains Time**************************/  
        for (int i = 0; i < size; i++) {
            if(i==0)
                begain[i]=0;
            else if(ends[i-1]>arrival[i]){
                  begain[i]=ends[i-1];
              }
              else if(arrival[i]>ends[i-1]){
                  begain[i]=arrival[i];
              }
        }
        
     
               
                System.out.println("\nPId  InterAT Service  Arrival Begins Ends");
		for(int i=0;i<size;i++)
		{
                    pid[i] = i+1;
                    System.out.println(pid[i]+"\t"+inter[i]+"\t"+service[i]+"\t"+arrival[i]+"\t"+begain[i]+"\t"+ends[i]);
                }          
    }
}
