/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paw.tokokelontongadam.service;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import paw.tokokelontongadam.entity.Produk;
import paw.tokokelontongadam.repo.ProdukRepository;

@Service
@Transactional
public class ProdukService {

    @Autowired
    private ProdukRepository repo;

    public Iterable<Produk> findAll() {
        return repo.findAll();
    }

    public void addProduk(Produk produk) {
        repo.save(produk);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    public Optional<Produk> findById(Long id) {
        return repo.findById(id);
    }

    public void updateProduk(Produk produk) {
        repo.save(produk);
    }
    
    public List<Produk>findByName(String keyword){
        return repo.findByNamaProdukContains(keyword);
    }
}
