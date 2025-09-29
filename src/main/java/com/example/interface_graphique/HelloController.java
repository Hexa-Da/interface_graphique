package com.example.interface_graphique;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class HelloController {
    @FXML
    private Canvas mainCanvas;
    
    @FXML
    private Button redButton;
    
    @FXML
    private Button greenButton;
    
    @FXML
    private Button blueButton;
    
    @FXML
    private Button blackButton;
    
    private GraphicsContext gc;
    private boolean isDrawing = false;
    private Color currentColor = Color.BLACK;

    @FXML
    public void initialize() {
        // Initialiser le GraphicsContext du Canvas
        gc = mainCanvas.getGraphicsContext2D();
        gc.setStroke(currentColor);
        gc.setLineWidth(2);
        
        // Initialiser les styles des boutons
        updateButtonStyles();
    }

    @FXML
    protected void clearImage(ActionEvent event) {
        // Effacer le canvas
        gc.clearRect(0, 0, mainCanvas.getWidth(), mainCanvas.getHeight());
        System.out.println("Canvas cleared!");
    }

    @FXML
    protected void selectRed(ActionEvent event) {
        currentColor = Color.RED;
        gc.setStroke(currentColor);
        updateButtonStyles();
        System.out.println("Couleur sélectionnée: Rouge");
    }

    @FXML
    protected void selectGreen(ActionEvent event) {
        currentColor = Color.GREEN;
        gc.setStroke(currentColor);
        updateButtonStyles();
        System.out.println("Couleur sélectionnée: Vert");
    }

    @FXML
    protected void selectBlue(ActionEvent event) {
        currentColor = Color.BLUE;
        gc.setStroke(currentColor);
        updateButtonStyles();
        System.out.println("Couleur sélectionnée: Bleu");
    }

    @FXML
    protected void selectBlack(ActionEvent event) {
        currentColor = Color.BLACK;
        gc.setStroke(currentColor);
        updateButtonStyles();
        System.out.println("Couleur sélectionnée: Noir");
    }
    
    
    private void updateButtonStyles() {
        // Réinitialiser tous les boutons
        redButton.getStyleClass().removeAll("color-button-selected");
        greenButton.getStyleClass().removeAll("color-button-selected");
        blueButton.getStyleClass().removeAll("color-button-selected");
        blackButton.getStyleClass().removeAll("color-button-selected");
        
        // Appliquer le style sélectionné au bouton actuel
        if (currentColor.equals(Color.RED)) {
            redButton.getStyleClass().add("color-button-selected");
        } else if (currentColor.equals(Color.GREEN)) {
            greenButton.getStyleClass().add("color-button-selected");
        } else if (currentColor.equals(Color.BLUE)) {
            blueButton.getStyleClass().add("color-button-selected");
        } else if (currentColor.equals(Color.BLACK)) {
            blackButton.getStyleClass().add("color-button-selected");
        }
    }

    @FXML
    protected void onCanvasMousePressed(MouseEvent event) {
        isDrawing = true;
        gc.beginPath();
        gc.moveTo(event.getX(), event.getY());
    }

    @FXML
    protected void onCanvasMouseDragged(MouseEvent event) {
        if (isDrawing) {
            gc.lineTo(event.getX(), event.getY());
            gc.stroke();
        }
    }

    @FXML
    protected void onCanvasMouseReleased(MouseEvent event) {
        isDrawing = false;
    }
}
