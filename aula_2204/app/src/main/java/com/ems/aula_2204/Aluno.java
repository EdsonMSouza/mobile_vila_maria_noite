package com.ems.aula_2204;

import java.io.Serializable;

public class Aluno implements Serializable {
    private String ra;
    private String nome;
    private String curso;

    public Aluno() {
    }

    // criar o método construtor
    public Aluno(String ra, String nome, String curso) {
        this.ra = ra;
        this.nome = nome;
        this.curso = curso;
    }

    // gets e sets
    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return nome;
    }

    public String getDados() {
        return ra + ", " + nome + ", " + curso;
    }
}
