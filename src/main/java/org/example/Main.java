package org.example;

import com.fazecast.jSerialComm.SerialPort;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        SerialPort port = SerialPort.getCommPort("COM3");
        port.setBaudRate(9600);
        port.openPort();

        try {
            while (true) {
                byte[] readBuffer = new byte[port.bytesAvailable()];
                int numRead = port.readBytes(readBuffer, readBuffer.length);

                if (numRead > 0) {
                    //System.out.println("READ - " + numRead + " bytes -");

                    String s = new String(readBuffer, "UTF-8");
                    System.out.println(s);
                }

                Thread.sleep(1000);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        port.closePort();

    }
}