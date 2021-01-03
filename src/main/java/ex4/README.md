# Exercise 4
Find the mean of how many genres all movies have

## Data uploading
The following commands were executed:
```bash
$ hdfs dfs -mkdir /input/ex4
$ hdfs dfs -put ~/ml-latest/movies.csv /input/ex4
```

## Explanation
Small output, and a neat little trick. This time in the mapper class after splitting by `,`
we get the `[2]` element in the array and split it again by `|` and by getting the length of this array
we get the genre count of this movie. In the reducer class we count how many movies there are and sum up
the amount of genres we found. In the `cleanup` method (which is called right before the reducer terminates),
we do the division to find the mean and then write that to the contex.

To run (notice two input dirs):
```bash
$ hadoop jar hadoop.jar Main -ex4 /input/ex4 /output/ex4
```

## Screenshot
```bash
$ hdfs dfs -text /output/ex4/part-r-00000
Movie genre mean:       1.8263042691439306
```
