# Gnome sort
The original sorting logic of Gnome Sort is simple, it checks if **arr[i]** is greater than **arr[i - 1]**, if it's not, the sorting algorithm will swap the two numbers, decrement **i**, check again if **arr[i]** is greater than **arr[i - 1]** again, if yes, swap, decrement **i**, until **arr[i]** is at the correct position. But the original implementation has a problem: After **arr[i]** is now at the correct position, the main loop will have to iterate back to where **arr[i]** originally was before a swap is performed, if **arr[i]** was swapped a little near from its previous location, this would be fine, but in some cases, **arr[i]** is swapped way too far from its original position, because it is far, the iteration is going to be slow, and the sorting algorithm won't be able to resume the sorting process until the main loop reaches the original location of **arr[i]**.

# Skipping logic
Instead of having to iterate, this variant introduces a small change, when a swap is performed, the sorting algorithm now tracks the original location of **arr[i]**, when the swap is done and **arr[i]** in its rightful spot, instead of looping back, the algorithm simply skips ahead of all numbers before the **original location of arr[i] + 1** and resume from there immediately, the skipped numbers are already sorted. The location must be added by 1 to make up for the "shifting" of elements, and so that the last element of sorted portion of the array is not read, reducing comparisons.

It has the following characteristics, despite the optimization, the characteristics are exactly the same as the original implementation.

```
Best    Average    Worst    Stable
O(n)     O(n²)     O(n²)     Yes
