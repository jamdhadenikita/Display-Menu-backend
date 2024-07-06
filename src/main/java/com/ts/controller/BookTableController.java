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

    @PostMapping
    public ResponseEntity<BookTable> createBooking(@RequestBody BookTable bookTable) {
        BookTable savedBooking = bookTableService.saveBooking(bookTable);
        return new ResponseEntity<>(savedBooking, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookTable> updateBooking(@PathVariable Long id, @RequestBody BookTable bookingDetails) {
        BookTable existingBooking = bookTableService.getBookingById(id);
        if (existingBooking != null) {
            existingBooking.setName(bookingDetails.getName());
            existingBooking.setEmail(bookingDetails.getEmail());
            existingBooking.setDate_time(bookingDetails.getDate_time());
            existingBooking.setNumbe_of_people(bookingDetails.getNumbe_of_people());
            existingBooking.setSpecial_request(bookingDetails.getSpecial_request());
            BookTable updatedBooking = bookTableService.saveBooking(existingBooking);
            return new ResponseEntity<>(updatedBooking, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        bookTableService.deleteBooking(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
