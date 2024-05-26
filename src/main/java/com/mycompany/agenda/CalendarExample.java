package com.mycompany.agenda;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class CalendarExample extends JFrame {
    private JPanel calendarPanel;
    private JLabel monthLabel;
    private JButton prevButton;
    private JButton nextButton;
    private Calendar calendar;
    private HashMap<String, ArrayList<String>> appointments; // Armazena compromissos

    public CalendarExample() {
        calendar = new GregorianCalendar();
        appointments = new HashMap<>();

        setTitle("Calendário");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Compromissos");
        JMenuItem listMenuItem = new JMenuItem("Listar Compromissos");
        JMenuItem addMenuItem = new JMenuItem("Adicionar Compromisso");
        menu.add(listMenuItem);
        menu.add(addMenuItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        listMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listAppointments();
            }
        });

        addMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addAppointment();
            }
        });

        monthLabel = new JLabel("", JLabel.CENTER);
        prevButton = new JButton("<");
        nextButton = new JButton(">");

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BorderLayout());
        headerPanel.add(prevButton, BorderLayout.WEST);
        headerPanel.add(monthLabel, BorderLayout.CENTER);
        headerPanel.add(nextButton, BorderLayout.EAST);

        calendarPanel = new JPanel();
        calendarPanel.setLayout(new GridLayout(0, 7));

        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calendar.add(Calendar.MONTH, -1);
                updateCalendar();
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calendar.add(Calendar.MONTH, 1);
                updateCalendar();
            }
        });

        add(headerPanel, BorderLayout.NORTH);
        add(calendarPanel, BorderLayout.CENTER);

        updateCalendar();
    }

    private void updateCalendar() {
        calendarPanel.removeAll();

        // Definir o título do mês
        monthLabel.setText(calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, getLocale()) + " " + calendar.get(Calendar.YEAR));

        // Cabeçalhos dos dias da semana
        String[] days = {"Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sáb"};
        for (String day : days) {
            calendarPanel.add(new JLabel(day, JLabel.CENTER));
        }

        // Dias do mês
        Calendar tempCalendar = (Calendar) calendar.clone();
        tempCalendar.set(Calendar.DAY_OF_MONTH, 1);
        int firstDayOfWeek = tempCalendar.get(Calendar.DAY_OF_WEEK) - 1;
        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        // Preencher os dias vazios antes do primeiro dia do mês
        for (int i = 0; i < firstDayOfWeek; i++) {
            calendarPanel.add(new JLabel(""));
        }

        // Preencher os dias do mês
        for (int day = 1; day <= daysInMonth; day++) {
            final int currentDay = day;  // Variável final ou efetivamente final
            JButton dayButton = new JButton(String.valueOf(day));
            String date = currentDay + "/" + (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.YEAR);
            if (appointments.containsKey(date)) {
                dayButton.setBackground(Color.CYAN);
            }

            dayButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String selectedDate = currentDay + "/" + (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.YEAR);
                    String appointment = JOptionPane.showInputDialog("Adicionar compromisso para " + selectedDate + ":");
                    if (appointment != null && !appointment.trim().isEmpty()) {
                        addAppointmentToDate(selectedDate, appointment);
                    }
                }
            });
            calendarPanel.add(dayButton);
        }

        calendarPanel.revalidate();
        calendarPanel.repaint();
    }

    private void addAppointmentToDate(String date, String appointment) {
        appointments.computeIfAbsent(date, k -> new ArrayList<>()).add(appointment);
        updateCalendar();
    }

    private void listAppointments() {
        StringBuilder message = new StringBuilder("Compromissos:\n");
        for (String date : appointments.keySet()) {
            message.append(date).append(":\n");
            for (String appointment : appointments.get(date)) {
                message.append(" - ").append(appointment).append("\n");
            }
        }
        JOptionPane.showMessageDialog(this, message.length() > 12 ? message.toString() : "Nenhum compromisso agendado.");
    }

    private void addAppointment() {
        String date = JOptionPane.showInputDialog("Digite a data (dd/MM/yyyy):");
        if (date != null && !date.trim().isEmpty()) {
            String appointment = JOptionPane.showInputDialog("Digite o compromisso:");
            if (appointment != null && !appointment.trim().isEmpty()) {
                addAppointmentToDate(date, appointment);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CalendarExample frame = new CalendarExample();
                frame.setVisible(true);
            }
        });
    }
}
/*

 */