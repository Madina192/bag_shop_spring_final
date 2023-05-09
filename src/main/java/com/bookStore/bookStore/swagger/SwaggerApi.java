package com.bookStore.bookStore.swagger;

import com.bookStore.bookStore.entity.Book;
import com.bookStore.bookStore.entity.MyBookList;
import com.bookStore.bookStore.service.BookService;
import com.bookStore.bookStore.service.MyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SwaggerApi {
    @Autowired
    private BookService service;

    @Autowired
    private MyBookService myBookService;

    @GetMapping("/")
    public String home() {
        return "home";
    }
    @GetMapping("/book_register")
    public String bookRegister() {
        return "bookRegister";
    }

    @GetMapping("/available_books")
    public String getAllBooks(Model model){
        return sortBags(model, service);
    }

    public static String sortBags(Model model, BookService service) {
        List<Book> listBackpack= service.findBooksByKeyword("backpack");
        List<Book>listPurse= service.findBooksByKeyword("purses");
        List<Book>listShopper= service.findBooksByKeyword("shopper");
        model.addAttribute("backpack", listBackpack);
        model.addAttribute("purses", listPurse);
        model.addAttribute("shopper", listShopper);
        return "bookList";
    }

    @GetMapping("/my_books")
    public List<MyBookList> getMyBooks(Model model) {
        List<MyBookList>list = myBookService.getAllMyBooks();
        model.addAttribute("book",list);
        return myBookService.getAllMyBooks();
    }
    @PostMapping("/save")
    public void addBook(@ModelAttribute Book book) {
        service.save(book);

    }
    @RequestMapping("/myList/{id}")
    public String getMyList(@PathVariable("id") int id) {
        Book b=service.getBookById(id);
        MyBookList mb = new MyBookList(b.getId(), b.getName(), b.getAuthor(), b.getPrice(), b.getImage_url());
        myBookService.saveMyBooks(mb);
        return "redirect:/my_books";
    }

    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id, Model model){
        Book b = service.getBookById(id);
        model.addAttribute("book",b);
        return "bookEdit";
    }

    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        service.deleteById(id);
        return "redirect:/available_books";
    }
}
