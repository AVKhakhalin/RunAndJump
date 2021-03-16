package RunAndJump;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;

public class SolveTask4
{
    String dirPath;

    SolveTask4(String _dirPath)
    {
        this.dirPath = _dirPath;

        String separators = "[ ,.!?;:\\-+_#*/\"]";
        File checkDir = new File(dirPath);
        if (!checkDir.exists())
        {
            JOptionPane.showMessageDialog(new JFrame(), "Директория не существует. Пожалуйста, укажите существующую директорию.", "ОШИБКА!", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            // Поиск в директории всех файлов
            File curDir = new File(dirPath);
            File[] existFiles = readFilesFromDir(curDir, false);
            // Считывание информации из файла
/*            try (FileInputStream fileReader = new FileInputStream(filePath))
            {
                byte[] buffer = new byte[fileReader.available()];
                fileReader.read(buffer, 0, buffer.length);
                String fullBuffer = new String(buffer);
                String[] fileWords = fullBuffer.split(separators);
                String result = "";
                int numberFoundedWords = 0;
                for (int i = 0; i < fileWords.length; i++)
                {
                    System.out.println(fileWords[i]);
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
                    System.out.println("В файле " + filePath + "\nнет слова " + wordToSearch + ".");
                    JOptionPane.showMessageDialog(new JFrame(),"В файле " + filePath + "\nнет слова " + wordToSearch + ".", "ИНФОРМАЦИЯ", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    System.out.println("В файле " + filePath + "\nслово " + wordToSearch + " присутствует " + (numberFoundedWords == 1 ? "на позиции " : "на позициях: ") + result + ".");
                    JOptionPane.showMessageDialog(new JFrame(),"В файле " + filePath + "\nслово " + wordToSearch + " присутствует " + (numberFoundedWords == 1 ? "на позиции " : "на позициях: ") + result + ".", "ИНФОРМАЦИЯ", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(new JFrame(), "Невозможно открыть файл " + filePath + ".", "ОШИБКА", JOptionPane.ERROR_MESSAGE);
            }

 */
        }
    }

    public File[] readFilesFromDir(File dir, boolean lastDirectory)
    {
        File[] tempListFiles = null;
        File[] allFoundedFiles = null;

        File[] files = dir.listFiles();
        if (files == null)
        {
            return null;
        }

        int subDirTotal = 0;
        for (int i = 0; i < files.length; i++)
        {
            if (files[i].isDirectory() == true)
            {
                subDirTotal++;
            }
            else
            {

            }
        }

        int subDirCounter = 0;

        for (int i = 0; i < files.length; i++)
        {
            if (files[i].isDirectory() == true)
            {
                subDirCounter++;
                readFilesFromDir(files[i], subDirTotal == subDirCounter);
            }
        }

        return allFoundedFiles;
    }
}
