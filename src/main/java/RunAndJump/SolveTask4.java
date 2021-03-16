package RunAndJump;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;

public class SolveTask4
{
    String dirPath;
    String wordToSearch;

    SolveTask4(String _dirPath, String _wordToSearch)
    {
        this.dirPath = _dirPath;
        this.wordToSearch = _wordToSearch;

        String separators = "[ ,.!?;:\\-+_#*/\"«»<>{}]";
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

            // Считывание информации из найденных файлов
            byte[] buffer;
            String result;
            String[] fileWords;
            String fullBuffer;
            String otchet = "";
            int numberFoundedWords;
            int numberFoundedFilesWithWord = 0;
            if (existFiles != null)
            {
                for (File curFile : existFiles)
                {
                    try (FileInputStream fileReader = new FileInputStream(curFile))
                    {
                        buffer = new byte[fileReader.available()];
                        fileReader.read(buffer, 0, buffer.length);
                        fullBuffer = new String(buffer);
                        fileWords = fullBuffer.split(separators);
                        result = "";
                        numberFoundedWords = 0;
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
                        if ((result.length() != 0) && (otchet.length() == 0))
                        {
                            numberFoundedFilesWithWord++;
                            otchet = "В директории " + dirPath + "\nнайдены следующие файлы со словом " + wordToSearch + ":";
                            otchet += "\n" + numberFoundedFilesWithWord + ". В файле " + curFile.getAbsolutePath() + " слово \"" + wordToSearch + "\" присутствует " + (numberFoundedWords == 1 ? "на позиции " : "на позициях: ") + result + ".";
                        }
                        else if (result.length() != 0)
                        {
                            numberFoundedFilesWithWord++;
                            otchet += "\n" + numberFoundedFilesWithWord + ". В файле " + curFile.getAbsolutePath() + " слово \"" + wordToSearch + "\" присутствует " + (numberFoundedWords == 1 ? "на позиции " : "на позициях: ") + result + ".";
                        }
                    }
                    catch (Exception e)
                    {
                        System.out.println(e.getMessage());
                        JOptionPane.showMessageDialog(new JFrame(), "Невозможно открыть файл " + curFile + ".", "ОШИБКА", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
            if (otchet.length() == 0)
            {
                System.out.println("В директории " + dirPath + " нет файлов, содержащих слово \"" + wordToSearch + "\".");
                JOptionPane.showMessageDialog(new JFrame(), "В директории " + dirPath + " нет файлов, содержащих слово \"" + wordToSearch + "\".", "ИНФОРМАЦИЯ", JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                System.out.println(otchet);
                JOptionPane.showMessageDialog(new JFrame(), otchet, "ИНФОРМАЦИЯ", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public File[] readFilesFromDir(File dir, boolean lastDirectory)
    {
        int counter1;
        int counter2;
        int counter3;
        File[] tempListFiles = null;
        File[] allFoundedFiles = null;

        File[] files = dir.listFiles();
        if (files == null)
        {
            return null;
        }

        int subDirTotal = 0;
        for (counter1 = 0; counter1 < files.length; counter1++)
        {
            if (files[counter1].isDirectory() == true)
            {
                subDirTotal++;
            }
            else
            {
                // Получения списка файлов из текущей директории
                if (allFoundedFiles == null)
                {
                    counter3 = 0;
                }
                else
                {
                    counter3 = allFoundedFiles.length;
                }
                tempListFiles = new File[counter3 + 1];
                for (counter2 = 0; counter2 < counter3; counter2++)
                {
                    tempListFiles[counter2] = allFoundedFiles[counter2];
                }
                tempListFiles[counter3] = files[counter1];
                allFoundedFiles = null;
                allFoundedFiles = new File[counter2 + 1];
                for (counter2 = 0; counter2 < allFoundedFiles.length; counter2++)
                {
                    allFoundedFiles[counter2] = tempListFiles[counter2];
                }
            }
        }

        int subDirCounter = 0;

        for (int i = 0; i < files.length; i++)
        {
            if (files[i].isDirectory() == true)
            {
                subDirCounter++;
                File[] tempListSubdirFiles = readFilesFromDir(files[i], subDirTotal == subDirCounter);
                if (tempListSubdirFiles != null)
                {
                    if (allFoundedFiles == null)
                    {
                        counter3 = 0;
                    }
                    else
                    {
                        counter3 = allFoundedFiles.length;
                    }
                    tempListFiles = new File[counter3 + tempListSubdirFiles.length];
                    for (counter2 = 0; counter2 < counter3; counter2++)
                    {
                        tempListFiles[counter2] = allFoundedFiles[counter2];
                    }
                    for (counter1 = 0; counter1 < tempListSubdirFiles.length; counter1++)
                    {
                        tempListFiles[counter2++] = tempListSubdirFiles[counter1];
                    }
                    allFoundedFiles = null;
                    allFoundedFiles = new File[tempListFiles.length];
                    for (counter2 = 0; counter2 < allFoundedFiles.length; counter2++)
                    {
                        allFoundedFiles[counter2] = tempListFiles[counter2];
                    }
                }
            }
        }
        return allFoundedFiles;
    }
}
