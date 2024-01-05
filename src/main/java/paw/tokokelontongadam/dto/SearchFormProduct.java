/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paw.tokokelontongadam.dto;

/**
 *
 * @author lenovo
 */
public class SearchFormProduct {
    private String keyword;

    //constructor
    public SearchFormProduct() {
    }

    public SearchFormProduct(String keyword) {
        this.keyword = keyword;
    }

    //getter
    public String getKeyword() {
        return this.keyword;
    }

    //setter
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
