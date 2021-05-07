/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compito_cimara_7_5;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

/**
 *
 * @author 4AIA
 */
public class Interfaccia extends JFrame{
    JLabel labelCodice = new JLabel("Codice ISBN");
    JTextField textCodice = new JTextField();
    
    JLabel labelTitolo = new JLabel("Tiolo libro");
    JTextField textTitolo = new JTextField();
    
    JLabel labelPrezzo = new JLabel("Prezzo in €");
    JTextField textPrezzo = new JTextField();
    
    JLabel nome = new JLabel();
    
    JLabel labelCodiceInserito = new JLabel();
    
    JLabel labelCopieLibro = new JLabel();
    
    JLabel labelLibri = new JLabel();
    
    JLabel niente = new JLabel();
    
    JButton conferma = new JButton("Conferma");
    JButton cancella = new JButton("Cancella");
    
    Libreria cima = new Libreria("Libreria in Cima");
    
    public Interfaccia()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 400);
        this.setLocation(550, 270);
        Container pannello = this.getContentPane();
        pannello.setBackground(Color.lightGray);
        pannello.setLayout(null);
        this.setTitle(cima.getNome());
        
        //Codice ISBN
        labelCodice.setSize(190, 30);
        labelCodice.setOpaque(false);
        labelCodice.setLocation(150, 120);
        pannello.add(labelCodice);
        
        pannello.add(textCodice);
        textCodice.setSize(140, 30);
        textCodice.setLocation(250, 120);
        
        //Titolo libro
        labelTitolo.setSize(190, 30);
        labelTitolo.setOpaque(false);
        labelTitolo.setLocation(150, 150);
        pannello.add(labelTitolo);
        
        pannello.add(textTitolo);
        textTitolo.setSize(140, 30);
        textTitolo.setLocation(250, 150);
        
        //Prezzo libro
        labelPrezzo.setSize(190, 30);
        labelPrezzo.setOpaque(false);
        labelPrezzo.setLocation(150, 180);
        pannello.add(labelPrezzo);
        
        pannello.add(textPrezzo);
        textPrezzo.setSize(140, 30);
        textPrezzo.setLocation(250, 180);
        
        //Bottone conferma
        pannello.add(conferma);
        conferma.setSize(90, 30);
        conferma.setLocation(150, 240);
        conferma.addMouseListener(new MouseClick());
        
        //Codice libro inserito
        labelCodiceInserito.setSize(250, 30);
        labelCodiceInserito.setOpaque(false);
        labelCodiceInserito.setLocation(400, 120);
        labelCodiceInserito.setVisible(false);
        pannello.add(labelCodiceInserito);
        
        //Copie del libro 
        labelCopieLibro.setSize(190, 30);
        labelCopieLibro.setOpaque(false);
        labelCopieLibro.setLocation(400, 150);
        labelCopieLibro.setVisible(false);
        pannello.add(labelCopieLibro);    
        
        //Niente
        niente.setText("Errore. Si prega di inserire dei parametri validi.");
        niente.setSize(280, 30);
        niente.setOpaque(true);    
        niente.setLocation(150, 80);
        niente.setBackground(Color.red);
        niente.setVisible(false);
        pannello.add(niente);    
        
        //Nome libreria
        nome.setText("Libreria Cima");
        nome.setSize(280, 30);
        nome.setOpaque(false);    
        nome.setLocation(150, 40);
        nome.setFont(new Font(null, 40, 40));
        pannello.add(nome);
        
        //Libri totali
        labelLibri.setSize(190, 30);
        labelLibri.setOpaque(false);
        labelLibri.setLocation(400, 180);
        labelLibri.setVisible(false);
        pannello.add(labelLibri);
        
        //Bottone cancella
        pannello.add(cancella);
        cancella.setSize(90, 30);
        cancella.setLocation(300, 240);
        cancella.addMouseListener(new MouseClick());
    }
    
    private class MouseClick implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent me) {
            if(me.getComponent().equals(conferma))
            {
                niente.setVisible(false);

                if(textCodice.getText().isEmpty() || textTitolo.getText().isEmpty() || textPrezzo.getText().isEmpty())
                {
                    niente.setVisible(true);
                }
                
                Libro l = new Libro(textCodice.getText(), textTitolo.getText(), Float.parseFloat(textPrezzo.getText()));
                cima.addLibro(l);
                
                
                
                labelCopieLibro.setText("Copie del libro presenti: " + cima.contaLibri(textCodice.getText()));
                labelLibri.setText("Libri presenti in libreria: " + cima.libriTot());
                labelCodiceInserito.setText("Il codice ISBN del libro inserito è: " + textCodice.getText());
                labelCodiceInserito.setVisible(true);
                labelCopieLibro.setVisible(true);
                labelLibri.setVisible(true);
                
            }else if(me.getComponent().equals(cancella))
            {
                niente.setVisible(false);
                
                textCodice.setText("");
                textTitolo.setText("");
                textPrezzo.setText("");
                
                labelCodiceInserito.setVisible(false);
                labelCopieLibro.setVisible(false);
                labelLibri.setVisible(false);
            }
        }

        @Override
        public void mousePressed(MouseEvent me) {
        }

        @Override
        public void mouseReleased(MouseEvent me) {
        }

        @Override
        public void mouseEntered(MouseEvent me) {
        }

        @Override
        public void mouseExited(MouseEvent me) {
        }
        
    }
}
