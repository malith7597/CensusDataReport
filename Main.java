package com.company;



import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

        public static void ReadFiles(String sourcepath, int no_of_lines) {
                File file = new File(sourcepath);
                HashMap<Integer, Integer> St_population = new HashMap<Integer, Integer>();
                HashMap<Integer, Integer> Ch_population = new HashMap<Integer, Integer>();
                HashMap<Integer, Integer> Po_population = new HashMap<Integer, Integer>();
                long StatePopulation = 0;
                long StateChildern = 0;
                String statevalue = "";
                int count = 0;
                long total_po = 0;
                try {
                        Scanner rdr = new Scanner(file);
                        while (rdr.hasNextLine()) {
                                String data = rdr.nextLine();

                                int StatePovertyPopulation;
                                //substring values into different categories
                                statevalue = data.substring(0, 2).trim();
                                String schoolpopulation = data.substring(83, 90).trim();
                                String childrenpopulation = data.substring(92, 99).trim();
                                String povertyChild = data.substring(101, 108).trim();
                                // convert into integer values

                                int Statevalue = Integer.parseInt(statevalue);
                                int Schoolpopulation = Integer.parseInt(schoolpopulation);
                                int ChildrenPopulation = Integer.parseInt(childrenpopulation);
                                int PovertyChildren = Integer.parseInt(povertyChild);

                                St_population.computeIfPresent(Statevalue, (key, val) -> val + Schoolpopulation);
                                St_population.putIfAbsent(Statevalue, Schoolpopulation);
                                Ch_population.computeIfPresent(Statevalue, (key, val) -> val + ChildrenPopulation);
                                Ch_population.putIfAbsent(Statevalue, ChildrenPopulation);
                                Po_population.computeIfPresent(Statevalue, (key, val) -> val + PovertyChildren);
                                Po_population.putIfAbsent(Statevalue, PovertyChildren);


                        }
                        // System.out.println(St_population.size());
                        // System.out.println(child_population.size());
                        //   System.out.println(child_poverty.size());
                        System.out.println("State     Population     Child Population     Poverty Population    %Child Poverty");
                        int total = 0;

                        for (int i : St_population.keySet()) {
                                double poor = Po_population.get(i).intValue();
                                double all = Ch_population.get(i).intValue();
                                double precentage = poor / all * 100;
                                DecimalFormat df = new DecimalFormat("###.##");
                                // System.out.println(df.format(precentage));
                                System.out.println(i + "             " + St_population.get(i) + "             " + Ch_population.get(i) + "             " + Po_population.get(i) + "             " + df.format(precentage));
                        }
                } catch (FileNotFoundException e) {
                        e.printStackTrace();
                }
        }
        public static void WriteFiles(String sourcepath,String destpath, int no_of_lines) {
                System.out.println(destpath);
                File file = new File(sourcepath);
                HashMap<Integer, Integer> St_population = new HashMap<Integer, Integer>();
                HashMap<Integer, Integer> Ch_population = new HashMap<Integer, Integer>();
                HashMap<Integer, Integer> Po_population = new HashMap<Integer, Integer>();
                long StatePopulation = 0;
                long StateChildern = 0;
                String statevalue = "";
                int count = 0;
                long total_po = 0;
                try {
                        Scanner rdr = new Scanner(file);
                        while (rdr.hasNextLine()) {
                                String data = rdr.nextLine();

                                int StatePovertyPopulation;
                                //substring values into different categories
                                statevalue = data.substring(0, 2).trim();
                                String schoolpopulation = data.substring(83, 90).trim();
                                String childrenpopulation = data.substring(92, 99).trim();
                                String povertyChild = data.substring(101, 108).trim();
                                // convert into integer values

                                int Statevalue = Integer.parseInt(statevalue);
                                int Schoolpopulation = Integer.parseInt(schoolpopulation);
                                int ChildrenPopulation = Integer.parseInt(childrenpopulation);
                                int PovertyChildren = Integer.parseInt(povertyChild);

                                St_population.computeIfPresent(Statevalue, (key, val) -> val + Schoolpopulation);
                                St_population.putIfAbsent(Statevalue, Schoolpopulation);
                                Ch_population.computeIfPresent(Statevalue, (key, val) -> val + ChildrenPopulation);
                                Ch_population.putIfAbsent(Statevalue, ChildrenPopulation);
                                Po_population.computeIfPresent(Statevalue, (key, val) -> val + PovertyChildren);
                                Po_population.putIfAbsent(Statevalue, PovertyChildren);


                        }
                        // System.out.println(St_population.size());
                        // System.out.println(child_population.size());
                        //   System.out.println(child_poverty.size());
                        File file1 = new File(destpath);
                        if(file.exists()){
                                FileWriter writer2 =new FileWriter(destpath);
                                writer2.write("State     Population     Child Population     Poverty Population    %Child Poverty\n");
                                for (int i : St_population.keySet()) {
                                        double poor = Po_population.get(i).intValue();
                                        double all = Ch_population.get(i).intValue();
                                        double precentage = poor / all * 100;

                                        DecimalFormat df = new DecimalFormat("###.##");
                                        writer2.write(i + "                       " + St_population.get(i) + "                       " + Ch_population.get(i) + "                       " + Po_population.get(i) + "                     " + df.format(precentage));
                                        writer2.write("\n");
                                }
                                        writer2.close();
                        }
                        else{
                                System.out.println("FIle already Exists");
                                Scanner scn = new Scanner(System.in);
                                System.out.println("Enter the new file path:");
                                String newpath = scn.nextLine();
                                File file3 =new File(newpath);
                                FileWriter writer = new FileWriter(file3);
                                writer.write("State     Population     Child Population     Poverty Population    %Child Poverty\n");
                                for (int i : St_population.keySet()) {
                                        double poor = Po_population.get(i).intValue();
                                        double all = Ch_population.get(i).intValue();
                                        double precentage = poor / all * 100;

                                        DecimalFormat df = new DecimalFormat("###.##");
                                        writer.write(i + "             " + St_population.get(i) + "             " + Ch_population.get(i) + "             " + Po_population.get(i) + "             " + df.format(precentage));
                                        writer.write("\n");
                                }
                        }




                } catch (FileNotFoundException e) {
                        e.printStackTrace();
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }





        public static void main(String[] args) {


                ReadFiles("G:\\OneDrive\\Desktop\\Census\\SmallAreaIncomePovertyEstData.txt",13486);
                WriteFiles("G:\\OneDrive\\Desktop\\Census\\SmallAreaIncomePovertyEstData.txt","G:\\OneDrive\\Desktop\\Census\\report.txt",13486);





        }

}














