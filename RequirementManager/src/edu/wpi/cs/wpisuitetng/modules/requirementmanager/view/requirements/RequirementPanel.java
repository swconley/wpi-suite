/*******************************************************************************
 * Copyright (c) 2013 WPI-Suite
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Team Rolling Thunder
 ******************************************************************************/
package edu.wpi.cs.wpisuitetng.modules.requirementmanager.view.requirements;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import edu.wpi.cs.wpisuitetng.modules.requirementmanager.controller.UpdateRequirementController;
import edu.wpi.cs.wpisuitetng.modules.requirementmanager.models.Requirement;
import edu.wpi.cs.wpisuitetng.modules.requirementmanager.models.characteristics.RequirementStatus;
import edu.wpi.cs.wpisuitetng.modules.requirementmanager.view.ViewEventController;
import edu.wpi.cs.wpisuitetng.modules.requirementmanager.view.requirements.tabs.RequirementTabsPanel;

/**
 * @author Pi 
 * @author Chris
 * @author Brian
 */
public class RequirementPanel extends JPanel
{
	private Requirement displayRequirement;
	private RequirementViewMode viewMode;
	
	private RequirementInformationPanel infoPanel;
	private RequirementTabsPanel tabsPanel;
	private RequirementButtonPanel buttonPanel;
	
	private boolean readyToClose = false;
	
	public RequirementPanel(Requirement editingRequirement)
	{
		this.viewMode = (RequirementViewMode.EDITING);
		
		this.displayRequirement = editingRequirement;
		this.buildLayout();
	}
	
	public RequirementPanel(int parentID)
	{
		this.viewMode = (RequirementViewMode.CREATING);
		
		this.displayRequirement = new Requirement();
		
		try 
		{
			displayRequirement.setParentID(parentID);
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		this.buildLayout();
	}
	
	private void buildLayout()
	{
		buttonPanel = new RequirementButtonPanel(this, viewMode, displayRequirement);
		infoPanel = new RequirementInformationPanel(this, viewMode, displayRequirement);
		tabsPanel = new RequirementTabsPanel(this, viewMode, displayRequirement);
		
		JSplitPane contentPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, infoPanel, tabsPanel);
		JScrollPane contentScroll = new JScrollPane();
		contentScroll.setViewportView(contentPanel);
		
		this.setLayout(new BorderLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.NORTH; // Anchor to top of panel
		c.weightx = 1; // Fill horizontal space
		c.weighty = 1;
		this.add(contentScroll, BorderLayout.CENTER); // Add scroll pane to panel

		c.anchor = GridBagConstraints.SOUTH;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridy = 1;
		this.add(buttonPanel, BorderLayout.SOUTH);
	}
	
	public void refreshRequirementPanel()
	{
		
	}
	
	public void OKPressed() {
		if (infoPanel.validateFields()) {
			infoPanel.update();
			readyToClose = true;
			ViewEventController.getInstance().removeTab(this);
		}		
	}

	public void clearPressed() 
	{
		
	}

	public void cancelPressed() 
	{
		ViewEventController.getInstance().refreshTable();
		ViewEventController.getInstance().removeTab(this);		
	}
	
	/**
	 * Deletes the requirement. Sets all fields uneditable, sets status to
	 * deleted and closes the tab.
	 */
	public void deletePressed() 
	{
		if (this.displayRequirement.getStatus() == RequirementStatus.INPROGRESS)
			return;

		this.infoPanel.deleteRequirement();

		displayRequirement.setStatus(RequirementStatus.DELETED, false);

		UpdateRequirementController.getInstance().updateRequirement(displayRequirement);
		
		ViewEventController.getInstance().refreshTable();
		ViewEventController.getInstance().removeTab(this);	
	}	

	public void fireDeleted(boolean b) {
		this.buttonPanel.fireDeleted(b);
	}

	public void fireValid(boolean b) {		
		buttonPanel.fireValid(b);
	}
	
	public void fireChanges(boolean b) {	
		buttonPanel.fireChanges(b);
	}
	
	public void fireRefresh()
	{
		infoPanel.refreshInfo();
	}

	public Requirement getDisplayRequirement() {
		return displayRequirement;
	}

	public boolean readyToRemove() {
		if(readyToClose) return true;
		return infoPanel.readyToRemove() && tabsPanel.readyToRemove();
	}
}
