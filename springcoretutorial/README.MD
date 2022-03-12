###Build the transformer agent jar###
On the right side of gradle menu, select the fatJar task to generate a fatJar for the javaagenttutorial project
The fatJar will be generated in the build/libs/ folder.


Then select the bootJar task for springcoretutorial project



run java -javaagent:springboottutorial/springcoretutorial/javaagenttutorial/build/libs//javaagenttutorial-fat-0.0.1-SNAPSHOT.jar] -jar  springcoretutorial-0.0.1-SNAPSHOT.jar 


