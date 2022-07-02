package com;

import java.util.ArrayList;
import java.util.Scanner;

public class adi {
    public static void main(String[] args) {

        ArrayList<String> NAMA = new ArrayList<>();
        ArrayList<String> NIM = new ArrayList<>();
        ArrayList<String> ALAMAT = new ArrayList<>();
        Scanner input= new Scanner(System.in);

        int PILIHAN;

        do{

            System.out.println(" PROGRAM DATA MAHASISWA");
            System.out.println(" ***********************");
            System.out.println(" 1. tambahkan data");
            System.out.println(" 2. tampilkan nilai");
            System.out.println(" 3. cari");
            System.out.println(" 4. hapus");
            System.out.println(" 5. keluar");
            System.out.println(" Pilih Menu:");
            PILIHAN = input.nextInt();

            if(PILIHAN==1){
                System.out.print("Masukan Data;");
                String nm = input.next();
                NAMA.add(nm);

                System.out.print("Masukan Nim;");
                String nim = input.next();
                NIM.add(nim);

                System.out.print("Masukan Alamat;");
                String alt = input.next();
                ALAMAT.add(nm);

            } else if (PILIHAN==2) {
                System.out.println(" Data Mahasiswa ");
                System.out.println("*******************");

                for (int i = 0; i < NIM.size(); i++) {
                    System.out.println(i+1+"."+NIM.get(i));
                }
                System.out.println(" lihat data lengkap");

            } else if (PILIHAN==3) {
                System.out.println(" masukan data nomor ke berapa:");
                int CARI= input.nextInt();

                if ( CARI==1){
                    System.out.print(" Nama:"+NAMA.get(0));
                    System.out.print(" Nim:"+NIM.get(0));
                    System.out.print(" Alamat:"+ALAMAT.get(0));
                }
                if ( CARI==2){
                    System.out.print(" Nama:"+NAMA.get(1));
                    System.out.print(" Nim:"+NIM.get(1));
                    System.out.print(" Alamat:"+ALAMAT.get(1));
                }

            } else if (PILIHAN==4) {
                for (int i = 0; i < NIM.size(); i++) {
                    System.out.println(i+1+"."+NIM.get(i));
                }
                System.out.print(" Masukkan NIM yang akan di hapus:");
                String nim= input.next();
                NIM.remove(nim);

            } else if (PILIHAN==5) {
                System.out.println(" selesai");
            }
        }while ( PILIHAN != 5);
    }
}
