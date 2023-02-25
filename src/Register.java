import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Register extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JLabel age;
    private JTextField textField4;
    private JComboBox comboBox1;
    private JCheckBox свойВариантCheckBox;
    private JTextField textField5;
    private JComboBox comboBox2;
    private JCheckBox свойВариантCheckBox1;
    private JTextField textField6;
    private JSlider slider1;
    private JList list1;
    private JCheckBox другоеCheckBox;
    private JTextField textField7;
    private JTextArea textArea1;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    ButtonGroup bg = new ButtonGroup();

    public Register() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        bg.add(radioButton1);
        bg.add(radioButton2);
        textField5.setEnabled(false);
        textField6.setEnabled(false);
        textField7.setEnabled(false);

        свойВариантCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == 1) {
                    comboBox1.setEnabled(false);
                    textField5.setEnabled(true);
                }
                else {
                    comboBox1.setEnabled(true);
                    textField5.setEnabled(false);
                }
            }
        });

        свойВариантCheckBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == 1) {
                    comboBox2.setEnabled(false);
                    textField6.setEnabled(true);
                }
                else {
                    comboBox2.setEnabled(true);
                    textField6.setEnabled(false);
                }
            }
        });
        другоеCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                if (itemEvent.getStateChange() == 1)
                    textField7.setEnabled(true);
                else
                    textField7.setEnabled(false);
            }
        });
        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String summary = "";
                summary = "фамилия: " + textField1.getText() + "\n" +
                        "Имя: " + textField2.getText() + "\n" +
                        "Отчество: " + textField2.getText() + "\n" +
                        "Возраст: " + textField3.getText() + "\n" +
                        "Пол: " + (radioButton1.isSelected()?"Мужской":radioButton2.isSelected()?"Женский":"Не определён") + "\n" +
                        "Цвет волос: " + (textField5.isEnabled()?textField5.getText():(comboBox1.getSelectedItem())) + "\n" +
                        "Цвет глаз: " + (textField6.isEnabled()?textField6.getText():comboBox2.getSelectedItem()) + "\n" +
                        "Рост: " + slider1.getValue() + "\n" +
                        "Увлечения: ";
                for (int i = 0; i < list1.getSelectedValuesList().size(); i++) {
                    summary += list1.getSelectedValuesList().get(i);
                    if (i < list1.getSelectedValuesList().size()-1)
                        summary += ", ";
                }
                if (textField7.isEnabled())
                    summary += ", " + textField7.getText();
                summary += "\n" + "О себе: \n" + textArea1.getText();
                JOptionPane.showMessageDialog(contentPane, summary, "Регистрация", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        Register dialog = new Register();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
