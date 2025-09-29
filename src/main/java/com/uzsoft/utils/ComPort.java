package com.uzsoft.utils;

import jssc.SerialPort;
import jssc.SerialPortException;

public class ComPort {
    private SerialPort serialPort;
    private final String portName;
    private final Integer baudRate;
    private static final int DATA_RATE = 9600;

    public ComPort(String portName, Integer baudRate) {
        this.portName = portName;
        this.baudRate = baudRate;
        initialize();
    }

    public SerialPort initialize() {
        try {
            serialPort = new SerialPort(portName);
            serialPort.openPort();
            serialPort.setEventsMask(SerialPort.MASK_RXCHAR);
            serialPort.setParams(baudRate != null ? baudRate : DATA_RATE,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);
            serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_RTSCTS_IN |
                    SerialPort.FLOWCONTROL_RTSCTS_OUT);
            return serialPort;
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return null;
    }

    public SerialPort getSerialPort() {
        return serialPort;
    }

    public synchronized void close() {
        try {
            if (serialPort != null) {
                serialPort.removeEventListener();
                serialPort.closePort();
            }
        } catch (SerialPortException e) {
            e.printStackTrace();
        }
    }
}