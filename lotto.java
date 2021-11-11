package org.hsd.inflab.se1c4;


import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
 
public class lotto extends Application {
 
    @Override
    public void start(Stage primaryStage) throws Exception {
 
        Pane root = new Pane();
        Scene scene = new Scene(root, 250, 70);
        primaryStage.setTitle("Lottoziehung");
        primaryStage.setScene(scene);
        primaryStage.show();
        // TextField
        TextField Zahl1 = new TextField();
        TextField Zahl2 = new TextField();
        TextField Zahl3 = new TextField();
        TextField Zahl4 = new TextField();
        TextField Zahl5 = new TextField();
        TextField Zahl6 = new TextField();
        Button Ziehung = new Button("Ziehen");
        
        Zahl1.setMaxSize(30, 30);
        Zahl2.setMaxSize(30, 30);
        Zahl3.setMaxSize(30, 30);
        Zahl4.setMaxSize(30, 30);
        Zahl5.setMaxSize(30, 30);
        Zahl6.setMaxSize(30, 30);
        
        Zahl1.setLayoutX(10);
        Zahl1.setLayoutY(10);
        Zahl2.setLayoutX(50);
        Zahl2.setLayoutY(10);
        Zahl3.setLayoutX(90);
        Zahl3.setLayoutY(10);
        Zahl4.setLayoutX(130);
        Zahl4.setLayoutY(10);
        Zahl5.setLayoutX(170);
        Zahl5.setLayoutY(10);
        Zahl6.setLayoutX(210);
        Zahl6.setLayoutY(10);
        Ziehung.setLayoutX(100);
        Ziehung.setLayoutY(40);   
        
        root.getChildren().addAll(Zahl1, Zahl2, Zahl3, Zahl4, Zahl5, Zahl6, Ziehung); 
        
        
 
        Ziehung.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	
            	int[] nums ={0,0,0,0,0,0};
            	
            	for (int i=0;i<6;i++)
            	{
            		nums[i]=(int)((Math.random()) * 49 + 1);
            		
            		//Vermeidung doppelter Zahlen
            		
            		for(int j=0;j<i;j++)
            		{
            			if(nums[i]==nums[j])
            			{
            				nums[i]=(int)((Math.random()) * 49 + 1);
            				j--;
            			}            				
            		}
            	}
            	
                //Bubblesort
                
                int i, j;
        	     for(i=0;i<6;++i) 
        	     {
        	        for(j=0;j<6-i-1;++j) 
        	        {
        	            if (nums[j]>nums[j + 1]) 
        	            {
        	                int tmp = nums[j];
        	                nums[j] = nums[j+1];
        	                nums[j+1] = tmp;
        	            }
        	        }
        	     }
        	     //Löschen alter Zahlen
        	    Zahl1.clear();
        	    Zahl2.clear();
        	    Zahl3.clear();
        	    Zahl4.clear();
        	    Zahl5.clear();
        	    Zahl6.clear();
        	    //Beschreiben mit neuen Zahlen
                Zahl1.appendText("" +nums[0]);
                Zahl2.appendText("" +nums[1]);
                Zahl3.appendText("" +nums[2]);
                Zahl4.appendText("" +nums[3]);
                Zahl5.appendText("" +nums[4]);
                Zahl6.appendText("" +nums[5]);
             
            }
        });
           
    }
    public static void main(String[] args) {
    	Application.launch(args);
    }
}
