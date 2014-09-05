package tsc.Functions;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Noctis on 23.07.2014.
 * Класс нужен для загрузки/создания файла конфигураций
 * в котором хранится IP и Port
 */
public class TSCConfig {

    private String IP;
    private int Port = 0;
    private String DefaultLanguage = "";
    private File ConfigFile = new File("Config.ini");
    private Scanner ConfigScanner;
    private PrintWriter ConfigWriter;
    private ArrayList<String> ConfigList = new ArrayList<String>();

    public TSCConfig(){
        //Попытка загрузить данные из файла, если попытка неудачная, файл удаляется и пересоздается
        ConfigCreate();
        try{
            ConfigScanner = new Scanner(ConfigFile);
            while(ConfigScanner.hasNextLine()) {
                ConfigList.add(ConfigScanner.nextLine());
            }
            ConfigScanner.close();
            if(!CheckConfigFile(ConfigList)){
                ConfigFile.delete();
                ConfigCreate();
            }
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null,"Failed reading file \"Config.ini\"");
        }
    }

    private void ConfigCreate(){
        //Создание файла конфигураций по заданному шаблону
        try {
            if (!ConfigFile.exists()) {
                ConfigFile.createNewFile();
                ConfigWriter = new PrintWriter(ConfigFile);
                ConfigWriter.println("IP = 127.0.0.1");
                ConfigWriter.println("Port = 3124");
                ConfigWriter.println("Language = English");
                ConfigWriter.flush();
            }
        }catch (IOException ex){
            JOptionPane.showMessageDialog(null,"Failed to create file \"Config.ini\"");
            return;
        }
    }
    //Функция служит для загрузки и одновременной проверки целостности файла,
    //если загруженая информация некорректна, то возвращает флаг неудачной загрузки
    private boolean CheckConfigFile(ArrayList<String> CheckList){
        boolean swc = false;
        String tmpString = "";
        for(int i = 0; i < CheckList.size();i++) {
            switch (i) {
                case 0:
                    if (CheckList.get(i).startsWith("IP")){
                        for(int j = 2; j<CheckList.get(i).length();j++) {
                            if(swc)
                                if(CheckList.get(i).charAt(j)!= ' ')
                                    tmpString+=CheckList.get(i).charAt(j);
                            if (CheckList.get(i).charAt(j) == '=')
                                swc = true;
                        }
                        if(tmpString.length()>=7)
                            IP = tmpString;
                        else
                            return false;
                        swc = false;
                        tmpString = "";
                    }
                case 1:
                    if (CheckList.get(i).startsWith("Port")){
                        for(int j = 4; j<CheckList.get(i).length();j++) {
                            if(swc)
                                if(CheckList.get(i).charAt(j)!= ' ')
                                    tmpString+=CheckList.get(i).charAt(j);
                            if (CheckList.get(i).charAt(j) == '=')
                                swc = true;
                        }
                        if(tmpString.length()>=1)
                            Port = Integer.decode(tmpString);
                        else
                            return false;
                        swc = false;
                    }
                case 2:
                    if (CheckList.get(i).startsWith("Language")){
                        for(int j = 8; j<CheckList.get(i).length();j++) {
                            if(swc)
                                if(CheckList.get(i).charAt(j)!= ' ')
                                    tmpString+=CheckList.get(i).charAt(j);
                            if (CheckList.get(i).charAt(j) == '=')
                                swc = true;
                        }
                        if(tmpString.length()>=1)
                            DefaultLanguage = tmpString;
                        else
                            return false;
                        swc = false;
                    }
            }
        }
        return true;
    }
    //Возвращает IP
    public String getIP(){
        return IP;
    }
    //Возвращает Port
    public int getPort(){
        return Port;
    }
    //Возвращает стартовый язык
    public String getDefaultLanguage(){return DefaultLanguage;}
}
