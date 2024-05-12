package com.lms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Book")
public class BookEntity {
	@Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
 private int id;
    @Column(name = "Title")
private String title;
    @Column(name = "Author")
private String author;
    @Column(name = "Isbn")
private String isbn;
    @Column(name = "Genre")
private String genre;
    @Column(name = "Quantity")
private int quantity;
	public int getBookId() {
		return id;
	}
	public void setBookId(int bookId) {
		this.id = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
    
    

}
