package com.ge.swing.usb;

import java.awt.Insets;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.border.EmptyBorder;
import javax.swing.Timer;

import java.util.*;
import java.awt.Font;

public class ValidateUSBHover extends JDialog
{
	private boolean capitalLetter = false;
	private boolean stayCapitalLetter = false;
	private String strCaptcha;
	
	private final JPanel contentPanel;
	private JTextField txtInput;
	private JLabel lblCaptcha;
	private JButton btnNewCaptcha;
	private JButton btnValidate;
	private JLabel lblErrorMessage;
	private JLabel lblInputMessage;
	
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	private JButton btn0;
	
	private JButton btnQ;
	private JButton btnW;
	private JButton btnE;
	private JButton btnR;
	private JButton btnT;
	private JButton btnY;
	private JButton btnU;
	private JButton btnI;
	private JButton btnO;
	private JButton btnP;
	
	private JButton btnA;
	private JButton btnS;
	private JButton btnD;
	private JButton btnF;
	private JButton btnG;
	private JButton btnH;
	private JButton btnJ;
	private JButton btnK;
	private JButton btnL;
	
	private JButton btnZ;
	private JButton btnX;
	private JButton btnC;
	private JButton btnV;
	private JButton btnB;
	private JButton btnN;
	private JButton btnM;
	
	private JButton btnBackspace;
	private JButton btnShift;
	private JButton btnCapsLock;
	
	int buttonDelay = 1000;
	private Timer timer1btn = new Timer(buttonDelay, new one_ButtonActionListener());
	private Timer timer2btn = new Timer(buttonDelay, new two_ButtonActionListener());
	private Timer timer3btn = new Timer(buttonDelay, new three_ButtonActionListener());
	private Timer timer4btn = new Timer(buttonDelay, new four_ButtonActionListener());
	private Timer timer5btn = new Timer(buttonDelay, new five_ButtonActionListener());
	private Timer timer6btn = new Timer(buttonDelay, new six_ButtonActionListener());
	private Timer timer7btn = new Timer(buttonDelay, new seven_ButtonActionListener());
	private Timer timer8btn = new Timer(buttonDelay, new eight_ButtonActionListener());
	private Timer timer9btn = new Timer(buttonDelay, new nine_ButtonActionListener());
	private Timer timer0btn = new Timer(buttonDelay, new zero_ButtonActionListener());
	
	private Timer timerQbtn = new Timer(buttonDelay, new Q_ButtonActionListener());
	private Timer timerWbtn = new Timer(buttonDelay, new W_ButtonActionListener());
	private Timer timerEbtn = new Timer(buttonDelay, new E_ButtonActionListener());
	private Timer timerRbtn = new Timer(buttonDelay, new R_ButtonActionListener());
	private Timer timerTbtn = new Timer(buttonDelay, new T_ButtonActionListener());
	private Timer timerYbtn = new Timer(buttonDelay, new Y_ButtonActionListener());
	private Timer timerUbtn = new Timer(buttonDelay, new U_ButtonActionListener());
	private Timer timerIbtn = new Timer(buttonDelay, new I_ButtonActionListener());
	private Timer timerObtn = new Timer(buttonDelay, new O_ButtonActionListener());
	private Timer timerPbtn = new Timer(buttonDelay, new P_ButtonActionListener());
	private Timer timerAbtn = new Timer(buttonDelay, new A_ButtonActionListener());
	private Timer timerSbtn = new Timer(buttonDelay, new S_ButtonActionListener());
	private Timer timerDbtn = new Timer(buttonDelay, new D_ButtonActionListener());
	private Timer timerFbtn = new Timer(buttonDelay, new F_ButtonActionListener());
	private Timer timerGbtn = new Timer(buttonDelay, new G_ButtonActionListener());
	private Timer timerHbtn = new Timer(buttonDelay, new H_ButtonActionListener());
	private Timer timerJbtn = new Timer(buttonDelay, new J_ButtonActionListener());
	private Timer timerKbtn = new Timer(buttonDelay, new K_ButtonActionListener());
	private Timer timerLbtn = new Timer(buttonDelay, new L_ButtonActionListener());
	private Timer timerZbtn = new Timer(buttonDelay, new Z_ButtonActionListener());
	private Timer timerXbtn = new Timer(buttonDelay, new X_ButtonActionListener());
	private Timer timerCbtn = new Timer(buttonDelay, new C_ButtonActionListener());
	private Timer timerVbtn = new Timer(buttonDelay, new V_ButtonActionListener());
	private Timer timerBbtn = new Timer(buttonDelay, new B_ButtonActionListener());
	private Timer timerNbtn = new Timer(buttonDelay, new N_ButtonActionListener());
	private Timer timerMbtn = new Timer(buttonDelay, new M_ButtonActionListener());
	
	private Timer timerShiftbtn = new Timer(buttonDelay, new Shift_ButtonActionListener());	
	private Timer timerCapsbtn = new Timer(buttonDelay, new Caps_ButtonActionListener());	
	private Timer timerBackspacebtn = new Timer(buttonDelay, new Backspace_ButtonActionListener());
	
	private Timer timerValidatebtn = new Timer(buttonDelay, new Validate_ButtonActionListener());	
	private Timer timerNewCaptchabtn = new Timer(buttonDelay, new NewCaptcha_ButtonActionListener());	

