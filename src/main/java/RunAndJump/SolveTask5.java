package RunAndJump;

import javax.swing.*;

public class SolveTask5
{
    SolveTask5()
    {
        Cat newCat = new Cat(5);
        Human newHuman = new Human(5);
        Robot newRobot = new Robot(5);
        System.out.println("Созданы три класса Человек (может пробежать до 200 метров и прыгнуть до 2 метров),\nКот (может пробежать до 300 метров и прыгнуть до 2,5 метров),\nРобот (может пробежать до 1500 метров и прыгнуть до 5 метров), которые не наследуются от одного класса.");
        JOptionPane.showMessageDialog(new JFrame(), "<html><font face=\"MyFont, Verdana, Arial\", size=\"4\">Созданы три класса Человек (может пробежать до 200 метров и прыгнуть до 2 метров),<br>Кот (может пробежать до 300 метров и прыгнуть до 2,5 метров),<br>Робот (может пробежать до 1500 метров и прыгнуть до 5 метров), которые не наследуются от одного класса.</html>", "ИНФОРМАЦИЯ", JOptionPane.INFORMATION_MESSAGE);

        newHuman.runSolveTask5();
        newHuman.jumpSolveTask5();
        newCat.runSolveTask5();
        newCat.jumpSolveTask5();
        newRobot.runSolveTask5();
        newRobot.jumpSolveTask5();
    }
}
