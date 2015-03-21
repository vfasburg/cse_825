#!/bin/sh
#this line should be uncommented
# sudo -u vince xmodmap -display :0 /home/vince/Documents/Xmodmap_restricted &
xhost local:vince
export DISPLAY=:0.0
java -jar /home/vince/Downloads/ValidateUSB.jar

#echo "hello world" > /tmp/test.log
