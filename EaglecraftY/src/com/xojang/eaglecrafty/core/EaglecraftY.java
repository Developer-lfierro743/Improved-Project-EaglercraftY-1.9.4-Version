package com.xojang.eaglecrafty.core;

import javax.swing.*;
import java.awt.*;

public class EaglecraftY {
  public static void main(String[] args) {
    // Initialize the game
    GameLoop gameLoop = new GameLoop();
    gameLoop.setWindowSize(800, 600); // Set the window size
    gameLoop.setTitle("EaglecraftY Java Edition (Pre-Development)"); // Set the window title

    // Create a JFrame to display version information and copyright
    JFrame versionFrame = new JFrame("EaglecraftY Version");
    versionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    versionFrame.setLayout(new BorderLayout());

    // Create a panel to display version information
    JPanel versionPanel = new JPanel();
    versionPanel.setLayout(new BoxLayout(versionPanel, BoxLayout.Y_AXIS));
    versionPanel.add(new JLabel("Version: Pre-Development V0.0.0"));
    versionPanel.add(new JLabel("Note: This project is in early development. It may have bugs! Enjoy this game."));
    versionFrame.add(versionPanel, BorderLayout.CENTER);

    // Create a panel to display copyright information
    JPanel copyrightPanel = new JPanel();
    copyrightPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
    copyrightPanel.add(new JLabel("Copyright Xojang ZB. Do not distribute!"));
    versionFrame.add(copyrightPanel, BorderLayout.SOUTH);

    // Create a panel to display FPS counter
    JPanel fpsPanel = new JPanel();
    fpsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    JLabel fpsLabel = new JLabel("FPS: 0");
    fpsPanel.add(fpsLabel);
    versionFrame.add(fpsPanel, BorderLayout.NORTH);

    // Update FPS counter every second
    Timer fpsTimer = new Timer(1000, e -> {
      fpsLabel.setText("FPS: " + gameLoop.getFPS());
    });
    fpsTimer.start();

    // Set up version frame
    versionFrame.setSize(200, 100);
    versionFrame.setLocation(10, 10);
    versionFrame.setVisible(true);

    //start the game loop
    gameLoop.start();
    } catch (Exception e) {
      System.err.println("Error 001:sorry for the inconvenience,the game has crashed. Reason: " + e.getMessage());
      JOptionPane.showMessageDialog(null, "Error 001:sorry for the inconvenience,the game has crashed. Reason: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
  }
    
