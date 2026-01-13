package Modules;

import Components.PageHeader;
import Components.Table;
import config.DesignConstants;
import javax.swing.*;
import java.awt.*;

public abstract class BaseEntityPage extends JFrame {

    public BaseEntityPage(String title, String entityName, Object[][] formStructure, String[] columns) {
        initComponents();
        
        PageHeader pageHeader = new PageHeader(title, formStructure);
        
        Object[][] data = fetchData();
        Table tablePanel = new Table(columns, entityName, formStructure, data);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        pageHeader.setMaximumSize(new Dimension(Integer.MAX_VALUE, pageHeader.getPreferredSize().height));
        tablePanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));

        mainPanel.add(pageHeader);
        mainPanel.add(tablePanel);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(mainPanel, BorderLayout.CENTER);
    }

    protected abstract Object[][] fetchData();

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(DesignConstants.FRAME_SIZE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 769, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 525, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }
}
