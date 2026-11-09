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

    // This is by far the most optimized version
    // As it skips through the sorted portion of the array
    // And the index synchronization is done naturally
    // There is no need for a manual trigger!
    // This version is comparable to Version B
    public static void optimizedGnomeSort(int[] arr)
    {
        int i = 1;
        int prev = 1;
        int n = arr.length;
        while (i < n)
        {
            if (i == 0 || arr[i] >= arr[i - 1])
            {
                ++prev;
                i = prev; 
            }
            else
            {
                int temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
                --i;
            }
        }
    }
    
    public static void jumpingGnomeSortA(int[] arr)
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
    }
    
    public static void jumpingGnomeSortB(int[] arr)
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
    }
    
    public static void jumpingGnomeSortC(int[] arr)
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
    }
}
