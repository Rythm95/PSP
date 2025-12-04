package _09Info;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PMPConsola203 {

    public static void main(String[] args) {
        ProcessHandle processHandle = ProcessHandle.current();
        ProcessHandle.Info processInfo = processHandle.info();
        System.out.println("PID: " + processHandle.pid());
        System.out.println("Arguments: " + processInfo.arguments());
        System.out.println("Command: " + processInfo.command());
        System.out.println("Instant: " + processInfo.startInstant());
        System.out.println("Total CPU duration: " + processInfo.totalCpuDuration());
        System.out.println("User: " + processInfo.user());
        ProcessBuilder processBuilder = new ProcessBuilder("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        Process process;
        try {
            process = processBuilder.inheritIO().start();
            ProcessHandle childProcessHandle = process.toHandle();
            ProcessHandle.Info childprocessInfo = childProcessHandle.info();
            System.out.println("PID: " + childProcessHandle.pid());
            System.out.println("Arguments: " + childprocessInfo.arguments());
            System.out.println("Command: " + childprocessInfo.command());
            System.out.println("Instant: " + childprocessInfo.startInstant());
            System.out.println("Total CPU duration: " + childprocessInfo.totalCpuDuration());
            System.out.println("User: " + childprocessInfo.user());
        } catch (IOException ex) {
            Logger.getLogger(PMPConsola203.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
