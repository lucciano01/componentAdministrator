/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.componenteadmin.entidade;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;


/**
 *
 * @author Luciano
 */
@Entity
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String tif;
    @Lob
    private byte [] imagem1;
    @Lob
    private byte [] imagem2;
    @Lob
    private byte [] imagem3;
    @Lob
    private byte [] imagem4;

    public byte[] getImagem1() {
        return imagem1;
    }

    public void setImagem1(byte[] imagem1) {
        this.imagem1 = imagem1;
    }

    public byte[] getImagem2() {
        return imagem2;
    }

    public void setImagem2(byte[] imagem2) {
        this.imagem2 = imagem2;
    }

    public byte[] getImagem3() {
        return imagem3;
    }

    public void setImagem3(byte[] imagem3) {
        this.imagem3 = imagem3;
    }

    public byte[] getImagem4() {
        return imagem4;
    }

    public void setImagem4(byte[] imagem4) {
        this.imagem4 = imagem4;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTif() {
        return tif;
    }

    public void setTif(String tif) {
        this.tif = tif;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifpb.componente.adm.soap.entidades.Usuario[ id=" + id + " ]";
    }
    
}
