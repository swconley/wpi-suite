/*******************************************************************************
 * Copyright (c) 2012-2014 -- WPI Suite
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributor: team struct-by-lightning
 *******************************************************************************/
package edu.wpi.cs.wpisuitetng.modules.PlanningPoker.views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.wpi.cs.wpisuitetng.janeway.config.ConfigManager;
import edu.wpi.cs.wpisuitetng.modules.PlanningPoker.controller.AddPlanningPokerVoteController;
import edu.wpi.cs.wpisuitetng.modules.PlanningPoker.controller.GetPlanningPokerGamesController;
import edu.wpi.cs.wpisuitetng.modules.PlanningPoker.controller.GetPlanningPokerUserController;
import edu.wpi.cs.wpisuitetng.modules.PlanningPoker.controller.UpdatePlanningPokerUserController;
import edu.wpi.cs.wpisuitetng.modules.PlanningPoker.models.PlanningPokerUser;
import edu.wpi.cs.wpisuitetng.modules.PlanningPoker.models.PlanningPokerUserModel;

/**
 * @author sfmailand
 * 
 */
public class PreferencesView extends JPanel {

	PlanningPokerUser currentUser;

	public static void openNewTab() {
		final PreferencesView view = new PreferencesView();
		MainView.getInstance().addCloseableTab("Preferences", view);
	}

	/**
	 * Creates new form PreferencesWindow
	 */
	public PreferencesView() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		textPanel = new javax.swing.JPanel();
		emailPanel = new javax.swing.JPanel();
		emailField = new javax.swing.JTextField();
		aimPanel = new javax.swing.JPanel();
		aimField = new javax.swing.JTextField();
		notificationPanel = new javax.swing.JPanel();
		sendEmail = new javax.swing.JCheckBox();
		sendAIM = new javax.swing.JCheckBox();
		updateUser = new javax.swing.JButton();
		errorMessage = new javax.swing.JLabel();

		fillAllFields();