	public static void main(String[] args)
	{
		try
		{			
			final ValidateUSBHover dialog = new ValidateUSBHover();
			//dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
			dialog.setTitle("USB Keyboard and Mouse Validation");
			dialog.setAlwaysOnTop(true);
			dialog.setVisible(true);
			
			// get random number for location of dialog
			Random random = new Random();
			int x = ( Math.abs(random.nextInt()) % 600 ) + 100; // number in range 100-700
			int y = ( Math.abs(random.nextInt()) % 200 ) + 100; // number in range 100-300
			dialog.setLocation(x,y);
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public class Captcha
	{
		Color foreColor = Color.blue;
		Color backColor = Color.orange;
		Font fontType;
		
		public String generateCaptcha()
		{
			Random random = new Random();
			int length = 6;
			StringBuffer captchaStringBuffer = new StringBuffer();
			for (int i = 0; i < length; i++)
			{
				int captchaNumber = Math.abs(random.nextInt()) % 60;
				int charNumber = 0;
				if (captchaNumber < 26)
				{
					charNumber = 65 + captchaNumber;
				}
				else if (captchaNumber < 52)
				{
					charNumber = 97 + (captchaNumber - 26);
				}
				else
				{
					charNumber = 48 + (captchaNumber - 52);
				}
				
				captchaStringBuffer.append((char)charNumber);
			}
			
			return captchaStringBuffer.toString();
		}
		
		public Color generateForeColor()
		{
			Random random = new Random();
			int captchaNumber = Math.abs(random.nextInt()) % 7;
			
			// pick a color
			switch ( captchaNumber )
			{
				case 0:
					foreColor =  Color.blue;
					break;
				case 1:
					foreColor =  Color.green;
					break;
				case 2:
					foreColor =  Color.red;
					break;
				case 3:
					foreColor =  Color.black;
					break;
				case 4:
					foreColor =  Color.orange;
					break;
				case 5:
					foreColor =  Color.magenta;
					break;
				case 6:
					
				default:
					foreColor =  Color.cyan;
					break;
			}
			
			return foreColor;
		}
		
		public Color generateBackColor()
		{
			Random random = new Random();
			int captchaNumber = Math.abs(random.nextInt()) % 7;
			
			// pick a color
			switch ( captchaNumber )
			{
				case 0:
					backColor =  Color.blue;
					if (foreColor == backColor)
					{
						backColor =  Color.green;
					}
					break;
				case 1:
					backColor =  Color.green;
					if (foreColor == backColor || foreColor == Color.cyan || foreColor == Color.orange)
					{
						backColor =  Color.red;
					}
					break;
				case 2:
					backColor =  Color.red;
					if (foreColor == backColor || foreColor == Color.magenta)
					{
						backColor =  Color.black;
					}
					break;
				case 3:
					backColor =  Color.black;
					if (foreColor == backColor)
					{
						backColor =  Color.orange;
					}
					break;
				case 4:
					backColor =  Color.orange;
					if (foreColor == backColor)
					{
						backColor =  Color.magenta;
					}
					break;
				case 5:
					backColor =  Color.magenta;
					if (foreColor == backColor || foreColor == Color.red)
					{
						backColor =  Color.cyan;
					}
					break;
				case 6:

				default:
					backColor =  Color.cyan;
					if (foreColor == backColor || foreColor == Color.green)
					{
						backColor =  Color.blue;
					}
					break;
			}
			
			return backColor;
		}
		
		public Font generateFont()
		{
			Random random = new Random();
			int captchaNumber = Math.abs(random.nextInt()) % 4;
			
			// pick a color
			switch ( captchaNumber )
			{
				case 0:
					fontType = new Font("Vivaldi", Font.PLAIN, 35);
					//break;
				case 1:
					fontType = new Font("Parchment", Font.PLAIN, 35);
					//break;
				case 2:
					fontType = new Font("Edwardian Script ITC", Font.PLAIN, 35);
					//break;				
				case 3:
					
				default:
					fontType = new Font("Vladimir Script", Font.PLAIN, 40);
					break;
			}
			
			return fontType;
		}
	}
	
	public ValidateUSBHover()
	{		
		// JDialog
		setBounds(100, 100, 400, 400);
		
		// JPanel
		contentPanel = new JPanel();
		contentPanel.setBounds(100, 100, 400, 400);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		// Error message
		lblErrorMessage = new JLabel("");
		lblErrorMessage.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorMessage.setBounds(25, 175, 90, 20);
		lblErrorMessage.setForeground(Color.red);
		contentPanel.add(lblErrorMessage);
		
		// Message
		lblInputMessage = new JLabel("Please enter the above text to validate the USB device");
		lblInputMessage.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblInputMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblInputMessage.setBounds(50, 150, 300, 20);	
		contentPanel.add(lblInputMessage);
		
		// Input box
		txtInput = new JTextField();
		txtInput.setBounds(125, 175, 150, 20);
		contentPanel.add(txtInput);
		
		txtInput.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String userInput = txtInput.getText();
				
				if ( userInput.equals(strCaptcha) )
				{
					lblCaptcha.setText("Validated");
					lblCaptcha.setBackground(Color.green);
					lblCaptcha.setForeground(Color.black);
					lblErrorMessage.setText("");
				}
				else
				{
					lblErrorMessage.setText("Invalid, try again");
					Captcha newCaptcha = new Captcha();
					strCaptcha = newCaptcha.generateCaptcha();
					lblCaptcha.setText(strCaptcha);
					lblCaptcha.setForeground(newCaptcha.generateForeColor());
					lblCaptcha.setBackground(newCaptcha.generateBackColor());
					lblCaptcha.setFont(newCaptcha.generateFont());
					txtInput.setText("");
				}
			}
		});

		// Validate button
		btnValidate = new JButton("Validate");
		btnValidate.setMargin(new Insets(1, 1, 1, 1));
		btnValidate.setHorizontalAlignment(SwingConstants.CENTER);
		btnValidate.setBounds(275, 175, 75, 20);
		contentPanel.add(btnValidate);
		
