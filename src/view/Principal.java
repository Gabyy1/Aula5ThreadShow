package view;

import java.util.concurrent.Semaphore;

import controller.Show;

public class Principal {

public static void main(String[] args) {

Semaphore semaforo = new Semaphore(1);
int i = 100;

for (int threadId = 1; threadId < 301; threadId++) {
i = (int) (int) ((Math.random()*4)+1);
   
new Show (threadId, semaforo, i).start();

}
}

}
