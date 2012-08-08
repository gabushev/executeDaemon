#Description
This package allow to run php-scripts (only php testing yet) in background mode.
For start this application is need:
- edit xml file edConfig.xml in $APP_DIRECTORY/cfg/
- manually create directory /var/log/executeDaemon and set permissions for write to this
- run java-application as "java -jar executeDaemon.jar"

A package was tested with^
  - PHP 5.3.6 with Suhosin-Patch
  - Java(TM) SE Runtime Environment (build 1.7.0_03-b04)
  - Java HotSpot(TM) 64-Bit Server VM (build 22.1-b02, mixed mode)