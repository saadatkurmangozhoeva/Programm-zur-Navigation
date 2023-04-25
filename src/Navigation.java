import java.util.*;
import java.io.*;
import java.util.Scanner;

public class Navigation {
    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);

        System.out.println("Wählen Sie Start, geben Sie die Stationsnummer von 0 bis 28 ein");
        int Start = in.nextInt();
        System.out.println("Wählen Sie Ziel, geben Sie die Stationsnummer von 0 bis 28 ein");
        int Ziel = in.nextInt();
        int[] chilonzorIndex = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int[] uzbekistanIndex = {12, 13, 14, 15, 16, 17, 18, 19, 20, 21,22};
        int[] yunusobodIndex = {23, 24, 25, 26, 27, 28};
        ArrayList <Integer> arr = new ArrayList();

        //Für den Start
        // ausgewählte Stationen von ChilonzorLine
        if (Start <= 11) {
            for (int j = 0; j <= chilonzorIndex.length; j++) {
                break;
            }
        }
        // ausgewählte Stationen von UzbekistanLine
        if (Start > 11 && Start <= 22) {
            for (int j = 0; j <= uzbekistanIndex.length; j++) {
                //  System.out.println("Точка А");
                //  System.out.println(uzbekistanIndex[j] = a);
                break;
            }
        }
        //ausgewählte Stationen von YunusobodLine
        if (Start > 22) {
            for (int j = 0; j <= yunusobodIndex.length; j++) {
                break;
            }
        }

        //Für das Ziel
        // ausgewählte Stationen von ChilonzorLine
        if (Ziel <= 11) {
            for (int j = 0; j <= chilonzorIndex.length; j++) {
                break;
            }
        }
        // ausgewählte Stationen von UzbekistanLine
        if (Ziel> 11 && Ziel <= 22) {
            for (int j = 0; j <= uzbekistanIndex.length; j++) {
                break;
            }
        }
        //ausgewählte Stationen von YunusobodLine
        if (Ziel > 22) {
            for (int j = 0; j <= yunusobodIndex.length; j++) {
                break;
            }
        }

        //konstruiert den Weg
        if (Start < Ziel) {

            // ChilonzorLine
            if (Start <= 11 && Ziel <= 11) {
                for (int i = Start; i <= Ziel; i++) {
                    arr.add(chilonzorIndex[i]);
                }
            }

            //UzbekistanLine
            try{
                if (Start > 11 && Start <= 22 && Ziel > 11 && Ziel<= 22) {
                    for (int i=0; i<uzbekistanIndex.length; i++){
                        if(uzbekistanIndex[i]>=Start && uzbekistanIndex[i]<=Ziel){
                            arr.add(uzbekistanIndex[i]);
                        }
                    }
                }
            }catch (Exception ex)
            {
                ex.printStackTrace();
            }

            //YunusobodLine
            try{
                if (Start > 22 && Ziel > 22) {
                    for (int i=0; i<yunusobodIndex.length; i++){
                        if(yunusobodIndex[i]>=Start && yunusobodIndex[i]<=Ziel){
                            //  System.out.println(yunusobodIndex[i]);
                            arr.add(yunusobodIndex[i]);
                        }
                    }
                }
            }catch (Exception ex)
            {
                ex.printStackTrace();
            }

            // ChilonzorLine und  UzbekistanLine
            try{
                if (Start <= 11 && (Ziel > 11 && Ziel<= 22)) {
                    if (Start < 7) {
                        for (int i = Start; i <= chilonzorIndex[6]; i++) {
                            //  System.out.println(chilonzorIndex[i]);
                            arr.add(chilonzorIndex[i]);
                            if (chilonzorIndex[i] == 6) {
                                // System.out.println("Пересадка на другую ветку");
                                // идет обработка синий ветки
                                //направление
                                if (uzbekistanIndex[4] < Ziel) {
                                    for (int t = 4; t < uzbekistanIndex.length ; t++) {
                                        for (int k = uzbekistanIndex[t]; uzbekistanIndex[t] <= Ziel; t++) {
                                            //    System.out.println(uzbekistanIndex[t]);
                                            arr.add(uzbekistanIndex[t]);
                                        }
                                    }
                                } else {
                                    int t=4;
                                    for (int k = uzbekistanIndex[t]; uzbekistanIndex[t] >= Ziel;  t--) {
                                        arr.add(uzbekistanIndex[t]);
                                    }
                                }
                            }
                        }
                    } else {
                        for (int q = Start - 1; q >= chilonzorIndex[6]; q--) {
                            arr.add(chilonzorIndex[q]);
                            if (chilonzorIndex[q] == 6) {

                                 // UzbekistanLine wird verarbeitet
                                if (uzbekistanIndex[4] < Ziel) {
                                    for (int t = 4; t < uzbekistanIndex.length - 1; t++) {
                                        for (int k = uzbekistanIndex[t]; uzbekistanIndex[t] <= Ziel; t++) {
                                            arr.add(uzbekistanIndex[t]);
                                        }
                                    }
                                } else {
                                    int t=4;
                                    for (int k = uzbekistanIndex[t]; uzbekistanIndex[t] >= Ziel;  t--) {
                                        arr.add(uzbekistanIndex[t]);
                                    }
                                }
                            }
                        }
                    }
                }
            }catch (Exception ex)
            {
                ex.printStackTrace();
            }

            // red and green
            try{
                if (Start <= 11 && Ziel > 22) {
                    if (Start < 9) {
                        for (int i = Start; i <= chilonzorIndex[8]; i++) {

                            arr.add(chilonzorIndex[i]);
                            if (chilonzorIndex[i] == 8) {

                                // UzbekistanLine werden verarbeitet
                                //Richtung
                                if (yunusobodIndex[4] < Ziel) {
                                    for (int t = 4; t < 6; t++) {
                                        for (int k = yunusobodIndex[t]; yunusobodIndex[t] <= Ziel; t++) {
                                            arr.add(yunusobodIndex[t]);
                                        }
                                    }
                                }
                                if (yunusobodIndex[4] > Ziel) {
                                    int t = 4;
                                    for (int k = yunusobodIndex[t]; yunusobodIndex[t] >= Ziel; t--) {
                                        arr.add(yunusobodIndex[t]);
                                    }
                                }
                            }
                        }
                    } else {
                        for (int q = Start - 1; q >= chilonzorIndex[8]; q--) {
                            arr.add(chilonzorIndex[q]);
                            if (chilonzorIndex[q] == 8) {

                                // UzbekistanLine werden verarbeitet
                                if (yunusobodIndex[4] < Ziel) {
                                    for (int t = 4; t < 6; t++) {
                                        for (int k = yunusobodIndex[t]; yunusobodIndex[t] <= Ziel; t++) {
                                            arr.add(yunusobodIndex[t]);
                                        }
                                    }
                                } else {
                                    int t = 4;
                                    for (int k = yunusobodIndex[t]; yunusobodIndex[t] >= Ziel; t--) {
                                        arr.add(yunusobodIndex[t]);
                                    }
                                }
                            }
                        }
                    }
                }
            }catch (Exception ex)
            {
                ex.printStackTrace();
            }

            //UzbekistanLine und YunusobodLine
            try{
                if ((Start > 11 && Start <= 22) && Ziel > 22) {
                    if (Start < uzbekistanIndex[6]) {
                        for (int j = 0; Start <= uzbekistanIndex[6]; j++) {
                            // System.out.println(uzbekistanIndex[j]);
                            arr.add(uzbekistanIndex[j]);
                            if (chilonzorIndex[j] == 6) {

                                // UzbekistanLine werden verarbeitet
                                //Richtung
                                int t = 5;
                                for (int k = yunusobodIndex[t]; yunusobodIndex[t] >= Ziel; t--) {
                                    System.out.println(yunusobodIndex[t]);
                                    arr.add(yunusobodIndex[t]);
                                }
                                break;
                            }
                        }
                    } else {
                        for (int i = 0; Start >= uzbekistanIndex[6]; i--) {

                            //Richtung
                            int t = 5;

                            arr.add(uzbekistanIndex[i]);
                            if (chilonzorIndex[i] == 6) {
                                System.out.println("Пересадка на другую ветку");
                                 // UzbekistanLine werden verarbeitet

                                for (int k = yunusobodIndex[t]; yunusobodIndex[t] >= Ziel; t--) {

                                    arr.add(yunusobodIndex[t]);
                                }
                                break;
                            }
                        }
                    }
                }
            }catch (Exception ex)
            {
                ex.printStackTrace();
            }

        }
        else{


            // ChilonzorLine
            if (Start <= 11 && Ziel <= 11) {
                for (int i = Start; i >= Ziel; i--) {
                    arr.add(chilonzorIndex[i]);
                }
            }

            //UzbekistanLine
            try{
                if (Start > 11 && Start <= 22 && Ziel > 11 && Ziel <= 22) {
                    for (int i=0; i<uzbekistanIndex.length; i++){
                        if(uzbekistanIndex[i]<=Start && uzbekistanIndex[i]>=Ziel){
                            arr.add(uzbekistanIndex[i]);
                        }
                    }
                }
            }catch (Exception ex)
            {
                ex.printStackTrace();
            }

            //YunusobodLine
            try{
                if (Start > 22 && Ziel > 22) {
                    for (int i=0; i<yunusobodIndex.length; i++){
                        if(yunusobodIndex[i]<=Start && yunusobodIndex[i]>=Ziel){
                            arr.add(yunusobodIndex[i]);
                        }
                    }
                }
            }catch (Exception ex)
            {
                ex.printStackTrace();
            }

            //UzbekistanLine und ChilonzorLine
            try{
                if (Ziel <= 11 && (Start > 11 && Start <= 22)) {
                    if (Start > 16) {

                        for (int i=10; i<uzbekistanIndex.length; i--){
                            if(uzbekistanIndex[i]<=Start){
                                arr.add(uzbekistanIndex[i]);
                                if(uzbekistanIndex[i]==16){

                                    if (chilonzorIndex[6] < Ziel) {
                                        for (int t = 6; t < chilonzorIndex.length - 1; t++) {
                                            for (int k = chilonzorIndex[t]; chilonzorIndex[t] <= Ziel; t++) {
                                                arr.add(chilonzorIndex[t]);
                                            }
                                            break;
                                        }
                                        break;
                                    } else {
                                        int t = 6;
                                        for (int k = chilonzorIndex[t]; chilonzorIndex[t] >= Ziel; t--) {
                                            arr.add(chilonzorIndex[t]);
                                            if(chilonzorIndex[t]==Ziel){
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                }
                            }
                        }
                    } else {
                        for (int i=0; i<uzbekistanIndex.length; i++){
                            if(uzbekistanIndex[i]>=Start && uzbekistanIndex[i]<=16){

                                arr.add(uzbekistanIndex[i]);
                                if(uzbekistanIndex[i]==16){

                                    if (chilonzorIndex[6] < Ziel) {
                                        for (int t = 6; t < chilonzorIndex.length - 1; t++) {
                                            for (int k = chilonzorIndex[t]; chilonzorIndex[t] <= Ziel; t++) {
                                                //     System.out.println(chilonzorIndex[t]);
                                                arr.add(chilonzorIndex[t]);
                                            }
                                            break;
                                        }
                                        break;
                                    } else {
                                        int t = 6;
                                        for (int k = chilonzorIndex[t]; chilonzorIndex[t] >= Ziel; t--) {
                                            arr.add(chilonzorIndex[t]);
                                            if(chilonzorIndex[t]==Ziel){
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }catch (Exception ex)
            {
                ex.printStackTrace();
            }


            //YunusobodLine und UzbekistanLine
            try{
                if (Start>22 && (Ziel>11 && Ziel<=22)){
                    for (int i=0; i<=yunusobodIndex.length-1; i++){
                        arr.add(yunusobodIndex[i]);
                        for (int j = yunusobodIndex[i]; j>=yunusobodIndex[5];){
                            if (uzbekistanIndex[6] < Ziel) {
                                for (int t = 6; t < uzbekistanIndex.length - 1; t++) {
                                    for (int k = uzbekistanIndex[t]; uzbekistanIndex[t] <= Ziel; t++) {
                                        arr.add(uzbekistanIndex[t]);
                                    }
                                    break;
                                }
                            } else {
                                int t = 6;
                                for (int k = uzbekistanIndex[t]; uzbekistanIndex[t] >= Ziel; t--) {
                                    arr.add(uzbekistanIndex[t]);
                                }
                                break;
                            }

                        }
                    }
                }
            }catch (Exception ex)
            {
                ex.printStackTrace();
            }

            // YunusobodLine und ChilonzorLine
            try{
                if (Start>22 && Ziel<12){
                    if(Start<=27){
                        for (int i=0; i<=yunusobodIndex.length-2; i++) {
                            arr.add(yunusobodIndex[i]);
                            for (int j = yunusobodIndex[i]; j >= yunusobodIndex[4]; ) {
                                // UzbekistanLine werden verarbeitet
                                //Richtung
                                if (chilonzorIndex[8] < Ziel) {
                                    for (int t = 8; t < 12; t++) {
                                        for (int k = chilonzorIndex[t]; chilonzorIndex[t] <= Ziel; t++) {
                                            arr.add(chilonzorIndex[t]);
                                        }
                                        break;
                                    }
                                }
                                if (chilonzorIndex[8] > Ziel) {
                                    int t = 8;
                                    for (int k = chilonzorIndex[t]; chilonzorIndex[t] >= Ziel; t--) {
                                        arr.add(chilonzorIndex[t]);
                                    }
                                    break;
                                }
                                if(chilonzorIndex[8]==Ziel){
                                    arr.add(chilonzorIndex[8]);
                                    break;
                                }

                            }
                        }
                    }
                    if(Start==28){
                        int i=5;
                        for(yunusobodIndex[i]=Start; yunusobodIndex[i]>=27; i--){
                            arr.add(yunusobodIndex[i]);
                            if(yunusobodIndex[i]==27){

                                // UzbekistanLine werden verarbeitet
                                //Richtung
                                if (chilonzorIndex[8] < Ziel) {
                                    for (int t = 8; t < 12; t++) {
                                        for (int k = chilonzorIndex[t]; chilonzorIndex[t] <= Ziel; t++) {
                                            arr.add(chilonzorIndex[t]);
                                        }
                                        break;
                                    }
                                }
                                if (chilonzorIndex[8] > Ziel) {
                                    int t = 8;
                                    for (int k = chilonzorIndex[t]; chilonzorIndex[t] >= Ziel; t--) {
                                        arr.add(chilonzorIndex[t]);
                                    }
                                    break;
                                }
                                if(chilonzorIndex[8]==Ziel){
                                    arr.add(chilonzorIndex[8]);
                                    break;
                                }

                            }

                        }

                    }
                }
            }catch (Exception ex)
            {
                ex.printStackTrace();
            }


        }


        // Eine neue Map-Instanz erstellen, um Schlüssel-Wert-Paare zu speichern
        Map<Integer, String> lines = new HashMap<Integer, String>();

        try {
            // Jede Datei nacheinander öffnen und ihren Inhalt lesen
            BufferedReader chilonzorLine = new BufferedReader(new FileReader("ChilonzorLine.txt"));
            BufferedReader uzbekistanLine = new BufferedReader(new FileReader("UzbekistanLine.txt"));
            BufferedReader yunusobodLine= new BufferedReader(new FileReader("YunusobodLine.txt"));

            String line;
            // Lesen Sie den Inhalt jeder Datei zeilenweise
            while ((line = chilonzorLine.readLine()) != null) {
                // Teile einen String in ein Schlüssel-Wert-Paar
                String[] pair = line.split("\\|");
                // Schlüssel in int type und Wert in string type konvertieren und zur Karte hinzufügen
               lines.put(Integer.parseInt(pair[0]), pair[1]);
            }

            while ((line = uzbekistanLine.readLine()) != null) {
                String[] pair = line.split("\\|");
               lines.put(Integer.parseInt(pair[0]), pair[1]);
            }

            while ((line = yunusobodLine.readLine()) != null) {
                String[] pair = line.split("\\|");
               lines.put(Integer.parseInt(pair[0]), pair[1]);
            }

            // Alle Dateien nach dem Lesen schließen
            chilonzorLine.close();
            uzbekistanLine.close();
            yunusobodLine.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        int num = 0;
        String value;

        for (int i = 0; i < arr.size(); i++) {
            num=arr.get(i);
            value =lines.get(num);
            System.out.println(value);
        }


    }
}
