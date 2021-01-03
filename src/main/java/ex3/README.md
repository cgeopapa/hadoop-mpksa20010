# Exercise 3
Find how many tags each movie has.

## Data uploading
The following commands were executed:
```bash
$ hdfs dfs -mkdir /input/ex3/movies
$ hdfs dfs -mkdir /input/ex3/ratings
$ hdfs dfs -put ~/ml-latest/tags.csv /input/ex3/ratings
$ hdfs dfs -put ~/ml-latest/tags.csv /input/ex3/movies
```

## Explanation
Here we need to use the same join technique as in ex2. This time we will use the
ratings.csv. We need to save the ratings each user gave to each movie and then, in the reducer class,
we are summing them all up and count each rating. In the contex we write the extracted movie
title, and the division result between sum and count.

To run (notice two input dirs):
```bash
$ hadoop jar hadoop.jar Main -ex3 /input/ex3/ratings /input/ex3/movies /output/ex3
```

## Screenshot
```bash
$ hdfs dfs -text /output/ex3/part-r-00000
Day of the Dead (1985)  3.5679768041237114
Never Ever! (Nigdy w zyciu!) (2004)     2.642857142857143
"Children of Leningradsky, The (2005)"  3.8
"Hello, Dolly! (1969)"  3.3727810650887573
I'm Going Home (Je rentre à la maison) (2001)   3.3392857142857144
Submerged (2005)        1.7666666666666666
Memoirs of an Invisible Man (1992)      2.807065217391304
"Rose, The (1979)"      3.192015209125475
Stacy (2001)    2.7941176470588234
Insanitarium (2008)     2.6666666666666665
Illegal (1955)  3.1363636363636362
See No Evil (1971)      3.213235294117647
Echelon Conspiracy (2009)       2.949404761904762
Jasminum (2006) 3.4
After Sex (2007)        2.76027397260274
Super Sucker (2002)     2.293103448275862
"Third Part of the Night, The (Trzecia czesc nocy) (1972)"      3.7
Indiscretion of an American Wife (a.k.a. Terminal Station) (Stazione Termini) (1953)    2.638888888888889
At War with the Army (1950)     2.6527777777777777
Barbarella (1968)       2.979837580509661
Bingo (1991)    2.0705128205128207
13B (2009)      3.010869565217391
Monsters vs. Aliens (2009)      3.1353624349219062
God told Me To (1976)   2.971264367816092
"I, Madman (1989)"      2.554054054054054
Boarding Gate (2007)    3.0
California Dreamin' (Nesfarsit) (2007)  3.753968253968254
Counter Investigation (Contre-enquête) (2007)   3.607142857142857
Sita Sings the Blues (2008)     3.6818181818181817
Jungle Book (1942)      3.541404612159329
. . . . .
```