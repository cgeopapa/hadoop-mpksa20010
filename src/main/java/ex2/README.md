# Exercise 2
Find how many tags each movie has.

## Data uploading
The following commands were executed:
```bash
$ hdfs dfs -mkdir /input/ex2/movies
$ hdfs dfs -mkdir /input/ex2/tags
$ hdfs dfs -put ~/ml-latest/tags.csv /input/ex2/tags
$ hdfs dfs -put ~/ml-latest/tags.csv /input/ex2/movies
```

## Explanation
Again, it is a simple counting problem. We need to count how many times a movieId is present 
in the tags.csv. This is how many tags a movie has. This time there is also a need for a join
operation. So we have two mappers. One for helping with the counting and another for finding
out the title of each movie that hides behind each movieId. The one reducer will then count how 
many times the special character of the tags' mapper is present and extract the title of
the movie from inside the iterable object that gets as input.

To run (notice two input dirs):
```bash
$ hadoop jar hadoop.jar Main -ex2 /input/ex2/tags /input/ex2/movies /output/ex2
```

## Screenshot
```bash
$ hdfs dfs -text /output/ex2/part-r-00000
Once Upon a Time in China II (Wong Fei-hung Ji Yi: Naam yi dong ji keung) (1992)        20
Sugar (2008)    17
Once Upon a Time in China III (Wong Fei-hung tsi sam: Siwong tsangba) (1993)    14
Young Thugs: Nostalgia (Kishiwada shônen gurentai: Bôkyô) (1998)        3
Paper Moon (1973)       57
Praying with Lior (2008)        5
Sgt. Pepper's Lonely Hearts Club Band (1978)    20
Ong-Bak 2: The Beginning (Ong Bak 2) (2008)     13
"Girl with the Dragon Tattoo, The (Män som hatar kvinnor) (2009)"       505
Bloodbath at the House of Death (1984)  6
"Song for Martin, A (Sång för Martin, En) (2001)"       4
Sunshine Cleaning (2008)        84
Targets (1968)  21
"Ugly American, The (1963)"     0
"Bostonians, The (1984)"        11
Kung Fu Panda: Secrets of the Furious Five (2008)       20
Hangman's Knot (1952)   3
Space Jam (1996)        80
Convoy (1978)   20
Immortal Sergeant (1943)        2
Day of the Dead (1985)  136
Never Ever! (Nigdy w zyciu!) (2004)     4
"Children of Leningradsky, The (2005)"  10
"Hello, Dolly! (1969)"  19
I'm Going Home (Je rentre à la maison) (2001)   4
Submerged (2005)        3
Memoirs of an Invisible Man (1992)      7
"Rose, The (1979)"      16
Stacy (2001)    12
Insanitarium (2008)     4
. . . . .
```