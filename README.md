# Overview
The original sorting logic of Gnome Sort is simple, it checks if **arr[i]** is greater than **arr[i - 1]**, if it's not, the sorting algorithm will swap the two numbers, decrement **i**, check again if **arr[i]** is greater than **arr[i - 1]**, if no, swap, decrement **i**, repeat until **arr[i]** is at the correct position. But the original implementation has a problem: After **arr[i]** is now at the correct position, the main loop will have to iterate back to where **arr[i]** originally was before a swap is performed, if **arr[i]** was swapped a little near from its previous location, this would be fine, but in some cases, **arr[i]** is swapped way too far from its original position, because it is far, the iteration is going to be slow, and the sorting algorithm won't be able to resume the sorting process until the main loop reaches the original location of **arr[i]**.

# Jumping logic
Instead of having to iterate, this variant introduces a small change, when a swap is performed, the sorting algorithm now tracks the original location of **arr[i]**. When the swap is done and **arr[i]** in its rightful spot, instead of looping back, the algorithm simply skips ahead of all numbers before the **original location of arr[i] + 1** and resume from there immediately, the skipped numbers are already sorted. The location must be added by 1 to make up for the "shifting" of elements, and so that the last element of sorted portion of the array is not read, reducing comparisons.

There are 3 ways to write the jumping logic. The first method is by directly assigning the previous location of **n** before swapping to **i**. The second method is to declare a sychronized second copy of **i**, this second copy will not be decremented during the sorting process, when **n** has been placed in its correct spot, the second index copy will now be given to **i**, achieving the jump optimization. The third method is to count how many swaps have been performed to place **n** in its correct spot, when **n** is in its correct spot, the total number of performed swaps will be added to **i**, achieving the leap optimization.

Despite the optimization, the characteristics of this variant is exactly the same as the original implementation.

```
Best     Average     Worst     Memory     Stable     Deterministic
O(n)      O(n²)      O(n²)      O(1)      Yes        Yes
```

# Visualization
These visualizations are produced using Timo Bingmann's [The Sound of Sorting](https://github.com/bingmann/sound-of-sorting/)
For comparison, here is the original Gnome Sort arranging 256 elements in ascending order.

https://github.com/user-attachments/assets/6d7cf157-b477-41c0-be60-34c7b7a7a82d

This is Jumping Gnome Sort, sorting 256 elements in ascending order, it can be observed in the visualization that this variant no longer has to iterate back to where it stopped after placing a number in its correct spot.

https://github.com/user-attachments/assets/eeea2feb-9e11-4241-a9a6-69406bf6b3d9

# Benchmark
I have included a benchmark of this variant compared to the original variant on several inputs, it is consistent that there is good performance improvement. The benchmark has been performed on my laptop which has the Intel i3-1005G1 processor. Actual sort time varies based on the input distribution and the user's computer hardware.

![alt text](https://github.com/Unbreakable-Syntax/jumping_gnome_sort/blob/main/bars1.png?raw=true)

# Usage
This sorting algorithm has not been uploaded to Cargo, if you wish to use this sorting algorithm, please go to the main.rs file and copy the code.

# Objective
This sorting algorithm is not really ideal for primary usage, even with the applied optimization. I have made this variant since I wanted to create my own optimized variant of this sorting algorithm, and I believe it should be "preserved", even if this is not the first time that this variant has been implemented. The skipping logic should give Gnome Sort a boost in performance, but I believe this is all that could be done to Gnome Sort to make it faster without changing its core logic too much.

Please feel free to use this Gnome Sort variant as an educational tool, as a reference, or if you want to use it in your own project.
