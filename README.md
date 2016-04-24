# About
Just a simple project that dispatch work to a pool of workers by using a round robin algorithm.
The project uses Akka's router to dispatch work to 5 workers. The work is simulated by using a Thread sleep of
a random value between 1000-5000 ms.
