package telas;

import com.toedter.calendar.JCalendar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;

public class calendarPane extends javax.swing.JPanel {

    public calendarPane() {
        initComponents();
    }

    private Date selectedDate;

    private void initComponents() {
        JCalendar calendar = new JCalendar();

        calendar.addPropertyChangeListener("calendar", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                selectedDate = calendar.getDate();
            }
        });

        JButton selectDateButton = new JButton("Selecionar Data");
        selectDateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedDate != null) {
                    
                    new selectEventType(selectedDate).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(calendarPane.this, "Por favor, selecione uma data.", "Data não selecionada", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // Configuração do layout do painel
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(calendar, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectDateButton)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(calendar, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectDateButton))
                .addContainerGap(15, Short.MAX_VALUE))
        );
    }
}
