This repository is intended for my own personal use to support java tuition. 
It contains exercises that students can do to learn various concepts.
It is also intended to familiarise students with using git, and github's pull request and review functionality.

##Structure
* Each directory in the project is a self-contained maven project.
* Each directory has a README.md file with details of the task(s)

##For students
###Getting started
* Ensure you have Java 16 installed. 
  * Some of these excercises will introduce some java 16 features.
* Create a fork of the repository. 
  * This will create a copy of it in your github account that is linked to this
* You can then clone your fork locally, so you can work on it in your favourite IDE.
* It will be worth adding a remote for this upstream repository too so that as I add exercises you can update your fork 
  with these
  * You can do this by running `git remote add upsteam git@github.com:ewencluley/java-teaching-exercises.git`
  * Then to update your local with added upstream changes you can run `git fetch upsteam && git rebase upstream/main` 

### Completing tasks
1. You should read over the README in the project you will be working on
2. Attempt to implement the code to meet the specification of the task
3. Commit your code to a new branch of your fork. You cna do this by (when on the main branch locally) running 
   `git checkout -b the-excerise-name` then use `git add` to add any files you created or modified, and finally git
   commit to create a new commit.
4. Do a `git push --set-upstream origin the-excerise-name` to push the branch up and link your local branch to 
   the remote one in your fork.
5. Now you have the new branch with your work pushed to your fork of the repository you can open a pull request to pull 
   the branch onto the `main` branch. This will allow me to review & discuss the code you have written.

N.B. You can also use any other git client you like, if you are familiar with something other than the command line git 
client, use it.

#Plan
1. Http Requests - looking at POST and GET, request parameters and request/response bodies.
   * https://dzone.com/articles/simple-http-server-in-java
   * https://www.codeproject.com/tips/1040097/create-a-simple-web-server-in-java-http-server
2. Json Serialization/Deserialization - how to deserialize a request body to a java object and how to serialize a 
   java object to a response. There are many json serialization libraries out there but we will use Jackson for this.
3. Spring boot intro 
4. TBD
5. ...