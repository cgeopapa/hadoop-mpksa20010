# Exercise 1
Find the users who have voted for more than 10 movies

## Data uploading
The following commands were executed:
```bash
$ hdfs dfs -mkdir /input/ex1
$ hdfs dfs -put ~/ml-latest/tags.csv /input/ex1
```

## Explanation
In essence, it is a simple counting problem. We need to count how many times a userId is present in the csv.
This is how many times the user has voted for a movie. Finally, 
before we write in the contex we need to check if that user has voted
more than 10 times.

To run:
```bash
$ hadoop jar hadoop.jar Main -ex1 /input/ex1 /output/ex1
```

## Screenshots
```bash
$ hdfs dfs -text /output/ex1/part-r-00000
10000   79
100048  34
100060  23
100116  10
100244  11
100294  519
100312  111
100347  54
100373  28
10038   97
100474  177
100537  19
100618  16
100701  32
100704  23
10074   100
100833  14
100940  132
100995  145
101107  118
101142  72
101185  10
101294  12
101346  26
101431  56
10149   31
101536  359
101564  29
101576  66
101607  96
101613  51
101648  23
101663  10
101754  1479
101763  78
101778  628
10180   19
101860  12
101886  72
10194   20
102042  14
102046  152
10205   256
. . . . .
```