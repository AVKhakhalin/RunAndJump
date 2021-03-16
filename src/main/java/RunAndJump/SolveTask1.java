package RunAndJump;

import javax.swing.*;
import java.io.*;

public class SolveTask1
{
    String dirPath;
    int numberFile;
    String[] strForFile = {"Анна Андреевна Ахматова \"Новогодняя баллада\"\n" +
            "И месяц, скучая в облачной мгле,\n" +
            "Бросил в горницу тусклый взор.\n" +
            "Там шесть приборов стоят на столе,\n" +
            "И один только пуст прибор.\n" +
            "Это муж мой, и я, и друзья мои,\n" +
            "Мы Новый встречаем год,\n" +
            "Отчего мои пальцы словно в крови\n" +
            "И вино, как отрава, жжет?\n" +
            "\n" +
            "Хозяин, поднявши первый стакан,\n" +
            "Был важен и недвижим:\n" +
            "«Я пью за землю родных полян,\n" +
            "В которой мы все лежим»,\n" +
            "\n" +
            "А друг, поглядевши в лицо мое\n" +
            "И вспомнив Бог весть о чем,\n" +
            "Воскликнул: «А я за песни ее,\n" +
            "В которых мы все живем».\n" +
            "\n" +
            "Но третий, не знавший ничего,\n" +
            "Когда он покинул свет,\n" +
            "Мыслям моим в ответ\n" +
            "Промолвил: «Мы выпить должны за того,\n" +
            "Кого еще с нами нет».\n\n",

            "Anna Andreevna Akhmatova \"Escape\" June 1914\n" +
            "My dear, if we could only\n" +
            "Reach all the way to the seas\n" +
            "\"Be quiet\" and descended the stairs\n" +
            "Losing breath and looking for keys.\n" +

            "Past the buildings, where sometime\n" +
            "We danced and had fun and drank wine\n" +
            "Past the white columns of Senate\n" +
            "Where it's dark, dark again.\n" +

            "What are you doing, you madman!\n" +
            "No, I am only in love with thee!\n" +
            "This evening is wide and noisy,\n" +
            "Ship will have lots of fun at the sea!\n" +

            "Horror tightly clutches the throat,\n" +
            "Shuttle took us at dusk on our turn..\n" +
            "The tough smell of ocean tightrope\n" +
            "Inside trembling nostrils did burn.\n" +

            "Say, you most probably know:\n" +
            "I don't sleep? Thus in sleep it can be\n" +
            "Only oars splashed in measured manner\n" +
            "Over Nieva's waves heavy.\n" +

            "And the black sky began to get lighter,\n" +
            "Someone called from the bridge to us,\n" +
            "As with both hands I was clutching\n" +
            "On my chest the rim of the cross.\n" +

            "On your arms, as I lost all my power,\n" +
            "Like a little girl you carried me,\n" +
            "That on deck of a yacht alabaster\n" +
            "Incorruptible day's light we'd meet\n\n"};

    SolveTask1(String _dirPath, int _numberFile)
    {
        this.dirPath = _dirPath;
        this.numberFile = _numberFile;

        File file = new File(dirPath);
        FileOutputStream fileOutputStream;
        if (!file.exists())
        {
            JOptionPane.showMessageDialog(new JFrame(), "Директория не существует. Пожалуйста, укажите существующую директорию.", "ОШИБКА", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            try
            {
                fileOutputStream = new FileOutputStream(dirPath + "\\task1_file" + numberFile + ".txt");
                byte[] buf = (strForFile[numberFile - 1]).getBytes("UTF-8");
                fileOutputStream.write(buf, 0, buf.length);
                fileOutputStream.close(); // закрыть поток
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(new JFrame(), "Невозможно создать файл " + (dirPath + "\\task1_file" + numberFile + ".txt") + ".", "ОШИБКА", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
