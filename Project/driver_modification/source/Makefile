#
# Makefile for the USB input drivers
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

# EXTRA_CFLAGS are used to specify include directories
EXTRA_CFLAGS := -I/home/bonnie/Documents/linux_source/linux-3.19/include/
EXTRA_CFLAGS += -I/usr/include/
EXTRA_CFLAGS += -I/usr/include/x86_64-linux-gnu/

all:
	make -C /lib/modules/$(KVERSION)/build M=$(PWD) modules
clean:
	make -C /lib/modules/$(KVERSION)/build M=$(PWD) clean