		sendEmail.setText("Email");
		sendEmail.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				sendEmailActionPerformed(evt);
			}
		});

		sendAIM.setText("AIM");
		sendAIM.setActionCommand("");
		sendAIM.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				sendAIMActionPerformed(evt);
			}
		});

		emailField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				emailFieldKeyTyped(evt);
			}
		});

		aimField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				aimFieldKeyTyped(evt);
			}
		});

		updateUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				updateUserPressed(evt);
			}
		});

		updateUser.setText("Save Changes");

		final GroupLayout textPanelLayout = new javax.swing.GroupLayout(
				textPanel);
		textPanel.setLayout(textPanelLayout);
		textPanelLayout.setHorizontalGroup(textPanelLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 0,
				Short.MAX_VALUE));
		textPanelLayout.setVerticalGroup(textPanelLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 110,
				Short.MAX_VALUE));

		emailPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createLineBorder(Color.BLACK), "Email"));

		final GroupLayout emailPanelLayout = new javax.swing.GroupLayout(
				emailPanel);
		emailPanel.setLayout(emailPanelLayout);
		emailPanelLayout.setHorizontalGroup(emailPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(emailField));
		emailPanelLayout.setVerticalGroup(emailPanelLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				emailPanelLayout
						.createSequentialGroup()
						.addGap(0, 0, Short.MAX_VALUE)
						.addComponent(emailField,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)));

		aimPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createLineBorder(Color.BLACK), "AIM"));

		final GroupLayout aimPanelLayout = new javax.swing.GroupLayout(
				aimPanel);
		aimPanel.setLayout(aimPanelLayout);
		aimPanelLayout.setHorizontalGroup(aimPanelLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				aimField));
		aimPanelLayout.setVerticalGroup(aimPanelLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				aimPanelLayout
						.createSequentialGroup()
						.addGap(0, 0, Short.MAX_VALUE)
						.addComponent(aimField,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)));

		notificationPanel.setBorder(javax.swing.BorderFactory
				.createTitledBorder(javax.swing.BorderFactory
						.createLineBorder(Color.BLACK),
						"Send Notifications To"));

		sendEmail.setText("Email");

		sendAIM.setText("AIM");

		final GroupLayout notificationPanelLayout = new javax.swing.GroupLayout(
				notificationPanel);
		notificationPanel.setLayout(notificationPanelLayout);
		notificationPanelLayout
				.setHorizontalGroup(notificationPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								notificationPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												sendEmail,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												101,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												102, Short.MAX_VALUE)
										.addComponent(
												sendAIM,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												92,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap()));
		notificationPanelLayout
				.setVerticalGroup(notificationPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								notificationPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												notificationPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(sendEmail)
														.addComponent(sendAIM))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		updateUser.setText("Save Changes");
		updateUser.setToolTipText("");

		final GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(16, 16, 16)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
																.addComponent(
																		notificationPanel,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addComponent(
																		aimPanel,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addComponent(
																		emailPanel,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addComponent(
																		textPanel,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE))
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		updateUser,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		130,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		errorMessage,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		310,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(564, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(textPanel,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(emailPanel,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(aimPanel,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(notificationPanel,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(updateUser)
												.addComponent(errorMessage))
								.addContainerGap(316, Short.MAX_VALUE)));
	}// </editor-fold>

	/**
	 * Description
	 * 
	 * @param evt
	 */
	protected void emailFieldKeyTyped(KeyEvent evt) {
		checkAllFields();
	}

	protected void smsFieldKeyTyped(KeyEvent evt) {
		checkAllFields();
	}

	protected void aimFieldKeyTyped(KeyEvent evt) {
		checkAllFields();
	}

	private void sendEmailActionPerformed(ActionEvent evt) {
		checkAllFields();
	}

	private void sendAIMActionPerformed(ActionEvent evt) {
		checkAllFields();
	}

	private void updateUserPressed(ActionEvent evt) {
		if (isValidEmail()) {
			currentUser.setEmail(emailField.getText());
		}

		final String aimText = aimField.getText();
		final boolean validAim = (aimText.length() > 0) && !(aimText.contains(" "));

		if (validAim) {
			currentUser.setInstantMessage(aimText);
		}

		currentUser.setSendAim(sendAIM.isSelected());
		currentUser.setSendEmail(sendEmail.isSelected());
		UpdatePlanningPokerUserController.getInstance().update(currentUser);
		updateUser.setText("Saved!");
		updateUser.setEnabled(false);
	}

	private void checkAllFields() {

		updateUser.setText("Save Changes");
		updateUser.setEnabled(true);
		boolean emailEntered = isValidEmail();
		boolean aimEntered = !(aimField.getText().length() == 0)
				&& !aimField.getText().contains(" ");
		boolean oneOptionSelected = sendEmail.isSelected()
				|| sendAIM.isSelected();

		boolean aimChecked = true;
		boolean emailChecked = true;

		if (!aimEntered && sendAIM.isSelected()) {
			errorMessage.setText("AIM checked, but no account entered");
			aimChecked = false;
		}

		if (!emailEntered && sendEmail.isSelected()) {
			errorMessage.setText("Emailed checked, but no valid email entered");
			emailChecked = false;
		}
		if (!oneOptionSelected) {
			errorMessage.setText("Must have one option checked");
		}

		final boolean canUpdate = aimChecked && emailChecked && oneOptionSelected;

		if (canUpdate) {
			errorMessage.setText("");
		}

		updateUser.setEnabled(canUpdate);

	}

	private boolean isValidEmail() {
		final String emailText = emailField.getText();
		final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern
				.compile(
						"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",
						Pattern.CASE_INSENSITIVE);
		final Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailText);

		return matcher.find();
	}

	private void fillAllFields() {
		GetPlanningPokerUserController.getInstance().retrieveUser();
		try {
			Thread.sleep(150);
		} catch (Exception e) {
		}

		currentUser = PlanningPokerUserModel.getInstance().getUser(
				ConfigManager.getConfig().getUserName());

		if (currentUser.getEmail() != null) {
			emailField.setText(currentUser.getEmail());
		}
		if (currentUser.getInstantMessage() != null) {
			aimField.setText(currentUser.getInstantMessage());
		}

		sendEmail.setSelected(currentUser.canSendEmail());
		sendAIM.setSelected(currentUser.canSendAim());

	}

	// Variables declaration - do not modify
	private javax.swing.JTextField aimField;
	private javax.swing.JPanel aimPanel;
	private javax.swing.JTextField emailField;
	private javax.swing.JPanel emailPanel;
	private javax.swing.JLabel errorMessage;
	private javax.swing.JPanel notificationPanel;
	private javax.swing.JCheckBox sendAIM;
	private javax.swing.JCheckBox sendEmail;
	private javax.swing.JPanel textPanel;
	private javax.swing.JButton updateUser;
	// End of variables declaration

}
