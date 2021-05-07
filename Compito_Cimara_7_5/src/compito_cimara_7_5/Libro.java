/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compito_cimara_7_5;

/**
 *
 * @author 4AIA
 */
public class Libro {
    private String codiceIsbn;
    private String titolo;
    private float prezzo;
    private int copia;

    public Libro(String codiceIsbn, String titolo, float prezzo) {
        this.codiceIsbn = codiceIsbn;
        this.titolo = titolo;
        this.prezzo = prezzo;
        copia = 1;
    }

    public String getCodiceIsbn() {
        return codiceIsbn;
    }
    
    public void addCopia()
    {
        copia++;
    }
    
    public int getCopia()
    {
        return copia;
    }
}
