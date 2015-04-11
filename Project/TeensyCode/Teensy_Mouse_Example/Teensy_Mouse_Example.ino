  
void setup() {
  Serial.begin(9600);
  delay(2000);
}

void loop() {
int i;
for(i = 0; i < 50; i++) {
  usb_mouse_move(-127,-127,0);
}
usb_mouse_move(30,60,0);

usb_mouse_buttons(1,0,0);
usb_mouse_buttons(0,0,0);

delay(250);
usb_keyboard_press(KEY_BACKSPACE, 0);

usb_mouse_move(120,0,0);


Keyboard.print("terminal");

usb_mouse_move(0,110,10);
delay(500);
usb_mouse_buttons(1,0,0);
usb_mouse_buttons(0,0,0);

//usb_keyboard_press(KEY_ENTER, 0);

delay(1200);

Keyboard.print("echo \"any command I want\"\n");


delay(300000);
}
