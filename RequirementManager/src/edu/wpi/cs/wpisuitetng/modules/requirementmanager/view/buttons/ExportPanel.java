/*******************************************************************************
 * Copyright (c) 2013 WPI-Suite
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package edu.wpi.cs.wpisuitetng.modules.requirementmanager.view.buttons;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import edu.wpi.cs.wpisuitetng.janeway.gui.container.toolbar.ToolbarGroupView;
import edu.wpi.cs.wpisuitetng.modules.requirementmanager.models.Requirement;
import edu.wpi.cs.wpisuitetng.modules.requirementmanager.models.RequirementModel;
import edu.wpi.cs.wpisuitetng.modules.requirementmanager.view.Exporter;
import edu.wpi.cs.wpisuitetng.modules.requirementmanager.view.ViewEventController;

/**
 * @author Benjamin
 *
 */
public class ExportPanel extends ToolbarGroupView {
	// initialize the main view toolbar buttons	
	private final JButton exportButton = new JButton("<html>Export Requirements</html>");
	private final JPanel contentPanel = new JPanel();
		
		public ExportPanel(){
			super("");
			
			this.contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.X_AXIS));
			this.setPreferredWidth(350);
			
			//this.createIterationButton.setSize(200, 200);
			//this.createButton.setPreferredSize(new Dimension(200, 200));
			this.exportButton.setHorizontalAlignment(SwingConstants.CENTER);
			
			/**
			 * Exports the list of selected requirements to a file when btnExport is
			 * pressed
			 */
			exportButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// Create default list model
					DefaultListModel lm = new DefaultListModel();
//					Requirement req = RequirementModel.getInstance().getRequirements().get(i);	
					for (int i = 0; i < ViewEventController.getInstance().getOverviewTable().getSelectedRows().length; i++) {
						lm.addElement((Requirement)ViewEventController.getInstance().getOverviewTable().getValueAt(ViewEventController.getInstance().getOverviewTable().getSelectedRows()[i], 1));
					}
					if(lm.getSize() == 0) {
						return;
					}
					//lm.addElement((Requirement)ViewEventController.getInstance().getOverviewTable().getValueAt(ViewEventController.getInstance().getOverviewTable().getSelectedRow(),1));
					//Create a file chooser
					final JFileChooser fc = new JFileChooser();
					//In response to a button click:
					int returnVal = fc.showSaveDialog(contentPanel);
					if (returnVal == JFileChooser.APPROVE_OPTION) {
						// Create exporter
						Exporter ex = new Exporter();
						// Export requirements
						ex.exportAsJSON(lm, fc.getSelectedFile().getAbsolutePath());
						System.out.println("Exported all selected requirements\n");
					}
				}
			});
				
			contentPanel.add(exportButton);
			contentPanel.setOpaque(false);
			

			this.add(contentPanel);
		}
		/**
		 * Method getCreateButton.
		
		 * @return JButton Returns the export button
		 */
		public JButton getExportButton() {
			return exportButton;
		}

		
}
