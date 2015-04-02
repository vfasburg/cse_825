*******************************************************************

This is the README.txt file for the GUI for validating a USB device
Project completed by Vince Fasburg, Bonnie Reiff, and Josh Thomas

*******************************************************************

This README contains the following four sections below:
1. Instructions to import the project into Eclipse
2. Instructions to manually run the Java Application from Eclipse
3. Instructions to build the runnable JAR from the source code
4. Instruction to run the executable JAR

*******************************************************************

Instructions to import the project into Eclipse:

Prerequisites: The instructions assume the user has Eclipse installed.

1. Open Eclipse to the desired workspace. In the "File" menu, select "Import...". This should bring up a new window titled "Import".
2. Click to the left of the "General" folder to expand this section and select "Existing projects into Workspace". Click "Next".
3. Ensure that the radio button for "Select root directory:" is chosen.
     Click the "Browse..." button and navigate to the "ValidateUSB_Hover" folder. Note: this directory needs to contain a ".project" file.
4. Click Finish. The ValidateUSB_Hover project should now appear in the workspace. 

*******************************************************************

Instructions to manually run the Java Application from Eclipse:

Prerequisites: The GUI is a Java project developed in Eclipse.
These instructions assume that the ValidateUSB_Hover project already exists in Eclipse and compiles with no errors.
See the "Instructions to import the project into Eclipse" section of this document to get to this point.

1. Open Eclipse to the workspace containing the ValidateUSB_Hover project.
2. Right-click on the ValidateUSB_Hover project and selected "Run As -> Java Application".
     This should open the ValidateUSB_Hover Java Application.

*******************************************************************

Instructions to build the runnable JAR from the source code:

Prerequisites: The GUI is a Java project developed in Eclipse.
These instructions assume that the ValidateUSB_Hover project already exists in Eclipse and compiles with no errors.
See the "Instructions to import the project into Eclipse" section of this document to get to this point.

1. Right-click on ValidateUSB_Hover project and select "Export...". This should bring up a new window titled "Export".
2. Click to the left of the "Java" folder to expand this section and select "Runnable JAR file". Click "Next".
3. Ensure that "ValidateUSB_Hover - ValidateUSB_Hover" is selected in the "Launch configuration:" field.
4. Modify the export destination if desired in the "Export destination:" field. No other settings need to be changed. Click "Finish".

*******************************************************************

Instruction to run the executable JAR:

Prerequisites: These instructions assume that this installation's version of the java command is in your path.  
If it isn't, then you should either specify the complete path to the java command or update your PATH environment variable.
These instrutions also assume you have already created the runnable JAR file as described in the section "Instructions to build the runnable JAR from the source code"

1. Using a command line program, navigate to the directory in which the JAR is located.
2. Execute the command "java -jar ValidateUSB_Hover.jar". Note that the command should change accordingly if the JAR file is named differently.
3. The program should run and display the ValidateUSB_Hover Java Application.

*******************************************************************