# lab01

Introduction to Java Basics, the terminal, and Github

The basics building blocks of Java are classes which hold fields and methods, including special methods called constructors. 
The concept of a Driver, something meant to test the functionality of the code via a main method. 

# Given Instructions

Lab01 - Due tonight by 11:59 pm

An introduction to terminal commands, basic java programming, and git commands.

Welcome!

You are working in a Linux lab; the operating system on these computers is the Ubuntu variant of Linux. Enter your Binghamton user ID and PODS password to log on - if you are unable to log on, consult the TA. This website also has some materials you may find helpful over the course of the semester. It is from another TA that used to help teach the course, so just keep in mind that there may be some outdated information. For instance, we will be using Java 10 instead of Java 8.


Some Directory Setup

For the beginning part of the course, we will be working from the terminal and coding in a simple text editor. Open up a terminal by clicking the black prompt icon in the bottom icon bar. Type in the command rm -rf .cache. This executes the rm command to remove the directory named .cache. Removing this directory is done to provide more memory space on your account. Next run the command mkdir -p cs140/labs which creates a labs directory within a cs140 directory. Next change to the labs directory with the command cd cs140/labs. Notice your prompt has changed to reflect the directory change. More about the shell can be found here.


Github: Setting up and cloning lab01

We will be using Github to submit your labs and assignments throughout this course. You will need a Github account, so if you don't have one already, go to Github and sign up.

Once you have signed up for an account, fill out and submit this google form 

Completing the form will be part of your grade for this lab.

Here is a link to some starting code for lab01 from github.

 

After you click on the link and accept the assignment, you'll probably notice it takes a little time to set up the repository for you. When the set up is complete, it should give you a URL.

Go to the repository that has been made for you at the URL, and hit the green Clone or download button. Be sure to clone with HTTPS, copying the link provided to you. We are about to clone the repository to your linux computer so you can begin interacting with the code. You may notice that some starter files have been provided for you.

Now, go back to the terminal. Make sure you are in the cs140/labs directory. We need to set up our git credentials. Enter then following two commands to the terminal and hit enter for each after filling in the quotes with your info:
git config --global user.name "Firstname Lastname"
git config --global user.email "email@binghamton.edu"

Next we clone the repository from GitHub by running the following git command:

git clone URL

Where URL is the URL that you copied from GitHub's green clone or download button. 

Once the cloning is complete, run the command ls, which lists all directories and files in your current directory. You should see that a new directory has been created for you lab01-GIT-USERNAME_HERE. Go ahead and cd into it.

 

💡If you get stuck along the way, please ask a TA to help you. Cloning assignments will be done for the rest of the course.💡

Congratulations! You just cloned your first assignment for the class, and are ready to code.


Onto the lab: Baby Steps

Go ahead and open up Hello.java, which has been included in your repository. Whenever you want to create a new file or open an existing one, you would open the text editor with the name of the file like so:
gedit filename.java &

Internalize this small program and how it is written. There will be a quiz on something similar in class tomorrow (Friday).

With this minimal but complete program, we now must compile and run it. You'll need to learn the two commands to compile and run Java programs. To compile, run javac -d . Hello.java. To run, execute java lab01.Hello. You should see the text "Hello, World!" in the console. A more detailed explanation of what you have just done can be found here.


Some classes

The basic building block of Java programs is classes. Classes model real-world objects where the class's variables model an object's data and the class's methods model actions available on that object.

We have provided two classes for you, Loan.java and Loanee.java

Look over Loan.java, noting the variables and methods contained in the class. Use the comments to assist your understanding.

We can accomplish more when objects interact. The Loanee class will model a person taking out a Loan.

Read the provided code in Loanee.java and then respond to the two TODOs that have to do with completing given methods. Read the comments to understand how the method should behave.
The TA will walk you through how to use constructors in Java to create an object, this is a basic skill that you will need throughout the course, so if you have questions or doubts, please ask
 

Taking the code for a spin

We've written two classes so now we want to actually use those classes to accomplish some tasks. For now, we just want to do some simple tests of the canPayLoan method you've implemented. 

We have provided a simple tester, the LoanSimulation.java file. Notice the tester is basically a main method that uses the Loan and Loanee classes we have discussed above.

Now compile and run your code with the following two commands:

javac -d . *.java
java lab01.LoanSimulation
Note the similarities between these commands and those you issued for Hello.java. More about this here


Submitting the lab to Github and myCourses

In this and future labs, we will use Github Classroom repositories. You have already forked this repository when you accepted the GitHub classroom link. That makes a copy of the repository, free for you to make changes. Then you cloned your forked repository to get a working copy onto this machine. 

Now that we have made local changes to our working copy, let's commit those changes to the repository:

⚠️ Note: These commands all presume that your current working directory is within the directory tracked by git.

git commit -a -m "first commit"
The -a says that git should add all tracked files with changes to your commit, and the -m says the next string contains the commit message.

What about untracked files? Run the following commands:

touch dummy.txt
git status
You'll notice that git tells us that information.txt is an untracked file. That means it's not being tracked by the repository. Let's fix that by adding it.

git add dummy.txt
git commit -m "Added a dummy file"
⚠️ You must add any new files you create to the repository with the git add command or they will not upload to the repo, and your code will not work.

Once we've made the commits for a given coding session, we need to add those to the repository by performing a push:

git push 
Now, let's say we don't want dummy.txt in the repository anymore. How can we remove it?

git rm dummy.txt
git commit -am "Removed a dummy file"
git push
Lastly, the next time we begin a coding session, we will need to pull to get an updated working copy.

git pull 
This will allow you to keep your code in the lab and on your own computer synchronized if you want to work outside of lab.

Lastly we are going to make our final commit. You will need to do this when your submission is ready for grading.

git commit --allow-empty -a -m "completed lab01"
git push
The --allow-empty option makes it possible to make a commit without having made any changes. This will enable you to just update the comment.

💡 You can commit as often as you like, and revert your code to any previous commit using the commit hash. The commit hash is a long number that identifies a specific version of your code. I recommending making commits often with a comment describing the state of your code. To find your most recent commit hash, use the following command:

git rev-parse HEAD 
You should get a long, strange looking number:

0a8d7e3dfca995dfd470552cde7a065f82f97bd8

To complete your submission, you must copy and paste this number into mycourses. Go to MyCourses, select CS140-A0, and go to Content-> Submissions-> Labs. Select lab01, and where it says text submission, paste your commit hash. The TAs will only grade your submission that corresponds to the hash you submitted. You can update this as often as you like until the deadline.

⚠️ You MUST submit the commit hash on mycourses before the deadline to be considered on time even if your lab is completely working before the deadline. ⚠️

That's it! We've completed our work for this lab. We will use this submission process for all subsequent labs and assignments.

💡 Useful git references:

https://guides.github.com/introduction/flow/ 
https://help.github.com 
https://git-scm.com/doc
