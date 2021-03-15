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
            "Кого еще с нами нет».",

            "Анна Андреевна Ахматова \"Памяти 19 июля 1914\"\n" +
            "Тогда случилось в час один:\n" +
            "Короткое уже кончалось лето,\n" +
            "Дымилось тело вспаханных равнин.\n" +
            "\n" +
            "Вдруг запестрела тихая дорога,\n" +
            "Плач полетел, серебряно звеня…\n" +
            "Закрыв лицо, я умоляла Бога\n" +
            "До первой битвы умертвить меня.\n" +
            "\n" +
            "Из памяти, как груз отныне лишний,\n" +
            "Исчезли тени песен и страстей.\n" +
            "Ей — опустевшей — приказал Всевышний\n" +
            "Стать страшной книгой грозовых вестей."};

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
