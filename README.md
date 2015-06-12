# arcusysdevday2015

Please add an subdirectory per team. Submit your team's sourcecode there.

NOTE! The actual problem will be presented right at the devday.

# THE TASK

* The task is simple RaSa -algorithm (modified from famous Joensuu University professors, Raimo Rask and Jorma Sajaniemi, C complexity calculator).
* The purpose of the algorithm is to estimate the complexness of Java source code files.
* The complessness is calculated in a following way: 
** Calculate each statement ending with ";". Each block { }, increments the RaSa sum by bolck depth * number of statements inside that block. Thus { ; } is of depth 2 with one statement.
** Level 1 is statements outside blocks, like java import -statements.
** Levels 2...N is statements inside blocks


# THE WORKING PROGRAM

    $ rasacalculator a.java b.java c.java d*.java
    a.java: lines 10, RaSa 100
    b.java: lines 20, RaSa 200
    c.java: lines 30, RaSa 70
    da.java: lines 5, RaSa 200
    total: lines 65, RaSa 570
    $

# THE EXAMPLES


a) Minimal a

    --code starts here--
    void test()
    { ; }
    --code ends here--

* The code has one block, containing 1 statement. Thus the RaSa sum is 2*1

b) Minimal b

    --code starts here--
    void test()
    {
       System.out.println("Hi");
    }
    --code ends here--

* One block, containing 1 statement. Thus the RaSa sum is 2*1

c) Complex a

    --code starts here--
    void test()
    { int a = 0;		
      int b = 1;
      if (a > b) {
	System.out.println(a);
      } else {
	System.out.println(a);
      }
      System.out.println("Bye");
    }
    --code ends here--
* On level 2 we have 2 statements = 4
* On level 3 we have 1 statement  = 3
* On level 3 we have 1 statement  = 3
* On level 2 we have 1 statements = 2
* RaSa sum is: 12


    

