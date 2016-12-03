********************************************
CONFIGURATION INSTRUCTION
********************************************

All configuration handle by build script.



********************************************
BUILD & DEPLOY INSTRUCTIONS
********************************************

Build script does require root privilege to run.

Build script is located in the root folder

To start build script:
-navigate to the project folder with the command line
enter the following command:
"sudo bash init"

(you will be prompted for a password to gain root access)



Build script will do the following automatically:

1-Check for MongoDB and download it if not found
2-Check for JDK (Java Development Kit) and download if not found
3-Download appropriate Gradle version
4-Clean project
5-Regenerate project files
6-Build project
7-run unit testing (if Firefox is open, coverage page may not load)
	(Coverage index.html is located in the build/reports/jacoco/test/html)
8-Create/Update war file
9-Set MONGOURI environment variable
10-Execute created war file



After running init script, you can run test coverage anytime with the following commands
All commands assume command line terminal points to root directory of project

Run test: "sudo bash ./gradlew runTest"
build war: "sudo bash ./gradlew war"
build project: "sudo bash ./gradlew build"

None of these commands are necessary as the init script will run all of them.
These are provided as a courtesy.


**********************************************
COPYRIGHT & LICENSING
**********************************************
MIT License

Copyright (c) 2016 Jean-Rodney Larrieux, Patrick Mendus, Alex Lerma, Tony Vadakumchery.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.


***********************************************
KNOW BUGS
***********************************************
none
(does not mean software is bug free, just that we haven't tested enough)




***********************************************
CREDIT & ACKNOWLEDGEMENT
***********************************************
Alex Lerma and Google for helping me master Spring Boot

My wife Monika for putting up with me the last 2 weeks of hard work towards this project

My classmate Patrick Mendus for contacting me at odd hours to talk about thi project and
shed light on obscure concepts, And for doing an awesome job on the front end

My Teammamte Tony for helping us keep track of the details
