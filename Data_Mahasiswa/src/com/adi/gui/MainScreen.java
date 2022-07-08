package com.adi.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

public class MainScreen extends JFrame{
    private JPanel panelMain;
    private JList jListMahasiswa;
    private JButton buttonFilter;
    private JTextField textFieldFilter;
    private JTextField textFieldNim;
    private JTextField textFieldNama;
    private JTextField textFieldIpk;
    private JButton buttonSave;
    private JButton buttonDelete;
    private JButton buttonClear;

    private List<Mahasiswa> arraydata = new ArrayList<>();

    private DefaultListModel defaultListModel = new DefaultListModel();

    class Mahasiswa{
        private String nim;

        public String getNim() {
            return nim;
        }

        public void setNim(String nim) {
            this.nim = nim;
        }

        public String getNama() {
            return nama;
        }

        public void setNama(String nama) {
            this.nama = nama;
        }

        public Float getIpk() {
            return ipk;
        }

        public void setIpk(Float ipk) {
            this.ipk = ipk;
        }

        private String nama;
        private Float ipk;


    }

    public MainScreen(){
        super("Data Mahasiswa");
        this.setContentPane(panelMain);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();

        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nama = textFieldNama.getText();
                String nim = textFieldNim.getText();
                Float ipk = Float.valueOf(textFieldIpk.getText());

                Mahasiswa mahasiswa = new Mahasiswa();

                mahasiswa.setNama(nama);
                mahasiswa.setNim(nim);
                mahasiswa.setIpk(ipk);

                arraydata.add(mahasiswa);
                setButtonClear();

                fromMahasiswaToListModel();
            }
        });

        buttonClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setButtonClear();
            }
        });
        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = jListMahasiswa.getSelectedIndex();

                if (index < 0)
                    return;

                String nama = jListMahasiswa.getSelectedValue().toString();

                for (int i = 0; i < arraydata.size(); i++) {
                    if (arraydata.get(i).getNama().equals(nama)){
                        arraydata.remove(i);
                        break;
                    }
                }
                setButtonClear();
                fromMahasiswaToListModel();
            }
        });
        jListMahasiswa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int index = jListMahasiswa.getSelectedIndex();

                if (index < 0)
                    return;

                String nama = jListMahasiswa.getSelectedValue().toString();

                for (int i = 0; i < arraydata.size(); i++) {
                    if (arraydata.get(i).getNama().equals(nama)){
                        Mahasiswa mahasiswa = arraydata.get(i);
                        textFieldNama.setText(mahasiswa.getNama());
                        textFieldNim.setText(mahasiswa.getNim());
                        textFieldIpk.setText(String.valueOf(mahasiswa.getIpk()));
                        break;
                    }
                }
            }
        });
        buttonFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String keyWord = textFieldFilter.getText();

                List<String> filtered = new ArrayList<>();

                for (int i = 0; i < arraydata.size(); i++) {
                    if (arraydata.get(i).getNama().contains(keyWord)){
                        filtered.add(arraydata.get(i).getNama());
                    }
                }
                refreshListModel(filtered);
            }
        });
    }
    private void fromMahasiswaToListModel(){

        List<String> listnamaMahasiswa = new ArrayList<>();

        for (int i = 0; i < arraydata.size() ; i++) {
            listnamaMahasiswa.add(arraydata.get(i).getNama());
        }
        refreshListModel(listnamaMahasiswa);
    }
    private void setButtonClear(){
        textFieldIpk.setText("");
        textFieldNama.setText("");
        textFieldNim.setText("");
    }
    private void refreshListModel(List<String> list){
        defaultListModel.clear();
        defaultListModel.addAll(list);
        jListMahasiswa.setModel(defaultListModel);
    }

    public static void main(String[] args) {
        MainScreen mainScreen = new MainScreen();
        mainScreen.setVisible(true);
    }


}
