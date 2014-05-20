package com.mycompany.jproxifier2;

/**
 * Hello world!
 *
 */
public class JProxifier2 
{
    public static void main( String[] args )
    {
         System.out.println("We are loading main JFrame using this wrapper because if there are any problems with dependencies, this class will be executed and will throw NoClassDefExcaption, in consequence at least error message will be shown.");
         MainWindow1 window = new MainWindow1(); //initialization in main
         window.setSize(630,500);
         window.setVisible(true);

         
         javax.swing.SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                    //Template: sout[tab]
                   
                    
            }
        });
    }
}
