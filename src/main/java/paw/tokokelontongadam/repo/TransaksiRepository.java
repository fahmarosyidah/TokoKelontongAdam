/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package paw.tokokelontongadam.repo;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import paw.tokokelontongadam.entity.Transaksi;

public interface TransaksiRepository extends CrudRepository<Transaksi, Long>{
    List <Transaksi> findByNamaProdukContains(String keyword);
}

