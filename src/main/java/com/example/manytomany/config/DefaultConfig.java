package com.example.manytomany.config;

import com.example.manytomany.model.ItemVenda;
import com.example.manytomany.model.Produto;
import com.example.manytomany.model.Venda;
import com.example.manytomany.repositories.ItemVendaRepository;
import com.example.manytomany.repositories.ProdutoRepository;
import com.example.manytomany.repositories.VendaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DefaultConfig {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    
    private VendaRepository vendaRepository;

    @Autowired
    private ItemVendaRepository itemVendaRepository;

    @Bean
    public boolean instantiateDatabase() {
        Produto p1 = new Produto(1L, "celular", "smartphone 64gb", 1500.00);
        Produto p2 = new Produto(2L, "tv", "50 pol", 2000.00);

        Venda v1 = new Venda(1L);

        ItemVenda iv1 = new ItemVenda(p1, v1, 1, 1500.00, 1500.00, 0.00, 1500.00);
        ItemVenda iv2 = new ItemVenda(p2, v1, 2, 2000.00, 4000.00, 0.00, 4000.00);

        p1.getVendas().add(v1);
        p2.getVendas().add(v1);

        produtoRepository.save(p1);
        produtoRepository.save(p2);

        vendaRepository.save(v1);

        itemVendaRepository.save(iv1);
        itemVendaRepository.save(iv2);

        return true;
    }
}