		btnValidate.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent evt)
			{
				timerValidatebtn.start();				
			}
			public void mouseExited(MouseEvent evt)
			{
				timerValidatebtn.stop();
			}
		});
		
		// ******************** Captcha ******************** //
		
		Captcha captcha = new Captcha();
		strCaptcha = captcha.generateCaptcha();
		lblCaptcha = new JLabel(strCaptcha);
		lblCaptcha.setOpaque(true);
		lblCaptcha.setBounds(100, 60, 200, 70);
		lblCaptcha.setHorizontalAlignment(SwingConstants.CENTER);
		lblCaptcha.setForeground(captcha.generateForeColor());
		lblCaptcha.setBackground(captcha.generateBackColor());
		lblCaptcha.setFont(captcha.generateFont());
		contentPanel.add(lblCaptcha);
		
		btnNewCaptcha = new JButton("Get New Captcha");
		btnNewCaptcha.setMargin(new Insets(1, 1, 1, 1));
		btnNewCaptcha.setHorizontalAlignment(SwingConstants.CENTER);
		btnNewCaptcha.setBounds(125, 20, 150, 20);
		contentPanel.add(btnNewCaptcha);
		
		btnNewCaptcha.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent evt)
			{
				timerNewCaptchabtn.start();				
			}
			public void mouseExited(MouseEvent evt)
			{
				timerNewCaptchabtn.stop();
			}
		});
		
		// ******************* Keyboard ******************* //
		
		int numRowY = 225;
		int numRowX = 50;
		int keysRow1Y = numRowY+25;
		int keysRow1X = numRowX+10;
		int keysRow2Y = keysRow1Y+25;
		int keysRow2X = keysRow1X+10;
		int keysRow3Y = keysRow2Y+25;
		int keysRow3X = keysRow2X+10;
		
		// number row
		btn1 = new JButton("1");
		btn1.setMargin(new Insets(1, 1, 1, 1));
		btn1.setHorizontalAlignment(SwingConstants.CENTER);
		btn1.setBounds(numRowX, numRowY, 20, 20);
		contentPanel.add(btn1);
		
		btn1.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent evt)
			{
				timer1btn.start();				
			}
			public void mouseExited(MouseEvent evt)
			{
				timer1btn.stop();
			}
		});
		
		btn2 = new JButton("2");
		btn2.setMargin(new Insets(1, 1, 1, 1));
		btn2.setHorizontalAlignment(SwingConstants.CENTER);
		btn2.setBounds(numRowX+30, numRowY, 20, 20);
		contentPanel.add(btn2);
		
		btn2.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent evt)
			{
				timer2btn.start();				
			}
			public void mouseExited(MouseEvent evt)
			{
				timer2btn.stop();
			}
		});
		
		btn3 = new JButton("3");
		btn3.setMargin(new Insets(1, 1, 1, 1));
		btn3.setHorizontalAlignment(SwingConstants.CENTER);
		btn3.setBounds(numRowX+60, numRowY, 20, 20);
		contentPanel.add(btn3);
		
		btn3.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent evt)
			{
				timer3btn.start();				
			}
			public void mouseExited(MouseEvent evt)
			{
				timer3btn.stop();
			}
		});
		
		btn4 = new JButton("4");
		btn4.setMargin(new Insets(1, 1, 1, 1));
		btn4.setHorizontalAlignment(SwingConstants.CENTER);
		btn4.setBounds(numRowX+90, numRowY, 20, 20);
		contentPanel.add(btn4);
		
		btn4.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent evt)
			{
				timer4btn.start();				
			}
			public void mouseExited(MouseEvent evt)
			{
				timer4btn.stop();
			}
		});
		
		btn5 = new JButton("5");
		btn5.setMargin(new Insets(1, 1, 1, 1));
		btn5.setHorizontalAlignment(SwingConstants.CENTER);
		btn5.setBounds(numRowX+120, numRowY, 20, 20);
		contentPanel.add(btn5);
		
		btn5.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent evt)
			{
				timer5btn.start();				
			}
			public void mouseExited(MouseEvent evt)
			{
				timer5btn.stop();
			}
		});
		
		btn6 = new JButton("6");
		btn6.setMargin(new Insets(1, 1, 1, 1));
		btn6.setHorizontalAlignment(SwingConstants.CENTER);
		btn6.setBounds(numRowX+150, numRowY, 20, 20);
		contentPanel.add(btn6);
		
		btn6.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent evt)
			{
				timer6btn.start();				
			}
			public void mouseExited(MouseEvent evt)
			{
				timer6btn.stop();
			}
		});
		
		btn7 = new JButton("7");
		btn7.setMargin(new Insets(1, 1, 1, 1));
		btn7.setHorizontalAlignment(SwingConstants.CENTER);
		btn7.setBounds(numRowX+180, numRowY, 20, 20);
		contentPanel.add(btn7);
		
		btn7.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent evt)
			{
				timer7btn.start();				
			}
			public void mouseExited(MouseEvent evt)
			{
				timer7btn.stop();
			}
		});
		btn8 = new JButton("8");
		btn8.setMargin(new Insets(1, 1, 1, 1));
		btn8.setHorizontalAlignment(SwingConstants.CENTER);
		btn8.setBounds(numRowX+210, numRowY, 20, 20);
		contentPanel.add(btn8);
		
		btn8.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent evt)
			{
				timer8btn.start();				
			}
			public void mouseExited(MouseEvent evt)
			{
				timer8btn.stop();
			}
		});
		
		btn9 = new JButton("9");
		btn9.setMargin(new Insets(1, 1, 1, 1));
		btn9.setHorizontalAlignment(SwingConstants.CENTER);
		btn9.setBounds(numRowX+240, numRowY, 20, 20);
		contentPanel.add(btn9);
		
		btn9.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent evt)
			{
				timer9btn.start();				
			}
			public void mouseExited(MouseEvent evt)
			{
				timer9btn.stop();
			}
		});
		
		btn0 = new JButton("0");
		btn0.setMargin(new Insets(1, 1, 1, 1));
		btn0.setHorizontalAlignment(SwingConstants.CENTER);
		btn0.setBounds(numRowX+270, numRowY, 20, 20);
		contentPanel.add(btn0);
		
		btn0.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent evt)
			{
				timer0btn.start();				
			}
			public void mouseExited(MouseEvent evt)
			{
				timer0btn.stop();
			}
		});
		
		// row 1
		btnQ = new JButton("q");
		btnQ.setBounds(keysRow1X, keysRow1Y, 20, 20);
		btnQ.setMargin(new Insets(1,1,1,1));
		btnQ.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(btnQ);
		
		btnQ.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent evt)
			{
				timerQbtn.start();				
			}
			public void mouseExited(MouseEvent evt)
			{
				timerQbtn.stop();
			}
		});
		
		btnW = new JButton("w");
		btnW.setMargin(new Insets(1, 1, 1, 1));
		btnW.setHorizontalAlignment(SwingConstants.CENTER);
		btnW.setBounds(keysRow1X+30, keysRow1Y, 20, 20);
		contentPanel.add(btnW);
		
		btnW.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent evt)
			{
				timerWbtn.start();				
			}
			public void mouseExited(MouseEvent evt)
			{
				timerWbtn.stop();
			}
		});
		
		btnE = new JButton("e");
		btnE.setMargin(new Insets(1, 1, 1, 1));
		btnE.setHorizontalAlignment(SwingConstants.CENTER);
		btnE.setBounds(keysRow1X+60, keysRow1Y, 20, 20);
		contentPanel.add(btnE);
		
		btnE.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent evt)
			{
				timerEbtn.start();				
			}
			public void mouseExited(MouseEvent evt)
			{
				timerEbtn.stop();
			}
		});
		
		btnR = new JButton("r");
		btnR.setMargin(new Insets(1, 1, 1, 1));
		btnR.setHorizontalAlignment(SwingConstants.CENTER);
		btnR.setBounds(keysRow1X+90, keysRow1Y, 20, 20);
		contentPanel.add(btnR);
		
		btnR.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent evt)
			{
				timerRbtn.start();				
			}
			public void mouseExited(MouseEvent evt)
			{
				timerRbtn.stop();
			}
		});
		
		btnT = new JButton("t");
		btnT.setMargin(new Insets(1, 1, 1, 1));
		btnT.setHorizontalAlignment(SwingConstants.CENTER);
		btnT.setBounds(keysRow1X+120, keysRow1Y, 20, 20);
		contentPanel.add(btnT);
		
		btnT.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent evt)
			{
				timerTbtn.start();				
			}
			public void mouseExited(MouseEvent evt)
			{
				timerTbtn.stop();
			}
		});
		
		btnY = new JButton("y");
		btnY.setMargin(new Insets(1, 1, 1, 1));
		btnY.setHorizontalAlignment(SwingConstants.CENTER);
		btnY.setBounds(keysRow1X+150, keysRow1Y, 20, 20);
		contentPanel.add(btnY);
		
		btnY.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent evt)
			{
				timerYbtn.start();				
			}
			public void mouseExited(MouseEvent evt)
			{
				timerYbtn.stop();
			}
		});
		
		btnU = new JButton("u");
		btnU.setMargin(new Insets(1, 1, 1, 1));
		btnU.setHorizontalAlignment(SwingConstants.CENTER);
		btnU.setBounds(keysRow1X+180, keysRow1Y, 20, 20);
		contentPanel.add(btnU);
		
		btnU.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent evt)
			{
				timerUbtn.start();				
			}
			public void mouseExited(MouseEvent evt)
			{
				timerUbtn.stop();
			}
		});
		
		btnI = new JButton("i");
		btnI.setMargin(new Insets(1, 1, 1, 1));
		btnI.setHorizontalAlignment(SwingConstants.CENTER);
		btnI.setBounds(keysRow1X+210, keysRow1Y, 20, 20);
		contentPanel.add(btnI);
		
		btnI.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent evt)
			{
				timerIbtn.start();				
			}
			public void mouseExited(MouseEvent evt)
			{
				timerIbtn.stop();
			}
		});
		
		btnO = new JButton("o");
		btnO.setMargin(new Insets(1, 1, 1, 1));
		btnO.setHorizontalAlignment(SwingConstants.CENTER);
		btnO.setBounds(keysRow1X+240, keysRow1Y, 20, 20);
		contentPanel.add(btnO);
		
		btnO.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent evt)
			{
				timerObtn.start();				
			}
			public void mouseExited(MouseEvent evt)
			{
				timerObtn.stop();
			}
		});
		
		btnP = new JButton("p");
		btnP.setMargin(new Insets(1, 1, 1, 1));
		btnP.setHorizontalAlignment(SwingConstants.CENTER);
		btnP.setBounds(keysRow1X+270, keysRow1Y, 20, 20);
		contentPanel.add(btnP);
		
		btnP.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent evt)
			{
				timerPbtn.start();				
			}
			public void mouseExited(MouseEvent evt)
			{
				timerPbtn.stop();
			}
		});
		
		// row 2
		btnA = new JButton("a");
		btnA.setMargin(new Insets(1, 1, 1, 1));
		btnA.setHorizontalAlignment(SwingConstants.CENTER);
		btnA.setBounds(keysRow2X, keysRow2Y, 20, 20);
		contentPanel.add(btnA);
		
		btnA.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent evt)
			{
				timerAbtn.start();				
			}
			public void mouseExited(MouseEvent evt)
			{
				timerAbtn.stop();
			}
		});
		
		btnS = new JButton("s");
		btnS.setMargin(new Insets(1, 1, 1, 1));
		btnS.setHorizontalAlignment(SwingConstants.CENTER);
		btnS.setBounds(keysRow2X+30, keysRow2Y, 20, 20);
		contentPanel.add(btnS);
		
		btnS.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent evt)
			{
				timerSbtn.start();				
			}
			public void mouseExited(MouseEvent evt)
			{
				timerSbtn.stop();
			}
		});
		
		btnD = new JButton("d");
		btnD.setMargin(new Insets(1, 1, 1, 1));
		btnD.setHorizontalAlignment(SwingConstants.CENTER);
		btnD.setBounds(keysRow2X+60, keysRow2Y, 20, 20);
		contentPanel.add(btnD);
		
		btnD.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent evt)
			{
				timerDbtn.start();				
			}
			public void mouseExited(MouseEvent evt)
			{
				timerDbtn.stop();
			}
		});
		
		btnF = new JButton("f");
		btnF.setMargin(new Insets(1, 1, 1, 1));
		btnF.setHorizontalAlignment(SwingConstants.CENTER);
		btnF.setBounds(keysRow2X+90, keysRow2Y, 20, 20);
		contentPanel.add(btnF);
		
		btnF.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent evt)
			{
				timerFbtn.start();				
			}
			public void mouseExited(MouseEvent evt)
			{
				timerFbtn.stop();
			}
		});
		
		btnG = new JButton("g");
		btnG.setMargin(new Insets(1, 1, 1, 1));
		btnG.setHorizontalAlignment(SwingConstants.CENTER);
		btnG.setBounds(keysRow2X+120, keysRow2Y, 20, 20);
		contentPanel.add(btnG);
		
		btnG.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent evt)
			{
				timerGbtn.start();				
			}
			public void mouseExited(MouseEvent evt)
			{
				timerGbtn.stop();
			}
		});
		
		btnH = new JButton("h");
		btnH.setMargin(new Insets(1, 1, 1, 1));
		btnH.setHorizontalAlignment(SwingConstants.CENTER);
		btnH.setBounds(keysRow2X+150, keysRow2Y, 20, 20);
		contentPanel.add(btnH);
		
		btnH.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent evt)
			{
				timerHbtn.start();				
			}
			public void mouseExited(MouseEvent evt)
			{
				timerHbtn.stop();
			}
		});
		
		btnJ = new JButton("j");
		btnJ.setMargin(new Insets(1, 1, 1, 1));
		btnJ.setHorizontalAlignment(SwingConstants.CENTER);
		btnJ.setBounds(keysRow2X+180, keysRow2Y, 20, 20);
		contentPanel.add(btnJ);
		
		btnJ.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent evt)
			{
				timerJbtn.start();				
			}
			public void mouseExited(MouseEvent evt)
			{
				timerJbtn.stop();
			}
		});
		
		btnK = new JButton("k");
		btnK.setMargin(new Insets(1, 1, 1, 1));
		btnK.setHorizontalAlignment(SwingConstants.CENTER);
		btnK.setBounds(keysRow2X+210, keysRow2Y, 20, 20);
		contentPanel.add(btnK);
		
		btnK.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent evt)
			{
				timerKbtn.start();				
			}
			public void mouseExited(MouseEvent evt)
			{
				timerKbtn.stop();
			}
		});
		
		btnL = new JButton("l");
		btnL.setMargin(new Insets(1, 1, 1, 1));
		btnL.setHorizontalAlignment(SwingConstants.CENTER);
		btnL.setBounds(keysRow2X+240, keysRow2Y, 20, 20);
		contentPanel.add(btnL);
		
		btnL.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent evt)
			{
				timerLbtn.start();				
			}
			public void mouseExited(MouseEvent evt)
			{
				timerLbtn.stop();
			}
		});
		
		// row 3
		btnZ = new JButton("z");
		btnZ.setMargin(new Insets(1, 1, 1, 1));
		btnZ.setHorizontalAlignment(SwingConstants.CENTER);
		btnZ.setBounds(keysRow3X, keysRow3Y, 20, 20);
		contentPanel.add(btnZ);
		
		btnZ.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent evt)
			{
				timerZbtn.start();				
			}
			public void mouseExited(MouseEvent evt)
			{
				timerZbtn.stop();
			}
		});
		
		btnX = new JButton("x");
		btnX.setMargin(new Insets(1, 1, 1, 1));
		btnX.setHorizontalAlignment(SwingConstants.CENTER);
		btnX.setBounds(keysRow3X+30, keysRow3Y, 20, 20);
		contentPanel.add(btnX);
		
		btnX.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent evt)
			{
				timerXbtn.start();				
			}
			public void mouseExited(MouseEvent evt)
			{
				timerXbtn.stop();
			}
		});
		
		btnC = new JButton("c");
		btnC.setMargin(new Insets(1, 1, 1, 1));
		btnC.setHorizontalAlignment(SwingConstants.CENTER);
		btnC.setBounds(keysRow3X+60, keysRow3Y, 20, 20);
		contentPanel.add(btnC);
		
		btnC.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent evt)
			{
				timerCbtn.start();				
			}
			public void mouseExited(MouseEvent evt)
			{
				timerCbtn.stop();
			}
		});
		
		btnV = new JButton("v");
		btnV.setMargin(new Insets(1, 1, 1, 1));
		btnV.setHorizontalAlignment(SwingConstants.CENTER);
		btnV.setBounds(keysRow3X+90, keysRow3Y, 20, 20);
		contentPanel.add(btnV);
		
		btnV.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent evt)
			{
				timerVbtn.start();				
			}
			public void mouseExited(MouseEvent evt)
			{
				timerVbtn.stop();
			}
		});
		
		btnB = new JButton("b");
		btnB.setMargin(new Insets(1, 1, 1, 1));
		btnB.setHorizontalAlignment(SwingConstants.CENTER);
		btnB.setBounds(keysRow3X+120, keysRow3Y, 20, 20);
		contentPanel.add(btnB);
		
		btnB.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent evt)
			{
				timerBbtn.start();				
			}
			public void mouseExited(MouseEvent evt)
			{
				timerBbtn.stop();
			}
		});
		
		btnN = new JButton("n");
		btnN.setMargin(new Insets(1, 1, 1, 1));
		btnN.setHorizontalAlignment(SwingConstants.CENTER);
		btnN.setBounds(keysRow3X+150, keysRow3Y, 20, 20);
		contentPanel.add(btnN);
		
		btnN.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent evt)
			{
				timerNbtn.start();				
			}
			public void mouseExited(MouseEvent evt)
			{
				timerNbtn.stop();
			}
		});
		
		btnM = new JButton("m");
		btnM.setMargin(new Insets(1, 1, 1, 1));
		btnM.setHorizontalAlignment(SwingConstants.CENTER);
		btnM.setBounds(keysRow3X+180, keysRow3Y, 20, 20);
		contentPanel.add(btnM);
		
		btnM.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent evt)
			{
				timerMbtn.start();				
			}
			public void mouseExited(MouseEvent evt)
			{
				timerMbtn.stop();
			}
		});		
		
		btnBackspace = new JButton("<===");
		btnBackspace.setMargin(new Insets(1, 1, 1, 1));
		btnBackspace.setHorizontalAlignment(SwingConstants.CENTER);
		btnBackspace.setBounds(keysRow3X+210, keysRow3Y, 60, 20);
		contentPanel.add(btnBackspace);
		
		btnBackspace.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent evt)
			{
				timerBackspacebtn.start();				
			}
			public void mouseExited(MouseEvent evt)
			{
				timerBackspacebtn.stop();
			}
		});
		
		btnShift = new JButton("Shift");
		btnShift.setMargin(new Insets(1, 1, 1, 1));
		btnShift.setHorizontalAlignment(SwingConstants.CENTER);
		btnShift.setBounds(keysRow3X-55, keysRow3Y, 50, 20);
		//btnShift.setEnabled(false);
		contentPanel.add(btnShift);
				
		btnShift.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent evt)
			{
				timerShiftbtn.start();				
			}
			public void mouseExited(MouseEvent evt)
			{
				timerShiftbtn.stop();
			}
		});
		
		btnCapsLock = new JButton("Caps");
		btnCapsLock.setMargin(new Insets(1, 1, 1, 1));
		btnCapsLock.setHorizontalAlignment(SwingConstants.CENTER);
		btnCapsLock.setBounds(keysRow2X-45, keysRow2Y, 40, 20);
		contentPanel.add(btnCapsLock);
		
		btnCapsLock.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent evt)
			{
				timerCapsbtn.start();				
			}
			public void mouseExited(MouseEvent evt)
			{
				timerCapsbtn.stop();
			}
		});
	}
	
	class one_ButtonActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String currentText = txtInput.getText();
			String newText = currentText.concat("1");
			txtInput.setText(newText);
		}
	}
	
	class two_ButtonActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String currentText = txtInput.getText();
			String newText = currentText.concat("2");
			txtInput.setText(newText);
		}
	}
	
	class three_ButtonActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String currentText = txtInput.getText();
			String newText = currentText.concat("3");
			txtInput.setText(newText);
		}
	}
	
	class four_ButtonActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String currentText = txtInput.getText();
			String newText = currentText.concat("4");
			txtInput.setText(newText);
		}
	}
	
	class five_ButtonActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String currentText = txtInput.getText();
			String newText = currentText.concat("5");
			txtInput.setText(newText);
		}
	}
	
	class six_ButtonActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String currentText = txtInput.getText();
			String newText = currentText.concat("6");
			txtInput.setText(newText);
		}
	}
	
	class seven_ButtonActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String currentText = txtInput.getText();
			String newText = currentText.concat("7");
			txtInput.setText(newText);
		}
	}
	
	class eight_ButtonActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String currentText = txtInput.getText();
			String newText = currentText.concat("8");
			txtInput.setText(newText);
		}
	}
	
	class nine_ButtonActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String currentText = txtInput.getText();
			String newText = currentText.concat("9");
			txtInput.setText(newText);
		}
	}
	
	class zero_ButtonActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String currentText = txtInput.getText();
			String newText = currentText.concat("0");
			txtInput.setText(newText);
		}
	}
	
	class Q_ButtonActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String currentText = txtInput.getText();
			String newText = "";
			
			if (capitalLetter)
			{
				newText = currentText.concat("Q");
				if (!stayCapitalLetter)
				{
					setToLower();
				}
			}
			else
			{
				newText = currentText.concat("q");
			}
			
			txtInput.setText(newText);
		}
	}
	
	class W_ButtonActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String currentText = txtInput.getText();
			String newText = "";
			
			if (capitalLetter)
			{
				newText = currentText.concat("W");
				if (!stayCapitalLetter)
				{
					setToLower();
				}
			}
			else
			{
				newText = currentText.concat("w");
			}
			
			txtInput.setText(newText);
		}
	}
	
	class E_ButtonActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String currentText = txtInput.getText();
			String newText = "";
			
			if (capitalLetter)
			{
				newText = currentText.concat("E");
				if (!stayCapitalLetter)
				{
					setToLower();
				}
			}
			else
			{
				newText = currentText.concat("e");
			}
			
			txtInput.setText(newText);
		}
	}
	
	class R_ButtonActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String currentText = txtInput.getText();
			String newText = "";
			
			if (capitalLetter)
			{
				newText = currentText.concat("R");
				if (!stayCapitalLetter)
				{
					setToLower();
				}
			}
			else
			{
				newText = currentText.concat("r");
			}
			
			txtInput.setText(newText);
		}
	}
	
	class T_ButtonActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String currentText = txtInput.getText();
			String newText = "";
			
			if (capitalLetter)
			{
				newText = currentText.concat("T");
				if (!stayCapitalLetter)
				{
					setToLower();
				}
			}
			else
			{
				newText = currentText.concat("t");
			}
			
			txtInput.setText(newText);
		}
	}
	
	class Y_ButtonActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String currentText = txtInput.getText();
			String newText = "";
			
			if (capitalLetter)
			{
				newText = currentText.concat("Y");
				if (!stayCapitalLetter)
				{
					setToLower();
				}
			}
			else
			{
				newText = currentText.concat("y");
			}
			
			txtInput.setText(newText);
		}
	}
	
	class U_ButtonActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String currentText = txtInput.getText();
			String newText = "";
			
			if (capitalLetter)
			{
				newText = currentText.concat("U");
				if (!stayCapitalLetter)
				{
					setToLower();
				}
			}
			else
			{
				newText = currentText.concat("u");
			}
			
			txtInput.setText(newText);
		}
	}
	
	class I_ButtonActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String currentText = txtInput.getText();
			String newText = "";
			
			if (capitalLetter)
			{
				newText = currentText.concat("I");
				if (!stayCapitalLetter)
				{
					setToLower();
				}
			}
			else
			{
				newText = currentText.concat("i");
			}
			
			txtInput.setText(newText);
		}
	}
	
	class O_ButtonActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String currentText = txtInput.getText();
			String newText = "";
			
			if (capitalLetter)
			{
				newText = currentText.concat("O");
				if (!stayCapitalLetter)
				{
					setToLower();
				}
			}
			else
			{
				newText = currentText.concat("o");
			}
			
			txtInput.setText(newText);
		}
	}
	
	class P_ButtonActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String currentText = txtInput.getText();
			String newText = "";
			
			if (capitalLetter)
			{
				newText = currentText.concat("P");
				if (!stayCapitalLetter)
				{
					setToLower();
				}
			}
			else
			{
				newText = currentText.concat("p");
			}
			
			txtInput.setText(newText);
		}
	}
	
	class A_ButtonActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String currentText = txtInput.getText();
			String newText = "";
			
			if (capitalLetter)
			{
				newText = currentText.concat("A");
				if (!stayCapitalLetter)
				{
					setToLower();
				}
			}
			else
			{
				newText = currentText.concat("a");
			}
			
			txtInput.setText(newText);
		}
	}
	
	class S_ButtonActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String currentText = txtInput.getText();
			String newText = "";
			
			if (capitalLetter)
			{
				newText = currentText.concat("S");
				if (!stayCapitalLetter)
				{
					setToLower();
				}
			}
			else
			{
				newText = currentText.concat("s");
			}
			
			txtInput.setText(newText);
		}
	}
	
	class D_ButtonActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String currentText = txtInput.getText();
			String newText = "";
			
			if (capitalLetter)
			{
				newText = currentText.concat("D");
				if (!stayCapitalLetter)
				{
					setToLower();
				}
			}
			else
			{
				newText = currentText.concat("d");
			}
			
			txtInput.setText(newText);
		}
	}
	
	class F_ButtonActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String currentText = txtInput.getText();
			String newText = "";
			
			if (capitalLetter)
			{
				newText = currentText.concat("F");
				if (!stayCapitalLetter)
				{
					setToLower();
				}
			}
			else
			{
				newText = currentText.concat("f");
			}
			
			txtInput.setText(newText);
		}
	}
	
	class G_ButtonActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String currentText = txtInput.getText();
			String newText = "";
			
			if (capitalLetter)
			{
				newText = currentText.concat("G");
				if (!stayCapitalLetter)
				{
					setToLower();
				}
			}
			else
			{
				newText = currentText.concat("g");
			}
			
			txtInput.setText(newText);
		}
	}
	
	class H_ButtonActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String currentText = txtInput.getText();
			String newText = "";
			
			if (capitalLetter)
			{
				newText = currentText.concat("H");
				if (!stayCapitalLetter)
				{
					setToLower();
				}
			}
			else
			{
				newText = currentText.concat("h");
			}
			
			txtInput.setText(newText);
		}
	}
	
	class J_ButtonActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String currentText = txtInput.getText();
			String newText = "";
			
			if (capitalLetter)
			{
				newText = currentText.concat("J");
				if (!stayCapitalLetter)
				{
					setToLower();
				}
			}
			else
			{
				newText = currentText.concat("j");
			}
			
			txtInput.setText(newText);
		}
	}
	
	class K_ButtonActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String currentText = txtInput.getText();
			String newText = "";
			
			if (capitalLetter)
			{
				newText = currentText.concat("K");
				if (!stayCapitalLetter)
				{
					setToLower();
				}
			}
			else
			{
				newText = currentText.concat("k");
			}
			
			txtInput.setText(newText);
		}
	}
	
	class L_ButtonActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String currentText = txtInput.getText();
			String newText = "";
			
			if (capitalLetter)
			{
				newText = currentText.concat("L");
				if (!stayCapitalLetter)
				{
					setToLower();
				}
			}
			else
			{
				newText = currentText.concat("l");
			}
			
			txtInput.setText(newText);
		}
	}
	
	class Z_ButtonActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String currentText = txtInput.getText();
			String newText = "";
			
			if (capitalLetter)
			{
				newText = currentText.concat("Z");
				if (!stayCapitalLetter)
				{
					setToLower();
				}
			}
			else
			{
				newText = currentText.concat("z");
			}
			
			txtInput.setText(newText);
		}
	}
	
	class X_ButtonActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String currentText = txtInput.getText();
			String newText = "";
			
			if (capitalLetter)
			{
				newText = currentText.concat("X");
				if (!stayCapitalLetter)
				{
					setToLower();
				}
			}
			else
			{
				newText = currentText.concat("x");
			}
			
			txtInput.setText(newText);
		}
	}
	
	class C_ButtonActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String currentText = txtInput.getText();
			String newText = "";
			
			if (capitalLetter)
			{
				newText = currentText.concat("C");
				if (!stayCapitalLetter)
				{
					setToLower();
				}
			}
			else
			{
				newText = currentText.concat("c");
			}
			
			txtInput.setText(newText);
		}
	}
	
	class V_ButtonActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String currentText = txtInput.getText();
			String newText = "";
			
			if (capitalLetter)
			{
				newText = currentText.concat("V");
				if (!stayCapitalLetter)
				{
					setToLower();
				}
			}
			else
			{
				newText = currentText.concat("v");
			}
			
			txtInput.setText(newText);
		}
	}
	
	class B_ButtonActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String currentText = txtInput.getText();
			String newText = "";
			
			if (capitalLetter)
			{
				newText = currentText.concat("B");
				if (!stayCapitalLetter)
				{
					setToLower();
				}
			}
			else
			{
				newText = currentText.concat("b");
			}
			
			txtInput.setText(newText);
		}
	}
	
	class N_ButtonActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String currentText = txtInput.getText();
			String newText = "";
			
			if (capitalLetter)
			{
				newText = currentText.concat("N");
				if (!stayCapitalLetter)
				{
					setToLower();
				}
			}
			else
			{
				newText = currentText.concat("n");
			}
			
			txtInput.setText(newText);
		}
	}
	
	class M_ButtonActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String currentText = txtInput.getText();
			String newText = "";
			
			if (capitalLetter)
			{
				newText = currentText.concat("M");
				if (!stayCapitalLetter)
				{
					setToLower();
				}
			}
			else
			{
				newText = currentText.concat("m");
			}
			
			txtInput.setText(newText);
		}
	}
	
	class Backspace_ButtonActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String currentText = txtInput.getText();
			int length = currentText.length();
			if (length != 0)
			{
				String newText = currentText.substring(0,length-1);
				txtInput.setText(newText);
			}
		}
	}
	
	class Shift_ButtonActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (capitalLetter == false)
			{
				setToCapital();
			}
			else
			{
				setToLower();
			}
		}
	}
	
	class Caps_ButtonActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (stayCapitalLetter == false)
			{
				setToCapital();
				stayCapitalLetter = true;
				btnCapsLock.setBorder(BorderFactory.createLineBorder(Color.orange, 1));
			}
			else
			{
				setToLower();
				btnCapsLock.setBorder(UIManager.getBorder("Button.border"));
				stayCapitalLetter = false;
			}
		}
	}
	
	class Validate_ButtonActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String userInput = txtInput.getText();
			
			if ( userInput.equals(strCaptcha) )
			{
				dispose();
				
				/*lblCaptcha.setText("Validated");
				lblCaptcha.setBackground(Color.green);
				lblCaptcha.setForeground(Color.black);
				lblErrorMessage.setText("");*/
			}
			else
			{
				lblErrorMessage.setText("Invalid, try again");
				Captcha newCaptcha = new Captcha();
				strCaptcha = newCaptcha.generateCaptcha();
				lblCaptcha.setText(strCaptcha);
				lblCaptcha.setForeground(newCaptcha.generateForeColor());
				lblCaptcha.setBackground(newCaptcha.generateBackColor());
				lblCaptcha.setFont(newCaptcha.generateFont());
				txtInput.setText("");
			}
		}
	}
	
	class NewCaptcha_ButtonActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Captcha newCaptcha = new Captcha();
			strCaptcha = newCaptcha.generateCaptcha();
			
			lblCaptcha.setText(strCaptcha);
			lblCaptcha.setForeground(newCaptcha.generateForeColor());
			lblCaptcha.setBackground(newCaptcha.generateBackColor());
			lblCaptcha.setFont(newCaptcha.generateFont());
		}
	}
	
	private void setToCapital()
	{
		capitalLetter = true;
		
		btnQ.setText("Q");
		btnW.setText("W");
		btnE.setText("E");
		btnR.setText("R");
		btnT.setText("T");
		btnY.setText("Y");
		btnU.setText("U");
		btnI.setText("I");
		btnO.setText("O");
		btnP.setText("P");
		btnA.setText("A");
		btnS.setText("S");
		btnD.setText("D");
		btnF.setText("F");
		btnG.setText("G");
		btnH.setText("H");
		btnJ.setText("J");
		btnK.setText("K");
		btnL.setText("L");
		btnZ.setText("Z");
		btnX.setText("X");
		btnC.setText("C");
		btnV.setText("V");
		btnB.setText("B");
		btnN.setText("N");
		btnM.setText("M");
	}
	
	private void setToLower()
	{
		capitalLetter = false;
		stayCapitalLetter = false;
		
		btnQ.setText("q");
		btnW.setText("w");
		btnE.setText("e");
		btnR.setText("r");
		btnT.setText("t");
		btnY.setText("y");
		btnU.setText("u");
		btnI.setText("i");
		btnO.setText("o");
		btnP.setText("p");
		btnA.setText("a");
		btnS.setText("s");
		btnD.setText("d");
		btnF.setText("f");
		btnG.setText("g");
		btnH.setText("h");
		btnJ.setText("j");
		btnK.setText("k");
		btnL.setText("l");
		btnZ.setText("z");
		btnX.setText("x");
		btnC.setText("c");
		btnV.setText("v");
		btnB.setText("b");
		btnN.setText("n");
		btnM.setText("m");
	}
}
