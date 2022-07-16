## Sekeleton automation framework for commercial project
### This is a skeleton project for learning building Selenium 3 + TestNG automation framework from scratch.
````shell
Important Note: 
+ Language binding is java. Running stably with java version 11 (jdk 11.0.15 or 11.0.13)
+ This project does not using latest selenium version. Using selenium version is 3.141.59 (7/3/2022: latest stable version is 4.0.3)
+ Public domain using for test: https://demo.nopcommerce.com/ and https://admin-demo.nopcommerce.com/admin/
+ Using maven build tools to manage dependencies and third-party libraries
+ Generate reports with extent report version 5
+ Using TestNG as test automation framework (annotation, testRunner...)
`````

### Features
+  Support demo running through local, selenium grid and cloud testing with proper configuration
+  Support cross-browser testing: chrome, firefox, headless browser, opera, edge, safari....
+  Auto retry when testcases fail, console logging, generating report with attached screenshot and so on...

### Install
**Running by maven command line (recommend):**
```sh
mvn clean test 
```
**Running with batch file**
Click and runbatch file with server name

#### Local running:
Clone project and run through maven command line (or running with TestNG plugins).
**Support server name** is: dev, testing, staging, product. Each server name is corresponding to each below domain:

### Cloud running:
Only support running on https://www.browserstack.com. You can configure other platform (ex: Saucelabs, CrossBrowserTesting...) by setting credentials and url in GlobalConstants class. 
There are three methods available to create cloud credentials. Uncomment lines in GlobalConstants class to adapt to requirements.

+ Method 1: 
Creating in test/resources "cloud_credentials.properties" with content as below:
```sh
cloudUsername=your_cloud_username
cloudPassword=your_cloud_password
```
+ Method 2: 
Configure .env file

+ Method 3: 
Configure setCloudCredentials.bat file and running before opening IDE.

### Grid Running:
Support both real devices or docker grid selenium (recommend). Install docker desktop and running below command:
```sh
cd project_location
docker compose up -d 
```
### To run pipeline in jenkins CI/CD
```sh
Configure svm (github, gitlab...) credentials in jenkins system and replace git repo url in jenkinsFile.groovy
```


