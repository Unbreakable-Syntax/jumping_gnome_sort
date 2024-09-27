# Overview
The original sorting logic of Gnome Sort is simple, it checks if **arr[i]** is greater than **arr[i - 1]**, if it's not, the sorting algorithm will swap the two numbers, decrement **i**, check again if **arr[i]** is greater than **arr[i - 1]** again, if no, swap, decrement **i**, until **arr[i]** is at the correct position. But the original implementation has a problem: After **arr[i]** is now at the correct position, the main loop will have to iterate back to where **arr[i]** originally was before a swap is performed, if **arr[i]** was swapped a little near from its previous location, this would be fine, but in some cases, **arr[i]** is swapped way too far from its original position, because it is far, the iteration is going to be slow, and the sorting algorithm won't be able to resume the sorting process until the main loop reaches the original location of **arr[i]**.

# Skipping logic
Instead of having to iterate, this variant introduces a small change, when a swap is performed, the sorting algorithm now tracks the original location of **arr[i]**. When the swap is done and **arr[i]** in its rightful spot, instead of looping back, the algorithm simply skips ahead of all numbers before the **original location of arr[i] + 1** and resume from there immediately, the skipped numbers are already sorted. The location must be added by 1 to make up for the "shifting" of elements, and so that the last element of sorted portion of the array is not read, reducing comparisons.

It has the following characteristics, despite the optimization, the characteristics are exactly the same as the original implementation.

```
Best     Average     Worst     Stable     Deterministic
O(n)      O(n²)      O(n²)      Yes            Yes
```
# Benchmark
I have included a benchmark file of this variant compared to the original variant on several inputs, it is consistent that there is 20% performance improvement. I will add additional benchmarks soon.

# Usage
This sorting algorithm has not been uploaded to Cargo, if you wish to use this sorting algorithm, please go to the main.rs file and copy the code.

# Objective
This sorting algorithm is not really ideal for primary usage, even with the applied optimization. I have made this variant since I believe that this specific Gnome sort variant has not yet existed somewhere else, and I wanted to create my own optimized variant of this sorting algorithm. The skipping logic should give Gnome Sort a boost in performance, but I believe this is all that could be done to Gnome Sort to make it faster without changing its core logic too much.

Please feel free to use this Gnome Sort variant as an educational tool, a reference, or if you want to use it in your own project.
