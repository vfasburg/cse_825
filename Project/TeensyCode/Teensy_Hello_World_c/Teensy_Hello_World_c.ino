/* Simple USB Keyboard Example
   Teensy becomes a USB keyboard and types characters

   You must select Keyboard from the "Tools > USB Type" menu

   This example code is in the public domain.
*/

int count = 0;

void setup() {
  Serial.begin(9600);
  delay(2000);
}

void loop() {
  // press and hold CTRL
  Keyboard.set_modifier(MODIFIERKEY_CTRL);
  Keyboard.send_now();
  
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
  
  delay(1000);
  
  // Your computer will receive these characters from a USB keyboard.
  Keyboard.println("echo All Files Deleted "); 

  delay(30000);
}
