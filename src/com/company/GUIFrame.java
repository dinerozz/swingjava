package com.company;

import javax.swing.*; // импортируем библиотеки и эвенты из swing
import java.awt.*; // импортируем всё из awt
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; // слушатель действий
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import static java.lang.Thread.sleep;

public class GUIFrame{
    public static void main(String[] args) {
        new GUIFrame(); // метод main, создаем новый фрейм
    }

    private JPanel rootPanel; // Основная панель
    private JButton calculateButton; // Кнопка расчета
    private JLabel amplitudeLabel; // текст для амплитуды
    private JTextField AmplitudeTextField; // текстовое поле для ввода амплитуды
    private JCheckBox themeStateCheckBox; // чекбокс для смены цветовой схемы
    private JLabel periodLabel;
    private JTextField PeriodTextField; // текстовое поле для ввода периода
    private JTextField SpeedTextField;// текстовое поле для ввода скорости
    private JLabel speedLabel;
    private JLabel distanceLabel;
    private JTextField DistanceTextField; // текстовое поле для ввода расстояния
    private JLabel resultLabel;
    private JTextArea resultTextArea; // текстовое поле для вывода результатов
    private final double pi = Math.acos(-1); // Константа числа ПИ (расчитываем через arccos(-1)
    private double A, T, L, c, x; // Объявляем аргументы уравнения: амплитуда, период, расстояние, скорость, смещение

    public GUIFrame() {
        JFrame frame = new JFrame(); // создаем объект фрейм
        frame.setContentPane(rootPanel); // устанавливаем главное окно
        setLightTheme(); // применяем по умолчанию светлую тему, вызывая метод setLightTheme
        frame.setVisible(true); // устанавливаем видимость true
        frame.setBounds(750, 250, 500, 600); // устанавливаем пропорции и положение на экране
        frame.setTitle("point displacement"); // задаем заголовок
        calculateButton.addActionListener(new ActionListener() { // добавляем слушатель событий
            @Override
            public void actionPerformed(ActionEvent e) { // при нажатии на кнопку calculate, выполняем следующий код:
                String getAmplitude = AmplitudeTextField.getText();
                A = Double.parseDouble(getAmplitude); // считываем значение с textField и присваиваем его соответствующей переменной
                String getPeriod = PeriodTextField.getText();
                T = Double.parseDouble(getPeriod); // считываем значение с textField и присваиваем его соответствующей переменной
                String getSpeed = SpeedTextField.getText();
                c = Double.parseDouble(getSpeed); // считываем значение с textField и присваиваем его соответствующей переменной
                String getDistance = DistanceTextField.getText();
                L = Double.parseDouble(getDistance); // считываем значение с textField и присваиваем его соответствующей переменной
                System.out.println("[================DEBUG================]");
                for(float t = 0; t <= 10; t += 0.5){ // цикл с параметром t, который является изменением времени от 0 до 10 секунд, с шагом 0.5
                    x = A * (Math.cos(((2 * pi) / T) * (t - (L / c)))); // уравнение смещения
                    System.out.println("Смещение точки при t = " + t + " равно:  " + x + "\n"); // вывод результата с шагом t = 0.5 секунд
                    resultTextArea.append("Смещение точки при t = " + t + " равно: " + x + "\n"); // выводим результат в поле textArea
                }
                System.out.println("[================DEBUG================]");
            }
        });
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        themeStateCheckBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == 1){
                    setDarkTheme(); // устанавливаем темную тему, если чекбокс активен
                }else{
                    setLightTheme(); // иначе светлую тему
                }
            }
        });
    }
    public void setDarkTheme(){ // значения цветов элеметнов для темной темы
        rootPanel.setBackground(new java.awt.Color(34, 34, 38));
        amplitudeLabel.setForeground(new java.awt.Color(255, 255, 255));
        periodLabel.setForeground(new java.awt.Color(255, 255, 255));
        speedLabel.setForeground(new java.awt.Color(255, 255, 255));
        distanceLabel.setForeground(new java.awt.Color(255, 255, 255));
        resultLabel.setForeground(new java.awt.Color(255, 255, 255));
    }
    public void setLightTheme(){ // значения цветов элеметнов для светлой темы
        rootPanel.setBackground(new java.awt.Color(255,255,255));
        amplitudeLabel.setForeground(new java.awt.Color(0,0,0));
        periodLabel.setForeground(new java.awt.Color(0, 0, 0));
        speedLabel.setForeground(new java.awt.Color(0, 0, 0));
        distanceLabel.setForeground(new java.awt.Color(0, 0, 0));
        resultLabel.setForeground(new java.awt.Color(0, 0, 0));
    }
}

