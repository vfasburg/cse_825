#!/bin/sh
#this line should be uncommented
xhost local:vince
export DISPLAY=:0.0
if [ -f /home/vince/.testfile ]
then
  :
else
  echo "" > /home/vince/.testfile
  sudo -u vince xmodmap -display :0 /home/vince/Documents/Xmodmap_restricted #&
  sudo -u vince xmodmap -display :0 -e "pointer = 0 0 0 0 0 0 0 0 0 0 0 0 "
  sudo -u vince java -jar /home/vince/Downloads/ValidateUSB_Hover.jar
  sudo -u vince xmodmap -display :0 -e "pointer = 1 2 3 4 5 6 7 8 9 10 11 12 "
  sudo -u vince xmodmap -display :0 /home/vince/Documents/Xmodmap_orig
  rm -f /home/vince/.testfile
fi


