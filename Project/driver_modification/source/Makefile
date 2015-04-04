#
# Makefile for the USB Human Input Device (HID) drivers
# File originally found at: https://www.kernel.org/
#
# Modified by Vince Fasburg, Bonnie Reiff, and Josh Thomas
# for Michigan State University, CSE 825
#

# Set up the KVERSION variable for the make targets
KVERSION= $(shell uname -r)

# Multipart objects.
usbhid-y	:= hid-core.o hid-quirks.o

# Optional parts of multipart objects.
ifeq ($(CONFIG_USB_HIDDEV),y)
	usbhid-y	+= hiddev.o
endif
ifeq ($(CONFIG_HID_PID),y)
	usbhid-y	+= hid-pidff.o
endif

obj-$(CONFIG_USB_HID)		+= usbhid.o
obj-$(CONFIG_USB_KBD)		+= usbkbd.o
obj-$(CONFIG_USB_MOUSE)		+= usbmouse.o

all:
	make -C /lib/modules/$(KVERSION)/build M=$(PWD) modules
clean:
	make -C /lib/modules/$(KVERSION)/build M=$(PWD) clean
