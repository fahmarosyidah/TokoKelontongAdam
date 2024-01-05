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
import paw.tokokelontongadam.entity.Transaksi;
import paw.tokokelontongadam.repo.TransaksiRepository;

@Service
@Transactional
public class TransaksiService {

    @Autowired
    private TransaksiRepository repo;
// fungsi untuk return course

    public Iterable<Transaksi> findAll() {
        return repo.findAll();
    }
// Function create exam data

    public void addTransaksi(Transaksi transaksi) {
        repo.save(transaksi);
    }
//function delete

    public void deleteById(Long id) {
        repo.deleteById(id);
    }
//function edit

    public Optional<Transaksi> findById(Long id) {
        return repo.findById(id);
    }
//function update

    public void updateTransaksi(Transaksi transaksi) {
        repo.save(transaksi);
    }
    
    public List<Transaksi>findByName(String keyword){
        return repo.findByNamaProdukContains(keyword);
    }
}
