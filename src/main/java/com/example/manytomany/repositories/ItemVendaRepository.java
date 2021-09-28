package com.example.manytomany.repositories;

import com.example.manytomany.model.ItemVenda;
import com.example.manytomany.model.pk.ItemVendaPK;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemVendaRepository extends JpaRepository<ItemVenda, ItemVendaPK> {

}
