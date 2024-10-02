use rand::{thread_rng, Rng};

fn main() {
    let mut arr: Vec<i32> = (0..=50).collect();
    shuffle_array(&mut arr);
    println!("Shuffled: {:?}", arr);
    skipping_gnome_sort(&mut arr);
    println!("Sorted: {:?}", arr);
}

// Version A
// prev variable is used as a "teleporter" variable
// When n is at its proper spot, n is given the value of prev
fn jumping_gnome_sort(arr: &mut Vec<i32>)
{
    let mut i: usize = 0;
    let mut prev: usize = 0;
    while i < arr.len()
    {
        if i == 0 || arr[i] >= arr[i - 1]
        {
            if prev != 0
            { i = prev; prev = 0; }
            i += 1;
        }
        else
        {
            arr.swap(i, i - 1);
            if prev == 0 { prev = i; }
            i -= 1;
        }
    }
}

// Version B
// prev variable goes along with i, but it is not decremented during swapping
fn jumping_gnome_sort_b(arr: &mut Vec<i32>)
{
    let mut i: usize = 0;
    let mut n: usize = arr.len();
    let mut prev: usize = 0;
    while i < n
    {
        if i == 0 || arr[i] >= arr[i - 1]
        {
            if i < prev { i = prev; }
            i += 1;
            prev += 1;
        }
        else
        {
            arr.swap(i, i - 1);
            i -= 1;
        }
    }
}

// Version C
// prev variable is used as a "counter" variable
// prev counts how many times i has been decremented
fn skipping_gnome_sort_c(arr: &mut Vec<i32>)
{
    let mut i: usize = 0;
    let mut n: usize = arr.len();
    let mut prev: usize = 0;
    while i < n
    {
        if i == 0 || arr[i] >= arr[i - 1]
        {
            if prev != 0 { i += prev; prev = 0; }
            i += 1;
        }
        else
        {
            arr.swap(i, i - 1);
            prev += 1;
            i -= 1;
        }
    }
}

fn shuffle_array(arr: &mut Vec<i32>)
{
    let mut rand: rand::rngs::ThreadRng = thread_rng();
    let mut random: usize;
    for pos in 1..arr.len()
    {
        random = rand.gen_range(0..=pos);
        arr.swap(pos, random);
    }
}
