#!/bin/sh

# Created by Vince Fasburg, Bonnie Reiff, and Josh Thomas
# for Michigan State University, CSE 825

# Script setup code
xhost local:bonnie
export DISPLAY=:0.0

# Look for the hidden testfile that indicates whether the keyboard and mouse are currently restricted
if [ -f /usr/local/bin/.testfile ]
then
  :
else
  # Create the testfile indicator
  echo "" > /usr/local/bin/.testfile
  # Restrict the keyboard to only non-special keys and prevent the mouse from clicking
  sudo -u bonnie xmodmap -display :0 /usr/local/bin/Xmodmap_restricted
  sudo -u bonnie xmodmap -display :0 -e "pointer = 0 0 0 0 0 0 0 0 0 0 0 0 "
  # Run the human validation captcha
  sudo -u bonnie java -jar /usr/local/bin/ValidateUSB_Hover.jar
  # Allow the full range of keyboard keys and allow the mouse to click 
  sudo -u bonnie xmodmap -display :0 -e "pointer = 1 2 3 4 5 6 7 8 9 10 11 12 "
  sudo -u bonnie xmodmap -display :0 /usr/local/bin/Xmodmap_orig
  # Remove the testfile indicator
  rm -f /usr/local/bin/.testfile
fi


