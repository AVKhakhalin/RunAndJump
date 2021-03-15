package RunAndJump;

import javax.swing.*; // импортируем весь свинг, дабы не заморачиваться(мы ведь только учимся))
import java.awt.*; // и весь авт аналогично
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import java.awt.Font;
import java.awt.event.*;
import java.awt.FlowLayout;

public class DialogWindow
{
    int sizeWidth;
    int sizeHeight;
    int centerLocation_x;
    int centerLocation_y;

    public JTextField textField_3;
    public JTextField textField_4;

    DialogWindow (int _sizeWidth, int _sizeHeight)
    {
        this.sizeWidth = _sizeWidth;
        this.sizeHeight = _sizeHeight;
    }

    public JPanel createContentPane ()
    {
        // Создаём панель
        JPanel totalGUI = new JPanel();
        totalGUI.setBackground(new Color(200, 203, 255)); // смена фона окна
        totalGUI.setLayout(null);

//        JFrame frame = new JFrame();
//        frame.setBounds(locationX, locationY, sizeWidth, sizeHeight);
//        frame.setVisible(true);

        // Добавляем текст в окно
        JLabel blueLabel = new JLabel("<html><font face=\"MyFont, Verdana, Arial\", size=\"5\"><br>" +
                "Домашнее задание включало в себя следующее:<br>" +
                "1. Создать 2 текстовых файла, примерно по 50-100 символов в каждом (особого значения не имеет).<br><br>" +
                "2. Написать метод, «склеивающий» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.<br><br>" +
                "3. * Написать метод, который проверяет присутствует ли указанное пользователем слово в файле (работаем только с латиницей).<br><br>" +
                "4. ** Написать метод, проверяющий, есть ли указанное слово в папке.<br><br><br>" +
                "5. Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса. Эти классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в консоль).<br><br>" +
                "6. Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники должны выполнять соответствующие действия (бежать или прыгать), результат выполнения печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).<br><br><br>" +
                "7. Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.<br><br>" +
                "8. * У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения на бег и прыжки. Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.</html>");
        blueLabel.setLocation(30, 0); // координаты текста
        blueLabel.setSize(sizeWidth - 70, sizeHeight - 100); // размер области с текстом
        blueLabel.setVerticalAlignment(1);
        blueLabel.setHorizontalAlignment(0);
        blueLabel.setForeground(Color.BLACK); // Цвет текста
        totalGUI.add(blueLabel);

        // Создание кнопки для задания №1
        JButton task_1_button = new JButton("Проверить задание");
        task_1_button.setToolTipText("Нажмите для проверки задания №1");
        task_1_button.setLocation(700, 80); // это координаты кнопки
        task_1_button.setSize(150,40 ); // это размер кнопки
        totalGUI.add(task_1_button);
        ActionListener actionListener1 = new TestActionListener(1); // Подключение обработчика событий к кнопке
        task_1_button.addActionListener(actionListener1);

        // Создание кнопки для задания №2
        JButton task_2_button = new JButton("Проверить задание");
        task_2_button.setToolTipText("Нажмите для проверки задания №2");
        task_2_button.setLocation(700, 150); // это координаты кнопки
        task_2_button.setSize(150,40 ); // это размер кнопки
        totalGUI.add(task_2_button);
        ActionListener actionListener2 = new TestActionListener(2); // Подключение обработчика событий к кнопке
        task_2_button.addActionListener(actionListener2);

        // Создание кнопки для задания №3
        JButton task_3_button = new JButton("Проверить задание");
        task_3_button.setToolTipText("Нажмите для проверки задания №3");
        task_3_button.setLocation(700, 220); // это координаты кнопки
        task_3_button.setSize(150,40 ); // это размер кнопки
        totalGUI.add(task_3_button);
        ActionListener actionListener3 = new TestActionListener(3); // Подключение обработчика событий к кнопке
        task_3_button.addActionListener(actionListener3);

        // Создание текстового поля для ввода слова для задания №3
        textField_3 = new JTextField(15);
        textField_3.setToolTipText("<html>Введите слово для поиска в задании №3<br>и нажмите соответствующую кнопку<br>\"Проверить задание\"</html>");
        textField_3.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,16));
        textField_3.setBounds(500, 220, 160, 30);
        totalGUI.add(textField_3);

        // Создание кнопки для задания №4
        JButton task_4_button = new JButton("Проверить задание");
        task_4_button.setToolTipText("Нажмите для проверки задания №4");
        task_4_button.setLocation(700, 290); // это координаты кнопки
        task_4_button.setSize(150,40 ); // это размер кнопки
        totalGUI.add(task_4_button);
        ActionListener actionListener4 = new TestActionListener(4); // Подключение обработчика событий к кнопке
        task_4_button.addActionListener(actionListener4);

        // Создание текстового поля для ввода слова для задания №4
        textField_4 = new JTextField(15);
        textField_4.setToolTipText("<html>Введите слово для поиска в задании №3<br>и нажмите соответствующую кнопку<br>\"Проверить задание\"</html>");
        textField_4.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,16));
        textField_4.setBounds(500, 291, 160, 30);
        totalGUI.add(textField_4);

        // Создание кнопки для задания №5
        JButton task_5_button = new JButton("Проверить задание");
        task_5_button.setToolTipText("Нажмите для проверки задания №5");
        task_5_button.setLocation(700, 390); // это координаты кнопки
        task_5_button.setSize(150,40 ); // это размер кнопки
        totalGUI.add(task_5_button);
        ActionListener actionListener5 = new TestActionListener(5); // Подключение обработчика событий к кнопке
        task_5_button.addActionListener(actionListener5);

        // Создание кнопки для задания №6
        JButton task_6_button = new JButton("Проверить задание");
        task_6_button.setToolTipText("Нажмите для проверки задания №6");
        task_6_button.setLocation(700, 510); // это координаты кнопки
        task_6_button.setSize(150,40 ); // это размер кнопки
        totalGUI.add(task_6_button);
        ActionListener actionListener6 = new TestActionListener(6); // Подключение обработчика событий к кнопке
        task_6_button.addActionListener(actionListener6);

        // Создание кнопки для задания №7
        JButton task_7_button = new JButton("Проверить задание");
        task_7_button.setToolTipText("Нажмите для проверки задания №7");
        task_7_button.setLocation(700, 580); // это координаты кнопки
        task_7_button.setSize(150,40 ); // это размер кнопки
        totalGUI.add(task_7_button);
        ActionListener actionListener7 = new TestActionListener(7); // Подключение обработчика событий к кнопке
        task_7_button.addActionListener(actionListener7);

        // Создание кнопки для задания №8
        JButton task_8_button = new JButton("Проверить задание");
        task_8_button.setToolTipText("Нажмите для проверки задания №8");
        task_8_button.setLocation(700, 680); // это координаты кнопки
        task_8_button.setSize(150,40 ); // это размер кнопки
        totalGUI.add(task_8_button);
        ActionListener actionListener8 = new TestActionListener(8); // Подключение обработчика событий к кнопке
        task_8_button.addActionListener(actionListener8);

        // Создание кнопки для выхода из программы
        JButton task_EXIT_button = new JButton("Выйти из программы");
        task_EXIT_button.setToolTipText("Нажмите для выхода из программы");
        task_EXIT_button.setLocation((int) (sizeWidth / 2 - 80), sizeHeight - 98); // это координаты кнопки
        task_EXIT_button.setSize(160,40 ); // это размер кнопки
        totalGUI.add(task_EXIT_button);
        ActionListener actionListener_EXIT = new TestActionListener(0); // Подключение обработчика событий к кнопке
        task_EXIT_button.addActionListener(actionListener_EXIT);

        totalGUI.setOpaque(true);
        return totalGUI;
    }

    // Обработка событий при нажатии на левую кнопку мыши
    public class TestActionListener implements ActionListener
    {
        int taskNumber = 0;

        TestActionListener (int _taskNumber)
        {
            this.taskNumber = _taskNumber;
        }

        public void actionPerformed(ActionEvent e)
        {
            String message;
            File newDirectory;
            switch (taskNumber)
            {
                case 1:
                    message = "<html><font face=\"MyFont, Verdana, Arial\", size=\"4\">Выберите директорию, в которой появятся два созданных файла.</html>";
                    if (directoryChooser(message) == true)
                    {
                        newDirectory = new File(MyData.path);
                        if ((MyData.path!="") && (newDirectory.isDirectory() == true))
                        {
                            SolveTask1 solveTask = new SolveTask1(MyData.path, 1);
                            solveTask = new SolveTask1(MyData.path, 2);
                            solveTask = null;
                            JOptionPane.showMessageDialog(new JFrame(), "<html><font face=\"MyFont, Verdana, Arial\", size=\"4\">В директории<br>" + MyData.path + "<br>созданы 2 файла: task1_file1.txt и task1_file2.txt</html>", "ИНФОРМАЦИЯ", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else
                        {
                            message = "Нужно выбрать папку. Пожалуйста, нажмите на кнопку \"Проверить задание\".";
                            JOptionPane.showMessageDialog(new JFrame(), message, "ОШИБКА", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    break;
                case 2:
                    message = "<html><font face=\"MyFont, Verdana, Arial\", size=\"4\">Выберите директорию, в которой появится файл с общей информацией.</html>";
                    if (directoryChooser(message) == true)
                    {
                        newDirectory = new File(MyData.path);
                        if ((MyData.path!="") && (newDirectory.isDirectory() == true))
                        {
                            SolveTask2 solveTask2 = new SolveTask2(MyData.path);
                            solveTask2 = null;
                            JOptionPane.showMessageDialog(new JFrame(), "<html><font face=\"MyFont, Verdana, Arial\", size=\"4\">В директории<br>" + MyData.path + "<br>создан файл unionInformation.txt с информацией из файлов: task1_file1.txt и task1_file1.txt</html>", "ИНФОРМАЦИЯ", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else
                        {
                            message = "Нужно выбрать папку. Пожалуйста, нажмите на кнопку \"Проверить задание\".";
                            JOptionPane.showMessageDialog(new JFrame(), message, "ОШИБКА", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    break;
                case 3:
                    message = "<html><font face=\"MyFont, Verdana, Arial\", size=\"4\">Выберите файл, в котором нужно произвести поиск слова " + textField_3.getText() + ".</html>";
                    if (directoryChooser(message) == true)
                    {
                        newDirectory = new File(MyData.path);
                        if ((MyData.path!="") && (newDirectory.isDirectory() == true))
                        {
                            SolveTask3 solveTask3 = new SolveTask3(MyData.path);
                            solveTask3 = null;
//                            JOptionPane.showMessageDialog(new JFrame(), "<html><font face=\"MyFont, Verdana, Arial\", size=\"4\">В директории<br>" + MyData.path + "<br>создан файл unionInformation.txt с информацией из файлов: task1_file1.txt и task1_file1.txt</html>", "ИНФОРМАЦИЯ", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else
                        {
                            message = "Нужно выбрать папку. Пожалуйста, нажмите на кнопку \"Проверить задание\".";
                            JOptionPane.showMessageDialog(new JFrame(), message, "ОШИБКА", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    break;
                case 4:
                    message = "<html><font face=\"MyFont, Verdana, Arial\", size=\"4\">Выберите директорию, в которой нужно произвести поиск слова " + textField_4.getText() + ".</html>";
                    if (directoryChooser(message) == true)
                    {
                        newDirectory = new File(MyData.path);
                        if ((MyData.path!="") && (newDirectory.isDirectory() == true))
                        {
                            SolveTask4 solveTask4 = new SolveTask4(MyData.path);
                            solveTask4 = null;
//                            JOptionPane.showMessageDialog(new JFrame(), "<html><font face=\"MyFont, Verdana, Arial\", size=\"4\">В директории<br>" + MyData.path + "<br>создан файл unionInformation.txt с информацией из файлов: task1_file1.txt и task1_file1.txt</html>", "ИНФОРМАЦИЯ", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else
                        {
                            message = "Нужно выбрать папку. Пожалуйста, нажмите на кнопку \"Проверить задание\".";
                            JOptionPane.showMessageDialog(new JFrame(), message, "ОШИБКА", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }

        public boolean directoryChooser(String message)
        {
            JOptionPane.showMessageDialog(new JFrame(), message, "ИНФОРМАЦИЯ", JOptionPane.INFORMATION_MESSAGE);
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new java.io.File("."));
            chooser.setDialogTitle("Укажите директорию");
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chooser.setAcceptAllFileFilterUsed(false);
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                System.out.println("Текущая директория: " + chooser.getSelectedFile());
//                        MyData.path = "" + chooser.getCurrentDirectory(); // отслеживаем выбор выше стоящей директории
                MyData.path = "" + chooser.getSelectedFile(); // отслеживаем выбор текущей директории
//                System.out.println("Выбран текущий файл: " + chooser.getSelectedFile());
//                MyData.path = "" + chooser.getSelectedFile(); // отслеживаем выбор файла
                return true;
            }
            else
            {
                System.out.println("Выбор не сделан. Попробуйте ещё раз, нажав на кнопку \nПроверить задание\"");
                return false;
            }
        }
    }
}
