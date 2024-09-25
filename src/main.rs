use rand::{thread_rng, Rng};

fn main() {
    let mut arr: Vec<i32> = (0..=50).collect();
    shuffle_array(&mut arr);
    println!("Shuffled: {:?}", arr);
    skipping_gnome_sort(&mut arr);
    println!("Sorted: {:?}", arr);
}

fn skipping_gnome_sort(arr: &mut Vec<i32>)
{
    let mut i: usize = 0;
    let mut prev: usize = 0;
    while i < arr.len()
    {
        if i == 0 || arr[i] >= arr[i - 1]
        {
            if prev != 0
            { i = prev + 1; prev = 0; continue; }
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