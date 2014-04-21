/*******************************************************************************
 * Copyright (c) 2013 WPI-Suite
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Struct-By-Lightning
 ******************************************************************************/
package edu.wpi.cs.wpisuitetng.modules.PlanningPoker.views;

import edu.wpi.cs.wpisuitetng.janeway.config.ConfigManager;
import edu.wpi.cs.wpisuitetng.modules.PlanningPoker.controller.AddUserController;
import edu.wpi.cs.wpisuitetng.modules.PlanningPoker.models.User;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This singleton is a JPanel with the GUI needed for the main area of the view
 * which prompts a user for contact information before they are able to enter
 * planning poker.
 * 
 * @author Austin Rose (atrose)
 */
public class ContactInformationPromptView extends javax.swing.JPanel {

	/**
	 * The single instance of this singleton-pattern class.
	 */
	private static ContactInformationPromptView singleInstance;

	/**
	 * @return ContactInformationPromptView The single accessible instance of
	 *         this singleton-pattern class.
	 */
	public static ContactInformationPromptView getInstance() {
		if (ContactInformationPromptView.singleInstance == null) {
			ContactInformationPromptView.singleInstance = new ContactInformationPromptView();
		}
		return singleInstance;
	}

	/**
	 * Constructor initializes all GUI components. It is a private member so
	 * that this class can be implemented as a singleton.
	 */
	private ContactInformationPromptView() {
		initComponents();
	}

	/**
	 * Listeners in the components will call this method whenever the submit
	 * button is pressed.
	 * 
	 * @param email
	 *            The text that was in the email field.
	 * @param aim
	 *            The text that was in the aim field.
	 */
	private void submitButtonPressed(String email, String aim) {

		// TODO: Right now, this button simply transitions from the contact
		// prompt to the main planning poker view no matter what.
		User user = new User(emailField.getText(), ConfigManager.getConfig().getUserName(), "1111111111", aimField.getText());
		AddUserController.getInstance().AddUser(user);
		MainView.getInstance().switchToMainOverview();
	}

	/**
	 * THIS METHOD WAS AUTOMATICALLY GENERATED BY NETBEANS.
	 */
	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		jPanel1 = new javax.swing.JPanel();
		jPanel2 = new javax.swing.JPanel();
		jPanel4 = new javax.swing.JPanel();
		contactPrompLabel = new javax.swing.JLabel();
		aimFieldPanel = new javax.swing.JPanel();
		aimField = new javax.swing.JTextField();
		emailFieldPanel = new javax.swing.JPanel();
		emailField = new javax.swing.JTextField();
		submitButton = new javax.swing.JButton();
		errorLabel = new javax.swing.JLabel();
		jPanel3 = new javax.swing.JPanel();
		jPanel5 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();

		setLayout(new java.awt.BorderLayout());

		jPanel1.setLayout(new java.awt.GridLayout(1, 2));

		contactPrompLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		contactPrompLabel
				.setText("<html>You must provide at least one point of contact to continue.</html>");

		aimFieldPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("AIM"));

		aimField.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent evt) {
				aimFieldKeyTyped(evt);
			}
		});

		javax.swing.GroupLayout aimFieldPanelLayout = new javax.swing.GroupLayout(aimFieldPanel);
		aimFieldPanel.setLayout(aimFieldPanelLayout);
		aimFieldPanelLayout.setHorizontalGroup(aimFieldPanelLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				aimFieldPanelLayout.createSequentialGroup().addContainerGap()
						.addComponent(aimField).addContainerGap()));
		aimFieldPanelLayout.setVerticalGroup(aimFieldPanelLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				aimFieldPanelLayout.createSequentialGroup().addContainerGap()
						.addComponent(aimField).addContainerGap()));

		emailFieldPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Email"));

		emailField.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent evt) {
				emailFieldKeyTyped(evt);
			}
		});

		javax.swing.GroupLayout emailFieldPanelLayout = new javax.swing.GroupLayout(emailFieldPanel);
		emailFieldPanel.setLayout(emailFieldPanelLayout);
		emailFieldPanelLayout.setHorizontalGroup(emailFieldPanelLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				emailFieldPanelLayout.createSequentialGroup().addContainerGap()
						.addComponent(emailField).addContainerGap()));
		emailFieldPanelLayout.setVerticalGroup(emailFieldPanelLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				emailFieldPanelLayout.createSequentialGroup().addContainerGap()
						.addComponent(emailField).addContainerGap()));

		submitButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		submitButton.setText("Submit");
		submitButton.setEnabled(false);
		submitButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				submitButtonActionPerformed(evt);
			}
		});

		errorLabel.setText("* Fill in at least one field");

		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout
				.setHorizontalGroup(jPanel4Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel4Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel4Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																contactPrompLabel,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																547, Short.MAX_VALUE)
														.addComponent(
																aimFieldPanel,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																emailFieldPanel,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addGroup(
																jPanel4Layout
																		.createSequentialGroup()
																		.addComponent(submitButton)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(errorLabel)
																		.addGap(0, 0,
																				Short.MAX_VALUE)))
										.addContainerGap()));
		jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel4Layout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(contactPrompLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(aimFieldPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(emailFieldPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addGroup(
								jPanel4Layout
										.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(submitButton).addComponent(errorLabel))
						.addContainerGap(345, Short.MAX_VALUE)));

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel2Layout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel2Layout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));

		jPanel1.add(jPanel2);

		jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
		jLabel1.setText("What is Planning Poker?");

		jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
		jLabel2.setText("<html> Planning Poker is a consensus-based tool for software developers to come together and estimate effort of development goals for the team. This is a great tool for agile teams to estimate the user stories they have for a given iteration.<br><br> The idea behind Planning Poker is that team discusses each user story and then goes into the game and then each user goes into the deck and selects the card that represents how effort he or she thinks the task will take. This process can be repeated for any number of user stories in the game.<br><br> During the game all estimates remain private until everyone has chose his or her card. After all estimates are in the Planning Poker game will calculate the Mean, Median, Mode, Minimum, Maximum, and Standard Deviation of the game. These values can be used for the team to continue the discussion and come to a consensus of what the groups estimate is for the user story.<br><br> </html>");
		jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

		javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
		jPanel5.setLayout(jPanel5Layout);
		jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel5Layout
						.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								jPanel5Layout
										.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel1,
												javax.swing.GroupLayout.DEFAULT_SIZE, 547,
												Short.MAX_VALUE)
										.addComponent(jLabel2,
												javax.swing.GroupLayout.PREFERRED_SIZE, 0,
												Short.MAX_VALUE)).addContainerGap()));
		jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel5Layout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel1)
						.addGap(18, 18, 18)
						.addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(313, Short.MAX_VALUE)));

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel3Layout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				jPanel3Layout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));

		jPanel1.add(jPanel3);

		add(jPanel1, java.awt.BorderLayout.CENTER);
	}// </editor-fold>

	private void aimFieldKeyTyped(java.awt.event.KeyEvent evt) {
		this.updateIfValid();
	}

	private void emailFieldKeyTyped(java.awt.event.KeyEvent evt) {
		this.updateIfValid();
	}

	private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {
		this.submitButtonPressed(this.emailField.getText(), this.aimField.getText());
	}

	private boolean updateIfValid() {
		String emailText = this.emailField.getText();
		String aimText = this.aimField.getText();
		
		Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailText);
        
		if (matcher.find() || aimText.length() != 0) {
			this.submitButton.setEnabled(true);
			this.errorLabel.setVisible(false);
			return true;
		} else {
			this.submitButton.setEnabled(false);
			this.errorLabel.setVisible(true);
			return false;
		}
	}

	/**
	 * THESE DECLARATIONS WERE AUTOMATICALLY GENERATED BY NETBEANS.
	 */
	private javax.swing.JTextField aimField;
	private javax.swing.JPanel aimFieldPanel;
	private javax.swing.JLabel contactPrompLabel;
	private javax.swing.JTextField emailField;
	private javax.swing.JPanel emailFieldPanel;
	private javax.swing.JLabel errorLabel;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JButton submitButton;
}
