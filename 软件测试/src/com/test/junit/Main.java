package com.test.junit;
import java.util.Iterator;
import java.util.Set;
 
 
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
 
 
 
 
 
 
public class Main {
 
 
/**
* @param args
*/
public static void main(String[] args) {
// TODO Auto-generated method stub
JUnitCore core = new JUnitCore();
core.addListener(new Listener());
Result result = core.run(PracticeTest.class);
 
Set<String> set = Listener.test_map.keySet();
Iterator<String> it = set.iterator();
while(it.hasNext()){
String name = it.next();
boolean is_success = Listener.test_map.get(name);
String is_success_str = is_success ? "success" : "failure"; 
System.out.println("test " + name + " : " + is_success_str );
}
 
System.out.println(result.wasSuccessful());
 
 
}
 
 
}