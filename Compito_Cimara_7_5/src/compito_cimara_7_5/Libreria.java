/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compito_cimara_7_5; 

import java.util.ArrayList;

/**
 *
 * @author 4AIA
 */
public class Libreria {
    private ArrayList<Libro> libri;
    private String nome;

    public Libreria(String nome) {
        this.nome = nome;
        libri = new ArrayList<>();
    }
    
    public void addLibro(Libro a)
    {
        int b = 0;
        
        for(int i = 0; i < libri.size(); i++)
        {
            if(libri.get(i).getCodiceIsbn().equals(a.getCodiceIsbn()))
            {
                libri.get(i).addCopia();
                b++;
                
            }
        }
        
        if(b == 0)
        {
            libri.add(a);
        }
        
    }
    
    public int contaLibri(String a)
    {

        for (int i = 0; i < libri.size(); i++) 
        {
            if(libri.get(i).getCodiceIsbn().equals(a))
            {
                return libri.get(i).getCopia();
            }
        }
        
        return 1;

    }

    public String getNome() {
        return nome;
    }
    
    public int libriTot()
    {
        int a = 0;
        
        for (int i = 0; i < libri.size(); i++) {
            a += libri.get(i).getCopia();
        }
        
        return a;
    }
}
