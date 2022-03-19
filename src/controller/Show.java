package controller;

import java.util.concurrent.Semaphore;

public class Show extends Thread {
private int threadId;
String ingressos;
private Semaphore semaforo;
private int i;
private static int totalI = 100;

public Show (int threadId, Semaphore semaforo, int i) {
this.threadId = threadId;
this.semaforo = semaforo;
this.i = i;
}

public void run() {
login();

}
   
public void login () {
int tempo = 0;

    tempo = (int) ((int) ((Math.random()*1951)+50));

if (tempo <= 1000) {
compra ();
}
else {
System.out.println("Usuario " + threadId + " Login encerrado, excedeu tempo limite.");
}

}

public void compra() {
int tempo = 0;

tempo = (int) ((int) ((Math.random()*2000)+1000));

if (tempo <= 2500) {
validação();

}

else {
System.out.println("Usuario " + threadId +" Compra encerrada, excedeu tempo limite.");
}
}

public void validação () {

try {
semaforo.acquire();

   if (i <= totalI) {
totalI = totalI - i;

System.out.println("Usuario " + threadId + " Concluiu a compra, restam " + totalI + " ingressos." );
Thread.sleep(100);
}

else {
System.out.println("Compra inválida, excedeu quantidade de ingressos diponíveis");
}
} catch (Exception e) {
e.printStackTrace();

}finally {
  semaforo.release();



}
}
}

