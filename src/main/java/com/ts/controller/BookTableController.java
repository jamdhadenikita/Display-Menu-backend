package com.ts.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ts.model.BookTable;
import com.ts.service.BookTableService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/bookTable")
public class BookTableController {

    @Autowired
    private BookTableService bookTableService;

    
   @GetMapping("get_all_booking")
    public ResponseEntity<List<BookTable>> getAllBookings() {
        List<BookTable> bookings = bookTableService.getAllBookings();
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }
   
    @GetMapping("/{id}")
    public ResponseEntity<BookTable> getBookingById(@PathVariable Long id) {
        BookTable booking = bookTableService.getBookingById(id);
        if (booking != null) {
            return new ResponseEntity<>(booking, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
    @GetMapping("/searchByName")
    public ResponseEntity<List<BookTable>> getBookingsByName(@RequestParam String name) {
        List<BookTable> bookings = bookTableService.getBookingsByName(name);
        if (!bookings.isEmpty()) {
            return new ResponseEntity<>(bookings, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
    @PostMapping("/book")
    public ResponseEntity<BookTable> updateBooking(@RequestBody BookTable bookingDetails) {
        if (bookingDetails != null) {
        	
            BookTable updatedBooking = bookTableService.saveBooking(bookingDetails.getName(),
            		bookingDetails.getEmail(),bookingDetails.getDate_time().toString(),bookingDetails.getNumbe_of_people(),
            		bookingDetails.getSpecial_request());

            // Send booking confirmation email
            try {
                bookTableService.sendBookingEmail(
                    bookingDetails.getEmail(),
                    "From Annapurna Mess",
                    bookingDetails.getName(),
                    bookingDetails.getDate_time().toString(),
                    bookingDetails.getNumbe_of_people(),
                    bookingDetails.getSpecial_request()
                );
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

            return new ResponseEntity<>(updatedBooking, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    
    @DeleteMapping("/delete-all")
    public ResponseEntity<Void> deleteAllBookings() {
        bookTableService.deleteAllBookings();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
   }
    
    

