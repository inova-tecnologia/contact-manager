package atividade_27_05_2023;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GerenciadorDeContatos implements Serializable {
    private Map<String, String> contatos;

    public GerenciadorDeContatos() {
        contatos = new HashMap<>();
    }

    public void adicionarContato(String nome, String numeroTelefone) {
        contatos.put(nome, numeroTelefone);
    }

    public void removerContato(String nome) {
        contatos.remove(nome);
    }

    public String buscarNumeroTelefone(String nome) {
        return contatos.get(nome);
    }

    public void exibirContatos() {
        System.out.println("Contatos:");
        for (Map.Entry<String, String> contato : contatos.entrySet()) {
            System.out.println(contato.getKey() + ": " + contato.getValue());
        }
    }

    public void gravarContatos(String arquivo) {
        try (FileOutputStream fileOut = new FileOutputStream(arquivo);
             ObjectOutputStream objOut = new ObjectOutputStream(fileOut)) {
            objOut.writeObject(contatos);
            System.out.println("Contatos gravados com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao gravar contatos: " + e.getMessage());
        }
    }

    public void lerContatos(String arquivo) {
        try (FileInputStream fileIn = new FileInputStream(arquivo);
             ObjectInputStream objIn = new ObjectInputStream(fileIn)) {
            contatos = (Map<String, String>) objIn.readObject();
            System.out.println("Contatos lidos com sucesso!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao ler contatos: " + e.getMessage());
        }
    }

}

