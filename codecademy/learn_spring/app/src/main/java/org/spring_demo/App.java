/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package org.spring_demo;

public class App {
    public String getClassName() {
        // TODO: Return only the last part/suffix of the class name?
        return this.getClass().getName();
    }
    public static void main(String[] args) {
        
        System.out.println(new App().getClassName());
    }
}
