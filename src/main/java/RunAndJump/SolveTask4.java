package RunAndJump;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class SolveTask4
{
    String dirPath;

    SolveTask4(String _dirPath)
    {
        this.dirPath = _dirPath;

        File file = new File(dirPath);
        SolveTask1 solveTask;
        if (!file.exists())
        {
            JOptionPane.showMessageDialog(new JFrame(), "Директория не существует. Пожалуйста, укажите существующую директорию.", "ОШИБКА!", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            for (int i = 1; i <= 2; i++)
            {
                file = new File(dirPath + "\\task1_file" + i + ".txt");
                if (!file.exists())
                {
                    solveTask = new SolveTask1(dirPath + "\\task1_file" + i + ".txt", i);
                }
            }
            // Проверка наличия файла unionInformation.txt в указанной папке. Если он есть, то удаляем его
            File fileDelete = new File(dirPath + "\\unionInformation.txt");
            if (fileDelete.exists())
            {
                if (fileDelete.delete())
                {
                    // Удаление файла успешно произведено
                }
                else
                {
                    System.out.println("В указанной директории уже существует файл \"unionInformation.txt\". Удалить его не получается.");
                    JOptionPane.showMessageDialog(new JFrame(), "В указанной директории уже существует файл unionInformation.txt. Удалить его не получается.", "ОШИБКА", JOptionPane.ERROR_MESSAGE);
                }
            }

            // Объединение информации в два файла
            for (int i = 1; i <= 2; i++)
            {
                try (FileOutputStream fileWriter = new FileOutputStream(dirPath + "\\unionInformation.txt", true); FileInputStream fileReader = new FileInputStream(dirPath + "\\task1_file" + i + ".txt"))
                {
                    byte[] buffer = new byte[fileReader.available()];
                    fileReader.read(buffer, 0, buffer.length);
                    fileWriter.write(buffer, 0, buffer.length);
                    fileReader.close();
                    fileWriter.close();
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage());
                    JOptionPane.showMessageDialog(new JFrame(), "Невозможно открыть файл " + (dirPath + "\\task1_file" + i + ".txt") + " или создать для записи файл " + (dirPath + "\\unionInformation.txt") + ".", "ОШИБКА", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
