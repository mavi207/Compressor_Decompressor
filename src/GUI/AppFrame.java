package GUI;

import CompressorDecompressor.Compressor;
import CompressorDecompressor.Decompressor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;

public class AppFrame extends JFrame implements ActionListener{

    // I have extended JFrame class, I have to add some functionality and implementation in my project
    /*Action listeners are probably the easiest — and most common — event handlers to implement.
      You implement an action listener to define what should be done when a user performs certain
      operation. An action event occurs, whenever an action is performed by the user.
     */
    // Action Listener is just detecting the button have been clicked
    JButton compressorButton;//creating compressor button using JButton
    JButton decompressorButton;//creating decompressor button using JButton

    AppFrame(){//constructor
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*The setDefaultCloseOperation() method is used to specify one of several options for the
          close ... JFrame.EXIT_ON_CLOSE — Exit the application. JFrame.
         */

        this.setLayout(null);

        compressorButton=new JButton("Select Your file to Compress");
        compressorButton.setBounds(50,50,300,30);
        // this will assign boundaries height & width to compressButton
        compressorButton.setBackground(Color.CYAN);
        // Setting Compressor Button Color
        compressorButton.addActionListener(this);
        // Add an action listener to the compressorButton

        decompressorButton=new JButton("Select Your file to Decompress");
        decompressorButton.setBounds(500,50,300,30);
        // this will assign boundaries height & width to decompressButton
        decompressorButton.setBackground(Color.CYAN);
        // Setting Decompressor Button Color
        decompressorButton.addActionListener(this);
        // Add an action listener to the decompressorButton

        this.add(compressorButton);
        this.add(decompressorButton);

        this.setSize(1000,500);
        // setting size of frame

        this.getContentPane().setBackground(Color.DARK_GRAY);
        // setting color of frame
        setTitle("Compressor Decompressor");
        // giving title to frame

        Container e=this.getContentPane();
        // making container obj of frame

        e.setBackground(new Color(192, 192, 192));
        // adding light silver color to container

         this.setResizable(false);
        // making size of frame fixed

        this.setVisible(true);
        // making the frame visible
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        /* parameter - ActionEvent e
          I have just Overridden this action Listener and inside this I will add action of
          compressorButton and decompressorButton button which should be performed on click
          of this button
        */

        // Check if the event source is the compressorButton
        if(e.getSource() == compressorButton)
        {
            // Create a file chooser dialog
            JFileChooser fileChooser = new JFileChooser();

            // Show the save dialog and store the user's response
            int response = fileChooser.showSaveDialog(null);

            // Check if the user clicked the "Save" or "OK" button
            if(response == JFileChooser.APPROVE_OPTION)
            {
                // Get the selected file from the file chooser
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());

                try
                {
                    // Call the Compressor.method() method and pass the selected file
                    Compressor.method(file);
                }
                catch(Exception ee)
                {
                    // Show an error message dialog if an exception occurs
                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }
        }

        if(e.getSource() == decompressorButton)
        {
            JFileChooser fileChooser = new JFileChooser();

            int response = fileChooser.showSaveDialog(null);

            if(response == JFileChooser.APPROVE_OPTION)
            {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());

                try
                {
                    Decompressor.method(file);
                }
                catch(Exception ee)
                {
                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }
        }
    }
}