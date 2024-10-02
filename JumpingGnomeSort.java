/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.jumpinggnomesort;

/**
 *
 * @author Percival
 */
public class JumpingGnomeSort 
{
    public static void main(String[] args) 
    {
        System.out.println("Hello World!");
    }
    
    public static int[] jumpingGnomeSortA(int[] arr)
    {
        int i = 0;
        int prev = 0;
        int n = arr.length;
        while (i < n)
        {
            if (i == 0 || arr[i] >= arr[i - 1])
            {
                if (prev != 0) { i = prev; prev = 0; }
                ++i;
            }
            else
            {
                int temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
                if (prev == 0) { prev = i; }
                --i;
            }
        }
        return arr;
    }
    
    public static int[] jumpingGnomeSortB(int[] arr)
    {
        int i = 0;
        int prev = 0;
        int n = arr.length;
        while (i < n)
        {
            if (i == 0 || arr[i] >= arr[i - 1])
            {
                if (i < prev) { i = prev; }
                ++i; ++prev;
            }
            else
            {
                int temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
                --i;
            }
        }
        return arr;
    }
    
    public static int[] jumpingGnomeSortC(int[] arr)
    {
        int i = 0;
        int prev = 0;
        int n = arr.length;
        while (i < n)
        {
            if (i == 0 || arr[i] >= arr[i - 1])
            {
                if (prev != 0) { i += prev; prev = 0; }
                ++i;
            }
            else
            {
                int temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
                --i; ++prev;
            }
        }
        return arr;
    }
}
