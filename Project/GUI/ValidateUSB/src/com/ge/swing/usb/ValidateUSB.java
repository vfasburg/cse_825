package com.ge.swing.usb;

import java.awt.Insets;
import java.awt.Color;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.border.EmptyBorder;

import java.util.*;
import java.awt.Font;

public class ValidateUSB extends JDialog
{

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
	private boolean capitalLetter = false;
	private boolean stayCapitalLetter = false;
	
	private String strCaptcha;

	public static void main(String[] args)
	{
		try
		{
			final ValidateUSB dialog = new ValidateUSB();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			//dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
			dialog.setTitle("USB Keyboard and Mouse Validation");
			dialog.setAlwaysOnTop(true);
			dialog.setFocusable(true);
			dialog.setVisible(true);
			dialog.setModal(true);
			
			dialog.addWindowFocusListener(new WindowFocusListener()
			{
				public void windowLostFocus(WindowEvent e)
				{
					dialog.setTitle("Out Focus");
					dialog.requestFocus();
					try {
						Thread.sleep(50);
					} catch (InterruptedException e1) {
						// Auto-generated catch block
					}
				}
				
				public void windowGainedFocus(WindowEvent e)
				{
					dialog.setTitle("In Focus");
					try {
						Thread.sleep(50);
					} catch (InterruptedException e1) {
						// Auto-generated catch block
					}
				}
			});
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
	
	public ValidateUSB()
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
		
		btnValidate.addActionListener(new ActionListener()
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
		
		btnNewCaptcha.addActionListener(new ActionListener()
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
		
		btn1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String currentText = txtInput.getText();
				String newText = currentText.concat("1");
				txtInput.setText(newText);
			}
		});
		
		btn2 = new JButton("2");
		btn2.setMargin(new Insets(1, 1, 1, 1));
		btn2.setHorizontalAlignment(SwingConstants.CENTER);
		btn2.setBounds(numRowX+30, numRowY, 20, 20);
		contentPanel.add(btn2);
		
		btn2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String currentText = txtInput.getText();
				String newText = currentText.concat("2");
				txtInput.setText(newText);
			}
		});
		
		btn3 = new JButton("3");
		btn3.setMargin(new Insets(1, 1, 1, 1));
		btn3.setHorizontalAlignment(SwingConstants.CENTER);
		btn3.setBounds(numRowX+60, numRowY, 20, 20);
		contentPanel.add(btn3);
		
		btn3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String currentText = txtInput.getText();
				String newText = currentText.concat("3");
				txtInput.setText(newText);
			}
		});
		
		btn4 = new JButton("4");
		btn4.setMargin(new Insets(1, 1, 1, 1));
		btn4.setHorizontalAlignment(SwingConstants.CENTER);
		btn4.setBounds(numRowX+90, numRowY, 20, 20);
		contentPanel.add(btn4);
		
		btn4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String currentText = txtInput.getText();
				String newText = currentText.concat("4");
				txtInput.setText(newText);
			}
		});
		
		btn5 = new JButton("5");
		btn5.setMargin(new Insets(1, 1, 1, 1));
		btn5.setHorizontalAlignment(SwingConstants.CENTER);
		btn5.setBounds(numRowX+120, numRowY, 20, 20);
		contentPanel.add(btn5);
		
		btn5.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String currentText = txtInput.getText();
				String newText = currentText.concat("5");
				txtInput.setText(newText);
			}
		});
		
		btn6 = new JButton("6");
		btn6.setMargin(new Insets(1, 1, 1, 1));
		btn6.setHorizontalAlignment(SwingConstants.CENTER);
		btn6.setBounds(numRowX+150, numRowY, 20, 20);
		contentPanel.add(btn6);
		
		btn6.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String currentText = txtInput.getText();
				String newText = currentText.concat("6");
				txtInput.setText(newText);
			}
		});
		
		btn7 = new JButton("7");
		btn7.setMargin(new Insets(1, 1, 1, 1));
		btn7.setHorizontalAlignment(SwingConstants.CENTER);
		btn7.setBounds(numRowX+180, numRowY, 20, 20);
		contentPanel.add(btn7);
		
		btn7.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String currentText = txtInput.getText();
				String newText = currentText.concat("7");
				txtInput.setText(newText);
			}
		});
		
		btn8 = new JButton("8");
		btn8.setMargin(new Insets(1, 1, 1, 1));
		btn8.setHorizontalAlignment(SwingConstants.CENTER);
		btn8.setBounds(numRowX+210, numRowY, 20, 20);
		contentPanel.add(btn8);
		
		btn8.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String currentText = txtInput.getText();
				String newText = currentText.concat("8");
				txtInput.setText(newText);
			}
		});
		
		btn9 = new JButton("9");
		btn9.setMargin(new Insets(1, 1, 1, 1));
		btn9.setHorizontalAlignment(SwingConstants.CENTER);
		btn9.setBounds(numRowX+240, numRowY, 20, 20);
		contentPanel.add(btn9);
		
		btn9.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String currentText = txtInput.getText();
				String newText = currentText.concat("9");
				txtInput.setText(newText);
			}
		});
		
		btn0 = new JButton("0");
		btn0.setMargin(new Insets(1, 1, 1, 1));
		btn0.setHorizontalAlignment(SwingConstants.CENTER);
		btn0.setBounds(numRowX+270, numRowY, 20, 20);
		contentPanel.add(btn0);
		
		btn0.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String currentText = txtInput.getText();
				String newText = currentText.concat("0");
				txtInput.setText(newText);
			}
		});
		
		// row 1
		btnQ = new JButton("q");
		btnQ.setBounds(keysRow1X, keysRow1Y, 20, 20);
		btnQ.setMargin(new Insets(1,1,1,1));
		btnQ.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(btnQ);
		
		btnQ.addActionListener(new ActionListener()
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
		});
		
		btnW = new JButton("w");
		btnW.setMargin(new Insets(1, 1, 1, 1));
		btnW.setHorizontalAlignment(SwingConstants.CENTER);
		btnW.setBounds(keysRow1X+30, keysRow1Y, 20, 20);
		contentPanel.add(btnW);
		
		btnW.addActionListener(new ActionListener()
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
		});
		
		btnE = new JButton("e");
		btnE.setMargin(new Insets(1, 1, 1, 1));
		btnE.setHorizontalAlignment(SwingConstants.CENTER);
		btnE.setBounds(keysRow1X+60, keysRow1Y, 20, 20);
		contentPanel.add(btnE);
		
		btnE.addActionListener(new ActionListener()
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
		});
		
		btnR = new JButton("r");
		btnR.setMargin(new Insets(1, 1, 1, 1));
		btnR.setHorizontalAlignment(SwingConstants.CENTER);
		btnR.setBounds(keysRow1X+90, keysRow1Y, 20, 20);
		contentPanel.add(btnR);
		
		btnR.addActionListener(new ActionListener()
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
		});
		
		btnT = new JButton("t");
		btnT.setMargin(new Insets(1, 1, 1, 1));
		btnT.setHorizontalAlignment(SwingConstants.CENTER);
		btnT.setBounds(keysRow1X+120, keysRow1Y, 20, 20);
		contentPanel.add(btnT);
		
		btnT.addActionListener(new ActionListener()
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
		});
		
		btnY = new JButton("y");
		btnY.setMargin(new Insets(1, 1, 1, 1));
		btnY.setHorizontalAlignment(SwingConstants.CENTER);
		btnY.setBounds(keysRow1X+150, keysRow1Y, 20, 20);
		contentPanel.add(btnY);
		
		btnY.addActionListener(new ActionListener()
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
		});
		
		btnU = new JButton("u");
		btnU.setMargin(new Insets(1, 1, 1, 1));
		btnU.setHorizontalAlignment(SwingConstants.CENTER);
		btnU.setBounds(keysRow1X+180, keysRow1Y, 20, 20);
		contentPanel.add(btnU);
		
		btnU.addActionListener(new ActionListener()
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
		});
		
		btnI = new JButton("i");
		btnI.setMargin(new Insets(1, 1, 1, 1));
		btnI.setHorizontalAlignment(SwingConstants.CENTER);
		btnI.setBounds(keysRow1X+210, keysRow1Y, 20, 20);
		contentPanel.add(btnI);
		
		btnI.addActionListener(new ActionListener()
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
		});
		
		btnO = new JButton("o");
		btnO.setMargin(new Insets(1, 1, 1, 1));
		btnO.setHorizontalAlignment(SwingConstants.CENTER);
		btnO.setBounds(keysRow1X+240, keysRow1Y, 20, 20);
		contentPanel.add(btnO);
		
		btnO.addActionListener(new ActionListener()
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
		});
		
		btnP = new JButton("p");
		btnP.setMargin(new Insets(1, 1, 1, 1));
		btnP.setHorizontalAlignment(SwingConstants.CENTER);
		btnP.setBounds(keysRow1X+270, keysRow1Y, 20, 20);
		contentPanel.add(btnP);
		
		btnP.addActionListener(new ActionListener()
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
		});
		
		// row 2
		btnA = new JButton("a");
		btnA.setMargin(new Insets(1, 1, 1, 1));
		btnA.setHorizontalAlignment(SwingConstants.CENTER);
		btnA.setBounds(keysRow2X, keysRow2Y, 20, 20);
		contentPanel.add(btnA);
		
		btnA.addActionListener(new ActionListener()
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
		});
		
		btnS = new JButton("s");
		btnS.setMargin(new Insets(1, 1, 1, 1));
		btnS.setHorizontalAlignment(SwingConstants.CENTER);
		btnS.setBounds(keysRow2X+30, keysRow2Y, 20, 20);
		contentPanel.add(btnS);
		
		btnS.addActionListener(new ActionListener()
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
		});
		
		btnD = new JButton("d");
		btnD.setMargin(new Insets(1, 1, 1, 1));
		btnD.setHorizontalAlignment(SwingConstants.CENTER);
		btnD.setBounds(keysRow2X+60, keysRow2Y, 20, 20);
		contentPanel.add(btnD);
		
		btnD.addActionListener(new ActionListener()
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
		});
		
		btnF = new JButton("f");
		btnF.setMargin(new Insets(1, 1, 1, 1));
		btnF.setHorizontalAlignment(SwingConstants.CENTER);
		btnF.setBounds(keysRow2X+90, keysRow2Y, 20, 20);
		contentPanel.add(btnF);
		
		btnF.addActionListener(new ActionListener()
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
		});
		
		btnG = new JButton("g");
		btnG.setMargin(new Insets(1, 1, 1, 1));
		btnG.setHorizontalAlignment(SwingConstants.CENTER);
		btnG.setBounds(keysRow2X+120, keysRow2Y, 20, 20);
		contentPanel.add(btnG);
		
		btnG.addActionListener(new ActionListener()
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
		});
		
		btnH = new JButton("h");
		btnH.setMargin(new Insets(1, 1, 1, 1));
		btnH.setHorizontalAlignment(SwingConstants.CENTER);
		btnH.setBounds(keysRow2X+150, keysRow2Y, 20, 20);
		contentPanel.add(btnH);
		
		btnH.addActionListener(new ActionListener()
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
		});
		
		btnJ = new JButton("j");
		btnJ.setMargin(new Insets(1, 1, 1, 1));
		btnJ.setHorizontalAlignment(SwingConstants.CENTER);
		btnJ.setBounds(keysRow2X+180, keysRow2Y, 20, 20);
		contentPanel.add(btnJ);
		
		btnJ.addActionListener(new ActionListener()
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
		});
		
		btnK = new JButton("k");
		btnK.setMargin(new Insets(1, 1, 1, 1));
		btnK.setHorizontalAlignment(SwingConstants.CENTER);
		btnK.setBounds(keysRow2X+210, keysRow2Y, 20, 20);
		contentPanel.add(btnK);
		
		btnK.addActionListener(new ActionListener()
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
		});
		
		btnL = new JButton("l");
		btnL.setMargin(new Insets(1, 1, 1, 1));
		btnL.setHorizontalAlignment(SwingConstants.CENTER);
		btnL.setBounds(keysRow2X+240, keysRow2Y, 20, 20);
		contentPanel.add(btnL);
		
		btnL.addActionListener(new ActionListener()
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
		});
		
		// row 3
		btnZ = new JButton("z");
		btnZ.setMargin(new Insets(1, 1, 1, 1));
		btnZ.setHorizontalAlignment(SwingConstants.CENTER);
		btnZ.setBounds(keysRow3X, keysRow3Y, 20, 20);
		contentPanel.add(btnZ);
		
		btnZ.addActionListener(new ActionListener()
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
		});
		
		btnX = new JButton("x");
		btnX.setMargin(new Insets(1, 1, 1, 1));
		btnX.setHorizontalAlignment(SwingConstants.CENTER);
		btnX.setBounds(keysRow3X+30, keysRow3Y, 20, 20);
		contentPanel.add(btnX);
		
		btnX.addActionListener(new ActionListener()
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
		});
		
		btnC = new JButton("c");
		btnC.setMargin(new Insets(1, 1, 1, 1));
		btnC.setHorizontalAlignment(SwingConstants.CENTER);
		btnC.setBounds(keysRow3X+60, keysRow3Y, 20, 20);
		contentPanel.add(btnC);
		
		btnC.addActionListener(new ActionListener()
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
		});
		
		btnV = new JButton("v");
		btnV.setMargin(new Insets(1, 1, 1, 1));
		btnV.setHorizontalAlignment(SwingConstants.CENTER);
		btnV.setBounds(keysRow3X+90, keysRow3Y, 20, 20);
		contentPanel.add(btnV);
		
		btnV.addActionListener(new ActionListener()
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
		});
		
		btnB = new JButton("b");
		btnB.setMargin(new Insets(1, 1, 1, 1));
		btnB.setHorizontalAlignment(SwingConstants.CENTER);
		btnB.setBounds(keysRow3X+120, keysRow3Y, 20, 20);
		contentPanel.add(btnB);
		
		btnB.addActionListener(new ActionListener()
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
		});
		
		btnN = new JButton("n");
		btnN.setMargin(new Insets(1, 1, 1, 1));
		btnN.setHorizontalAlignment(SwingConstants.CENTER);
		btnN.setBounds(keysRow3X+150, keysRow3Y, 20, 20);
		contentPanel.add(btnN);
		
		btnN.addActionListener(new ActionListener()
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
		});
		
		btnM = new JButton("m");
		btnM.setMargin(new Insets(1, 1, 1, 1));
		btnM.setHorizontalAlignment(SwingConstants.CENTER);
		btnM.setBounds(keysRow3X+180, keysRow3Y, 20, 20);
		contentPanel.add(btnM);
		
		btnM.addActionListener(new ActionListener()
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
		});		
		
		btnBackspace = new JButton("<===");
		btnBackspace.setMargin(new Insets(1, 1, 1, 1));
		btnBackspace.setHorizontalAlignment(SwingConstants.CENTER);
		btnBackspace.setBounds(keysRow3X+210, keysRow3Y, 60, 20);
		contentPanel.add(btnBackspace);
		
		btnBackspace.addActionListener(new ActionListener()
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
		});
		
		btnShift = new JButton("Shift");
		btnShift.setMargin(new Insets(1, 1, 1, 1));
		btnShift.setHorizontalAlignment(SwingConstants.CENTER);
		btnShift.setBounds(keysRow3X-55, keysRow3Y, 50, 20);
		contentPanel.add(btnShift);
		
		btnShift.addActionListener(new ActionListener()
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
		});
		
		btnCapsLock = new JButton("Caps");
		btnCapsLock.setMargin(new Insets(1, 1, 1, 1));
		btnCapsLock.setHorizontalAlignment(SwingConstants.CENTER);
		btnCapsLock.setBounds(keysRow2X-45, keysRow2Y, 40, 20);
		contentPanel.add(btnCapsLock);
		
		btnCapsLock.addActionListener(new ActionListener()
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
		});
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
