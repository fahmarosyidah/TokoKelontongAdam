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
import paw.tokokelontongadam.dto.SearchFormData;
import paw.tokokelontongadam.entity.Transaksi;
import paw.tokokelontongadam.service.TransaksiService;

@Controller
public class TransaksiController {

    @Autowired
    private TransaksiService transaksiService;

    @GetMapping("/transaksi")
    public String transaksi(Model model) {
        model.addAttribute("activePage", "transaksi");
        model.addAttribute("searchForm", new SearchFormData());
        model.addAttribute("transaksi", transaksiService.findAll());
        return "transaksi";
    }

    @GetMapping("/viewTransaksi/{id}")
    public String view(@PathVariable("id") Long id, Model model) {
        model.addAttribute("transaksi", transaksiService.findById(id).orElse(null));
        return "viewTransaksi";
    }

    @GetMapping("/addTransaksi")
    public String addTransaksi(Model model) {
        model.addAttribute("activePage", "transaksi");
        model.addAttribute("transaksi", new Transaksi());
        return "addTransaksi";
    }

    @PostMapping("/save")
    public String save(Transaksi transaksi, Model model) {
        transaksiService.addTransaksi(transaksi);
        return "redirect:/transaksi";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        // Panggil service untuk melakukan penghapusan
        transaksiService.deleteById(id);
        return "redirect:/transaksi";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        // Panggil service untuk melakukan edit
        model.addAttribute("transaksi", transaksiService.findById(id));
        return "/editTransaksi";
    }

    @PostMapping("/update")
    public String update(Transaksi transaksi, Model model) {
        // call service update
        transaksiService.updateTransaksi(transaksi);
        return "redirect:/transaksi";
    }

    @GetMapping("/search")
    public String search(SearchFormData searchFormData, Model model) {
        model.addAttribute("searchForm", searchFormData);
        model.addAttribute("transaksi",
                transaksiService.findByName(searchFormData.getKeyword()));
        return "transaksi";
    }
}
