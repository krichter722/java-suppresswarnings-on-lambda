/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package richtercloud.java.suppresswarnings.on.lambda;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;

/**
 *
 * @author richter
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Executors.newSingleThreadExecutor().submit(new Runnable() {
            @Override
            @SuppressWarnings("unchecked")
            public void run() {
                List list = new LinkedList();
                list.add("some string"); //without
                    //`@SuppressWarnings("unchecked")` javac warns about
                    //`[path to file].java: [path to file].java uses unchecked or unsafe operations.`
            }
        });
        
        @SuppressWarnings("unchecked")
        Runnable runnableJava8 = () -> {
            List list = new LinkedList();
            list.add("some string");
        };
        Executors.newSingleThreadExecutor().submit(runnableJava8);
        
        @SuppressWarnings("unchecked") //where to put this??
        Executors.newSingleThreadExecutor().submit(() -> {
            List list = new LinkedList();
            list.add("some string");
        });
    }
    
}
