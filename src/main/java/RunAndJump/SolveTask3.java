package RunAndJump;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class SolveTask3
{
    String filePath;
    String wordToSearch;

    SolveTask3(String _filePath, String _wordToSearch)
    {
        this.filePath = _filePath;
        this.wordToSearch = _wordToSearch;

        if ((wordToSearch == null) || (wordToSearch.isEmpty() == true))
        {
            System.out.println("ОШИБКА: Слово для поиска не задано. Нужно обязательно ввести слово для поиска. Попробуйте ещё раз.");
            JOptionPane.showMessageDialog(new JFrame(), "Слово для поиска не задано. Нужно обязательно ввести слово для поиска. Попробуйте ещё раз.", "ОШИБКА!", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            File file = new File(filePath);
            if (!file.exists())
            {
                System.out.println("ОШИБКА: Файл не существует. Пожалуйста, укажите существующий файл.");
                JOptionPane.showMessageDialog(new JFrame(), "Файл не существует. Пожалуйста, укажите существующий файл.", "ОШИБКА!", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                // Считывание информации из файла
                try (FileInputStream fileReader = new FileInputStream(filePath))
                {
                    String separators = "[ ,.!?;:\\-+_#*/\"«»<>{}]";
                    byte[] buffer = new byte[fileReader.available()];
                    fileReader.read(buffer, 0, buffer.length);
                    String fullBuffer = new String(buffer);
                    String[] fileWords = fullBuffer.split(separators);
                    String result = "";
                    int numberFoundedWords = 0;
                    for (int i = 0; i < fileWords.length; i++)
                    {
                        if (fileWords[i].equals(wordToSearch) == true)
                        {
                            if (result.length() == 0)
                            {
                                result += (i + 1);
                                numberFoundedWords++;
                            }
                            else
                            {
                                result += "," + (i + 1);
                                numberFoundedWords++;
                            }
                        }
                    }
                    if (result.length() == 0)
                    {
                        System.out.println("В файле " + filePath + "\nнет слова \"" + wordToSearch + "\".");
                        JOptionPane.showMessageDialog(new JFrame(),"В файле " + filePath + "\nнет слова \"" + wordToSearch + "\".", "ИНФОРМАЦИЯ", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else
                    {
                        System.out.println("В файле " + filePath + "\nслово \"" + wordToSearch + "\" присутствует " + (numberFoundedWords == 1 ? "на позиции " : "на позициях: ") + result + ".");
                        JOptionPane.showMessageDialog(new JFrame(),"В файле " + filePath + "\nслово " + wordToSearch + " присутствует " + (numberFoundedWords == 1 ? "на позиции " : "на позициях: ") + result + ".", "ИНФОРМАЦИЯ", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage());
                    JOptionPane.showMessageDialog(new JFrame(), "Невозможно открыть файл " + filePath + ".", "ОШИБКА", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
