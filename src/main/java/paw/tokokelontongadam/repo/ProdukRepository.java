/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package paw.tokokelontongadam.repo;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import paw.tokokelontongadam.entity.Produk;

/**
 *
 * @author lenovo
 */
public interface ProdukRepository extends CrudRepository<Produk, Long>{
    List <Produk> findByNamaProdukContains(String keyword);
}