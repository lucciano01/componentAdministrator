/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.projetoposartigo.entidades;

import java.io.Serializable;

/**
 *
 * @author Luciano
 */
public class Usuario implements Serializable {
    
    private String nome;
    private int idade;
    private String cpf;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nome=" + nome + ", idade=" + idade + ", cpf=" + cpf + '}';
    }
    
    
    
}
