/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paw.tokokelontongadam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import paw.tokokelontongadam.dto.SearchFormProduct;
import paw.tokokelontongadam.entity.Produk;
import paw.tokokelontongadam.service.ProdukService;

@Controller
public class ProdukController {

    @Autowired
    private ProdukService produkService;

    @GetMapping("/produk")
    public String produk(Model model) {
        model.addAttribute("activePage", "produk");
        model.addAttribute("searchForm", new SearchFormProduct());
        model.addAttribute("produk", produkService.findAll());
        return "produk";
    }
    
    @GetMapping("/dataProduk")
    public String dataProduk(Model model) {
        model.addAttribute("activePage", "produk");
        model.addAttribute("searchForm", new SearchFormProduct());
        model.addAttribute("produk", produkService.findAll());
        return "dataproduk";
    }

    @GetMapping("/viewProduk/{id}")
    public String view(@PathVariable("id") Long id, Model model) {
        model.addAttribute("produk", produkService.findById(id).orElse(null));
        return "viewProduk";
    }

    @GetMapping("/addProduk")
    public String addProduk(Model model) {
        model.addAttribute("activePage", "produk");
        model.addAttribute("produk", new Produk());
        return "addProduk";
    }
//
//    @PostMapping("/save")
//    public String save(Produk produk, Model model) {
//        produkService.addProduk(produk);
//        return "redirect:/produk";
//    }
//
//    @GetMapping("/delete/{id}")
//    public String delete(@PathVariable("id") Long id) {
//        produkService.deleteById(id);
//        return "redirect:/produk";
//    }
//
//    @GetMapping("/edit/{id}")
//    public String edit(@PathVariable("id") Long id, Model model) {
//        model.addAttribute("produk", produkService.findById(id));
//        return "editProduk";
//    }
//
//    @PostMapping("/update")
//    public String update(Produk produk, Model model) {
//        // call service update
//        produkService.updateProduk(produk);
//        return "redirect:/produk";
//    }
//
//    @GetMapping("/search")
//    public String search(SearchFormProduct searchFormProduct, Model model) {
//        model.addAttribute("searchForm", searchFormProduct);
//        model.addAttribute("produk",
//                produkService.findByName(searchFormProduct.getKeyword()));
//        return "produk";
//    }
}
