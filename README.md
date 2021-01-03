# Hadoop project - mpksa20010

This is a university project for my master degree.
For this project [this](http://files.grouplens.org/datasets/movielens/ml-latest.zip) dataset is being used.

This project consists of 4 challenge exercises where it is required to run hadoop jobs in order
to get specific data and apply different operations. 

## Uploading data to hdfs
To upload the data to the local single hadoop node hdfs was utilized.
Firstly the dataset was `wget`ed and `unzip`ed to the local filesystem.
Since each exercise required different csv for input each file was `hdfs dfs -put`ed
to separate folder according to the dependencies of each exercise.

Specifically the file system:
```bash
$ hdfs dfs -ls -R /input
drwxr-xr-x   - cgeo supergroup          0 2021-01-03 15:49 /input/ex1
-rw-r--r--   1 cgeo supergroup   39744990 2021-01-03 15:49 /input/ex1/tags.csv
drwxr-xr-x   - cgeo supergroup          0 2021-01-03 16:01 /input/ex2
drwxr-xr-x   - cgeo supergroup          0 2021-01-03 16:02 /input/ex2/movies
-rw-r--r--   1 cgeo supergroup    2858223 2021-01-03 16:02 /input/ex2/movies/movies.csv
drwxr-xr-x   - cgeo supergroup          0 2021-01-03 16:02 /input/ex2/tags
-rw-r--r--   1 cgeo supergroup   39744990 2021-01-03 16:02 /input/ex2/tags/tags.csv
drwxr-xr-x   - cgeo supergroup          0 2021-01-03 16:37 /input/ex3
drwxr-xr-x   - cgeo supergroup          0 2021-01-03 16:38 /input/ex3/movies
-rw-r--r--   1 cgeo supergroup    2858223 2021-01-03 16:38 /input/ex3/movies/movies.csv
drwxr-xr-x   - cgeo supergroup          0 2021-01-03 16:38 /input/ex3/ratings
-rw-r--r--   1 cgeo supergroup  759200511 2021-01-03 16:38 /input/ex3/ratings/ratings.csv
drwxr-xr-x   - cgeo supergroup          0 2021-01-03 17:09 /input/ex4
-rw-r--r--   1 cgeo supergroup    2858223 2021-01-03 17:09 /input/ex4/movies.csv
```

## Project structure
In the `src` folder there are 4 more folders named ex1-4. In each one of these there is one more README.md
file which explains what the exercise is about and how it was solved along with screenshots.
There is also a `Main.java` file. This is the main file that takes the first of the arguments
the user has to provide for each exercise. This string argument is -ex, and the number of the exercise to run.
Then using a simple switch statement it instantiates the appropriate Driver, providing
it with the same arguments it received from the console.
